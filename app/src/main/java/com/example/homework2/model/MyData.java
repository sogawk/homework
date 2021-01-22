package com.example.homework2.model;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyData {
    static HashMap<String, List<String>> map = new HashMap<>();

    static List<String> userList = new ArrayList<>();

    static List<Student> studentList = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            userList.add(String.valueOf(i));
            List<String> list = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                list.add(String.valueOf(j));
            }
            map.put(String.valueOf(i), list);
        }


            studentList.add(new Student(1, "小黑0"));
            studentList.add(new Student(2, "小黑1"));
            studentList.add(new Student(3, "小黑2"));
            studentList.add(new Student(4, "小黑3"));
            studentList.add(new Student(5, "小黑4"));
            studentList.add(new Student(5, "小黑5"));
            studentList.add(new Student(5, "小黑6"));
            studentList.add(new Student(5, "小黑7"));
            studentList.add(new Student(5, "小黑8"));
            studentList.add(new Student(5, "小黑9"));
            studentList.add(new Student(5, "小黑0"));
            studentList.add(new Student(5, "小黑1"));
            studentList.add(new Student(5, "小黑2"));
            studentList.add(new Student(5, "小黑3"));
            studentList.add(new Student(5, "小黑4"));
            studentList.add(new Student(5, "小黑5"));
            studentList.add(new Student(5, "小黑6"));
            studentList.add(new Student(5, "小黑7"));
            studentList.add(new Student(5, "小黑8"));
    }

    public static HashMap<String, List<String>> getMap() {
        return map;
    }

    public static void setMap(HashMap<String, List<String>> map) {
        MyData.map = map;
    }

    public static List<String> getUserList() {
        return userList;
    }

    public static void setUserList(List<String> userList) {
        MyData.userList = userList;
    }

    public static List<Student> getStudentList() {
        return studentList;
    }

    public static void setStudentList(List<Student> studentList) {
        MyData.studentList = studentList;
    }
}
