package be.technifutur.spring.demo.utils;


import be.technifutur.spring.demo.configs.JwtConfig;
import be.technifutur.spring.demo.models.Role;
import be.technifutur.spring.demo.models.entity.Gamer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.swagger.v3.core.util.Json;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.crypto.SecretKey;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Component
public class JwtUtil {

    private final JwtConfig config;

    private final JwtParser parser;

    private final JwtBuilder builder;

    public JwtUtil(JwtConfig config){
        this.config = config;
        SecretKey key = this.config.secretKey;
        this.parser = Jwts.parserBuilder().setSigningKey(key).build();
        this.builder = Jwts.builder().signWith(key);
    }

    public String generateToken(Gamer gamer){
        return builder
                .setSubject(gamer.getUsername())
                .claim("id",gamer.getId())
                .claim("birthdate",gamer.getBirthdate().toString())
                .claim("roles",gamer.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + config.expireAt * 1000L))
                .compact();
    }

    public Claims getClaims(String token){
        return parser.parseClaimsJws(token).getBody();
    }

    public Long getId(String token){
        return getClaims(token).get("id", Long.class);
    }

    public String getUsername(String token){
        return getClaims(token).getSubject();
    }

    public LocalDate getBirthdate(String token){
        return getClaims(token).get("birthdate", LocalDate.class);
    }

    public List<String> getRoles(String token){
        return getClaims(token).get("roles", List.class);
    }

    public boolean isValid(String token){
        Claims claims = getClaims(token);
        Date now = new Date();
        return getRoles(token) != null && now.after(claims.getIssuedAt()) && now.before(claims.getExpiration());
    }

    public String extractToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");

        if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7); // Supprimez le préfixe "Bearer "
        }

        return null; // Gérer le cas où le token n'est pas présent ou mal formaté
    }
}
