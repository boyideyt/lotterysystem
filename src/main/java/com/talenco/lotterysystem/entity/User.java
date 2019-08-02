package com.talenco.lotterysystem.entity;

public class User {
    private Integer userId;

    private String userName;

    private String realName;

    private String password;

    private Integer role;

    public User(Integer userId, String userName, String realName, String password, Integer role) {
        this.userId = userId;
        this.userName = userName;
        this.realName = realName;
        this.password = password;
        this.role = role;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}