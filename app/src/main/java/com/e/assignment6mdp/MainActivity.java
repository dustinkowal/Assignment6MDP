package com.e.assignment6mdp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textViewName1;
    TextView textViewPhone1;
    TextView textViewName2;
    TextView textViewPhone2;
    TextView textViewName3;
    TextView textViewPhone3;

    Button buttonCall1;
    Button buttonText1;
    Button buttonCall2;
    Button buttonText2;
    Button buttonCall3;
    Button buttonText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup buttons and text views
        textViewName1 = (TextView) findViewById(R.id.textViewName1);
        textViewPhone1 = (TextView) findViewById(R.id.textViewPhone1);
        textViewName2 = (TextView) findViewById(R.id.textViewName2);
        textViewPhone2 = (TextView) findViewById(R.id.textViewPhone2);
        textViewName3 = (TextView) findViewById(R.id.textViewName3);
        textViewPhone3 = (TextView) findViewById(R.id.textViewPhone3);

        buttonCall1 = (Button) findViewById(R.id.buttonCall1);
        buttonText1 = (Button) findViewById(R.id.buttonText1);
        buttonCall2 = (Button) findViewById(R.id.buttonCall2);
        buttonText2 = (Button) findViewById(R.id.buttonText2);
        buttonCall3 = (Button) findViewById(R.id.buttonCall3);
        buttonText3 = (Button) findViewById(R.id.buttonText3);

        //set on click listeners for all the call buttons
        buttonCall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callSomeone(textViewName1.getText().toString(), textViewPhone1.getText().toString());
            }
        });
        buttonCall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callSomeone(textViewName2.getText().toString(), textViewPhone2.getText().toString());
            }
        });
        buttonCall3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callSomeone(textViewName3.getText().toString(), textViewPhone3.getText().toString());
            }
        });

        //set on click listeners for all the text buttons
        buttonText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSomeone(textViewName1.getText().toString(), textViewPhone1.getText().toString(), "Who are you");
            }
        });
        buttonText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSomeone(textViewName2.getText().toString(), textViewPhone2.getText().toString(), "Can I get a Big Mac");
            }
        });
        buttonText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textSomeone(textViewName3.getText().toString(), textViewPhone3.getText().toString(), "Jenny I've got your number");
            }
        });


    }
    public void callSomeone(String name, String number){
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+number));

        if (callIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(callIntent);
        }
    }

    public void textSomeone(String name, String number, String text){
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("sms:" + number));
        sendIntent.putExtra("sms_body", text);
        startActivity(sendIntent);
    }
}
