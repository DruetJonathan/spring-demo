package be.technifutur.spring.demo.utils;


import be.technifutur.spring.demo.models.Role;
import be.technifutur.spring.demo.models.entity.Gamer;
import be.technifutur.spring.demo.repository.GamerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final GamerRepository gamerRepository;

    private final PasswordEncoder passwordEncoder;

    public DataInitializer(GamerRepository gamerRepository, PasswordEncoder passwordEncoder) {
        this.gamerRepository = gamerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        String pwd = passwordEncoder.encode("Test1234=");
        Gamer gamer = new Gamer();
        gamer.setPseudo("Bambino");
        gamer.setPassword(pwd);
        gamer.setEmail("seb@test.be");
        gamer.setActive(true);
        gamer.setRoles(Set.of(Role.ROLE_USER));
        gamer.setBirthdate(LocalDate.of(1991,3,27));
        gamerRepository.save(gamer);
        Gamer gamer1 = new Gamer();
        gamer1.setPseudo("Rudolf");
        gamer1.setPassword(pwd);
        gamer1.setEmail("rudolf@test.be");
        gamer1.setActive(true);
        gamer1.setRoles(Set.of(Role.ROLE_USER));
        gamer1.setBirthdate(LocalDate.of(1991,3,27));
        gamerRepository.save(gamer1);
    }
}
