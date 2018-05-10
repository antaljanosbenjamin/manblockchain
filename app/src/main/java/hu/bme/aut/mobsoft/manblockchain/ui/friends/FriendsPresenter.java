package hu.bme.aut.mobsoft.manblockchain.ui.friends;

import android.content.Intent;
import android.util.Log;

import com.orm.query.Condition;
import com.orm.query.Select;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.manblockchain.di.Network;
import hu.bme.aut.mobsoft.manblockchain.interactor.facebook.FacebookInteractor;
import hu.bme.aut.mobsoft.manblockchain.interactor.facebook.events.GetFriendEvent;
import hu.bme.aut.mobsoft.manblockchain.ManBlockchainApplication;
import hu.bme.aut.mobsoft.manblockchain.model.Friend;
import hu.bme.aut.mobsoft.manblockchain.ui.Presenter;
import hu.bme.aut.mobsoft.manblockchain.ui.details.DetailsActivity;

import static hu.bme.aut.mobsoft.manblockchain.ui.friends.FriendsFragment.EDITED_FRIEND_ID;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public class FriendsPresenter extends Presenter<FriendsScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    FacebookInteractor facebookInteractor;

    private List<Friend> friends;
    private static final String TAG = "FriendPresenter";

    public FriendsPresenter() {
        friends = Friend.listAll(Friend.class);
    }

    @Override
    public void attachScreen(FriendsScreen screen) {
        super.attachScreen(screen);
        ManBlockchainApplication.injector.inject(this);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();
    }

    public void addNewFriendFromFacebook() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                facebookInteractor.getFriend();
            }
        });
    }

    public void modifyFriend(int position) {
    }

    public void deleteFriend(int position) {
        Friend friend = friends.get(position);
        friends.remove(friend);
        friend.delete();
        refreshFriendsList();
    }

    public void changeStarOnFriend(int position) {
        Friend friend = friends.get(position);
        friend.changeStarred();
        friend.save();
    }

    public void refreshFriendsList() {
        friends = Select.from(Friend.class).orderBy("name").list();
        if (screen != null) {
            screen.showFriends();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetFriendEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            Friend newFriend = new Friend( event.getFriendDTO());
            newFriend.save();
            friends.add(newFriend);
            Collections.sort(friends, new Comparator<Friend>() {
                @Override
                public int compare(Friend f1, Friend f2) {
                    return f1.getName().compareTo(f2.getName());
                }
            });
            if (screen != null) {
                screen.showFriends();
            }
        }
    }

    public int getFriendsCount(){
        return friends.size();
    }

    public Friend getFriendByPosition(int position){
        return friends.get(position);
    }
}
