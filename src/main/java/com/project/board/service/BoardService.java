package com.project.board.service;


import com.project.board.domain.Board;
import com.project.board.domain.User;
import com.project.board.dto.BoardRequestDto;
import com.project.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getBoard(){
        return boardRepository.findAll();
    }

    public Board getBoardById(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(
                ()->new NullPointerException("no such board")
        );
    }

    public Long postBoard(User user, BoardRequestDto requestDto) {
        Board board = new Board(requestDto, user);
        boardRepository.save(board);
        return board.getBoardId();
    }

    @Transactional
    public void editBoard(User user, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(requestDto.getBoardId()).orElseThrow(
                ()-> new NullPointerException("No Such Board")
        );
        if(!board.getUser().getUserId().equals(user.getUserId())){
            throw new IllegalArgumentException("게시물을 수정할 권한이 없습니다.");
        }
        board.edit(requestDto);
    }


    public void deleteBoard(User user, Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(
                ()-> new NullPointerException("No Such Board")
        );
        if(!board.getUser().getUserId().equals(user.getUserId())){
            throw new IllegalArgumentException("게시물을 삭제 할 권한이 없습니다.");
        }

        boardRepository.deleteById(boardId);
    }
}
