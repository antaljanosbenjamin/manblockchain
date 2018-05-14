package hu.bme.aut.mobsoft.manblockchain.interactor.facebook;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import java.text.SimpleDateFormat;
import java.util.Date;

import hu.bme.aut.mobsoft.manblockchain.ManBlockchainApplication;
import hu.bme.aut.mobsoft.manblockchain.interactor.facebook.events.GetFriendEvent;
import hu.bme.aut.mobsoft.manblockchain.model.Friend;
import hu.bme.aut.mobsoft.manblockchain.model.facebook.FriendDTO;
import hu.bme.aut.mobsoft.manblockchain.model.facebook.FriendsDTO;
import hu.bme.aut.mobsoft.manblockchain.network.FacebookAPI;
import retrofit2.Call;
import retrofit2.Response;

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
            Call<FriendsDTO> friendsRequest = facebookAPI.getNewFriends();
            Response<FriendsDTO> response = friendsRequest.execute();
            event.setCode(response.code());
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            if (response.body().getInfo().getResults() < 1) {
                throw new Exception("Response doesn't contain friend!");
            }
            FriendDTO friendDTO = response.body().getResults().get(0);
            event.setFriend(friendDTO);
        } catch (Exception exp) {
            event.setThrowable(exp);
        }
        EventBus.getDefault().post(event);
    }
}

