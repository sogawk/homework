package com.example.homework2.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.homework2.util.Constant;
import com.example.homework2.util.MyRes;

public class TeacherMainPageViewModel extends ViewModel {
    public String welcomeMessage = "欢迎登陆:" + "小张" + " 老师！";

    MutableLiveData<MyRes> teacherPageRes;


    public TeacherMainPageViewModel() {
        teacherPageRes = new MutableLiveData<>();
    }


    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public MutableLiveData<MyRes> getTeacherPageRes() {
        return teacherPageRes;
    }

    public void setTeacherPageRes(MutableLiveData<MyRes> teacherPageRes) {
        this.teacherPageRes = teacherPageRes;
    }

    public void publishHomework() {
        teacherPageRes.setValue(new MyRes(Constant.PUBLISH_HOMEWORK, ""));
    }

    public void showHavePublished() {
        teacherPageRes.setValue(new MyRes(Constant.SHOW_HAVE_PUBLISH, ""));
    }

    public void showWaitForJudge() {
        teacherPageRes.setValue(new MyRes(Constant.WAIT_FOR_JUDGE, ""));
    }


    public void showStudentsList() {
        teacherPageRes.setValue(new MyRes(Constant.SHOW_STUDENT_LIST, ""));
    }

    public void showGradeList() {
        teacherPageRes.setValue(new MyRes(Constant.SHOW_GRADE, ""));
    }
}
