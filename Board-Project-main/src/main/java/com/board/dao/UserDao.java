package com.board.dao;

import com.board.domain.dto.UserDto;
import com.board.domain.requset.LoginRequset;
import com.board.domain.requset.SignupRequest;
import com.board.domain.response.LoginResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Objects;

@Component
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int signup(SignupRequest signupRequest) {
        String sql = "insert into user(username,password,name) value(?,?,?)";
        return jdbcTemplate.update(sql, signupRequest.getUsername(), signupRequest.getPassword(), signupRequest.getName());
    }

    public LoginResponse login(LoginRequset loginRequset) {
        String sql = "select * from user where username = ? and password = ?";
        UserDto userDto = jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new UserDto(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getBoolean("permission")
                ), loginRequset.getUsername(),loginRequset.getPassword());
        return new LoginResponse(Objects.requireNonNull(userDto));
    }

}
