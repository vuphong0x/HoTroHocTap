package com.example.hotrohoctap.course;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DAO {
    SQLite sqLite;
    SQLiteDatabase sqLiteDatabase;

    //khởi tạo database
    public DAO(Context context) {
        sqLite = new SQLite(context);
        sqLiteDatabase = sqLite.getWritableDatabase();
    }

    public int insertCourse(Course course) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("courseID", course.getCourseID());
        contentValues.put("courseName", course.getCourseName());
        contentValues.put("date",course.getDate());

        try {
            if (sqLiteDatabase.insert("Course", null, contentValues) == -1) {
                return -1;
            }


        } catch (Exception e) {
            Log.e("Lỗi!!!", e.toString());
        }
        return 1;
    }

    public int updateCourse(String courseID, String courseName, String date) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("courseName", courseName);
        contentValues.put("date", date);
        try {
            if (sqLiteDatabase.update("Course", contentValues, "courseID=?", new String[]{courseID}) == -1) {
                return -1;
            }
            ;

        } catch (Exception e) {
            Log.e("Lỗi!!!", e.toString());
        }
        return 1;
    }

    public int deleteCourse(String courseID) {

        if (sqLiteDatabase.delete("Course", "courseID=?", new String[]{courseID}) == -1) {

            return -1;
        }
        return 1;
    }

    public List<Course> getAll() {
        List<Course> list = new ArrayList<>();
        String sql = "select * from Course";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                Course course = new Course(cursor.getString(cursor.getColumnIndex("courseID")), cursor.getString(cursor.getColumnIndex("courseName")), cursor.getString(cursor.getColumnIndex("date")));
                list.add(course);
            } while (cursor.moveToNext());
            cursor.close();
        }
        sqLiteDatabase.close();

        return list;
    }
}
