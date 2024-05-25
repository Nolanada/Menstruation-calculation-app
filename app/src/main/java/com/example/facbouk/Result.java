package com.example.facbouk;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    private EditText First, second, third;
    private Button Ok;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home2_page);

        First = findViewById(R.id.Firstd);
        second = findViewById(R.id.Duration);
        third = findViewById(R.id.length);
        Ok = findViewById(R.id.ok);

        String first = getIntent().getStringExtra("keyFirst");
        String Second = getIntent().getStringExtra("keysecond");
        String Third = getIntent().getStringExtra("keythird");

        First.setText(first);
        second.setText(Second);
        third.setText(Third);
        Ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Result.this ,P_class.class);

                startActivity(intent1);
            }
        });
    }


}
