package com.example.goem.calculator2;

import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn_clear, btn_front, btn_back, btn_plus, btn_minus, btn_multi, btn_divi, btn_equal, btn_dot, btn_change;
    private TextView preViewText, resultViewText;
    private String getpreView = "";
    private String input = "";
    boolean firstCheck = false;
    boolean equalCheck = false;
    private int frontCheck = 0;
    private int backCheck = 0;
    double result = 0.0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewId();
        setListener();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == btn0.getId()) {
            pushButton("0");
        }else if(v.getId() == btn1.getId()) {
            pushButton("1");
        }else if(v.getId() == btn2.getId()) {
            pushButton("2");
        }else if(v.getId() == btn3.getId()) {
            pushButton("3");
        }else if(v.getId() == btn4.getId()) {
            pushButton("4");
        }else if(v.getId() == btn5.getId()) {
            pushButton("5");
        }else if(v.getId() == btn6.getId()) {
            pushButton("6");
        }else if(v.getId() == btn7.getId()) {
            pushButton("7");
        }else if(v.getId() == btn8.getId()) {
            pushButton("8");
        }else if(v.getId() == btn9.getId()) {
            pushButton("9");
        }else if(v.getId() == btn_plus.getId()) {
            pushOperatorButton("+");
        }else if(v.getId() == btn_minus.getId()) {
            pushOperatorButton("-");
        }else if(v.getId() == btn_multi.getId()) {
            pushOperatorButton("x");
        }else if(v.getId() == btn_divi.getId()) {
            pushOperatorButton("/");
        }else if(v.getId() == btn_dot.getId()) {
            if(firstCheck == false) {
                input = "0.";
                preViewText.setText(input);
                firstCheck = true;
                return;
            }
            String imsi = preViewText.getText() + "";
            String imsi2 = imsi.charAt(imsi.length() - 1) + "";
            for(int i = 0; i < input.length(); i++) {
                if(!Character.isLetterOrDigit(input.charAt(i))) {
                    return;
                }
            }
            if(input.equals("") || input.equals("0")) {
                input = "0.";
                preViewText.setText(getpreView + input);
            }else if(imsi2.equals(")")) {
                return;
            }else {
                input += ".";
                preViewText.setText(getpreView + input);
            }
        }else if(v.getId() == btn_front.getId()) {
            if(firstCheck == false) {
                firstCheck = true;
                getpreView = "(";
                preViewText.setText("(");
                frontCheck++;
                return;
            }
            String imsi = preViewText.getText() + "";
            String imsi2 = imsi.charAt(imsi.length() - 1) + "";
            if(imsi2.equals("(")) {
                getpreView += "(";
                preViewText.setText(getpreView);
                input = "";
                frontCheck++;
            }else if(imsi2.equals("+") || imsi2.equals("-") || imsi2.equals("x") || imsi2.equals("/")) {
                getpreView += "(";
                input = "";
                preViewText.setText(preViewText.getText() + "(");
                frontCheck++;
            }
            else {
                getpreView += input + "x(";
                input = "";
                preViewText.setText(preViewText.getText() + "x(");
                frontCheck++;
            }
        }else if(v.getId() == btn_back.getId()) {
            if(frontCheck > backCheck) {
                String imsi = preViewText.getText() + "";
                String imsi2 = imsi.charAt(imsi.length() - 1) + "";
                if(imsi2.equals("(")) {
                    return;
                }else if(imsi2.equals("+") || imsi2.equals("-") || imsi2.equals("x") || imsi2.equals("/")) {
                    return;
                }else {
                    getpreView += input + ")";
                    input = "";
                    preViewText.setText(getpreView);
                    backCheck++;
                }
            }
        }else if(v.getId() == btn_change.getId()) {

        }else if(v.getId() == btn_clear.getId()) {
            preViewText.setText("");
            resultViewText.setText("");
            input = "";
            getpreView = "";
            firstCheck = false;
        }else if(v.getId() == btn_equal.getId()) {
            getpreView = preViewText.getText() +"";
            String[] temp = getpreView.split("(?<=[x/()+-])|(?=[x/()+-])");
            Stack<String> stackTemp = new Stack<>();
            String temp3 = "";
            for(int i = 0; i < temp.length; i++) {
                if(temp[i].equals(")")) {
                    String temp2 = "";
                    for(int j = i - 1; ; j--) {
                        if(temp[j].equals("(")) {
                            stackTemp.pop();
                            i++;
                            break;
                        }
                        temp2 = temp[j] + temp2;
                        stackTemp.pop();
                    }
                    stackTemp.push(calc(temp2));
                }
                if(i == temp.length) {
                    break;
                }
                stackTemp.push(temp[i]);
            }
            int stackSize = stackTemp.size();
            for(int i = 0; i < stackSize; i++) {
                temp3 = stackTemp.pop() + temp3;
            }
            calc(temp3);
            result = result * 1000;
            result = Math.round(result);
            result /= 1000;
            if(result % 1 == 0) {
                resultViewText.setText((int)result + "");
            }else {
                resultViewText.setText(result +"");
            }
            preViewText.setText("");
            getpreView = "";
            equalCheck = true;
        }
    }

    private String calc(String string) {
        result = 0.0;
        String[] temp = string.split("(?<=[x/+-])|(?=[x/+-])");
        ArrayList<String> stackImsi = new ArrayList<>();
        for(int i = 0; i < temp.length; i++) {
            stackImsi.add(temp[i]);
            if(temp[i].equals("x") || temp[i].equals("/")) {
                stackImsi.remove(i);
                stackImsi.remove(i - 1);
                double a = Double.parseDouble(temp[i - 1]);
                double b = Double.parseDouble(temp[i + 1]);
                if (temp[i].equals("x")) {
                    stackImsi.add(Double.toString(a * b));
                } else {
                    stackImsi.add(Double.toString(a / b));
                }
            }
        }
        for(int i = 0; i < stackImsi.size(); i++) {
            if(stackImsi.get(i).equals("+") || stackImsi.get(i).equals("-")) {
                if(stackImsi.get(i).equals("+")) {
                    result += Double.parseDouble(stackImsi.get(i - 1)) + Double.parseDouble(stackImsi.get(i + 1));
                }
                if(stackImsi.get(i).equals("-")) {
                    result += Double.parseDouble(stackImsi.get(i - 1)) - Double.parseDouble(stackImsi.get(i + 1));
                }
            }
        }
        return result +"";
    }


    private  void pushButton(String buttonInt) {
        if(firstCheck == false) {
            input = buttonInt;
            preViewText.setText(input);
            firstCheck = true;
            return;
        }

        if(equalCheck == true) {
            input = buttonInt;
            preViewText.setText(input);
            equalCheck = false;
            resultViewText.setText("");
            return;
        }

        String imsi = preViewText.getText() +"";
        String imsi2 = imsi.charAt(imsi.length() - 1) + "";

        if(imsi2.equals(")")) {
            return;
        }

        if(input.equals("") || input.equals("0")) {
            input = buttonInt;
        }else {
            input += buttonInt;
        }
        preViewText.setText(getpreView + input);
    }

    private void pushOperatorButton(String operator) {
        if(firstCheck == false) {
            return;
        }
        if(equalCheck == true) {
            getpreView = resultViewText.getText() + operator;
            input = "";
            equalCheck = false;
            preViewText.setText(getpreView);
            resultViewText.setText("");
        }
        String imsi = preViewText.getText() + "";
        String imsi2 = imsi.charAt(imsi.length() - 1) + "";
        if(imsi2.equals("+") || imsi2.equals("-") || imsi2.equals("x") || imsi2.equals("/")) {
            getpreView = getpreView.substring(0, imsi.length() - 1) + operator;
            preViewText.setText(getpreView);
        }else if(imsi2.equals("(")) {
            return;
        }else {
            getpreView += input + operator;
            preViewText.setText(getpreView);
        }
        input = "";
    }








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
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_front = (Button) findViewById(R.id.btn_front);
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multi = (Button) findViewById(R.id.btn_multi);
        btn_divi = (Button) findViewById(R.id.btn_divi);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_change = (Button) findViewById(R.id.btn_change);

        preViewText = (TextView) findViewById(R.id.preViewText);
        resultViewText = (TextView) findViewById(R.id.resultViewText);

    }

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
        btn_clear.setOnClickListener(this);
        btn_front.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multi.setOnClickListener(this);
        btn_divi.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_change.setOnClickListener(this);


    }
}
