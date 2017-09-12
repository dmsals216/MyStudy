package com.example.goem.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn_plus, btn_minus, btn_multi, btn_divi, btn_equal, btn_clear;
    private TextView inputViewText, outputViewText;

    int result = 0;
    int input = 0;
    int calcCheck = 1;
    // calcCheck == 1   +
    // calcCheck == 2   -
    // calcCheck == 3   *
    // calcCheck == 4   /


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewId();
        setListener();
    }



    @Override
    public void onClick(View v) {
        if (v.getId() == btn0.getId()) {
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("0");
            }else {
                inputViewText.setText(inputViewText.getText() + "0");
            }
            input = input * 10 + 0;
            outputViewText.setText("");
        }else if (v.getId() == btn1.getId()) {
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("1");
            }else {
                inputViewText.setText(inputViewText.getText() + "1");
            }
            input = input * 10 + 1;
            outputViewText.setText("");
        }else if (v.getId() == btn2.getId()) {
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("2");
            }else {
                inputViewText.setText(inputViewText.getText() + "2");
            }
            input = input * 10 + 2;
            outputViewText.setText("");
        }else if (v.getId() == btn3.getId()) {
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("3");
            }else {
                inputViewText.setText(inputViewText.getText() + "3");
            }
            input = input * 10 + 3;
            outputViewText.setText("");
        }else if (v.getId() == btn4.getId()) {
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("4");
            }else {
                inputViewText.setText(inputViewText.getText() + "4");
            }
            input = input * 10 + 4;
            outputViewText.setText("");
        }else if (v.getId() == btn5.getId()) {
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("5");
            }else {
                inputViewText.setText(inputViewText.getText() + "5");
            }
            input = input * 10 + 5;
            outputViewText.setText("");
        }else if (v.getId() == btn6.getId()) {
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("6");
            }else {
                inputViewText.setText(inputViewText.getText() + "6");
            }
            input = input * 10 + 6;
            outputViewText.setText("");
        }else if (v.getId() == btn7.getId()) {
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("7");
            }else {
                inputViewText.setText(inputViewText.getText() + "7");
            }
            input = input * 10 + 7;
            outputViewText.setText("");
        }else if (v.getId() == btn8.getId()) {
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("8");
            }else {
                inputViewText.setText(inputViewText.getText() + "8");
            }
            input = input * 10 + 8;
            outputViewText.setText("");
        }else if (v.getId() == btn9.getId()) {
            if(inputViewText.getText().equals("0")) {
                inputViewText.setText("9");
            }else {
                inputViewText.setText(inputViewText.getText() + "9");
            }
            input = input * 10 + 9;
            outputViewText.setText("");
        }else if (v.getId() == btn_plus.getId()) {
            String imsi = inputViewText.getText() + "";
            if(imsi.equals("") || imsi.equals("0")) {
                return;
            }
            String imsi2 = imsi.charAt(imsi.length() - 1) + "";
            if(imsi2.equals("+") || imsi2.equals("-") || imsi2.equals("x") || imsi2.equals("/")) {
                inputViewText.setText(imsi.substring(0, imsi.length() - 1) +"+");
            } else {
                inputViewText.setText(inputViewText.getText() + "+");
            }
            calc();
            input = 0;
            calcCheck = 1;
            outputViewText.setText("");
        }else if (v.getId() == btn_minus.getId()) {
            String imsi = inputViewText.getText() + "";
            if(imsi.equals("") || imsi.equals("0")) {
                return;
            }
            String imsi2 = imsi.charAt(imsi.length() - 1) + "";
            if(imsi2.equals("+") || imsi2.equals("-") || imsi2.equals("x") || imsi2.equals("/")) {
                inputViewText.setText(imsi.substring(0, imsi.length() - 1) +"-");
            } else {
                inputViewText.setText(inputViewText.getText() + "-");
            }
            calc();
            input = 0;
            calcCheck = 2;
            outputViewText.setText("");
        }else if (v.getId() == btn_multi.getId()) {
            String imsi = inputViewText.getText() + "";
            if(imsi.equals("") || imsi.equals("0")) {
                return;
            }
            String imsi2 = imsi.charAt(imsi.length() - 1) + "";
            if(imsi2.equals("+") || imsi2.equals("-") || imsi2.equals("x") || imsi2.equals("/")) {
                inputViewText.setText(imsi.substring(0, imsi.length() - 1) +"x");
            } else {
                inputViewText.setText(inputViewText.getText() + "x");
            }
            calc();
            input = 0;
            calcCheck = 3;
            outputViewText.setText("");
        }else if (v.getId() == btn_divi.getId()) {
            String imsi = inputViewText.getText() + "";
            if(imsi.equals("") || imsi.equals("0")) {
                return;
            }
            String imsi2 = imsi.charAt(imsi.length() - 1) + "";
            if(imsi2.equals("+") || imsi2.equals("-") || imsi2.equals("x") || imsi2.equals("/")) {
                inputViewText.setText(imsi.substring(0, imsi.length() - 1) +"/");
            } else {
                inputViewText.setText(inputViewText.getText() + "/");
            }
            calc();
            input = 0;
            calcCheck = 4;
            outputViewText.setText("");
        }else if (v.getId() == btn_equal.getId()) {
            String imsi = inputViewText.getText() + "";
            if(imsi.equals("") || imsi.equals("0")) {
                return;
            }
            String imsi2 = imsi.charAt(imsi.length() - 1) + "";
            if(imsi2.equals("+") || imsi2.equals("-") || imsi2.equals("x") || imsi2.equals("/")) {
                return;
            } else {
                calc();
                outputViewText.setText(result + "");
                inputViewText.setText(result + "");
                input = result;
                result = 0;
                calcCheck = 1;
            }
        }else if (v.getId() == btn_clear.getId()) {
            inputViewText.setText("");
            outputViewText.setText("");
            result = 0;
            input = 0;
            calcCheck = 1;
        }

    }

    public void calc() {
        if(calcCheck == 1) {
            result += input;
        }else if(calcCheck == 2) {
            result -= input;
        }else if(calcCheck == 3) {
            result *= input;
        }else if(calcCheck == 4) {
            result /= input;
        }
    }






















    // Id값을 변수에 넣는다.
    private void setViewId() {
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multi = (Button) findViewById(R.id.btn_multi);
        btn_divi = (Button) findViewById(R.id.btn_divi);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_clear = (Button) findViewById(R.id.btn_clear);

        inputViewText = (TextView) findViewById(R.id.inputViewText);
        outputViewText = (TextView) findViewById(R.id.outputViewText);
    }

    // Listener선언을 한다.
    private void setListener() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multi.setOnClickListener(this);
        btn_divi.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);

    }
}
