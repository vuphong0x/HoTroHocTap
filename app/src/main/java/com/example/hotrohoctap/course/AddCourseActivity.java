package com.example.hotrohoctap.course;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


import com.example.hotrohoctap.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddCourseActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    EditText edCourseID, edCourseName, edDate;
    Button btnAdd, btnUpdate;
    DAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course);
        setTitle("Thêm Khóa Học");
        edCourseID = findViewById(R.id.edCourseID);
        edCourseName = findViewById(R.id.edCourseName);
        edDate = findViewById(R.id.edDate);
        btnAdd = findViewById(R.id.btnAdd);
        btnUpdate = findViewById(R.id.btnUpdate);

        try {
            Intent intent = getIntent();
            Bundle bundle = intent.getBundleExtra("bdCourse");
            edCourseID.setText(bundle.getString("courseID"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void picDate(View view) {
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(), "date");
    }

    public static class DatePickerFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar cal = new GregorianCalendar(year, month, dayOfMonth);
        setDate(cal);
    }

    private void setDate(Calendar calendar) {

        edDate.setText(sdf.format(calendar.getTime()));
    }

    public void addCourse(View view) {
        dao = new DAO(AddCourseActivity.this);
        String id = edCourseID.getText().toString();
        String name = edCourseName.getText().toString();
        String date = edDate.getText().toString();
        Course course = new Course(id, name, date);
        if (id.isEmpty() || name.isEmpty() || date.isEmpty()) {
            Toast.makeText(AddCourseActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        } else {
            if (dao.insertCourse(course) > 0) {
                Toast.makeText(AddCourseActivity.this, "Thêm thành công", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(AddCourseActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void updateCourse(View view) {
        dao = new DAO(AddCourseActivity.this);

        Course course = new Course(edCourseID.getText().toString(), edCourseName.getText().toString(), edDate.getText().toString());

        if (dao.updateCourse(course.getCourseID(), course.getCourseName(), course.getDate()) == 1) {
            Toast.makeText(getApplicationContext(), "Cập nhật thành công", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
        }

    }

}
