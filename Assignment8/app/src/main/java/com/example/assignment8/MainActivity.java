package com.example.assignment8;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    Button save,send,dial;
    EditText num1,num2,num3;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
           if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
               ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},100);
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED)
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS},1);

                dial=findViewById(R.id.dial);
                save=findViewById(R.id.save);
                send=findViewById(R.id.sendSms);
                num1=findViewById(R.id.num1);
                num2=findViewById(R.id.num2);
                num3=findViewById(R.id.num3);

             preferences=getSharedPreferences("contacts", MODE_PRIVATE);
                editor=preferences.edit();

                loadContacts();
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editor.putString("num1",num1.getText().toString());
                        editor.putString("num2",num2.getText().toString());
                        editor.putString("num3",num3.getText().toString());
                        editor.commit();
                        Toast.makeText(getApplicationContext(), "your contacts are saved",Toast.LENGTH_LONG).show();


                    }
                });
                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String mob1=num1.getText().toString();
                        String mob2=num2.getText().toString();
                        String mob3=num3.getText().toString();

                        String numbers=mob1+";"+mob2+";"+mob3;
                        String message="I am in problem!";
                        SmsManager smsManager=SmsManager.getDefault();
                        smsManager.sendTextMessage(mob1,null,message,null,null);

//
//                        Intent intent=new Intent(Intent.ACTION_SENDTO);
//                        intent.setData(Uri.parse("Smsto:"+numbers));
//                        intent.putExtra("Sms Body",message);
//                        startActivity(intent);
                    }
                });

                dial.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String mob1=num1.getText().toString();
//                        Intent intent=new Intent(Intent.ACTION_DIAL);
                        Intent intent=new Intent(Intent.ACTION_CALL);

                        intent.setData(Uri.parse("tel: "+mob1));
                        startActivity(intent);

                    }
                });
           return insets;
        });
    }
    private void loadContacts(){
        num1.setText(preferences.getString("num1",null));
        num2.setText(preferences.getString("num2",null));
        num3.setText(preferences.getString("num3",null));
    }
}