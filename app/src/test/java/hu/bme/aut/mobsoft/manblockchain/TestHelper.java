package hu.bme.aut.mobsoft.manblockchain;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

import hu.bme.aut.mobsoft.manblockchain.DaggerTestComponent;

public class TestHelper {

    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        ManBlockchainApplication application = (ManBlockchainApplication) RuntimeEnvironment.application;
        ManBlockchainApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        ManBlockchainApplication.injector = injector;
    }
}
