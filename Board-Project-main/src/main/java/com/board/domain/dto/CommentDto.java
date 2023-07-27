package com.board.domain.dto;

import java.sql.Timestamp;


public class CommentDto {

    private Integer id;
    private Integer board_id;
    private String content;
    private String username;
    private Timestamp createdAt;
// 게시판에 필요한 데이터를 저장하고 전송하기 위한 목적

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBoard_id() {
        return board_id;
    }

    public void setBoard_id(Integer board_id) {
        this.board_id = board_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    //   private을 했기 때문에
//   댓글 id, 게시판 번호, 댓글 내용, 이름, 생성날짜를 주고 받아야 해서
//   getter,setter생성
    public CommentDto(Integer id, Integer board_id, String content, String username, Timestamp createdAt) {
        this.id = id;
        this.board_id = board_id;
        this.content = content;
        this.username = username;
        this.createdAt = createdAt;
    }
}
// constroctor은 결국 값을 초기화 하기 위해 하는 것
//  현재 아이디 및 모든 것이 0이기 때문에 이런 객체는 유효하지 않는다고 합니다.
//  0이라 는 무슨 밀인가?
//  그래서 생성자를 생성하는 것이다.
//  생성자는 결국 함수의 일종,
//즉, 이 생성자를 사용하여 객체를 생성하면 아이디(id), 게시판 아이디(board_id), 내용(content), 유저네임(username), 생성일자(createdAt) 등의 값을 초기화할 수 있습니다