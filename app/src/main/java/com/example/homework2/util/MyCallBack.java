package com.example.homework2.util;

//封装的回掉类，viewmodel和model之间通信
public interface MyCallBack {
    void success(String message);

    void failure(String message);
}
