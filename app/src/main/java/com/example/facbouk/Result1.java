package com.example.facbouk;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result1 extends AppCompatActivity {
    private TextView period = findViewById(R.id.show);
    private Button button = findViewById(R.id.Per);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calender();

            }
        });


    }

    private void calender(){
        DatePickerDialog Dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {

                period.setText(String.valueOf(year)+ "."+String.valueOf(month)+"."+String.valueOf(day));

            }
        }, 2024, 0, 31);

        Dialog.show();
    }

}

