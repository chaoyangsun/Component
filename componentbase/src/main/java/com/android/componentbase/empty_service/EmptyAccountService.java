package com.android.componentbase.empty_service;

import com.android.componentbase.service.IAccountService;

public class EmptyAccountService implements IAccountService {
    @Override
    public boolean isLogin() {
        return false;
    }

}
