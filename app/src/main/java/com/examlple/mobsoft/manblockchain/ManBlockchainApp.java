package com.examlple.mobsoft.manblockchain;

import android.app.Application;

import com.examlple.mobsoft.manblockchain.ui.UIModule;

public class ManBlockchainApp extends Application {

    public static ManBlockchainAppComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        /*injector =
                DaggerManBlockchainAppComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();*/
    }
}
