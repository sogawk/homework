package com.example.homework2.view;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

//单个作业左右滑动的viewpager

public class WorkViewPager extends ViewPager {
    public WorkViewPager(@NonNull Context context) {
        super(context);
    }

    public WorkViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
}
