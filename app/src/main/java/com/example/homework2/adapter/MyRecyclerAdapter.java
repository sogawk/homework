package com.example.homework2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework2.R;
import com.example.homework2.model.MyData;
import com.example.homework2.view.WorkViewPager;

import java.util.ArrayList;
import java.util.List;

//学生上下滑动的adapter
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MviewHolder> {
    List<String> lists;

    Context context;

    public MyRecyclerAdapter(Context context) {
        this.context = context;
    }


    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public MviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_student_works_item, parent, false);

        MviewHolder mviewHolder = new MviewHolder(view);

        return mviewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MviewHolder holder, int position) {
        String string = lists.get(position);
        int size = MyData.getMap().get(string).size();

        List<ImageView> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(R.mipmap.ic_launcher);
            list.add(imageView);
        }
//        List<ImageView> list = MyData.getMap().get(string);
        holder.myViewPagerAdapter.setmList(list);

        holder.textView.setText("第" + position + "页");
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }


    static class MviewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        MyViewPagerAdapter myViewPagerAdapter;

        public MviewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.ttt);

            myViewPagerAdapter = new MyViewPagerAdapter();
            WorkViewPager workViewPager = itemView.findViewById(R.id.workViewPager);
            workViewPager.setAdapter(myViewPagerAdapter);
        }
    }
}

