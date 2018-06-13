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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creatingUserReadListener();
        creatingUserWriteListener();
        creatingUserExecuteListener();
        creatingGroupReadListener();
        creatingGroupWriteListener();
        creatingGroupExecuteListener();
        creatingOtherReadListener();
        creatingOtherWriteListener();
        creatingOtherExecuteListener();

        showOutput();

    }

    private void creatingOtherExecuteListener() {
        checkboxOtherExecute = (CheckBox) findViewById(R.id.other_execute);
        checkboxOtherExecute.setChecked(false);

        checkboxOtherExecute.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
                if (isChecked) {
                    numPermission += 1;
                } else {
                    numPermission -= 1;
                }

                showOutput();
            }
        });
    }

    private void creatingOtherWriteListener() {
        checkboxOtherWrite = (CheckBox) findViewById(R.id.other_write);
        checkboxOtherWrite.setChecked(false);

        checkboxOtherWrite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
                if (isChecked) {
                    numPermission += 2;
                } else {
                    numPermission -= 2;
                }

                showOutput();
            }
        });
    }

    private void creatingOtherReadListener() {
        checkboxOtherRead = (CheckBox) findViewById(R.id.other_read);
        checkboxOtherRead.setChecked(false);

        checkboxOtherRead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
                if (isChecked) {
                    numPermission += 4;
                } else {
                    numPermission -= 4;
                }

                showOutput();
            }
        });
    }

    private void creatingGroupExecuteListener() {
        checkboxGroupExecute = (CheckBox) findViewById(R.id.group_execute);
        checkboxGroupExecute.setChecked(false);

        checkboxGroupExecute.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
                if (isChecked) {
                    numPermission += 10;
                } else {
                    numPermission -= 10;
                }

                showOutput();
            }
        });
    }

    private void creatingGroupWriteListener() {
        checkboxGroupWrite = (CheckBox) findViewById(R.id.group_write);
        checkboxGroupWrite.setChecked(false);

        checkboxGroupWrite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
                if (isChecked) {
                    numPermission += 20;
                } else {
                    numPermission -= 20;
                }

                showOutput();
            }
        });
    }

    private void creatingGroupReadListener() {
        checkboxGroupRead = (CheckBox) findViewById(R.id.group_read);
        checkboxGroupRead.setChecked(false);

        checkboxGroupRead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
                if (isChecked) {
                    numPermission += 40;
                } else {
                    numPermission -= 40;
                }

                showOutput();
            }
        });
    }

    private void creatingUserExecuteListener() {
        checkboxUserExecute = (CheckBox) findViewById(R.id.user_execute);
        checkboxUserExecute.setChecked(false);

        checkboxUserExecute.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
                if (isChecked) {
                    numPermission += 100;
                } else {
                    numPermission -= 100;
                }

                showOutput();
            }
        });
    }

    private void creatingUserWriteListener() {
        checkboxUserWrite = (CheckBox) findViewById(R.id.user_write);
        checkboxUserWrite.setChecked(false);

        checkboxUserWrite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
                if (isChecked) {
                    numPermission += 200;
                } else {
                    numPermission -= 200;
                }

                showOutput();
            }
        });
    }


    private void creatingUserReadListener() {
        checkboxUserRead = (CheckBox) findViewById(R.id.user_read);
        checkboxUserRead.setChecked(false);

        checkboxUserRead.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
                if (isChecked) {
                    numPermission += 400;
                } else {
                    numPermission -= 400;
                }

                showOutput();
            }
        });
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

//    checkBox = (CheckBox)v.findViewById(R.id.approved_checkbox);
//    checkBox.setChecked(true);
//
//    checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
//        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//            // update your model (or other business logic) based on isChecked
//        }
//    });

//    public void onCheckboxClicked(View view) {
//        boolean checked = ((CheckBox) view).isChecked();
//
//        switch (view.getId()) {
//            case R.id.user_read:
//                if (checked)
//                    numPermission += 400;
//                else
//                    numPermission -= 400;
//                break;
//            case R.id.user_write:
//                if (checked)
//                    numPermission +=200;
//                else
//                    numPermission -=200;
//                Log.d(LOG_TAG, "result: " + numPermission);
//                break;
//            case R.id.user_execute:
//                if (checked)
//                    numPermission += 100;
//                else
//                    numPermission -= 100;
//                break;
//            case R.id.group_read:
//                if (checked)
//                    numPermission +=40;
//                else
//                    numPermission -=40;
//                Log.d(LOG_TAG, "result: " + numPermission);
//                break;
//            case R.id.group_write:
//                if (checked)
//                    numPermission += 20;
//                else
//                    numPermission -= 20;
//                break;
//            case R.id.group_execute:
//                if (checked)
//                    numPermission +=10;
//                else
//                    numPermission -=10;
//                Log.d(LOG_TAG, "result: " + numPermission);
//                break;
//            case R.id.other_read:
//                if (checked)
//                    numPermission +=4;
//                else
//                    numPermission -=4;
//                Log.d(LOG_TAG, "result: " + numPermission);
//                break;
//            case R.id.other_write:
//                if (checked)
//                    numPermission +=2;
//                else
//                    numPermission -=2;
//                break;
//            case R.id.other_execute:
//                if (checked)
//                    numPermission +=1;
//                else
//                    numPermission -=1;
//                Log.d(LOG_TAG, "result: " + numPermission);
//                break;
//
//        }
//        showOutput();
//    }

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
