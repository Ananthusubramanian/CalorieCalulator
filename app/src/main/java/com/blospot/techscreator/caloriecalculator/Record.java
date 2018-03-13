package com.blospot.techscreator.caloriecalculator;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ananthu on 13-02-2018.
 */

public class Record extends AppCompatActivity {
private TextInputEditText id;
private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        final DatabaseHandler db = new DatabaseHandler(this);
        id = findViewById(R.id.number);
        submit = findViewById(R.id.b_submit1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int t = Integer.parseInt(id.getText().toString());

                User u = db.getUser(t);
                final Dialog dialog = new Dialog(Record.this);
                dialog.setContentView(R.layout.dialog);
                dialog.setTitle("   Calorie   ");
                TextView id = (TextView) dialog.findViewById(R.id.text);
                String name ="   Name :"+u.getName();
                String cals ="   Calorie :"+u.getCal();
                id.setText(name);
                TextView cal = (TextView) dialog.findViewById(R.id.cal);
                cal.setText(cals);

                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

    }
}
