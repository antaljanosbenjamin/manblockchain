package hu.bme.aut.mobsoft.manblockchain.manblockchain.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.manblockchain.manblockchain.di.Network;
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
    public FriendsPresenter provideFriendsPresenter() {
        return new FriendsPresenter();
    }


    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}
