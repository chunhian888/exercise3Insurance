package com.example.taruc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerAge;
    RadioGroup radiogroupgender;
    RadioButton male, female;
    CheckBox checkboxes;
    TextView textview1;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerAge = findViewById(R.id.spinner);
        radiogroupgender = findViewById(R.id.radioGroup);
        male = findViewById(R.id.Male);
        female = findViewById(R.id.Female);
        checkboxes = findViewById(R.id.checkBox);
        textview1 = findViewById(R.id.result);
        button1 = findViewById(R.id.calculate);
        button2 = findViewById(R.id.reset);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.agegroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);
    }

    public void calcpremium() {
        int position = -1;
        double premium = 0;
        int gender;
        gender = radiogroupgender.getCheckedRadioButtonId();
        position = spinnerAge.getSelectedItemPosition();
        switch (position) {
            case 0:
                premium = 50;
                break;
            case 1:
                premium = 55;
                break;
            case 2:
                premium = 60;
                break;
            case 3:
                premium = 70;
                break;
            case 4:
                premium = 90;
                break;
            case 5:
                premium = 120;
                break;
            case 6:
                premium = 150;
                break;
            case 7:
                premium = 150;
                break;
        }
        if(gender == R.id.Male){
            if(position > 2){
                premium +=50;
            }
        }

        if(checkboxes.isChecked()){
            if(position == 3){
                premium +=100;
            }
            if(position > 3){
                premium +=50;
            }
        }

    }
}