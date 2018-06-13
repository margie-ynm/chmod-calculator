package com.example.yatusabes.chmodcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int numPermission = 0;
    private String outputString;
    private static final String LOG_TAG = "MainActivity";

    private CheckBox checkboxUserRead;
    private CheckBox checkboxUserWrite;
    private CheckBox checkboxUserExecute;

    private CheckBox checkboxGroupRead;
    private CheckBox checkboxGroupWrite;
    private CheckBox checkboxGroupExecute;

    private CheckBox checkboxOtherRead;
    private CheckBox checkboxOtherWrite;
    private CheckBox checkboxOtherExecute;

    private CompoundButton.OnCheckedChangeListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int[] listenerIds = {
                R.id.other_execute,
                R.id.other_read,
                R.id.other_write,
                R.id.group_execute,
                R.id.group_read,
                R.id.group_write,
                R.id.user_execute,
                R.id.user_read,
                R.id.user_write
        };
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listener = new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
                int id = checkBox.getId();
                int val = 0;

                switch (id) {
                    case R.id.other_execute: val = 1; break;
                    case R.id.other_read: val = 2; break;
                    case R.id.other_write: val = 4; break;
                    case R.id.group_execute: val = 10; break;
                    case R.id.group_read: val = 20; break;
                    case R.id.group_write: val = 40; break;
                    case R.id.user_execute: val = 100; break;
                    case R.id.user_read: val = 200; break;
                    case R.id.user_write: val = 400; break;
                }
                if (isChecked) {
                    numPermission += val;
                } else {
                    numPermission -= val;
                }

                showOutput();
            }
        };
        for (int id : listenerIds) {
            createListener(id);
        }

        showOutput();

    }

    private void createListener(int id) {
        checkboxOtherExecute = (CheckBox) findViewById(id);
        checkboxOtherExecute.setChecked(false);

        checkboxOtherExecute.setOnCheckedChangeListener(listener);
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

        TextView secondAnswerField = (TextView) findViewById(R.id.secondAnswerField);
        secondAnswerField.setText(outputString);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_action_about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
