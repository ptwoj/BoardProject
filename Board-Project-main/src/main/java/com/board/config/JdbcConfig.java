package com.board.config;


import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

//@Component
public class JdbcConfig {
    private final String url = "jdbc:mysql://localhost:3306/board" +
            "?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    private final String username = "root";
    private final String password = "1234";
//    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
