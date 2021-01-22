package com.example.homework2.viewModel;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.homework2.R;
import com.example.homework2.service.LoginService;
import com.example.homework2.util.Constant;
import com.example.homework2.util.MyCallBack;
import com.example.homework2.util.MyRes;

import java.lang.ref.WeakReference;

public class UserViewModel extends ViewModel {


    String userName;

    String password;

    String phone;

    Boolean isChecked;

    MutableLiveData<MyRes> loginRes;

    LoginService loginService;

    Application application;

    WeakReference<Activity> contextWeakReference;


    public UserViewModel(Application application, Activity activity) {
        contextWeakReference = new WeakReference<>(activity);
        this.application = application;
        loginService = new LoginService();
        loginRes = new MutableLiveData<>();
        loadCacheUserInfo();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean checked) {
        isChecked = checked;
    }

    public MutableLiveData<MyRes> getLoginRes() {
        return loginRes;
    }

    public void login() {
        loginService.login(userName, password, new MyCallBack() {
            @Override
            public void success(String message) {
                loginRes.setValue(new MyRes(Constant.LOGIN_SUCCESS, message));
                if (isChecked == true) {
                    saveUserInfo(message, userName, password);
                } else {
                    clearUserInfo();
                }
            }

            @Override
            public void failure(String message) {
                loginRes.setValue(new MyRes(Constant.LOGIN_FAILURE, message));
            }
        });
    }

    public void register() {
        if (phone == null || phone.isEmpty()) {
            EditText phone = contextWeakReference.get().findViewById(R.id.phone);
            CheckBox checkBox = contextWeakReference.get().findViewById(R.id.rememberPassword);
            phone.setVisibility(View.VISIBLE);

//            todo 竟然好使？
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) checkBox.getLayoutParams();
            layoutParams.addRule(RelativeLayout.BELOW, R.id.phone);
            checkBox.setLayoutParams(layoutParams);
            return;
        }

        loginService.register(userName, password, new MyCallBack() {
            @Override
            public void success(String message) {
                loginRes.setValue(new MyRes(Constant.REGISTER_SUCCESS, message));
                if (isChecked == true) {
                    saveUserInfo(message, userName, password);
                } else {
                    clearUserInfo();
                }
            }

            @Override
            public void failure(String message) {
                loginRes.setValue(new MyRes(Constant.REGISTER_FAILURE, message));
            }
        });
    }

    private void loadCacheUserInfo() {
        SharedPreferences preferences = contextWeakReference.get().getSharedPreferences("login", Context.MODE_PRIVATE);
        boolean isRemember = preferences.getBoolean("isRemember", false);
        if (isRemember) {
            userName = preferences.getString("userName", "");
            password = preferences.getString("password", "");
            isChecked = true;
        }
    }

    private void saveUserInfo(String uid, String userName, String password) {
        SharedPreferences sharedPreferences = contextWeakReference.get().getSharedPreferences("login", Context.MODE_PRIVATE);
        sharedPreferences.edit()
                .putString("uid", uid)
                .putString("userName", userName)
                .putString("password", password)
                .putBoolean("isRemember", true)
                .apply();
    }

    public void clearUserInfo() {
        SharedPreferences sharedPreferences = contextWeakReference.get().getSharedPreferences("login", Context.MODE_PRIVATE);
        sharedPreferences.edit()
                .clear()
                .apply();
    }

    public void logout() {
        clearUserInfo();
        loginRes.setValue(new MyRes(Constant.LOGOUT, null));
    }

}
