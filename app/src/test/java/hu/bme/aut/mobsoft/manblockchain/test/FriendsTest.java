package hu.bme.aut.mobsoft.manblockchain.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.manblockchain.BuildConfig;
import hu.bme.aut.mobsoft.manblockchain.model.Friend;
import hu.bme.aut.mobsoft.manblockchain.model.facebook.FriendDTO;
import hu.bme.aut.mobsoft.manblockchain.ui.friends.FriendsPresenter;
import hu.bme.aut.mobsoft.manblockchain.ui.friends.FriendsScreen;

import static hu.bme.aut.mobsoft.manblockchain.TestHelper.setTestInjector;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.inOrder;

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
    public void testAddNewFriendFromFacebook() {
        for(int i = 1; i < 5; i++) {
            friendsPresenter.addNewFriendFromFacebook();
            assertTrue(friendsPresenter.getFriendsCount() == i);
        }
        verify(friendsScreen,times(4)).showFriends();
    }

    @Test
    public void testDeleteFriend() {

        InOrder inOrder = inOrder(friendsScreen);

        for(int i = 1; i <= 5; i++) {
            Friend friend = new Friend();
            friend.setName("" + i);
            friend.save();
        }
        friendsPresenter.refreshFriendsList();
        assertEquals(5, friendsPresenter.getFriendsCount());
        inOrder.verify(friendsScreen).showFriends();
        assertEquals("3", friendsPresenter.getFriendByPosition(2).getName());
        friendsPresenter.deleteFriend(2);
        inOrder.verify(friendsScreen).showFriends();
        assertEquals("4", friendsPresenter.getFriendByPosition(2).getName());
    }

    @Test public void testChangeStarOnFriend(){
        for(int i = 1; i <= 5; i++) {
            Friend friend = new Friend();
            friend.setName("" + i);
            assertFalse(friend.isStarred());
            friend.save();
        }
        friendsPresenter.refreshFriendsList();
        friendsPresenter.changeStarOnFriend(3);
        assertTrue(friendsPresenter.getFriendByPosition(3).isStarred());
        friendsPresenter.changeStarOnFriend(2);
        assertTrue(friendsPresenter.getFriendByPosition(2).isStarred());
        friendsPresenter.changeStarOnFriend(2);
        assertFalse(friendsPresenter.getFriendByPosition(2).isStarred());
        friendsPresenter.changeStarOnFriend(3);
        assertFalse(friendsPresenter.getFriendByPosition(3).isStarred());
    }


    @After
    public void tearDown() {
        friendsPresenter.detachScreen();
    }

}
