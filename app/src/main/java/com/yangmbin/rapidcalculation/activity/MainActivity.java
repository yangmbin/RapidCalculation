package com.yangmbin.rapidcalculation.activity;

import android.os.Bundle;

import com.yangmbin.rapidcalculation.R;
import com.yangmbin.rapidcalculation.base.BaseActivity;
import com.yangmbin.rapidcalculation.bean.TestProblem;
import com.yangmbin.rapidcalculation.widget.RapidCalculationView;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.calView)
    RapidCalculationView calView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        calView.generateTest(TestProblem.ALGORITHM_TYPE_1);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }
}
