package com.example.hotrohoctap.course;

public class Course {
    String courseID, courseName, date;

    public Course() {
    }

    public Course(String courseID, String courseName, String date) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.date = date;
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
