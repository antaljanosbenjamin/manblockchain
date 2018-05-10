package hu.bme.aut.mobsoft.manblockchain.mock;

import hu.bme.aut.mobsoft.manblockchain.model.facebook.FriendsDTO;
import hu.bme.aut.mobsoft.manblockchain.network.FacebookAPI;
import retrofit2.Call;

public class MockFacebookAPI implements FacebookAPI {

    @Override
    public Call<FriendsDTO> getNewFriends() {
        return null;
    }
}
