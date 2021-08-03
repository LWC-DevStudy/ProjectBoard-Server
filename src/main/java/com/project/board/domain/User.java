package com.project.board.domain;


import lombok.Cleanup;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;
}
