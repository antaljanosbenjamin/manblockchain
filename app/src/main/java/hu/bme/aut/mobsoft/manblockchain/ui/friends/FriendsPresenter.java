package hu.bme.aut.mobsoft.manblockchain.ui.friends;

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

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public class FriendsPresenter extends Presenter<FriendsScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    FacebookInteractor facebookInteractor;

    FriendsScreen screen;

    private List<Friend> friends;

    public FriendsPresenter(){
        friends = new ArrayList<Friend>();
    }

    @Override
    public void attachScreen(FriendsScreen screen) {
        super.attachScreen(screen);
        ManBlockchainApplication.injector.inject(this);
        this.screen = screen;
        EventBus.getDefault().register(this);
        screen.showFriends(friends);

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

    public void addNewFriend(Friend friend) {
        friends.add(friend);
    }

    public void modifyFriend(Friend friend) {
    }

    public void deleteFriend(Friend friend) {
    }

    public void changeStarOnFriend(Friend friend) {
    }

    public List<Friend> getFriends(){
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
            friends.add(event.getFriend());
//            if (screen != null) {
//                screen.showFriends(friends);
//            }
        }
    }
}
