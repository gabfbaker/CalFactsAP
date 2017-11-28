package com.example.android.calfacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.example.android.calfacts.R.id.des_q;


public class MainActivity extends AppCompatActivity {
    RadioButton onemil, onebil, realpopulation;
    String selectedPopulation;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Insert section for "Your Name" text field
     **/
    int score = 0;

    //** Radio button scoring **//
    public void onRadioButtonClickedOne(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.realpopulation:
                if (checked)
                    score += 1;
                break;
            case R.id.onebil:
                if (checked)
                    //nothing
                    break;
            case R.id.onemil:
                if (checked)
                    //nothing
                    break;
        }
    }

    /**
     * CaliforniaCheckbox section
     **/
    public void checktvDetails1() {

        CheckBox sf_chkbx = (CheckBox) findViewById(R.id.sf_chkbx);
        CheckBox la_chkbx = (CheckBox) findViewById(R.id.la_chxbx);
        CheckBox juno_chkbx = (CheckBox) findViewById(R.id.juno_chkbx);

        if (juno_chkbx.isChecked()) {
            return;
        } else if (sf_chkbx.isChecked() && la_chkbx.isChecked()) {
            score += 2;
            return;
        } else if (sf_chkbx.isChecked() || la_chkbx.isChecked()) {
            score += 1;
        }

    }

    public void checktvDetails2() {

        CheckBox bears_chkbx = (CheckBox) findViewById(R.id.bears_chkbx);
        CheckBox cantaloupe_chkbx = (CheckBox) findViewById(R.id.cantaloupe_chkbx);
        CheckBox redwoods_chkbx = (CheckBox) findViewById(R.id.redwoods_chkbx);

        if (cantaloupe_chkbx.isChecked()) {
            return;
        } else if (bears_chkbx.isChecked() && redwoods_chkbx.isChecked()) {
            score += 2;
            return;
        } else if (bears_chkbx.isChecked() || redwoods_chkbx.isChecked()) {
            score += 1;
        }

    }


    /**
     * 1 sentence submit question
     **/

    public String des_q() {
        EditText editText = (EditText) findViewById(des_q);
        return editText.getText().toString();
    }

    /**
     * Submit Answer button
     **/
//
    public void submitButton(View v) {
        checktvDetails1();
        checktvDetails2();


        Toast.makeText(this, ("Your score is " + score), Toast.LENGTH_SHORT).show();


    }
}