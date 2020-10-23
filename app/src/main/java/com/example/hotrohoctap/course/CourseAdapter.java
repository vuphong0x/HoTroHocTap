package com.example.hotrohoctap.course;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hotrohoctap.R;

import java.util.List;


public class CourseAdapter extends BaseAdapter {
    Context context;
    List<Course> list;
    DAO dao;

    public CourseAdapter(Context context, List<Course> list) {
        this.context = context;
        this.list = list;
        dao = new DAO(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_course, parent, false);
        TextView tvCourseID = convertView.findViewById(R.id.tvCourseID);
        TextView tvCourseName = convertView.findViewById(R.id.tvCourseName);
        TextView tvDate = convertView.findViewById(R.id.tvDate);
        final Course course = (Course) getItem(position);
        tvCourseID.setText(course.getCourseID());
        tvCourseName.setText(course.getCourseName());
        tvDate.setText(course.getDate());
        ImageView ivDelete = convertView.findViewById(R.id.imgDelete);
        ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseID = list.get(position).getCourseID();
                dao.deleteCourse(courseID);
                Course course1 = list.get(position);
                list.remove(course1);
                notifyDataSetChanged();
            }
        });
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, AddCourseActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("courseID", course.getCourseID());
                intent.putExtra("bdCourse", bundle);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
