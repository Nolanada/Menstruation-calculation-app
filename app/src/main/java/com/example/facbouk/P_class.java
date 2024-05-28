package com.example.facbouk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class P_class extends AppCompatActivity {
    private EditText firstday, lenghtper, Avrlen;
    private EditText answer;
    private Button submit, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        firstday = findViewById(R.id.Fday);
        lenghtper = findViewById(R.id.Lengthper);
        Avrlen = findViewById(R.id.avglength);
        answer = findViewById(R.id.resultTextView);
        submit = findViewById(R.id.calculate);
        next = findViewById(R.id.next);

        submit.setOnClickListener(new View.OnClickListener()

        {
            @Override

            public void onClick (View v){

                calculateMenstrualCycle();

            }

        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                calculateNextThreePeriods();

            }
        });
    }

            private void calculateMenstrualCycle() {
                String Firstday = firstday.getText().toString();
                int periodDuration = Integer.parseInt(lenghtper.getText().toString());
                int averageCycleLength = Integer.parseInt(Avrlen.getText().toString());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date lastPeriodDate;
                try {
                    lastPeriodDate = sdf.parse(Firstday);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return;
                }

                Calendar nextPeriodCalendar = Calendar.getInstance();
                nextPeriodCalendar.setTime(lastPeriodDate);
                nextPeriodCalendar.add(Calendar.DAY_OF_YEAR, averageCycleLength);
                Date nextPeriodDate = nextPeriodCalendar.getTime();

                Calendar followingPeriodCalendar = Calendar.getInstance();
                followingPeriodCalendar.setTime(nextPeriodDate);
                followingPeriodCalendar.add(Calendar.DAY_OF_YEAR, averageCycleLength);
                Date followingPeriodDate = followingPeriodCalendar.getTime();

                String resultText;
                String result1, result2, result3, result4 = null;
                String resultText1 = null;
                resultText = sdf.format(lastPeriodDate) ;
                resultText += "Your last period lasted for " + periodDuration + " days\n";
                resultText += "Your average menstrual cycle length is " + averageCycleLength + " days\n";
                resultText1 = sdf.format(nextPeriodDate) + "\n";
                result1 = sdf.format(followingPeriodDate);/*
                result2 = result1 + sdf.format(followingPeriodDate);
                result3 = result2 + sdf.format(followingPeriodDate);
                result4 =  result3 + sdf.format(followingPeriodDate);*/
                answer.setText(resultText1);

            }

    private void calculateNextThreePeriods() {
        String lastPeriodDateStr =firstday.getText().toString();
        int averageCycleLength = Integer.parseInt(Avrlen.getText().toString());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date lastPeriodDate;
        try {
            lastPeriodDate = sdf.parse(lastPeriodDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }

        Calendar nextPeriodCalendar = Calendar.getInstance();
        nextPeriodCalendar.setTime(lastPeriodDate);

        // Store the next 3 period start dates in an ArrayList
        ArrayList<String> nextThreePeriods = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            nextPeriodCalendar.add(Calendar.DAY_OF_YEAR, averageCycleLength);
            Date nextPeriodStartDate = nextPeriodCalendar.getTime();
            String nextPeriodStartDateStr = sdf.format(nextPeriodStartDate);
            nextThreePeriods.add(nextPeriodStartDateStr);
        }

        // Pass the next 3 period start dates to the next activity
        Intent intent = new Intent(this, Result.class);
        intent.putStringArrayListExtra("nextThreePeriods", nextThreePeriods);
        startActivity(intent);
    }
}

