package hu.bme.aut.mobsoft.manblockchain.ui.details;

import hu.bme.aut.mobsoft.manblockchain.model.Friend;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public interface DetailsScreen {

    void loadFriend(Friend friend);

    void saveFriend();
}
