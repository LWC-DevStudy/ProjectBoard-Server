package com.project.board.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestDto {

    private Long boardId;
    private String title;
    private String content;

}
