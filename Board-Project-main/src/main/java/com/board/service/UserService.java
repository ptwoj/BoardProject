package com.board.service;

import com.board.dao.UserDao;
import com.board.domain.requset.LoginRequset;
import com.board.domain.requset.SignupRequest;
import com.board.domain.response.LoginResponse;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.regex.Pattern;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int signup(SignupRequest signupRequest) throws Exception {
        if (!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,}$", signupRequest.getPassword())) {
            throw new Exception("비밀번호는 최소 8자리에 숫자, 문자, 특수문자 각 1개 이상 포함 되어야 합니다");
        } else {
            return userDao.signup(signupRequest);
        }
    }


    public LoginResponse login(LoginRequset loginRequset) {
        try {
            return userDao.login(loginRequset);
        } catch (Exception e) {
            return null;
        }
    }
}