package com.eventmanager.dto;

/**
 * Created by kjsiosan on 4/1/2016.
 */
public class UserDto {

    private Long Id;
    private String username;
    private String password;

    public UserDto(){}

    public UserDto(Long id, String username, String password) {
        Id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
