package com.android.login;

import android.app.Application;

import com.android.base.BaseApp;
import com.android.componentbase.ServiceFactory;

public class LoginApp extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void init(Application application) {
        ServiceFactory.getInstance().setAccountService(new AccountService());
    }
}
