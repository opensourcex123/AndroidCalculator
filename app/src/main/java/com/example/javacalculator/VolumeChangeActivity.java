package com.example.javacalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class VolumeChangeActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn1Volume; //1
    Button btn2Volume; //2
    Button btn3Volume; //3
    Button btn4Volume; //4
    Button btn5Volume; //5
    Button btn6Volume; //6
    Button btn7Volume; //7
    Button btn8Volume; //8
    Button btn9Volume; //9
    Button btn0Volume; //0
    Button btnClearVolume; //c
    Button btnPointVolume; //.
    Button btnDelVolume;
    EditText contentStartVolume;
    TextView contentDestVolume;
    Spinner spinnerStartVolume;
    Spinner spinnerDestVolume;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_change);
        initControlsVolume();
        initClickEventsVolume();
    }

    private void initControlsVolume() {
        btn1Volume = findViewById(R.id.btn_1_volume);
        btn2Volume = findViewById(R.id.btn_2_volume);
        btn3Volume = findViewById(R.id.btn_3_volume);
        btn4Volume = findViewById(R.id.btn_4_volume);
        btn5Volume = findViewById(R.id.btn_5_volume);
        btn6Volume = findViewById(R.id.btn_6_volume);
        btn7Volume = findViewById(R.id.btn_7_volume);
        btn8Volume = findViewById(R.id.btn_8_volume);
        btn9Volume = findViewById(R.id.btn_9_volume);
        btn0Volume = findViewById(R.id.btn_0_volume);
        btnDelVolume = findViewById(R.id.btn_del_volume);
        btnClearVolume = findViewById(R.id.btn_clear_volume);
        btnPointVolume = findViewById(R.id.btn_point_volume);
        contentStartVolume = findViewById(R.id.unitStartVolume);
        contentDestVolume = findViewById(R.id.unitDestVolume);
        spinnerStartVolume = findViewById(R.id.spinnerStartVolume);
        spinnerDestVolume = findViewById(R.id.spinnerDestVolume);
    }

    private void initClickEventsVolume() {
        btn1Volume.setOnClickListener(this);
        btn2Volume.setOnClickListener(this);
        btn3Volume.setOnClickListener(this);
        btn4Volume.setOnClickListener(this);
        btn5Volume.setOnClickListener(this);
        btn6Volume.setOnClickListener(this);
        btn7Volume.setOnClickListener(this);
        btn8Volume.setOnClickListener(this);
        btn9Volume.setOnClickListener(this);
        btn0Volume.setOnClickListener(this);
        btnPointVolume.setOnClickListener(this);
        btnClearVolume.setOnClickListener(this);
        btnDelVolume.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1_volume: {
                changeValVolume("1");
            }
            break;
            case R.id.btn_2_volume: {
                changeValVolume("2");
            }
            break;
            case R.id.btn_3_volume: {
                changeValVolume("3");
            }
            break;
            case R.id.btn_4_volume: {
                changeValVolume("4");
            }
            break;
            case R.id.btn_5_volume: {
                changeValVolume("5");
            }
            break;
            case R.id.btn_6_volume: {
                changeValVolume("6");
            }
            break;
            case R.id.btn_7_volume: {
                changeValVolume("7");
            }
            break;
            case R.id.btn_8_volume: {
                changeValVolume("8");
            }
            break;
            case R.id.btn_9_volume: {
                changeValVolume("9");
            }
            break;
            case R.id.btn_0_volume: {
                changeValVolume("0");
            }
            break;
            case R.id.btn_point_volume: {
                changeValVolume(".");
            }
            break;
            case R.id.btn_clear_volume: {
                ClearVolume();
            }
            break;
            case R.id.btn_del_volume: {
                DeleteVolume();
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    @SuppressLint("SetTextI18n")
    private void changeValVolume(String flag) {
        String str = contentStartVolume.getText().toString();
        char ch[] = str.toCharArray();
        if (flag.equals(".")) {
            if (str != null && !str.equals("") && ch[str.length() - 1] == '.') {
                flag = "";
            } else if (ch == null || ch.length == 0) {
                flag = ".";
            }
        }
        String strStart = (String) spinnerStartVolume.getSelectedItem();
        String strDest = (String) spinnerDestVolume.getSelectedItem();

        if (strStart.equals("立方米")) {
            if (strDest.equals("立方米")) {
                try {
                    Double numberStart = Double.parseDouble(str + flag);
                    Double numberDest = numberStart;
                    contentStartVolume.setText(str + flag);
                    contentDestVolume.setText(numberDest.toString());
                }
                catch (Exception e) {
                    contentStartVolume.setText("");
                    contentDestVolume.setText("");
                }
            } else if (strDest.equals("立方分米")) {
                try {
                    Double numberStart = Double.parseDouble(str + flag);
                    Double numberDest = numberStart * 1000;
                    contentStartVolume.setText(str + flag);
                    contentDestVolume.setText(numberDest.toString());
                }
                catch (Exception e) {
                    contentStartVolume.setText("");
                    contentDestVolume.setText("");
                }
            }
        } else if (strStart.equals("立方分米")) {
            if (strDest.equals("立方米")) {
                try {
                    Double numberStart = Double.parseDouble(str + flag);
                    Double numberDest = numberStart / 1000;
                    contentStartVolume.setText(str + flag);
                    contentDestVolume.setText(numberDest.toString());
                }
                catch (Exception e) {
                    contentStartVolume.setText("");
                    contentDestVolume.setText("");
                }
            } else if (strDest.equals("立方分米")) {
                try {
                    Double numberStart = Double.parseDouble(str + flag);
                    Double numberDest = numberStart;
                    contentStartVolume.setText(str + flag);
                    contentDestVolume.setText(numberDest.toString());
                }
                catch (Exception e) {
                    contentStartVolume.setText("");
                    contentDestVolume.setText("");
                }
            }
        }
    }

    private void ClearVolume() {
        contentStartVolume.setText("");
        contentDestVolume.setText("");
    }

    private void DeleteVolume() {
        try {
            String str = contentStartVolume.getText().toString();
            str = str.substring(0, str.length() - 1);
            contentStartVolume.setText(str);
            changeValVolume("");
        }
        catch (Exception e) {
            contentStartVolume.setText("");
            contentDestVolume.setText("");
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