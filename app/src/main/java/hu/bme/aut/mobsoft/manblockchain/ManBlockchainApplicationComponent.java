package hu.bme.aut.mobsoft.manblockchain;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.mobsoft.manblockchain.interactor.facebook.FacebookInteractor;
import hu.bme.aut.mobsoft.manblockchain.interactor.InteractorModule;
import hu.bme.aut.mobsoft.manblockchain.network.NetworkModule;
import hu.bme.aut.mobsoft.manblockchain.ui.UIModule;
import hu.bme.aut.mobsoft.manblockchain.ui.about.AboutFragment;
import hu.bme.aut.mobsoft.manblockchain.ui.friends.FriendsActivity;
import hu.bme.aut.mobsoft.manblockchain.ui.friends.FriendsFragment;
import hu.bme.aut.mobsoft.manblockchain.ui.friends.FriendsPresenter;
import hu.bme.aut.mobsoft.manblockchain.ui.friends.FriendsScreen;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class,
        InteractorModule.class})
public interface ManBlockchainApplicationComponent {

    void inject(FacebookInteractor facebookInteractor);

    void inject(FriendsPresenter friendsPresenter);

    void inject(FriendsFragment friendFragment);

    void inject(AboutFragment aboutScreen);

}
