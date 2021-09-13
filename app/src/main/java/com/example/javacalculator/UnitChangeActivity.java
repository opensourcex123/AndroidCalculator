package com.example.javacalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UnitChangeActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1; //1
    Button btn2; //2
    Button btn3; //3
    Button btn4; //4
    Button btn5; //5
    Button btn6; //6
    Button btn7; //7
    Button btn8; //8
    Button btn9; //9
    Button btn0; //0
    Button btnClear; //c
    Button btnPoint; //.
    Button btnDel;
    EditText contentStart;
    TextView contentDest;
    Spinner spinnerStart;
    Spinner spinnerDest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_change);
        initControlsUnit();
        initClickEventsUnit();
    }

    private void initControlsUnit() {
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btn0 = findViewById(R.id.btn_0);
        btnDel = findViewById(R.id.btn_del);
        btnClear = findViewById(R.id.btn_clear);
        btnPoint = findViewById(R.id.btn_point);
        contentStart = findViewById(R.id.unitStart);
        contentDest = findViewById(R.id.unitDest);
        spinnerStart = findViewById(R.id.spinnerStart);
        spinnerDest = findViewById(R.id.spinnerDest);
    }

    private void initClickEventsUnit() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnDel.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1: {
                changeValUnit("1");
            }
            break;
            case R.id.btn_2: {
                changeValUnit("2");
            }
            break;
            case R.id.btn_3: {
                changeValUnit("3");
            }
            break;
            case R.id.btn_4: {
                changeValUnit("4");
            }
            break;
            case R.id.btn_5: {
                changeValUnit("5");
            }
            break;
            case R.id.btn_6: {
                changeValUnit("6");
            }
            break;
            case R.id.btn_7: {
                changeValUnit("7");
            }
            break;
            case R.id.btn_8: {
                changeValUnit("8");
            }
            break;
            case R.id.btn_9: {
                changeValUnit("9");
            }
            break;
            case R.id.btn_0: {
                changeValUnit("0");
            }
            break;
            case R.id.btn_point: {
                changeValUnit(".");
            }
            break;
            case R.id.btn_clear: {
                ClearUnit();
            }
            break;
            case R.id.btn_del: {
                DeleteUnit();
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    @SuppressLint("SetTextI18n")
    private void changeValUnit(String flag) {
        String str = contentStart.getText().toString();
        char ch[] = str.toCharArray();
        if (flag.equals(".")) {
            if (str != null && !str.equals("") && ch[str.length() - 1] == '.') {
                flag = "";
            } else if (ch == null || ch.length == 0) {
                flag = ".";
            }
        }
        String strStart = (String) spinnerStart.getSelectedItem();
        String strDest = (String) spinnerDest.getSelectedItem();

        if (strStart.equals("千米")) {
            if (strDest.equals("千米")) {
                try {
                    Double numberStart = Double.parseDouble(str + flag);
                    Double numberDest = numberStart;
                    contentStart.setText(str + flag);
                    contentDest.setText(numberDest.toString());
                }
                catch (Exception e) {
                    contentStart.setText("");
                    contentDest.setText("");
                }
            } else if (strDest.equals("米")) {
                try {
                    Double numberStart = Double.parseDouble(str + flag);
                    Double numberDest = numberStart * 1000;
                    contentStart.setText(str + flag);
                    contentDest.setText(numberDest.toString());
                }
                catch (Exception e) {
                    contentStart.setText("");
                    contentDest.setText("");
                }
            }
        } else if (strStart.equals("米")) {
            if (strDest.equals("千米")) {
                try {
                    Double numberStart = Double.parseDouble(str + flag);
                    Double numberDest = numberStart / 1000;
                    contentStart.setText(str + flag);
                    contentDest.setText(numberDest.toString());
                }
                catch (Exception e) {
                    contentStart.setText("");
                    contentDest.setText("");
                }
            } else if (strDest.equals("米")) {
                try {
                    Double numberStart = Double.parseDouble(str + flag);
                    Double numberDest = numberStart;
                    contentStart.setText(str + flag);
                    contentDest.setText(numberDest.toString());
                }
                catch (Exception e) {
                    contentStart.setText("");
                    contentDest.setText("");
                }
            }
        }
    }

    private void ClearUnit() {
        contentStart.setText("");
        contentDest.setText("");
    }

    private void DeleteUnit() {
        try {
            String str = contentStart.getText().toString();
            str = str.substring(0, str.length() - 1);
            contentStart.setText(str);
            changeValUnit("");
        }
        catch (Exception e) {
            contentStart.setText("");
            contentDest.setText("");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.unitmenu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help_unit: {
                Toast.makeText(this, "这是帮助", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.exit_unit: {
                finish();
            }
            break;
        }
        return true;
    }
}