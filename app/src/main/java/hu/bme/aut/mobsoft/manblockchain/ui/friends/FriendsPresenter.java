package hu.bme.aut.mobsoft.manblockchain.ui.friends;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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

    private List<Friend> friends;

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

    public void addFriendFromFacebook() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                facebookInteractor.getFriend();
            }
        });
    }

    public void addNewFriend(Friend friend) {
    }

    public void modifyFriend(Friend friend) {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetFriendEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                friends.add(event.getFriend());
                screen.showFriends(friends);
            }
        }
    }
}
