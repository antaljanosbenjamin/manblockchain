package hu.bme.aut.mobsoft.manblockchain.ui.friends;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.text.method.Touch;
import android.widget.Toast;

import java.util.List;
import rx.Observable;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.manblockchain.ManBlockchainApplication;
import hu.bme.aut.mobsoft.manblockchain.ManBlockchainApplicationComponent;
import hu.bme.aut.mobsoft.manblockchain.model.Friend;
import hu.bme.aut.mobsoft.manblockchain.model.Friends;
import hu.bme.aut.mobsoft.manblockchain.network.FacebookAPI;
import rx.functions.Action1;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public class FriendsFragment extends Fragment implements FriendsScreen {

    @Inject
    FriendsPresenter friendsPresenter;

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        friendsPresenter.attachScreen(this);
    }

    public FriendsFragment() {
        //ManBlockchainApplication.injector.inject(this);
    }

    @Override
    public void showFriends(List<Friend> friends) {

    }

    public void onAddNewFriend(){

    }

    public void addFriendFromFacebook(){

    }

    public void onEditFriend(Friend friend) {
    }

    public void onDeleteFriend(Friend friend) {
    }

    @Override
    public void showNetworkError(String errorMsg) {

    }
}
