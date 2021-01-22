package com.example.homework2.activity;

import androidx.annotation.Keep;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.homework2.R;
import com.example.homework2.databinding.ActivityLoginBinding;
import com.example.homework2.util.Constant;
import com.example.homework2.viewModel.UserViewModel;



public class LoginActivity extends AppCompatActivity {

    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        userViewModel = new UserViewModel(getApplication(), this);

        binding.setUserViewModel(userViewModel);
        userViewModel.getLoginRes().observe(this,
                myRes -> {
                    switch (myRes.getStatus()) {
                        case Constant.LOGIN_SUCCESS:
                            Intent intent = new Intent(this, TeacherMainActivity.class);
                            intent.putExtra("uid", myRes.getMessage());
                            startActivity(intent);
                            finish();
                            try {
                                this.clone();
                            } catch (CloneNotSupportedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case Constant.LOGIN_FAILURE:
                        case Constant.REGISTER_FAILURE:
                            Toast.makeText(LoginActivity.this, myRes.getMessage(), Toast.LENGTH_SHORT).show();
                            break;
                        case Constant.REGISTER_SUCCESS:
                            break;
                        default:
                    }
                });
    }




}