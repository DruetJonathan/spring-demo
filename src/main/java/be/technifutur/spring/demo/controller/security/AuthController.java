package be.technifutur.spring.demo.controller.security;

import be.technifutur.spring.demo.models.dto.security.GamerTokenDTO;
import be.technifutur.spring.demo.models.entity.Gamer;
import be.technifutur.spring.demo.models.form.GamerLoginForm;
import be.technifutur.spring.demo.service.GamerService;
import be.technifutur.spring.demo.utils.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final GamerService gamerService;

    private final JwtUtil jwtUtil;

    public AuthController(GamerService gamerService, JwtUtil jwtUtil) {
        this.gamerService = gamerService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<GamerTokenDTO> login(
            @RequestBody @Valid GamerLoginForm login
            ){
        Gamer gamer = gamerService.login(login.toEntity());
        GamerTokenDTO dto = GamerTokenDTO.fromEntity(gamer);
        String token = jwtUtil.generateToken(gamer);
        dto.setToken(token);
        System.out.println(jwtUtil.getRoles(token));
        return ResponseEntity.ok(dto);
    }
}
