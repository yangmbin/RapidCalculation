package com.yangmbin.rapidcalculation.bean;

/**
 * 测试题目
 *
 * @author yangmbin
 *         Create at 2017/10/31 11:25
 */
public class TestProblem {
    public static final String ALGORITHM_TYPE_1 = "+";
    public static final String ALGORITHM_TYPE_2 = "-";
    private int num1, num2;
    private String calType;

    public TestProblem(int num1, int num2, String calType) {
        this.num1 = num1;
        this.num2 = num2;
        this.calType = calType;
    }

    /**
     * 计算结果
     *
     * @return
     */
    public int getCalResult() {
        if (ALGORITHM_TYPE_1.equals(calType))
            return num1 + num2;
        return (num1 > num2 ? num1 - num2 : num2 - num1);
    }

    public String getEquation() {
        if (ALGORITHM_TYPE_1.equals(calType))
            return num1 + calType + num2;
        return (num1 > num2 ? num1 + calType +  num2 : num2 + calType +  num1);
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getCalType() {
        return calType;
    }

    public void setCalType(String calType) {
        this.calType = calType;
    }
}
