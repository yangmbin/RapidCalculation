package com.yangmbin.rapidcalculation.bean;

/**
 * 用来表示表达式的头或尾
 * @author yangmbin
 * Create at 2017/10/31 15:52
 */
public class Expression {
    private String express;
    private int type; // 0表示头，1表示尾部

    public Expression(String express, int type) {
        this.express = express;
        this.type = type;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
