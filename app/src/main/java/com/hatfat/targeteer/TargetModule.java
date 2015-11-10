package com.hatfat.targeteer;

import com.hatfat.agl.app.AglModule;

import dagger.Module;
@Module
        (
                library = true,

                includes = {
                        AglModule.class,
                },

                injects = {
                        TargetActivity.class,
                        TargetApplication.class,
                }
        )

public class TargetModule {

}
