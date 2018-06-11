package com.example.yatusabes.chmodcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int numPermission = 0;
    String outputString;
    private static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showOutput();

    }

    private void showOutput() {
        if (numPermission < 10) {
            outputString = "00" + ("" + numPermission);
        } else if (numPermission < 100) {
            outputString = "0" + ("" + numPermission);
        } else {
            outputString = ("" + numPermission);
        }
        TextView answerField = (TextView) findViewById(R.id.answerField);
        answerField.setText(outputString);
    }


    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.user_read:
                if (checked)
                    numPermission += 400;
                else
                    numPermission -= 400;
                break;
            case R.id.user_write:
                if (checked)
                    numPermission +=200;
                else
                    numPermission -=200;
                Log.d(LOG_TAG, "result: " + numPermission);
                break;
            case R.id.user_execute:
                if (checked)
                    numPermission += 100;
                else
                    numPermission -= 100;
                break;
            case R.id.group_read:
                if (checked)
                    numPermission +=40;
                else
                    numPermission -=40;
                Log.d(LOG_TAG, "result: " + numPermission);
                break;
            case R.id.group_write:
                if (checked)
                    numPermission += 20;
                else
                    numPermission -= 20;
                break;
            case R.id.group_execute:
                if (checked)
                    numPermission +=10;
                else
                    numPermission -=10;
                Log.d(LOG_TAG, "result: " + numPermission);
                break;
            case R.id.other_read:
                if (checked)
                    numPermission +=4;
                else
                    numPermission -=4;
                Log.d(LOG_TAG, "result: " + numPermission);
                break;
            case R.id.other_write:
                if (checked)
                    numPermission +=2;
                else
                    numPermission -=2;
                break;
            case R.id.other_execute:
                if (checked)
                    numPermission +=1;
                else
                    numPermission -=1;
                Log.d(LOG_TAG, "result: " + numPermission);
                break;

        }
        showOutput();
    }


}
