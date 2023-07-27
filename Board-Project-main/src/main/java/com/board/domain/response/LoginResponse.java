package com.board.domain.response;

import com.board.domain.dto.UserDto;

public class LoginResponse {
    private Integer id;

    private String username;
    private String name;
    private boolean permissoin;

    public LoginResponse(UserDto dto) {
        this.id = dto.getId();
        this.username = dto.getUsername();
        this.name = dto.getName();
        this.permissoin = dto.isPermissoin();
    }

    public LoginResponse(Integer id, String username, String name, boolean permissoin) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.permissoin = permissoin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPermissoin() {
        return permissoin;
    }

    public void setPermissoin(boolean permissoin) {
        this.permissoin = permissoin;
    }
}
