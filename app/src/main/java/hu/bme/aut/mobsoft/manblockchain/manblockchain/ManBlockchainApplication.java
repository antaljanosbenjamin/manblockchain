package hu.bme.aut.mobsoft.manblockchain.manblockchain;

import android.app.Application;

import hu.bme.aut.mobsoft.manblockchain.manblockchain.ui.UIModule;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public class ManBlockchainApplication extends Application {
    public static ManBlockchainApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerManBlockchainApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }
}
