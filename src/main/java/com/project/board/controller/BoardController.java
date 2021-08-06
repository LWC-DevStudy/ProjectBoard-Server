package com.project.board.controller;


import com.project.board.domain.Board;
import com.project.board.dto.BoardRequestDto;
import com.project.board.dto.BoardResponseDto;
import com.project.board.security.UserDetailsImpl;
import com.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/board")
    public Long postBoard(@AuthenticationPrincipal UserDetailsImpl userDetails,
                          @RequestBody BoardRequestDto requestDto){
        return boardService.postBoard(userDetails.getUser(), requestDto);
    }

    @PutMapping("/board")
    public void editBoard(@AuthenticationPrincipal UserDetailsImpl userDetails,
                          @RequestBody BoardRequestDto requestDto){
        boardService.editBoard(userDetails.getUser(), requestDto);
    }

    @DeleteMapping("/board/{boardId}")
    public void deleteBoard(@AuthenticationPrincipal UserDetailsImpl userDetails,
                            @PathVariable(name = "boardId") Long boardId){
        boardService.deleteBoard(userDetails.getUser(), boardId);
    }
}
