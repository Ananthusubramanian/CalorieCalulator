package com.blospot.techscreator.caloriecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private Spinner spinner;
private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.music_genere);
        submit = (Button)findViewById(R.id.submit);
        ArrayList<String> list = new ArrayList<String>();
        list.add("Enter patient detail");
        list.add("View patient detail");
        list.add("Calorie calculation");
        list.add("Details about software");
        ArrayAdapter<String> aa = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,list);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i= spinner.getSelectedItemPosition();
                switch (i){
                    case 0:startActivity(new Intent(MainActivity.this,Enterdata.class));
                        break;
                    case 1:startActivity(new Intent(MainActivity.this,Record.class));
                        break;
                    case 2:startActivity(new Intent(MainActivity.this,Calculator.class));
                        break;

                }
            }
        });


    }
}
