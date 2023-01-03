package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button_f,button_c;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.show);
        editText = findViewById(R.id.value);
        button_c = findViewById(R.id.temp_c);
        button_f = findViewById(R.id.temp_f);
        button_c.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("data",str);
                Intent i = getIntent();
                String st = i.getStringExtra("data");
                textView.setText(""+tempF(st));
            }
        });
        button_f.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                textView.setText(""+tempC(str));
                setIntent(intent);
            }
        });
    }


    public double tempF(String st){
        int num = Integer.parseInt(st);
        double feh = (num * 0.556) + 32;
        return feh;
    }
    public double tempC(String st){
        int num = Integer.parseInt(st);
        double cal = (num-32) * 0.556;
        return cal;
    }


}