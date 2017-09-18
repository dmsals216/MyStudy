package com.example.goem.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private String input = "";
    private String calculation;
    private boolean equalCheck = false;

    private TextView preViewText;
    private TextView resultViewText;

    private int frontSu = 0;
    private int backSu = 0;

    private double result = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preViewText = (TextView) findViewById(R.id.preViewText);
        resultViewText = (TextView) findViewById(R.id.resultViewText);
    }




    // --------------------------------------------------------------------------------숫자버튼을 눌렀을때 실행
    public void numButtonClick(View v) {
        Button b = (Button) v;
        if(equalCheck == true) {
            resultViewText.setText("");
            equalCheck = false;
        }
        //첫번째 실행
        if(preViewText.getText().equals("") || preViewText.getText().equals("0")) {
            calculation = b.getText() + "";
            input = b.getText() + "";
            preViewText.setText(calculation);
        }else {
            String temp = calculation.charAt(calculation.length() - 1) + "";
            if(temp.equals(")")) {
                return;
            }
            if(input.equals("") || input.equals("0")) {
                if(v.getId() == R.id.btn0) {
                    input = "0";
                    preViewText.setText(calculation + "0");
                }else {
                    input = b.getText() + "";
                    calculation += b.getText() + "";
                    preViewText.setText(calculation);
                }

            }else {
                input += b.getText() + "";
                calculation += b.getText() + "";
                preViewText.setText(calculation);
            }
        }
    }

    // ================================================================================연산자 버튼을 눌렀을때 실행
    public void operateButtonClick(View v) {
        Button b = (Button) v;
        if(equalCheck == true) {
            calculation = resultViewText.getText() + "" + b.getText();
            equalCheck = false;
            preViewText.setText(calculation);
            resultViewText.setText("");
            return;
        }
        if(preViewText.getText().equals("")) {
            calculation = "0" + b.getText();
            preViewText.setText(calculation);
        }
        String temp = calculation.charAt(calculation.length() - 1) + "";
        if(temp.equals("+") || temp.equals("-") || temp.equals("x") || temp.equals("/")) {
            calculation = calculation.substring(0, calculation.length() -  1) + b.getText();
            preViewText.setText(calculation);
        }else if (temp.equals("(")) {
            return;
        }else{
            calculation += b.getText();
            preViewText.setText(calculation);
        }
        input = "";
        equalCheck = false;
    }

    //=====================================================================================clear버튼을 눌렀을때 실행
    public void cButtonClick(View v) {
        calculation = "";
        input = "";
        preViewText.setText("");
        equalCheck = false;
        resultViewText.setText("");
    }

    // ================================================================================================ (((버튼을 눌렀을떄 실행
    public void frontButtonClick(View v) {
        if(preViewText.getText().equals("") || preViewText.getText().equals("0")) {
            calculation = "(";
            frontSu += 1;
            preViewText.setText(calculation);
            resultViewText.setText("");
            equalCheck = false;
            return;
        }
        String temp = calculation.charAt(calculation.length() - 1) +"";
        if(temp.equals("(")) {
            calculation += "(";
        }else if(temp.equals("+") || temp.equals("-") || temp.equals("x") || temp.equals("/")) {
            calculation += "(";
        }else {
            calculation += "x(";
        }
        input = "";
        frontSu += 1;
        preViewText.setText(calculation);
    }

    //====================================================================================================)버튼을 눌렀을때 실행
    public void backButtonClick(View v) {
        if(frontSu > backSu) {
            String temp = calculation.charAt(calculation.length() - 1) + "";
            if(temp.equals("(")) {
                return;
            }else if(input.equals("0")) {
                calculation += "0)";
                input = "";
                preViewText.setText(calculation);
                backSu++;
            }
            else if(temp.equals("+") || temp.equals("-") || temp.equals("x") || temp.equals("/")) {
                return;
            }else {
                calculation +=")";
                input = "";
                preViewText.setText(calculation);
                backSu++;
            }
        }
    }

    //===================================================================================================dot버튼을 눌렀을때 실행
    public void dotButtonClick(View v) {
        if(preViewText.getText().equals("") || preViewText.getText().equals("0")) {
            input = "0.";
            calculation = "0.";
            preViewText.setText(calculation);
            equalCheck = false;
            return;
        }
        for(int i = 0; i < input.length(); i++) {
            if(!Character.isLetterOrDigit(input.charAt(i))) {
                return;
            }
        }
        String temp = calculation.charAt(calculation.length() - 1) + "";
        if(temp.equals(")")) {
            return;
        }else if(input.equals("") || input.equals("0")) {
            input = "0.";
            calculation += "0.";
            preViewText.setText(calculation);
        }else {
            input += ".";
            calculation += ".";
            preViewText.setText(calculation);
        }
    }

    // ============================================================================================= () 을 기준으로 사칙연산을 시켜준다.
    public void equalButtonClick(View v) {
        if(equalCheck == true || frontSu != backSu || preViewText.getText().equals("") || preViewText.getText().equals("0")) {
            return;
        }
        String[] temp = calculation.split("(?<=[x/()+-])|(?=[x/()+-])");
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
            i--;
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
        calculation = "";
        result = 0;
        equalCheck = true;

    }

    //============================================================================================== 사칙연산 계산
    private String calc(String string) {
        result = 0.0;
        String[] temp = string.split("(?<=[x/+-])|(?=[x/+-])");
        ArrayList<String> stackImsi = new ArrayList<>();
        if(temp.length == 1) {
            result = Double.parseDouble(temp[0]);
            return temp[0];
        }
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
                    if(Double.parseDouble(stackImsi.get(i + 1)) >= 0) {
                        result += Double.parseDouble(stackImsi.get(i - 1)) - Double.parseDouble(stackImsi.get(i + 1));
                    }else {
                        result += Double.parseDouble(stackImsi.get(i - 1)) + Math.abs(Double.parseDouble(stackImsi.get(i + 1)));
                    }
                }
            }
        }
        return result +"";
    }

}
