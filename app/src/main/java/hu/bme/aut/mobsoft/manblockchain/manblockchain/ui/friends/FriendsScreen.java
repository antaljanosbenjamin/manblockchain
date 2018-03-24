package hu.bme.aut.mobsoft.manblockchain.manblockchain.ui.friends;

import java.util.List;

import hu.bme.aut.mobsoft.manblockchain.manblockchain.model.Friend;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public interface FriendsScreen {

    void showFriends(List<Friend> friends);

    void editFriend(Friend friend);

    void showNetworkError(String errorMsg);
}
