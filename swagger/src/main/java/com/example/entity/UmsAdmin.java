package com.example.entity;

public class UmsAdmin {
    private Long id;

    private Integer status;

    private String username;

    private String password;

    public UmsAdmin(){
    }

    public UmsAdmin(Long id,Integer status,String username,String password){
        this.id = id;
        this.status = status;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
