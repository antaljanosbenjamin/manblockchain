package hu.bme.aut.mobsoft.manblockchain.ui.friends;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.manblockchain.R;
import hu.bme.aut.mobsoft.manblockchain.model.Friend;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public class FriendsFragment extends Fragment {

    @Inject
    FriendsPresenter friendsPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_friends, container, false);

        return view;
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        //friendsPresenter.attachScreen(this);
    }

    public FriendsFragment() {
        //ManBlockchainApplication.injector.inject(this);
    }

    //@Override
    public void showFriends(List<Friend> friends) {

    }

    public void onAddNewFriend() {

    }

    public void addFriendFromFacebook() {

    }

    public void onEditFriend(Friend friend) {
    }

    public void onDeleteFriend(Friend friend) {
    }

    //@Override
    public void showNetworkError(String errorMsg) {

    }
}
