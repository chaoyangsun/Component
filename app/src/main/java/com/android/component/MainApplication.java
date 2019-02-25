package com.android.component;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.android.base.AppConfig;
import com.android.base.BaseApp;

public class MainApplication extends BaseApp {

    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebug()){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
        init(this);
    }

    private boolean isDebug() {
        return BuildConfig.DEBUG;
    }
    @Override
    public void init(Application application) {
        for (String app : AppConfig.modulesApp){
            try{
                Class clazz = Class.forName(app);
                BaseApp baseApp = (BaseApp) clazz.newInstance();
                baseApp.init(this);
            }catch (Exception e){
                Log.d("test","", e);
            }
        }
    }
}
