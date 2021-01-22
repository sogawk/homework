package com.example.homework2.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.homework2.R;
import com.example.homework2.adapter.StudentListAdapter;
import com.example.homework2.model.MyData;

//学生列表
public class StudentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        setTitle("学生列表");

        StudentListAdapter studentListAdapter = new StudentListAdapter(StudentListActivity.this, R.layout.student_list_item, MyData.getStudentList());
        ListView stuListView = findViewById(R.id.student_list_view);
        stuListView.setAdapter(studentListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_modify, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.modify:
//                todo : 点击之后修改学生列表
                break;
        }
        return false;
    }
}