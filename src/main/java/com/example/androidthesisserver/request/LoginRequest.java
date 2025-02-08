package com.example.androidthesisserver.request;

public class LoginRequest {
    private String email;
    private String password;  // 可选，如果需要密码进行登录

    // 生成构造方法、getter、setter
    public LoginRequest() {}

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
