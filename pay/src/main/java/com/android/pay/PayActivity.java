package com.android.pay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.android.componentbase.ServiceFactory;

@Route(path = "/android/pay")
public class PayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        if (getIntent() != null){
            String content = getIntent().getStringExtra("pay_content");
            if (!TextUtils.isEmpty(content)){
                ((TextView)(findViewById(R.id.pay_content))).setText(content);
            }
        }
        share();
    }

    private void share(){
        if (ServiceFactory.getInstance().getAccountService().isLogin()){
            Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "用户未登录", Toast.LENGTH_SHORT).show();
        }
    }

    public void shareLogin(View view){
        ARouter.getInstance().build("/account/login").navigation();
    }
}
