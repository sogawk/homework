package com.example.homework2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.homework2.R;
import com.example.homework2.databinding.ActivityTeacherMainBinding;
import com.example.homework2.util.Constant;
import com.example.homework2.util.MyRes;
import com.example.homework2.view.StudentListActivity;
import com.example.homework2.viewModel.TeacherMainPageViewModel;
import com.example.homework2.viewModel.UserViewModel;

public class TeacherMainActivity extends AppCompatActivity {

    UserViewModel userViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("教师界面");

//        UserViewModel userViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(getApplication()).get(TeacherMainPageViewModel.class);

        TeacherMainPageViewModel teacherMainPageViewModel = new TeacherMainPageViewModel();

        ActivityTeacherMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_teacher_main);

        binding.setTeacherMainPageViewModel(teacherMainPageViewModel);

        userViewModel = new UserViewModel(getApplication(), this);

        teacherMainPageViewModel.getTeacherPageRes().observe(this, new Observer<MyRes>() {
            @Override
            public void onChanged(MyRes myRes) {
                switch (myRes.getStatus()) {
                    case Constant.PUBLISH_HOMEWORK:
                        break;
                    case Constant.SHOW_HAVE_PUBLISH:
                        System.out.println();
                        break;
                    case Constant.WAIT_FOR_JUDGE:
                        break;
                    case Constant.SHOW_STUDENT_LIST:
                        Intent intent = new Intent(TeacherMainActivity.this, StudentListActivity.class);
                        startActivity(intent);
                        break;
                    case Constant.SHOW_GRADE:
                        break;
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                userViewModel.logout();
        }
        return false;
    }
}