package hu.bme.aut.mobsoft.manblockchain.network;


import rx.Observable;

import retrofit2.http.*;

import hu.bme.aut.mobsoft.manblockchain.model.Friends;

public interface FacebookAPI {

    /**
     * Get new friend
     *
     * @return Call<Friends>
     */

    @GET("api/")
    public Observable<Friends> getNewFriends();



}

