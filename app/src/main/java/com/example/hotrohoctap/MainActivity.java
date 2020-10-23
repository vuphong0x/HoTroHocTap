package com.example.hotrohoctap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hotrohoctap.course.CourseActivity;
import com.example.hotrohoctap.map.MapActivity;
import com.example.hotrohoctap.news.NewsActivity;
import com.example.hotrohoctap.social.SocialActivity;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Màn Hình Chính");
    }

    public void openCourse(View view) {
        intent = new Intent(this, CourseActivity.class);
        startActivity(intent);
    }

    public void openMap(View view) {
        intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    public void openNews(View view) {
        intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }

    public void openSocial(View view) {
        intent = new Intent(this, SocialActivity.class);
        startActivity(intent);
    }
}