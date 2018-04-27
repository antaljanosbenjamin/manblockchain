package hu.bme.aut.mobsoft.manblockchain;

import com.orm.SugarApp;

import hu.bme.aut.mobsoft.manblockchain.ui.UIModule;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public class ManBlockchainApplication extends SugarApp {
    public static ManBlockchainApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerManBlockchainApplicationComponent.builder().uIModule(new UIModule(this)).build();
        injector.toString();
    }
}
