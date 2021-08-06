package com.project.board.domain;


import com.project.board.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Board extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long boardId;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    private User user;

    public Board(BoardRequestDto boardRequestDto, User user) {
        this.content = boardRequestDto.getContent();
        this.title = boardRequestDto.getTitle();
        this.user = user;
    }

    public void edit(BoardRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.title = requestDto.getTitle();
    }
}
