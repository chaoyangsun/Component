package com.android.login;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/login/login")
public class LoginActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        updateLoginState();
    }

    private void initView(){
        textView = findViewById(R.id.tv_login_state);
    }

    public void login(View view){
        AccountUtils.userInfo = new UserInfo("admin","admin");
        updateLoginState();
    }

    private void updateLoginState() {
        textView.setText("登录界面：" + (AccountUtils.userInfo == null ? "未登录" : AccountUtils.userInfo.getUserName()));
    }

    public void exit(View view){
        AccountUtils.userInfo = null;
        updateLoginState();
    }
    public void pay(View view){
        ARouter.getInstance().build("/pay/pay").withString("pay_content", "登录支付").navigation();
    }
}
