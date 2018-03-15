package com.blospot.techscreator.caloriecalculator;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;


public class Enterdata extends AppCompatActivity {
    private TextInputEditText name,age,gender,weight,hours,heartrate;
    private Button sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enterdata);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Enter Data");
        final SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Id", Context.MODE_PRIVATE);
        final DatabaseHandler db = new DatabaseHandler(this);
        name= (TextInputEditText)findViewById(R.id.name);
        age=(TextInputEditText)findViewById(R.id.age);
        gender=(TextInputEditText)findViewById(R.id.gender);
        weight=(TextInputEditText)findViewById(R.id.weight);
        hours=(TextInputEditText)findViewById(R.id.hours);
        sub=(Button)findViewById(R.id.b_submit);
        heartrate= findViewById(R.id.heartrate);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    int t;
                    if(Objects.equals(sharedPreferences.getString("number", ""), "")){
                        t=0;
                    }else{
                        t=  Integer.parseInt(sharedPreferences.getString("number", ""));
                    }

                    if(!heartrate.getText().toString().isEmpty()&&!hours.getText().toString().isEmpty()&&!age.getText().toString().isEmpty()&&!weight.getText().toString().isEmpty()&&!name.getText().toString().isEmpty()&&!gender.getText().toString().isEmpty()) {
                        int hour=Integer.parseInt(hours.getText().toString());
                        int ag =Integer.parseInt(age.getText().toString());
                        int wt= Integer.parseInt(weight.getText().toString());
                        int rate = Integer.parseInt(heartrate.getText().toString());
                        double cal=(((0.02017*ag)-(rate*0.05741)+(ag*0.4472)-20.4022)*(hour*60))/4.184;
                        User u = new User(t, name.getText().toString(), age.getText().toString().trim(), gender.getText().toString(), weight.toString(), hours.toString(), cal);
                        db.add(u);
                        Toast.makeText(getApplicationContext(), " ID :: " + String.valueOf(t) + " (Remember this id for further use.)",
                                Toast.LENGTH_SHORT).show();
                        t++;
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("number", String.valueOf(t));
                        editor.apply();
                        startActivity(new Intent(Enterdata.this,MainActivity.class));
                    }else {
                        Toast.makeText(getApplicationContext(), "Error ",
                                Toast.LENGTH_SHORT).show();
                    }
                    }
                }

        });






    }

}
