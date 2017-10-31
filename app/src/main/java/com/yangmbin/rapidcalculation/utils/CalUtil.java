package com.yangmbin.rapidcalculation.utils;

/**
 * 简单表达式计算
 * @author yangmbin
 * Create at 2017/10/31 14:15
 */
public class CalUtil {

    public static int getResult(String expression) {
        if (expression.contains("+")) {
            int num1 = Integer.parseInt(expression.split("\\+")[0]);
            int num2 = Integer.parseInt(expression.split("\\+")[1]);
            return num1 + num2;
        } else if (expression.contains("-")) {
            int num1 = Integer.parseInt(expression.split("-")[0]);
            int num2 = Integer.parseInt(expression.split("-")[1]);
            return num1 - num2;
        } else {
            return Integer.parseInt(expression);
        }
    }
}
