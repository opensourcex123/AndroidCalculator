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

public class BaseChangeActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1Base; //1
    Button btn2Base; //2
    Button btn3Base; //3
    Button btn4Base; //4
    Button btn5Base; //5
    Button btn6Base; //6
    Button btn7Base; //7
    Button btn8Base; //8
    Button btn9Base; //9
    Button btn0Base; //0
    Button btnABase;
    Button btnBBase;
    Button btnCBase;
    Button btnDBase;
    Button btnEBase;
    Button btnFBase;
    Button btnClearBase; //c
    Button btnPointBase; //.
    Button btnDelBase;
    EditText contentStartBase;
    TextView contentDestBase;
    Spinner spinnerStartBase;
    Spinner spinnerDestBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_change);
        initControlsBase();
        initClickEventsBase();
    }

    private void initControlsBase() {
        btn1Base = findViewById(R.id.btn_1_base);
        btn2Base = findViewById(R.id.btn_2_base);
        btn3Base = findViewById(R.id.btn_3_base);
        btn4Base = findViewById(R.id.btn_4_base);
        btn5Base = findViewById(R.id.btn_5_base);
        btn6Base = findViewById(R.id.btn_6_base);
        btn7Base = findViewById(R.id.btn_7_base);
        btn8Base = findViewById(R.id.btn_8_base);
        btn9Base = findViewById(R.id.btn_9_base);
        btn0Base = findViewById(R.id.btn_0_base);
        btnABase = findViewById(R.id.btn_A_base);
        btnBBase = findViewById(R.id.btn_B_base);
        btnCBase = findViewById(R.id.btn_C_base);
        btnDBase = findViewById(R.id.btn_D_base);
        btnEBase = findViewById(R.id.btn_E_base);
        btnFBase = findViewById(R.id.btn_F_base);
        btnDelBase = findViewById(R.id.btn_del_base);
        btnClearBase = findViewById(R.id.btn_clear_base);
        btnPointBase = findViewById(R.id.btn_point_base);
        contentStartBase = findViewById(R.id.unitStartBase);
        contentDestBase = findViewById(R.id.unitDestBase);
        spinnerStartBase = findViewById(R.id.spinnerStartBase);
        spinnerDestBase = findViewById(R.id.spinnerDestBase);
    }

    private void initClickEventsBase() {
        btn1Base.setOnClickListener(this);
        btn2Base.setOnClickListener(this);
        btn3Base.setOnClickListener(this);
        btn4Base.setOnClickListener(this);
        btn5Base.setOnClickListener(this);
        btn6Base.setOnClickListener(this);
        btn7Base.setOnClickListener(this);
        btn8Base.setOnClickListener(this);
        btn9Base.setOnClickListener(this);
        btn0Base.setOnClickListener(this);
        btnABase.setOnClickListener(this);
        btnBBase.setOnClickListener(this);
        btnCBase.setOnClickListener(this);
        btnDBase.setOnClickListener(this);
        btnEBase.setOnClickListener(this);
        btnFBase.setOnClickListener(this);
        btnPointBase.setOnClickListener(this);
        btnClearBase.setOnClickListener(this);
        btnDelBase.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1_base: {
                changeValBase("1");
            }
            break;
            case R.id.btn_2_base: {
                changeValBase("2");
            }
            break;
            case R.id.btn_3_base: {
                changeValBase("3");
            }
            break;
            case R.id.btn_4_base: {
                changeValBase("4");
            }
            break;
            case R.id.btn_5_base: {
                changeValBase("5");
            }
            break;
            case R.id.btn_6_base: {
                changeValBase("6");
            }
            break;
            case R.id.btn_7_base: {
                changeValBase("7");
            }
            break;
            case R.id.btn_8_base: {
                changeValBase("8");
            }
            break;
            case R.id.btn_9_base: {
                changeValBase("9");
            }
            break;
            case R.id.btn_0_base: {
                changeValBase("0");
            }
            break;
            case R.id.btn_A_base: {
                changeValBase("A");
            }
            break;case R.id.btn_B_base: {
                changeValBase("B");
            }
            break;case R.id.btn_C_base: {
                changeValBase("C");
            }
            break;case R.id.btn_D_base: {
                changeValBase("D");
            }
            break;case R.id.btn_E_base: {
                changeValBase("E");
            }
            break;case R.id.btn_F_base: {
                changeValBase("F");
            }
            break;
            case R.id.btn_point_base: {
                changeValBase(".");
            }
            break;
            case R.id.btn_clear_base: {
                ClearBase();
            }
            break;
            case R.id.btn_del_base: {
                DeleteBase();
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    @SuppressLint("SetTextI18n")
    private void changeValBase(String flag) {
        String str = contentStartBase.getText().toString();
        char ch[] = str.toCharArray();
        if (flag.equals(".")) {
            if (str != null && !str.equals("") && ch[str.length() - 1] == '.') {
                flag = "";
            } else if (ch == null || ch.length == 0) {
                flag = ".";
            }
        }
        String strStart = (String) spinnerStartBase.getSelectedItem();
        String strDest = (String) spinnerDestBase.getSelectedItem();

        if (strStart.equals("二进制")) {
            if (strDest.equals("二进制")) {
                try {
                    int temp = Integer.parseInt(str + flag, 2);
                    String numDest = Integer.toBinaryString(temp);
                    contentStartBase.setText(str + flag);
                    contentDestBase.setText(numDest);
                }
                catch (Exception e) {
                    contentStartBase.setText("");
                    contentDestBase.setText("");
                }
            } else if (strDest.equals("八进制")) {
                try {
                    int temp = Integer.parseInt(str + flag, 2);
                    String numberDest = Integer.toOctalString(temp);
                    contentStartBase.setText(str + flag);
                    contentDestBase.setText(numberDest);
                }
                catch (Exception e) {
                    contentStartBase.setText("");
                    contentDestBase.setText("");
                }
            } else if (strDest.equals("十进制")) {
                try {
                    int temp = Integer.parseInt(str + flag, 2);
                    contentStartBase.setText(str + flag);
                    contentDestBase.setText(Integer.toString(temp));
                } catch (Exception e) {
                    contentStartBase.setText("");
                    contentDestBase.setText("");
                }
            } else if (strDest.equals("十六进制")) {
                try {
                    int temp = Integer.parseInt(str + flag, 2);
                    String numDest = Integer.toHexString(temp);
                    contentStartBase.setText(str + flag);
                    contentDestBase.setText(numDest);
                } catch (Exception e) {
                    contentStartBase.setText("");
                    contentDestBase.setText("");
                }
            }
        } else if (strStart.equals("八进制")) {
            if (strDest.equals("二进制")) {
                try {
                    int numStart = Integer.parseInt(str + flag);
                    String numDest = Integer.toBinaryString(numStart);
                    contentStartBase.setText(str + flag);
                    contentDestBase.setText(numDest);
                }
                catch (Exception e) {
                    contentStartBase.setText("");
                    contentDestBase.setText("");
                }
            } else if (strDest.equals("八进制")) {
                try {
                    int temp = Integer.parseInt(str + flag, 8);
                    String numDest = Integer.toOctalString(temp);
                    contentStartBase.setText(str + flag);
                    contentDestBase.setText(numDest);
                }
                catch (Exception e) {
                    contentStartBase.setText("");
                    contentDestBase.setText("");
                }
            } else if (strDest.equals("十进制")) {
                try {
                    int temp = Integer.parseInt(str + flag, 8);
                    contentStartBase.setText(str + flag);
                    contentDestBase.setText(Integer.toString(temp));
                }
                catch (Exception e) {
                    contentStartBase.setText("");
                    contentDestBase.setText("");
                }
            } else if (strDest.equals("十六进制")) {
                try {
                    int temp = Integer.parseInt(str + flag, 8);
                    String numDest = Integer.toHexString(temp);
                    contentStartBase.setText(str + flag);
                    contentDestBase.setText(numDest);
                }
                catch (Exception e) {
                    contentStartBase.setText("");
                    contentDestBase.setText("");
                }
            }
        } else if (strStart.equals("十进制")) {
            if (strDest.equals("二进制")) {
                try {
                    int numStart = Integer.parseInt(str + flag);
                    String numDest = Integer.toBinaryString(numStart);
                    contentStartBase.setText(str + flag);
                    contentDestBase.setText(numDest);
                } catch (Exception e) {
                    contentStartBase.setText("");
                    contentDestBase.setText("");
                }
            } else if (strDest.equals("八进制")) {
                try {
                    int numStart = Integer.parseInt(str + flag);
                    String numDest = Integer.toOctalString(numStart);
                    contentStartBase.setText(str + flag);
                    contentDestBase.setText(numDest);
                } catch (Exception e) {
                    contentStartBase.setText("");
                    contentDestBase.setText("");
                }
            } else if (strDest.equals("十进制")) {
                try {
                    int numStart = Integer.parseInt(str + flag);
                    contentStartBase.setText(str + flag);
                    contentDestBase.setText(Integer.toString(numStart));
                } catch (Exception e) {
                    contentStartBase.setText("");
                    contentDestBase.setText("");
                }
            } else if (strDest.equals("十六进制")) {
                try {
                    int numStart = Integer.parseInt(str + flag);
                    String numDest = Integer.toOctalString(numStart);
                    contentStartBase.setText(str + flag);
                    contentDestBase.setText(numDest);
                } catch (Exception e) {
                    contentStartBase.setText("");
                    contentDestBase.setText("");
                }
            }
        } else if (strStart.equals("十六进制")) {
            if (strDest.equals("二进制")) {
                int temp = Integer.parseInt(str + flag, 16);
                String numDest = Integer.toBinaryString(temp);
                contentStartBase.setText(str + flag);
                contentDestBase.setText(numDest);
            } else if (strDest.equals("八进制")) {
                int temp = Integer.parseInt(str + flag, 16);
                String numDest = Integer.toOctalString(temp);
                contentStartBase.setText(str + flag);
                contentDestBase.setText(numDest);
            } else if (strDest.equals("十进制")) {
                int temp = Integer.parseInt(str + flag, 16);
                contentStartBase.setText(str + flag);
                contentDestBase.setText(Integer.toString(temp));
            } else if (strDest.equals("十六进制")) {
                int temp = Integer.parseInt(str + flag, 16);
                String numDest = Integer.toHexString(temp);
                contentStartBase.setText(str + flag);
                contentDestBase.setText(numDest);
            }
        }
    }

    private void ClearBase() {
        contentStartBase.setText("");
        contentDestBase.setText("");
    }

    private void DeleteBase() {
        try {
            String str = contentStartBase.getText().toString();
            str = str.substring(0, str.length() - 1);
            contentStartBase.setText(str);
            changeValBase("");
        }
        catch (Exception e) {
            contentStartBase.setText("");
            contentDestBase.setText("");
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