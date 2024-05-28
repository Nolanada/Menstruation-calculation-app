package com.example.facbouk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    private TextView nextPeriod1TextView;
    private TextView nextPeriod2TextView;
    private TextView nextPeriod3TextView;
    private Button Ok;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2_page);

        // Get the next three period start dates from the Intent
        ArrayList<String> nextThreePeriods = getIntent().getStringArrayListExtra("nextThreePeriods");

        // Find the TextViews in the layout
        nextPeriod1TextView = findViewById(R.id.nextPeriod1TextView);
        nextPeriod2TextView = findViewById(R.id.nextPeriod2TextView);
        nextPeriod3TextView = findViewById(R.id.nextPeriod3TextView);

        // Set the text of the TextViews to the next three period start dates
        if (nextThreePeriods != null && nextThreePeriods.size() == 3) {
            nextPeriod1TextView.setText(nextThreePeriods.get(0));
            nextPeriod2TextView.setText(nextThreePeriods.get(1));
            nextPeriod3TextView.setText(nextThreePeriods.get(2));
        } else {
            // Handle the case where the nextThreePeriods list is empty or missing
            nextPeriod1TextView.setText("N/A");
            nextPeriod2TextView.setText("N/A");
            nextPeriod3TextView.setText("N/A");
        }
        Ok = findViewById(R.id.ok);

        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Result.this ,P_class.class);

                startActivity(intent1);
            }
        });

    }

}
