package hu.bme.aut.mobsoft.manblockchain.manblockchain.ui;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.manblockchain.manblockchain.ui.friends.FriendsPresenter;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public FriendsPresenter provideMainPresenter() {
        return new FriendsPresenter();
    }
}
