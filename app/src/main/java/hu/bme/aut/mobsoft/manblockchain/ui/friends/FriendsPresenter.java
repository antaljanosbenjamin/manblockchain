package hu.bme.aut.mobsoft.manblockchain.ui.friends;

import android.content.Intent;
import android.util.Log;

import com.orm.query.Condition;
import com.orm.query.Select;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
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
        EventBus.getDefault().register(this);
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

    public void modifyFriend(Long friendId) {
    }

    public void deleteFriend(Long friendId) {
        Friend friend = Select.from(Friend.class).where(Condition.prop("id").eq(friendId)).first();
        friends.remove(friend);
        friend.delete();
        refreshFriendsList();
    }

    public void changeStarOnFriend(Long friendId) {
        Friend friend = Select.from(Friend.class).where(Condition.prop("id").eq(friendId)).first();
        friend.changeStarred();
    }

    public void refreshFriendsList() {
        friends = Friend.listAll(Friend.class);
        screen.showFriends(friends);
    }

    public List<Friend> getFriends() {
        return friends;
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
            if (screen != null) {
                screen.showFriends(friends);
            }
        }
    }
}
