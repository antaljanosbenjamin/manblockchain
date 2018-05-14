package hu.bme.aut.mobsoft.manblockchain.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import hu.bme.aut.mobsoft.manblockchain.BuildConfig;
import hu.bme.aut.mobsoft.manblockchain.model.Friend;
import hu.bme.aut.mobsoft.manblockchain.ui.details.DetailsActivity;
import hu.bme.aut.mobsoft.manblockchain.ui.details.DetailsPresenter;
import hu.bme.aut.mobsoft.manblockchain.ui.details.DetailsScreen;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Antal János Benjamin on 2018. 05. 11..
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class DetailsTest {
    DetailsScreen detailsScreen;
    DetailsPresenter detailsPresenter;

    @Before
    public void setup(){
        detailsScreen = mock(DetailsActivity.class);
        detailsPresenter = new DetailsPresenter();
        detailsPresenter.attachScreen(detailsScreen);
    }

    @Test
    public void testLoadNewFriend(){
        ArgumentCaptor<Friend> friendCaptor = ArgumentCaptor.forClass(Friend.class);
        detailsPresenter.loadNewFriend();
        verify(detailsScreen).loadFriend(friendCaptor.capture());
        Friend capturedFriend = friendCaptor.getValue();
        assertTrue(capturedFriend.getName().isEmpty());
        assertTrue(capturedFriend.getPhoneNumber().isEmpty());
        assertTrue(capturedFriend.getEmail().isEmpty());
        assertTrue(capturedFriend.getNickName().isEmpty());
        assertTrue(capturedFriend.getFacebookProfilURL().isEmpty());
        assertTrue(capturedFriend.getInstagramProfilURL().isEmpty());
        assertTrue(capturedFriend.getLinkedinProfilURL().isEmpty());
        assertTrue(capturedFriend.getComments().isEmpty());
    }

    @After
    public void teardown(){
        detailsPresenter.detachScreen();
    }
}
