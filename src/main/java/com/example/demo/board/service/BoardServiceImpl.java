package com.example.demo.board.service;

import com.example.demo.board.controller.form.BoardRequestForm;
import com.example.demo.board.entity.Board;
import com.example.demo.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    final private BoardRepository boardRepository;
    @Override
    public void register(BoardRequestForm boardRequestForm) {
        boardRepository.save(boardRequestForm.toBoard());
    }

    @Override
    public List<Board> list() {
        return boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardId"));
    }

    @Override
    public Board readBoard(Long boardId) {
        Optional<Board> maybeBoard = boardRepository.findByBoardId(boardId);

        if (maybeBoard.isEmpty()) {
            log.info("정보가 없습니다!");
            return null;
        }

        return maybeBoard.get();
    }

    @Override
    public void deleteBoard(long boardId) {
        Optional<Board> maybeBoard = boardRepository.findByBoardId(boardId);

        if(maybeBoard.isEmpty()) {
            log.info("정보가 없습니다!");
        } else {
            boardRepository.deleteById(boardId);
        }
    }

    @Override
    public Board modifyBoard(long boardId, BoardRequestForm boardRequestForm) {
        Optional<Board> maybeBoard = boardRepository.findByBoardId(boardId);
        if(maybeBoard.isEmpty()){
            log.info("정보가 없습니다!");
            return null;
        } else {
            //수정 정보
            String modifyTitle = boardRequestForm.getTitle();
            String modifyContent = boardRequestForm.getContent();

            //재설정 후 저장
            Board board = maybeBoard.get();
            board.setTitle(modifyTitle);
            board.setContent(modifyContent);
            boardRepository.save(board);
            return board;
        }
    }
}
