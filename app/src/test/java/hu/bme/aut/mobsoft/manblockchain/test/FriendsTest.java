package hu.bme.aut.mobsoft.manblockchain.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;

import hu.bme.aut.mobsoft.manblockchain.BuildConfig;
import hu.bme.aut.mobsoft.manblockchain.model.Friend;
import hu.bme.aut.mobsoft.manblockchain.ui.friends.FriendsPresenter;
import hu.bme.aut.mobsoft.manblockchain.ui.friends.FriendsScreen;

import static hu.bme.aut.mobsoft.manblockchain.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class FriendsTest {

    private FriendsPresenter friendsPresenter;
    private FriendsScreen friendsScreen;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        friendsScreen = mock(FriendsScreen.class);
        friendsPresenter = new FriendsPresenter();
        friendsPresenter.attachScreen(friendsScreen);
    }

    @Test
    public void testTrendingMovies() {
        friendsPresenter.refreshFriendsList();
        Friend friend = new Friend();
        friend.save();
        verify(friendsScreen).showFriends();
    }


    @After
    public void tearDown() {
        friendsPresenter.detachScreen();
    }

}
