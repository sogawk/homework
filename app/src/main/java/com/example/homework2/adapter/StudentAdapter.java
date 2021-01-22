package com.example.homework2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.homework2.R;
import com.example.homework2.model.Student;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<Student> {


    private int resourceId;

    public StudentAdapter(@NonNull Context context, int textViewResourceId, @NonNull List<Student> objects) {
        super(context, textViewResourceId, objects);
        this.resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Student student = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        TextView studentName = view.findViewById(R.id.student_name);
        CheckBox studentCheck = view.findViewById(R.id.student_check);
        studentName.setText(student.getName());
        return view;
    }
}
