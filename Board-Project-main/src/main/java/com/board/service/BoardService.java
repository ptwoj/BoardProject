package com.board.service;

import com.board.dao.BoardDao;
import com.board.domain.dto.BoardDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardDao boardDao;


    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    public List<BoardDto> findAll() {
        return boardDao.findAll();
    }

    public int insert(String title, String category, String content, String username) {
        return boardDao.insert(title, category, username, content);
    }

    public BoardDto findBoardById(Integer id) {
        return boardDao.findBoardById(id);
    }

    public int update(String title, String category, String content, Integer id) {
        return boardDao.update(title, category, content, id);
    }

    public int delete(Integer id) {
        return boardDao.delete(id);
    }
}
