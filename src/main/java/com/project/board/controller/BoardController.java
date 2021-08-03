package com.project.board.controller;


import com.project.board.domain.Board;
import com.project.board.security.UserDetailsImpl;
import com.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/board")
    public List<Board> getBoards(){
        return boardService.getBoard();
    }

    @GetMapping("/board/{boardId}")
    public Board getBoardById(@PathVariable(name = "boardId") Long boardId){
        return boardService.getBoardById(boardId);
    }
}
