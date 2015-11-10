package com.hatfat.targeteer;

import com.hatfat.agl.app.AglApplication;

public class TargetApplication extends AglApplication {

    @Override
    public Object[] getInjectionModules() {
        return new Object[]{
                new TargetModule(),
        };
    }
}
