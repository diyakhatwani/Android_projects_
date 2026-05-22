package com.example.assignment4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView outputDevice, outputFeature;
    RadioButton device;
    RadioGroup rg;
    Button btn;
    CheckBox ch1, ch2, ch3, ch4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.submit);
        rg = findViewById(R.id.device);
        ch1 = findViewById(R.id.notify);
        ch2 = findViewById(R.id.darkmode);
        ch3 = findViewById(R.id.services);
        ch4 = findViewById(R.id.backup);

        outputDevice = findViewById(R.id.outputdevice);
        outputFeature = findViewById(R.id.outputfeature);

        btn.setOnClickListener(v -> Onclick(v));
    }

    public void Onclick(View view) {

        int SelectedId = rg.getCheckedRadioButtonId();
        device = findViewById(SelectedId);

        String deviceoutput = device.getText().toString();
        outputDevice.setText("Selected Device: " + deviceoutput);

        String feature = "";

        if (ch1.isChecked())
            feature += ch1.getText().toString() + " ";

        if (ch2.isChecked())
            feature += ch2.getText().toString() + " ";

        if (ch3.isChecked())
            feature += ch3.getText().toString() + " ";

        if (ch4.isChecked())
            feature += ch4.getText().toString() + " ";

        outputFeature.setText("Selected Feature: " + feature);
    }
}