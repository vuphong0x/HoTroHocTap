package com.example.hotrohoctap.course;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hotrohoctap.R;

import java.util.List;


public class CourseActivity extends AppCompatActivity {
    ImageView imgAddCourse;
    ListView lvList;
    DAO dao;
    List<Course> list;
    CourseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        setTitle("Khóa Học");

        Log.e("onCreate", "onCreate");
        imgAddCourse = findViewById(R.id.imgAddCourse);
        lvList = findViewById(R.id.lvList);

        dao = new DAO(this);
        list = dao.getAll();
        adapter = new CourseAdapter(this, list);
        lvList.setAdapter(adapter);

        imgAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CourseActivity.this, AddCourseActivity.class));
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart", "onRestart");
        dao = new DAO(this);
        list = dao.getAll();
        adapter = new CourseAdapter(this, list);
        lvList.setAdapter(adapter);
    }

}
