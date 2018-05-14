package hu.bme.aut.mobsoft.manblockchain;

import android.content.Context;



import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.manblockchain.di.Network;
import hu.bme.aut.mobsoft.manblockchain.ui.details.DetailsPresenter;
import hu.bme.aut.mobsoft.manblockchain.ui.friends.FriendsPresenter;
import hu.bme.aut.mobsoft.manblockchain.utils.UiExecutor;

@Module
public class TestModule {

    private Context context;

    public TestModule(Context context) {
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
    public DetailsPresenter provideDetailsPresenter() {
        return new DetailsPresenter();
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }


}