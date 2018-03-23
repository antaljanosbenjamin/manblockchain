package com.examlple.mobsoft.manblockchain;

import javax.inject.Singleton;

import dagger.Component;
import com.examlple.mobsoft.manblockchain.interactor.InteractorModule;
import com.examlple.mobsoft.manblockchain.network.NetworkModule;
import com.examlple.mobsoft.manblockchain.ui.UIModule;
import com.examlple.mobsoft.manblockchain.ui.main.MainActivity;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class,
        InteractorModule.class})
public interface ManBlockchainAppComponent {
    void inject(MainActivity mainActivity);

}
