package hu.bme.aut.mobsoft.manblockchain.interactor.facebook;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.manblockchain.ManBlockchainApplication;
import hu.bme.aut.mobsoft.manblockchain.network.FacebookAPI;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public class FacebookInteractor {

    @Inject
    FacebookAPI facebookAPI;

    public FacebookInteractor() {
        ManBlockchainApplication.injector.inject(this);
    }

    public void getFriend() {
    }
}

