package hu.bme.aut.mobsoft.manblockchain.manblockchain;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.mobsoft.manblockchain.manblockchain.ui.UIModule;
import hu.bme.aut.mobsoft.manblockchain.manblockchain.ui.friends.FriendsActivity;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

@Singleton
@Component(modules = {UIModule.class})
public interface ManBlockchainApplicationComponent {
    void inject(FriendsActivity friendsActivity);
}
