package com.yangmbin.rapidcalculation.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.yangmbin.rapidcalculation.R;

public class RapidCalculationView extends RelativeLayout implements View.OnTouchListener{

    private Context mContext;
    private View mView, mTouchView;
    private float oneX, oneY, twoX, twoY;

    public RapidCalculationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mView = LayoutInflater.from(context).inflate(R.layout.view_rapid_calculation, null);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mView.setLayoutParams(params);
        addView(mView);

        mTouchView = mView.findViewById(R.id.touchView);
        mTouchView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (pointerCount == 1) {
                    Log.e("yangmbin", "第1点坐标：" + motionEvent.getX(0) + "," + motionEvent.getY(0));
                    oneX = motionEvent.getX(0);
                    oneY = motionEvent.getY(0);
                }
                break;
            case MotionEvent.ACTION_POINTER_2_DOWN:
                if (pointerCount == 2) {
                    Log.e("yangmbin", "第2点坐标：" + motionEvent.getX(1) + "," + motionEvent.getY(1));
                    twoX = motionEvent.getX(1);
                    twoY = motionEvent.getY(1);
                    twoTouchEvent();
                }
                break;
        }

        return true;
    }

    /**
     * 1点点击事件处理
     */
    private void oneTouchEvent() {

    }

    /**
     * 2点点击事件处理
     */
    private void twoTouchEvent() {

    }

}
