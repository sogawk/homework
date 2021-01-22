package com.example.homework2.util;

//通用的liveData参数，用于viewModel和activity之间通信
public class MyRes {
    String status;

    String message;

    public MyRes(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
