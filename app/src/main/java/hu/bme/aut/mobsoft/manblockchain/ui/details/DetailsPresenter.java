package hu.bme.aut.mobsoft.manblockchain.ui.details;

import com.orm.query.Condition;
import com.orm.query.Select;

import org.greenrobot.eventbus.EventBus;

import hu.bme.aut.mobsoft.manblockchain.model.Friend;
import hu.bme.aut.mobsoft.manblockchain.ui.Presenter;
import hu.bme.aut.mobsoft.manblockchain.ui.friends.FriendsFragment;
import hu.bme.aut.mobsoft.manblockchain.ui.friends.FriendsScreen;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public class DetailsPresenter  extends Presenter<DetailsScreen> {

    private Friend friend;

    public void saveFriend(){
        friend.save();
    }

    public void refreshScreen(){
        if (screen != null){
            screen.loadFriend(friend);
        }
    }
    public void loadNewFriend(){
        friend = new Friend();
        refreshScreen();
    }

    public void loadFriend(Long friendId){
        friend = Select.from(Friend.class).where(Condition.prop("id").eq(friendId)).first();
        refreshScreen();
    }
}
