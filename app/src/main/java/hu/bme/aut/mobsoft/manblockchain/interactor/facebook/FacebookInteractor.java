package hu.bme.aut.mobsoft.manblockchain.interactor.facebook;

import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.manblockchain.ManBlockchainApplication;
import hu.bme.aut.mobsoft.manblockchain.interactor.facebook.events.GetFriendEvent;
import hu.bme.aut.mobsoft.manblockchain.model.Friend;
import hu.bme.aut.mobsoft.manblockchain.model.Friends;
import hu.bme.aut.mobsoft.manblockchain.network.FacebookAPI;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.HTTP;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public class FacebookInteractor {

    @Inject
    FacebookAPI facebookAPI;

    public FacebookInteractor() {
        ManBlockchainApplication.injector.inject(this);
    }

    public void getFriend() {
        GetFriendEvent event = new GetFriendEvent();
        try {
            Call<Friends> friendsRequest = facebookAPI.getNewFriends();
            Response<Friends> response = friendsRequest.execute();
            event.setCode(response.code());
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            if (response.body().getInfo().getResults() < 1 ) {
                throw new Exception("Response doesn't contain friend!");
            }
            Friend friend = response.body().getResults().get(0);
            event.setFriend(friend);
        } catch (Exception exp) {
            event.setThrowable(exp);
        }
        EventBus.getDefault().post(event);
    }
}

