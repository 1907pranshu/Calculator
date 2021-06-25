package com.pranshu.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView ed;
    boolean isNew = true;
    String oldNum = "";
    String op = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = (TextView) findViewById(R.id.ed);
    }

    public void numberEvent(View view) {
        if(isNew){
            ed.setText("");
            isNew = false;
        }
        String num = ed.getText().toString();
        switch(view.getId()){
            case R.id.btn9:
                num+=9;
                break;
            case R.id.btn8:
                num+="8";
                break;
            case R.id.btn7:
                num+="7";
                break;
            case R.id.btn6:
                num+="6";
                break;
            case R.id.btn5:
                num+="5";
                break;
            case R.id.btn4:
                num+="4";
                break;
            case R.id.btn3:
                num+="3";
                break;
            case R.id.btn2:
                num+="2";
                break;
            case R.id.btn1:
                num+="1";
                break;
            case R.id.btn0:
                num+="0";
                break;
            case R.id.btnclr:
                num = "0";
                isNew = true;
                break;

            case R.id.btnrnd:
                num+=".";
                break;
        }

        ed.setText(num);
    }

    public void opEvent(View view){
        isNew = true;
        oldNum = ed.getText().toString();

        switch (view.getId()) {
            case R.id.btnadd:
                op = "+";
                break;
            case R.id.btnmin:
                op = "-";
                break;
            case R.id.btnmul:
                op = "*";
                break;
            case R.id.btndiv:
                op = "/";
                break;
            case R.id.btnsqrt:
                op = "~2";
                break;
            case R.id.btnsqr:
                op = "^2";
                break;
            case R.id.btncube:
                op = "^3";
                break;
            case R.id.btnsin:
                oldNum = ed.getText().toString();
                ed.setText("sin("+oldNum+")");
                op = "sin";
                break;
            case R.id.btncos:
                oldNum = ed.getText().toString();
                ed.setText("cos("+oldNum+")");
                op = "cos";
                break;
            case R.id.btntan:
                oldNum = ed.getText().toString();
                ed.setText("tan("+oldNum+")");
                op = "tan";
                break;

        }
    }


    public void equalEvent(View view) {
        double res = 0.0;
        double radians = 0.0;
        String newNum;
        if(op.equals("~2")||op.equals("^2")||op.equals("^3")||op.equals("rnd")||op.equals("sin")||op.equals("cos")||op.equals("tan")){
            newNum=oldNum;
        }
        else {
            newNum = ed.getText().toString();
        }

        switch (op){
            case "+":
                res = Double.parseDouble(oldNum) + Double.parseDouble(newNum);
                break;
            case "-":
                res = Double.parseDouble(oldNum) - Double.parseDouble(newNum);
                break;
            case "*":
                res = Double.parseDouble(oldNum) * Double.parseDouble(newNum);
                break;
            case "/":
                res = Double.parseDouble(oldNum) / Double.parseDouble(newNum);
                break;
            case "~2":
                res = Math.sqrt(Double.parseDouble(oldNum));
                break;
            case "^2":
                res = Double.parseDouble(oldNum) * Double.parseDouble(oldNum);
                break;
            case "^3":
                res = Double.parseDouble(oldNum) * Double.parseDouble(newNum) * Double.parseDouble(newNum);
                break;
            case "sin":
                radians = Math.toRadians(Double.parseDouble(oldNum));
                double sinValue = Math.sin(radians);
                res = sinValue;
                break;
            case "cos":
                radians = Math.toRadians(Double.parseDouble(oldNum));
                double cosValue = Math.cos(radians);
                res = cosValue;
                break;
            case "tan":
                radians = Math.toRadians(Double.parseDouble(oldNum));
                double tanValue = Math.tan(radians);
                res = tanValue;
                break;

        }

        DecimalFormat df = new DecimalFormat("#.####");
        Double resu = new Double(df.format(res));
        ed.setText(resu+"");
    }
}