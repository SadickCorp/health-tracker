package com.example.springboot.beans;

import com.example.springboot.dto.light.LightUserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity()
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(mappedBy = "user")
    private Profil profil;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="users_roles",
            joinColumns= {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name="role_id")}
    )
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Monitoring> monitorings;

    @OneToOne(mappedBy = "user")
    private Goal goal;

    @OneToMany(mappedBy = "user")
    private List<Recipe> recipes;

    public User(){
        this.setMonitorings(new ArrayList<Monitoring>());
        this.setRecipes(new ArrayList<Recipe>());
    }

    public void update(LightUserDto lightUserDto){
        if(lightUserDto.getEmail() != null){
            this.setEmail(lightUserDto.getEmail());
        }
        if(lightUserDto.getPassword() != null){
            this.setPassword(lightUserDto.getPassword());
        }
    }
}
