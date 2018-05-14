package hu.bme.aut.mobsoft.manblockchain.network;


import hu.bme.aut.mobsoft.manblockchain.model.facebook.FriendsDTO;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FacebookAPI {

    /**
     * Get new friend
     *
     * @return Call<Friends>
     */

    @GET("api/")
    public Call<FriendsDTO> getNewFriends();

}

