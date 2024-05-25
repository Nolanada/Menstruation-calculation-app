package com.example.facbouk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                calculateMenstrualCycle2();

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

                /*String result = sdf.format(sdf.format(lastPeriodDate));
                String next = result + sdf.format(periodDuration);
                String next0 = next + averageCycleLength;
                String next1 = next0 + sdf.format(nextPeriodDate);
                String next2 = next1 + sdf.format(followingPeriodDate);*/

                /*Intent intent0 = new Intent(P_class.this, Result.class);
                intent0.putExtra("keyFirst", next1);
                intent0.putExtra("keyLen", next2);
                startActivity(intent0);
                */

                String resultText;
                String result1, result2, result3, result4 = null;
                String resultText1 = null;
                resultText = sdf.format(lastPeriodDate) ;
                resultText += "Your last period lasted for " + periodDuration + " days\n";
                resultText += "Your average menstrual cycle length is " + averageCycleLength + " days\n";
                resultText1 = sdf.format(nextPeriodDate) + "\n";
                result1 = sdf.format(followingPeriodDate);
                result2 = result1 + sdf.format(followingPeriodDate);
                result3 = result2 + sdf.format(followingPeriodDate);
                result4 =  result3 + sdf.format(followingPeriodDate);
                answer.setText(resultText1);

            }
        private void calculateMenstrualCycle2() {
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

                /*String result = sdf.format(sdf.format(lastPeriodDate));
                String next = result + sdf.format(periodDuration);
                String next0 = next + averageCycleLength;
                String next1 = next0 + sdf.format(nextPeriodDate);
                String next2 = next1 + sdf.format(followingPeriodDate);*/

                /*Intent intent0 = new Intent(P_class.this, Result.class);
                intent0.putExtra("keyFirst", next1);
                intent0.putExtra("keyLen", next2);
                startActivity(intent0);
                */

            String resultText;
            String result1, result2, result3= null;
            String next1, next2, next3;
            String resultText1 = null;
            resultText = sdf.format(lastPeriodDate) ;
            resultText += "Your last period lasted for " + periodDuration + " days\n";
            resultText += "Your average menstrual cycle length is " + averageCycleLength + " days\n";
            resultText1 = sdf.format(nextPeriodDate) + "\n";
            result1 = sdf.format(followingPeriodDate);
            result2 = result1 + sdf.format(followingPeriodDate);
            result3 = result2 + sdf.format(followingPeriodDate);
            next1 =  result3 + sdf.format(followingPeriodDate);
            next2 = next1+ sdf.format(followingPeriodDate);
            next3 = next2+ sdf.format(followingPeriodDate);
            answer.setText(resultText1);
            Intent intent0 = new Intent(P_class.this, Result.class);
            intent0.putExtra("keyFirst", next1);
            intent0.putExtra("keysecond", next2);
            intent0.putExtra("keythird", next2);
            startActivity(intent0);
        }
}

