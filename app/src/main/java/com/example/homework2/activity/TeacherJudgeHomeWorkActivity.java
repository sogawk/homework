package com.example.homework2.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.homework2.R;
import com.example.homework2.adapter.MyRecyclerAdapter;
import com.example.homework2.mannager.MyRecycleViewManager;
import com.example.homework2.model.MyData;
import com.example.homework2.util.Constant;
import com.example.homework2.util.MyRes;
import com.example.homework2.viewModel.UserViewModel;

public class TeacherJudgeHomeWorkActivity extends AppCompatActivity {

    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_judge_page);

        userViewModel = new UserViewModel(getApplication(), this);

        RecyclerView recyclerView = findViewById(R.id.userRecyclerView);

        MyRecycleViewManager myRecycleViewManager = new MyRecycleViewManager(this);



        recyclerView.setLayoutManager(myRecycleViewManager);

        MyRecyclerAdapter myRecyclerAdapter = new MyRecyclerAdapter(this);


        // todo 测试数据

        myRecyclerAdapter.setLists(MyData.getUserList());

        recyclerView.setAdapter(myRecyclerAdapter);


        userViewModel.getLoginRes().observe(this, new Observer<MyRes>() {
            @Override
            public void onChanged(MyRes myRes) {
                Intent intent;
                switch (myRes.getStatus()) {
                    case Constant.LOGOUT:
                        Toast.makeText(TeacherJudgeHomeWorkActivity.this, "logout", Toast.LENGTH_SHORT).show();
                        intent = new Intent(TeacherJudgeHomeWorkActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
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
                Toast.makeText(TeacherJudgeHomeWorkActivity.this, "logout", Toast.LENGTH_SHORT).show();
                userViewModel.logout();
        }
        return false;
    }
}