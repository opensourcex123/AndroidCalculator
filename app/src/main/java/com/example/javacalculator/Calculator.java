package com.example.javacalculator;

import java.util.Stack;

class Calculater {
    private final String[] sArray;
    private final Stack<String> number = new Stack<String>();
    private final Stack<String> sign = new Stack<String>();

    Calculater(String str) {
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
    }

    public void stackOpe() {
        for (int i = 0; i < sArray.length; i++) {
            if (!sArray[i].equals("+") && !sArray[i].equals("-") && !sArray[i].equals("x") && !sArray[i].equals("÷") && !sArray[i].equals("(") && !sArray[i].equals(")")) {
                number.push(sArray[i]);
            } else if (sign.isEmpty()) {
                sign.push(sArray[i]);
            } else if (sArray[i].equals("(")) {
                sign.push(sArray[i]);
            } else if (sArray[i].equals(")")) {
                while (!sign.peek().equals("("))
                    number.push(sign.pop());
                sign.pop();
                // 要入的符号比栈顶的符号优先级高，则直接压入符号栈
            } else if (check(sArray[i], sign.peek())) {
                sign.push(sArray[i]);
            } else {
                number.push(sign.pop());
                sign.push(sArray[i]);
            }
        }
        while (!sign.isEmpty())
            number.push(sign.pop());
    }

    private boolean check(String a, String b) {
        //如果符号栈内是（括号，直接返true
        if (b.equals("(")) {
            return true;
        }
        //如果符号栈内的优先级比要入的高，返回false
        if ((b.equals("x") || b.equals("÷")) && (a.equals("+") || a.equals("-"))) { //b>a
            return false;
        }
        //如果符号栈内的优先级比要入的低，返回true
        if ((b.equals("+") || b.equals("-")) && (a.equals("x") || a.equals("÷"))) { //b<a
            return true;
        }
        return false;
    }

    public Double operate() {
        stackOpe();
        Stack<Double> res = new Stack<Double>();
        for (int i = 0; i < number.size(); i++) {
            if (number.get(i).equals("+")) {
                Double b = res.pop();
                Double a = res.pop();
                res.push(a + b);
            } else if (number.get(i).equals("-")) {
                Double b = res.pop();
                Double a = res.pop();
                res.push(a - b);
            } else if (number.get(i).equals("x")) {
                Double b = res.pop();
                Double a = res.pop();
                res.push(a * b);
            } else if (number.get(i).equals("÷")) {
                Double b = res.pop();
                Double a = res.pop();
                res.push(a / b);
            } else if (number.get(i).isEmpty()) {
            } else {
                res.push(Double.parseDouble(number.get(i)));
            }
        }
        return res.pop();
    }
}
public class Calculator {
        String str="";
        public Double Eval(String str){
            //结构化
        Calculater cl = new Calculater(str);
            //计算
       return cl.operate();
   }
}
