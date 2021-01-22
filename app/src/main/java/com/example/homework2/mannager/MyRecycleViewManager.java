package com.example.homework2.mannager;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

//自定义的recycleView的manager
public class MyRecycleViewManager extends LinearLayoutManager {

    PagerSnapHelper pagerSnapHelper;

    public MyRecycleViewManager(Context context) {
        super(context);
        pagerSnapHelper = new PagerSnapHelper();
    }

    public MyRecycleViewManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public MyRecycleViewManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onAttachedToWindow(RecyclerView view) {
//        一滑就换页，不会停在两页中间
        pagerSnapHelper.attachToRecyclerView(view);
        super.onAttachedToWindow(view);
    }
}
