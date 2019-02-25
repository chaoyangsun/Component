package com.android.login;

import com.android.componentbase.service.IAccountService;

public class AccountService implements IAccountService {
    @Override
    public boolean isLogin() {
        return AccountUtils.userInfo != null ? true : false;
    }

}
