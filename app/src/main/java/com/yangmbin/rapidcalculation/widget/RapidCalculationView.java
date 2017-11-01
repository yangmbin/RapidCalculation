package com.yangmbin.rapidcalculation.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yangmbin.rapidcalculation.R;
import com.yangmbin.rapidcalculation.bean.Coordinate;
import com.yangmbin.rapidcalculation.bean.Expression;
import com.yangmbin.rapidcalculation.bean.TestProblem;
import com.yangmbin.rapidcalculation.utils.CalUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RapidCalculationView extends RelativeLayout implements View.OnTouchListener, View.OnClickListener {

    private Context mContext;
    private View mView, mTouchView;
    private TextView mBtn1, mBtn2, mBtn3, mBtn4, mBtn5, mBtn6, mBtn7, mBtn8, mBtn9, mBtn10, mBtn11, mBtn12;
    private List<TextView> mBtnList = new ArrayList<>();
    private List<Coordinate> mCoordinateList = new ArrayList<>();
    private List<TestProblem> mTestProblemList = new ArrayList<>();
    private List<Expression> mExpressionList = new ArrayList<>();
    private String[] colorList = {"#99CCFF", "#99CCCC", "#66CCCC", "#CCCCFF","#FFCCCC", "#FFCC99",
            "#996699", "#CCCC99","#CCCCCC", "#FF6666", "#0099CC", "#FFCC33"};

    public RapidCalculationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.view_rapid_calculation, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mView.setLayoutParams(params);
        addView(mView);

        // 监听一指点击
        initOneClickListener();

        // 监听二指点击
        mTouchView = mView.findViewById(R.id.touchView);
        mTouchView.setOnTouchListener(this);
    }

    /**
     * 初始化单击监听
     */
    private void initOneClickListener() {
        mBtn1 = mView.findViewById(R.id.btn1);
        mBtn2 = mView.findViewById(R.id.btn2);
        mBtn3 = mView.findViewById(R.id.btn3);
        mBtn4 = mView.findViewById(R.id.btn4);
        mBtn5 = mView.findViewById(R.id.btn5);
        mBtn6 = mView.findViewById(R.id.btn6);
        mBtn7 = mView.findViewById(R.id.btn7);
        mBtn8 = mView.findViewById(R.id.btn8);
        mBtn9 = mView.findViewById(R.id.btn9);
        mBtn10 = mView.findViewById(R.id.btn10);
        mBtn11 = mView.findViewById(R.id.btn11);
        mBtn12 = mView.findViewById(R.id.btn12);

        mBtnList.add(mBtn1);
        mBtnList.add(mBtn2);
        mBtnList.add(mBtn3);
        mBtnList.add(mBtn4);
        mBtnList.add(mBtn5);
        mBtnList.add(mBtn6);
        mBtnList.add(mBtn7);
        mBtnList.add(mBtn8);
        mBtnList.add(mBtn9);
        mBtnList.add(mBtn10);
        mBtnList.add(mBtn11);
        mBtnList.add(mBtn12);

        // 设置按钮的背景色和监听
        List colors = Arrays.asList(colorList);
        Collections.shuffle(colors);
        for (int i = 0; i < mBtnList.size(); i++) {
            mBtnList.get(i).setBackgroundColor(Color.parseColor((String) colors.get(i)));
            mBtnList.get(i).setOnClickListener(this);
        }

    }

    /**
     * 初始化坐标
     */
    private void initCoordinates(int width, int height) {
        int btnWidth = width / 4;
        int btnHeight = height / 3;
        mCoordinateList.add(new Coordinate(0, 0, btnWidth, btnHeight));
        mCoordinateList.add(new Coordinate(btnWidth, 0, btnWidth * 2, btnHeight));
        mCoordinateList.add(new Coordinate(btnWidth * 2, 0, btnWidth * 3, btnHeight));
        mCoordinateList.add(new Coordinate(btnWidth * 3, 0, btnWidth * 4, btnHeight));

        mCoordinateList.add(new Coordinate(0, btnHeight, btnWidth, btnHeight * 2));
        mCoordinateList.add(new Coordinate(btnWidth, btnHeight, btnWidth * 2, btnHeight * 2));
        mCoordinateList.add(new Coordinate(btnWidth * 2, btnHeight, btnWidth * 3, btnHeight * 2));
        mCoordinateList.add(new Coordinate(btnWidth * 3, btnHeight, btnWidth * 4, btnHeight * 2));

        mCoordinateList.add(new Coordinate(0, btnHeight * 2, btnWidth, btnHeight * 3));
        mCoordinateList.add(new Coordinate(btnWidth, btnHeight * 2, btnWidth * 2, btnHeight * 3));
        mCoordinateList.add(new Coordinate(btnWidth * 2, btnHeight * 2, btnWidth * 3, btnHeight * 3));
        mCoordinateList.add(new Coordinate(btnWidth * 3, btnHeight * 2, btnWidth * 4, btnHeight * 3));

        mCoordinateList.add(new Coordinate(0, btnHeight * 3, btnWidth, btnHeight * 4));
        mCoordinateList.add(new Coordinate(btnWidth, btnHeight * 3, btnWidth * 2, btnHeight * 4));
        mCoordinateList.add(new Coordinate(btnWidth * 2, btnHeight * 3, btnWidth * 3, btnHeight * 4));
        mCoordinateList.add(new Coordinate(btnWidth * 3, btnHeight * 3, btnWidth * 4, btnHeight * 4));
    }

    /**
     * 获取点击的位置
     *
     * @param x
     * @param y
     * @return
     */
    private int getClickPosition(float x, float y) {
        for (int i = 0; i < mCoordinateList.size(); i++) {
            Coordinate cur = mCoordinateList.get(i);
            if (x >= cur.getX1() && x <= cur.getX2() && y >= cur.getY1() && y <= cur.getY2())
                return i;
        }
        return -1;
    }

    /**
     * 2点点击事件处理
     */
    private void twoClickEvent(float x1, float y1, float x2, float y2) {
        Log.e("yangmbin", "btn " + getClickPosition(x1, y1));
        Log.e("yangmbin", "btn " + getClickPosition(x2, y2));
        int index1 = getClickPosition(x1, y1);
        int index2 = getClickPosition(x2, y2);
        // 判断点击的2个点必须是一个表达式的头和尾，并且是可见的
        if (mExpressionList.get(index1).getType() != mExpressionList.get(index2).getType()
                && mBtnList.get(index1).getVisibility() == VISIBLE
                && mBtnList.get(index2).getVisibility() == VISIBLE) {
            // 判断表达式是否相等
            if (CalUtil.getResult(mExpressionList.get(index1).getExpress()) == CalUtil.getResult(mExpressionList.get(index2).getExpress())) {
                mBtnList.get(index1).setVisibility(GONE);
                mBtnList.get(index2).setVisibility(GONE);
            }
        }
    }

    /**
     * 1点点击事件处理
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                break;
            case R.id.btn2:
                break;
            case R.id.btn3:
                break;
            case R.id.btn4:
                break;
            case R.id.btn5:
                break;
            case R.id.btn6:
                break;
            case R.id.btn7:
                break;
            case R.id.btn8:
                break;
            case R.id.btn9:
                break;
            case R.id.btn10:
                break;
            case R.id.btn11:
                break;
            case R.id.btn12:
                break;
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_POINTER_2_DOWN:
                if (pointerCount == 2) {
                    Log.e("yangmbin", "二指：" + motionEvent.getX(0) + "," + motionEvent.getY(0) + " " + motionEvent.getX(1) + "," + motionEvent.getY(1));
                    twoClickEvent(motionEvent.getX(0), motionEvent.getY(0), motionEvent.getX(1), motionEvent.getY(1));
                }
                break;
        }

        return true;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("yangmbin", "width:" + getMeasuredWidth() + " " + "height:" + getMeasuredHeight());
        // 初始化12个矩形的坐标
        initCoordinates(getMeasuredWidth(), getMeasuredHeight());
    }

    /**
     * 生成测试题目
     *
     * @param calType
     */
    public void generateTest(String calType) {
        mTestProblemList.clear();
        Random random = new Random();
        for (int i = 0; i < 6; i++)
            mTestProblemList.add(new TestProblem(random.nextInt(10), random.nextInt(10), calType));
        for (int i = 0; i < mTestProblemList.size(); i++) {
            mExpressionList.add(new Expression(mTestProblemList.get(i).getEquation(), 0));
            mExpressionList.add(new Expression(mTestProblemList.get(i).getCalResult() + "", 1));
        }
        Collections.shuffle(mExpressionList);
        // 设置数据
        mBtn1.setText(mExpressionList.get(0).getExpress());
        mBtn2.setText(mExpressionList.get(1).getExpress());
        mBtn3.setText(mExpressionList.get(2).getExpress());
        mBtn4.setText(mExpressionList.get(3).getExpress());
        mBtn5.setText(mExpressionList.get(4).getExpress());
        mBtn6.setText(mExpressionList.get(5).getExpress());
        mBtn7.setText(mExpressionList.get(6).getExpress());
        mBtn8.setText(mExpressionList.get(7).getExpress());
        mBtn9.setText(mExpressionList.get(8).getExpress());
        mBtn10.setText(mExpressionList.get(9).getExpress());
        mBtn11.setText(mExpressionList.get(10).getExpress());
        mBtn12.setText(mExpressionList.get(11).getExpress());
    }

}
