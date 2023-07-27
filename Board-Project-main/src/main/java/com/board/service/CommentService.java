package com.board.service;

import com.board.dao.CommentDao;
import com.board.domain.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentDao commentDao;

    public CommentService(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    public int addComment(Integer boardId, String content, String username) {
        // CommentDao를 사용하여 댓글 추가
        return commentDao.insert(boardId, content, username);

    }

    public List<CommentDto> findAll() {
        return commentDao.findAll();


    }

}