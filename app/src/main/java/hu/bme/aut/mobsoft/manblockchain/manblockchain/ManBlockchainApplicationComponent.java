package hu.bme.aut.mobsoft.manblockchain.manblockchain;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.mobsoft.manblockchain.manblockchain.interactor.facebook.FacebookInteractor;
import hu.bme.aut.mobsoft.manblockchain.manblockchain.interactor.facebook.InteractorModule;
import hu.bme.aut.mobsoft.manblockchain.manblockchain.network.NetworkModule;
import hu.bme.aut.mobsoft.manblockchain.manblockchain.ui.UIModule;
import hu.bme.aut.mobsoft.manblockchain.manblockchain.ui.friends.FriendsActivity;
import hu.bme.aut.mobsoft.manblockchain.manblockchain.ui.friends.FriendsFragment;
import hu.bme.aut.mobsoft.manblockchain.manblockchain.ui.friends.FriendsPresenter;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class,
        InteractorModule.class})
public interface ManBlockchainApplicationComponent {

    void inject(FacebookInteractor facebookInteractor);

    void inject(FriendsPresenter friendsPresenter);

    void inject(FriendsFragment friendsFragment);

}
