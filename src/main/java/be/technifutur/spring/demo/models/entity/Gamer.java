package be.technifutur.spring.demo.models.entity;

import be.technifutur.spring.demo.models.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Gamer implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gamer_id", nullable = false)
    private Long id;

    @Column(name = "gamer_pseudo", nullable = false, unique = true)
    private String pseudo;

    @Column(name = "gamer_email", nullable = false, unique = true)
    private String email;

    @Column(name = "gamer_password", nullable = false)
    private String password;

    @Column(name = "gamer_birthdate", nullable = false)
    private LocalDate birthdate;

    @Column(name = "gamer_active", nullable = false)
    private boolean active = true;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "gamer_role",
            joinColumns = @JoinColumn(name = "gamer_id")
    )
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(
            name = "games_played",
            joinColumns = @JoinColumn(name = "gamer_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name= "game_id", nullable = false)
    )
    private Set<Game> gamesPlayed = new HashSet<>();

    @OneToMany(mappedBy = "gamer")
    private Set<Participation> participations = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(r -> new SimpleGrantedAuthority(r.toString()))
                .toList();
    }

    @Override
    public String getUsername() {
        return this.pseudo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }
}
