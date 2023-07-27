package com.board.dao;

import com.board.domain.dto.SearchDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class SearchDao {
    private final JdbcTemplate jdbcTemplate;

    public SearchDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<SearchDto> findAll() {
        String sql = "select\n" +
                "    u.username,\n" +
                "    u.name ,\n" +
                "    b.id,\n" +
                "    b.title,\n" +
                "    b.content,\n" +
                "    b.category, \n" +
                "    b.create_at \n" +
                "from board.board as b\n" +
                "inner join board.user as u\n" +
                "    on b.username = u.username ORDER BY b.create_at DESC";

        List<SearchDto> SearchDto = jdbcTemplate.query(sql, getSearchDtoRowMapper());

        return SearchDto;
    }

    public List<SearchDto> findByKeyword(String keyword, String condition) {
        String sql = "select\n" +
                "    u.username,\n" +
                "    u.name ,\n" +
                "    b.id,\n" +
                "    b.title,\n" +
                "    b.content,\n" +
                "    b.category, \n" +
                "    b.create_at \n" +
                "from board.board as b\n" +
                "inner join board.user as u\n" +
                "    on b.username = u.username " +
                "where " + condition + " like ? ORDER BY b.create_at DESC";
        // ※각 절마다 띄어쓰기를 유의하도록 하자※
        // condition 변수는 String이 들어가는데 where 의 컬럼이 들어가는곳은
        // String이 들어가는곳이 아니기 때문에 바로 붙여서 사용하고 like 다음은 sql구문에서 string이 들어가는곳이기 때문에
        // 각각의 처리를 다른 방식으로 하는것이다.
        // board username과 user username으로 inner join해 서로 일치하는 값만 받아오고
        //  "where "+condition+" like ?";
        // 검색조건(condition)과 keyword가 일치하는게 있으면 가져오도록 함.

        String keywordPattern = "%" + keyword + "%";
//        System.out.println(keyword);
//        System.out.println(sql);
        List<SearchDto> SearchDto = jdbcTemplate.query(sql, getSearchDtoRowMapper(), keywordPattern);
        return SearchDto;
    }

    private RowMapper<SearchDto> getSearchDtoRowMapper() {
        return (rs, rowNum) ->
                new SearchDto(
                        rs.getString("username"),
                        rs.getString("name"),
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("category"),
                        rs.getTimestamp("create_at")
                );
    }

}
