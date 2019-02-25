package com.android.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view) {
        ARouter.getInstance().build("/account/login").navigation();
    }

    public void pay(View view) {
        ARouter.getInstance().build("/pay/pay").navigation();
    }

}
