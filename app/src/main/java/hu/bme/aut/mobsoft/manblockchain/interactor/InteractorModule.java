package hu.bme.aut.mobsoft.manblockchain.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.manblockchain.interactor.facebook.FacebookInteractor;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

@Module
public class InteractorModule {
    @Provides
    public FacebookInteractor provideArtistsInteractor() {
        return new FacebookInteractor();
    }
}
