package com.example.catastrophe1.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class Utilisateur implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String nom;
    private String prenom;

    private String email;

    private String login;

    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(columnDefinition = "NUMERIC")
    private int contactNumber;


    @OneToMany(mappedBy = "utilisateur")
    private List<PertesMaterielles> pertesMaterielles;

    @OneToMany(mappedBy = "utilisateur")
    private List<Aide> aides;

    @OneToMany(mappedBy = "utilisateur")
    private List<PersonneDisparue> personneDisparues;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }


    @Override
    public String getPassword() {
        return password ;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
