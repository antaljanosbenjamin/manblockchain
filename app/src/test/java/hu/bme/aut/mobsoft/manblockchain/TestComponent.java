package hu.bme.aut.mobsoft.manblockchain;


import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.mobsoft.manblockchain.interactor.InteractorModule;
import hu.bme.aut.mobsoft.manblockchain.mock.MockNetworkModule;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class})
public interface TestComponent extends ManBlockchainApplicationComponent {
}