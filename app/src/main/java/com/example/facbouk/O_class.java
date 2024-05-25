package com.example.facbouk;

import static com.example.facbouk.R.id;
import static com.example.facbouk.R.layout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class O_class extends AppCompatActivity {
    private EditText first, second, third, Result1, Result2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.ovulation_page);

        first = findViewById(id.Firstday);
        second = findViewById(id.periodlength);
        third = findViewById(id.avglength);
        btn = findViewById(id.calculate);
        Result1 = findViewById(id.res1);
        Result2 = findViewById(id.res2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateOvulationDays();
            }
        });
    }
    private void calculateOvulationDays() {
        String lastPeriodDateStr = first.getText().toString();
        int periodDuration = Integer.parseInt(second.getText().toString());
        int averageCycleLength = Integer.parseInt(third.getText().toString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date lastPeriodDate;
        try {
            lastPeriodDate = sdf.parse(lastPeriodDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

        Calendar ovulationCalendar = Calendar.getInstance();
        ovulationCalendar.setTime(lastPeriodDate);
        ovulationCalendar.add(Calendar.DAY_OF_YEAR, (averageCycleLength / 2) - 3);
        Date ovulationStartDate = ovulationCalendar.getTime();

        ovulationCalendar.add(Calendar.DAY_OF_YEAR, 6);
        Date ovulationEndDate = ovulationCalendar.getTime();
        String result1 = "", result2 ="";
        String resultText = "Based on the information you provided:\n\n";
        resultText += "Your last period started on: " + sdf.format(lastPeriodDate) + "\n";
        resultText += "Your last period lasted for " + periodDuration + " days\n";
        resultText += "Your average menstrual cycle length is " + averageCycleLength + " days\n";
        result1 += sdf.format(ovulationStartDate) + "\n";
        result2 += sdf.format(ovulationEndDate);


        Result1.setText(result1);
        Result2.setText(result2);

    }
}
