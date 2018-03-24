package hu.bme.aut.mobsoft.manblockchain.manblockchain.network;

import hu.bme.aut.mobsoft.manblockchain.manblockchain.model.Friend;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public class FacebookAPI {
    @GET("")
    Call<Friend> getFriend() {
        return null;
    }

    ;
}
