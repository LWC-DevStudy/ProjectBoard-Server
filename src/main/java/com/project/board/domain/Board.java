package com.project.board.domain;


import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardId;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String title;

    public Board(Long boardId, String contents, String title) {
        this.boardId = boardId;
        this.contents = contents;
        this.title = title;
    }

}
