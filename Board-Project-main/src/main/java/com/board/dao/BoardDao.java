package com.board.dao;

import com.board.domain.dto.BoardDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class BoardDao {

    private final JdbcTemplate jdbcTemplate;


    public BoardDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<BoardDto> getBoardDtoRowMapper() {
        return (rs, rowNum) ->
                new BoardDto(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("category"),
                        rs.getString("content"),
                        rs.getString("username"),
                        rs.getTimestamp("create_at")
                );
    }

    public List<BoardDto> findAll() {
        String sql = "SELECT b.id, b.title, b.category, b.username, b.content, b.create_at FROM board.board AS b ORDER BY b.create_at DESC";
        List<BoardDto> boardDtoList = jdbcTemplate.query(sql, getBoardDtoRowMapper());
        return boardDtoList;
    }

    public int insert(String title, String category, String content, String username) {
        String sql = "insert into board(title, category, content, username) VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql, title, category, username, content);
    }

    public BoardDto findBoardById(Integer id) {
        String sql = "select b.id, b.title, b.category, b.username, b.content, b.create_at from board.board as b where id = ?";
        System.out.println(sql);
        System.out.println(id);
        return jdbcTemplate.queryForObject(sql, getBoardDtoRowMapper(), id);

    }

    public int update(String title, String category, String content, Integer id) {
        String sql = "update board set title = ?, category = ?, content = ? where id = ?";
        return jdbcTemplate.update(sql, title, category, content, id);
    }

    public int delete(Integer id) {
        String sql = "delete from board where id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
