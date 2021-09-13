package com.example.javacalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    boolean isEqual = false;    // 全局变量判断是否进行等号操作，来显示内容
    Button btn_1; //1
    Button btn_2; //2
    Button btn_3; //3
    Button btn_4; //4
    Button btn_5; //5
    Button btn_6; //6
    Button btn_7; //7
    Button btn_8; //8
    Button btn_9; //9
    Button btn_0; //0
    Button btn_clear; //c
    Button btn_divide; //除号
    Button btn_mul;//x
    Button btn_reduce;//-
    Button btn_plus; //+
    Button btn_point; //.
    Button btn_equal; //=
    Button btn_reverse; // 取倒数
    Button btn_square;  // 取平方
    Button btn_sin;
    Button btn_cos;
    Button btn_tan;
    Button btn_leftBracket;//(
    Button btn_rightBracket;//)
    EditText contentBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initClickEvents();
    }

    private void initControls() {
        btn_1 = findViewById(R.id.button_1);
        btn_2 = findViewById(R.id.button_2);
        btn_3 = findViewById(R.id.button_3);
        btn_4 = findViewById(R.id.button_4);
        btn_5 = findViewById(R.id.button_5);
        btn_6 = findViewById(R.id.button_6);
        btn_7 = findViewById(R.id.button_7);
        btn_8 = findViewById(R.id.button_8);
        btn_9 = findViewById(R.id.button_9);
        btn_0 = findViewById(R.id.button_0);
        btn_clear = findViewById(R.id.button_clear);
        btn_divide = findViewById(R.id.button_divide);
        btn_mul = findViewById(R.id.button_mul);
        btn_reduce = findViewById(R.id.button_reduce);
        btn_plus = findViewById(R.id.button_plus);
        btn_point = findViewById(R.id.button_point);
        btn_equal = findViewById(R.id.button_equal);
        contentBox = findViewById(R.id.content);
        btn_reverse = findViewById(R.id.button_reverse);
        btn_square = findViewById(R.id.button_square);
        btn_sin = findViewById(R.id.button_sin);
        btn_cos = findViewById(R.id.button_cos);
        btn_tan = findViewById(R.id.button_tan);
        btn_leftBracket = findViewById(R.id.button_leftBrackets);
        btn_rightBracket = findViewById(R.id.button_rightBrackets);
    }

    private void initClickEvents() {
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_0.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_reduce.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_reverse.setOnClickListener(this);
        btn_square.setOnClickListener(this);
        btn_sin.setOnClickListener(this);
        btn_cos.setOnClickListener(this);
        btn_tan.setOnClickListener(this);
        btn_rightBracket.setOnClickListener(this);
        btn_leftBracket.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_1: {
                changeVal("1");
            }
            break;
            case R.id.button_2: {
                changeVal("2");
            }
            break;
            case R.id.button_3: {
                changeVal("3");
            }
            break;
            case R.id.button_4: {
                changeVal("4");
            }
            break;
            case R.id.button_5: {
                changeVal("5");
            }
            break;
            case R.id.button_6: {
                changeVal("6");
            }
            break;
            case R.id.button_7: {
                changeVal("7");
            }
            break;
            case R.id.button_8: {
                changeVal("8");
            }
            break;
            case R.id.button_9: {
                changeVal("9");
            }
            break;
            case R.id.button_0: {
                changeVal("0");
            }
            break;
            case R.id.button_plus: {
                changeVal("+");
            }
            break;
            case R.id.button_reduce: {
                changeVal("-");
            }
            break;
            case R.id.button_mul: {
                changeVal("x");
            }
            break;
            case R.id.button_divide: {
                changeVal("÷");
            }
            break;
            case R.id.button_point: {
                changeVal(".");
            }
            break;
            case R.id.button_leftBrackets: {
                changeVal("(");
            }
            break;
            case R.id.button_rightBrackets: {
                changeVal(")");
            }
            break;
            case R.id.button_reverse: {
                Reverse();
            }
            break;
            case R.id.button_square: {
                Square();
            }
            break;
            case R.id.button_sin: {
                Sin();
            }
            break;
            case R.id.button_cos: {
                Cos();
            }
            break;
            case R.id.button_tan: {
                Tan();
            }
            break;
            case R.id.button_clear: {
                Clear();
            }
            break;
            case R.id.button_equal: {
                try {
                    isEqual = true;
                    String str = contentBox.getText().toString();
                    Calculator calculator = new Calculator();
                    Double result = calculator.Eval(str);
                    contentBox.setText(result.toString());
                }
                catch (Exception e) {
                    isEqual = true;
                    contentBox.setText("出错");
                }
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    @SuppressLint("SetTextI18n")
    private void changeVal(String flag) {
        if (isEqual && flag.matches("[0-9]+")) {
            contentBox.setText("");
            isEqual = false;
        }
        isEqual = false;
        String str = contentBox.getText().toString();
        char ch[] = str.toCharArray();
        if (flag.equals("+")) {
            if (ch[str.length() - 1] == '+') {
                flag = "";
            } else if (ch[str.length() - 1] == '-') {
                ch[str.length() - 1] = '+';
                flag = "";
            } else if (ch[str.length() - 1] == 'x') {
                ch[str.length() - 1] = '+';
                flag = "";
            } else if (ch[str.length() - 1] == '÷') {
                ch[str.length() - 1] = '+';
                flag = "";
            }
        } else if (flag.equals("-")) {
            if (ch[str.length() - 1] == '+') {
                ch[str.length() - 1] = '-';
                flag = "";
            } else if (ch[str.length() - 1] == '-') {
                flag = "";
            } else if (ch[str.length() - 1] == 'x') {
                ch[str.length() - 1] = '-';
                flag = "";
            } else if (ch[str.length() - 1] == '÷') {
                ch[str.length() - 1] = '-';
                flag = "";
            }
        } else if (flag.equals("x")) {
            if (ch[str.length() - 1] == '+') {
                ch[str.length() - 1] = 'x';
                flag = "";
            } else if (ch[str.length() - 1] == '-') {
                ch[str.length() - 1] = 'x';
                flag = "";
            } else if (ch[str.length() - 1] == 'x') {
                flag = "";
            } else if (ch[str.length() - 1] == '÷') {
                ch[str.length() - 1] = 'x';
                flag = "";
            }
        } else if (flag.equals("÷")) {
            if (ch[str.length() - 1] == '+') {
                ch[str.length() - 1] = '÷';
                flag = "";
            } else if (ch[str.length() - 1] == '-') {
                ch[str.length() - 1] = '÷';
                flag = "";
            } else if (ch[str.length() - 1] == 'x') {
                ch[str.length() - 1] = '÷';
                flag = "";
            } else if (ch[str.length() - 1] == '÷') {
                flag = "";
            }
        } else if (flag.equals(".")) {
            if (str != null && !str.equals("") && ch[str.length() - 1] == '.' ) {
                flag = "";
            } else if (ch == null || ch.length == 0) {
                contentBox.setText(".");
                return;
            }
        }
        str = new String(ch);
        contentBox.setText(str + flag);
    }

    private void Clear() {
        contentBox.setText("");
    }

    private void Reverse() {
        String str = contentBox.getText().toString();
        String[] sArray;
        char[] ch = str.toCharArray();
        if (!Character.isDigit(ch[str.length() - 1])) {
            Toast.makeText(this, "无操作数", Toast.LENGTH_SHORT).show();
            return;
        }
        int i = 0;
        String temp = "";
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == 'x' || str.charAt(i) == '÷' || str.charAt(i) == '(' || str.charAt(i) == ')') {
                temp += "#";
                temp += str.charAt(i);
                temp += "#";
            } else {
                temp += str.charAt(i);
            }
            i++;
        }
        sArray = temp.split("#+");
        Double res = 1 / Double.parseDouble(sArray[sArray.length - 1]);
        sArray[sArray.length - 1] = String.valueOf(res);
        StringBuilder str_new = new StringBuilder();
        for (String s : sArray) {
            str_new.append(s);
        }
        contentBox.setText(str_new.toString());
    }

    private void Square() {
        String str = contentBox.getText().toString();
        String[] sArray;
        char[] ch = str.toCharArray();
        if (!Character.isDigit(ch[str.length() - 1])) {
            Toast.makeText(this, "无操作数", Toast.LENGTH_SHORT).show();
            return;
        }
        int i = 0;
        String temp = "";
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == 'x' || str.charAt(i) == '÷' || str.charAt(i) == '(' || str.charAt(i) == ')') {
                temp += "#";
                temp += str.charAt(i);
                temp += "#";
            } else {
                temp += str.charAt(i);
            }
            i++;
        }
        sArray = temp.split("#+");
        Double res = Double.parseDouble(sArray[sArray.length - 1]) * Double.parseDouble(sArray[sArray.length - 1]);
        sArray[sArray.length - 1] = String.valueOf(res);
        StringBuilder str_new = new StringBuilder();
        for (String s : sArray) {
            str_new.append(s);
        }
        contentBox.setText(str_new.toString());
    }

    private void Sin() {
        String str = contentBox.getText().toString();
        String[] sArray;
        char[] ch = str.toCharArray();
        if (!Character.isDigit(ch[str.length() - 1])) {
            Toast.makeText(this, "无操作数", Toast.LENGTH_SHORT).show();
            return;
        }
        int i = 0;
        String temp = "";
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == 'x' || str.charAt(i) == '÷' || str.charAt(i) == '(' || str.charAt(i) == ')') {
                temp += "#";
                temp += str.charAt(i);
                temp += "#";
            } else {
                temp += str.charAt(i);
            }
            i++;
        }
        sArray = temp.split("#+");
        Double res = Math.sin(Double.parseDouble(sArray[sArray.length - 1]));
        sArray[sArray.length - 1] = String.valueOf(res);
        StringBuilder str_new = new StringBuilder();
        for (String s : sArray) {
            str_new.append(s);
        }
        contentBox.setText(str_new.toString());
    }

    private void Cos() {
        String str = contentBox.getText().toString();
        String[] sArray;
        char[] ch = str.toCharArray();
        if (!Character.isDigit(ch[str.length() - 1])) {
            Toast.makeText(this, "无操作数", Toast.LENGTH_SHORT).show();
            return;
        }
        int i = 0;
        String temp = "";
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == 'x' || str.charAt(i) == '÷' || str.charAt(i) == '(' || str.charAt(i) == ')') {
                temp += "#";
                temp += str.charAt(i);
                temp += "#";
            } else {
                temp += str.charAt(i);
            }
            i++;
        }
        sArray = temp.split("#+");
        Double res = Math.cos(Double.parseDouble(sArray[sArray.length - 1]));
        sArray[sArray.length - 1] = String.valueOf(res);
        StringBuilder str_new = new StringBuilder();
        for (String s : sArray) {
            str_new.append(s);
        }
        contentBox.setText(str_new.toString());
    }

    private void Tan() {
        String str = contentBox.getText().toString();
        String[] sArray;
        char[] ch = str.toCharArray();
        if (!Character.isDigit(ch[str.length() - 1])) {
            Toast.makeText(this, "无操作数", Toast.LENGTH_SHORT).show();
            return;
        }
        int i = 0;
        String temp = "";
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == 'x' || str.charAt(i) == '÷' || str.charAt(i) == '(' || str.charAt(i) == ')') {
                temp += "#";
                temp += str.charAt(i);
                temp += "#";
            } else {
                temp += str.charAt(i);
            }
            i++;
        }
        sArray = temp.split("#+");
        Double res = Math.tan(Double.parseDouble(sArray[sArray.length - 1]));
        sArray[sArray.length - 1] = String.valueOf(res);
        StringBuilder str_new = new StringBuilder();
        for (String s : sArray) {
            str_new.append(s);
        }
        contentBox.setText(str_new.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help: {
                Toast.makeText(this, "这是帮助", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.exit: {
                finish();
            }
            break;
            case R.id.unitChange: {
                Intent intent = new Intent(this, UnitChangeActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.volumeChange: {
                Intent intent = new Intent(this, VolumeChangeActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.baseChange: {
                Intent intent = new Intent(this, BaseChangeActivity.class);
                startActivity(intent);
            }
            break;
        }
        return true;
    }
}