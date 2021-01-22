package com.example.homework2.mannager;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class MyLayoutMannager extends LinearLayoutManager {

    PagerSnapHelper pagerSnapHelper;

    public MyLayoutMannager(Context context) {
        super(context);
        pagerSnapHelper = new PagerSnapHelper();
    }

    public MyLayoutMannager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public MyLayoutMannager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onAttachedToWindow(RecyclerView view) {
//        一滑就换页，不会停在两页中间
        pagerSnapHelper.attachToRecyclerView(view);
        super.onAttachedToWindow(view);
    }
}
