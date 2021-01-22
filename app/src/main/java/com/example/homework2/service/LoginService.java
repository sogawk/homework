package com.example.homework2.service;

import com.example.homework2.util.MyCallBack;

public class LoginService {

    public void login(String name, String password, MyCallBack myCallBack) {
        if (name != null && password != null && name.equals("tt") && password.equals("123")) {

            myCallBack.success("1");
        } else {
            myCallBack.failure("用户名或密码错误");
        }
    }

    public void register(String name, String password, MyCallBack myCallBack) {
        myCallBack.failure(null);
    }

}
