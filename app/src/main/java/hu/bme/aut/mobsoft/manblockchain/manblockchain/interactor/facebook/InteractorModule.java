package hu.bme.aut.mobsoft.manblockchain.manblockchain.interactor.facebook;

import dagger.Module;
import dagger.Provides;

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
