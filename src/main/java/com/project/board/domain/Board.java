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
    private String contents;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    private User user;

    public Board(BoardRequestDto boardRequestDto, User user) {
        this.contents = boardRequestDto.getContents();
        this.title = boardRequestDto.getTitle();
        this.user = user;
    }

    public void edit(BoardRequestDto requestDto) {
        this.contents = requestDto.getContents();
        this.title = requestDto.getTitle();
    }
}
