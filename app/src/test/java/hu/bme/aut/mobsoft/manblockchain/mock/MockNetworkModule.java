package hu.bme.aut.mobsoft.manblockchain.mock;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.manblockchain.mock.MockFacebookAPI;
import hu.bme.aut.mobsoft.manblockchain.network.FacebookAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule {

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create());

    }

    @Provides
    @Singleton
    public FacebookAPI provideFacebookApi(Retrofit.Builder retrofitBuilder) {
        return new MockFacebookAPI();
    }

}