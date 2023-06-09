package com.example.dialogpopup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnDateDialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar= Calendar.getInstance();
                int year=calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                int day=calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int days) {
                        String selectedDate=days+"/"+(month+1)+"/"+year;

                        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                        View view= LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_dialog,null);
                        builder.setView(view);
                        ((TextView)view.findViewById(R.id.textDate)).setText(selectedDate);
                        builder.setView(view);
                        builder.show();
                    }

                },year,month,day);

                datePickerDialog.show();
            }
        });
    }
}