package com.atguigu.admin.bean;

public class Bean {
    private String username;
    private String password;

    public Bean(){

    }

    public Bean(String username,String password){
        this.username=username;
        this.password=password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
