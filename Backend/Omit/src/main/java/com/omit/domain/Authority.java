package com.omit.domain;

import com.omit.domain.user.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String name;

    @JoinColumn(name = "users")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Users users;

    public void setUsers(Users users){
        this.users=users;
    }
}
