package com.omit.domain.user;

import com.omit.domain.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userid")
    private String userid;

    private String password;

    private String username;

    @Column(name="email", unique = true)
    private String email;

    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Builder.Default
    private List<Authority> roles=new ArrayList<>();

    public void setRoles(List<Authority> role){
        this.roles=role;
        roles.forEach(o -> o.setUsers(this));
    }

}
