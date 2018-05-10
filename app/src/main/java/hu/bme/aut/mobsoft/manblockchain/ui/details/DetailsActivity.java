package hu.bme.aut.mobsoft.manblockchain.ui.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.orm.query.Condition;
import com.orm.query.Select;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.manblockchain.ManBlockchainApplication;
import hu.bme.aut.mobsoft.manblockchain.R;
import hu.bme.aut.mobsoft.manblockchain.model.Friend;
import hu.bme.aut.mobsoft.manblockchain.ui.friends.FriendsFragment;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public class DetailsActivity extends AppCompatActivity implements DetailsScreen {

    @Inject
    DetailsPresenter detailsPresenter;

    Friend friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ManBlockchainApplication.injector.inject(this);

        String title;
        boolean isEditFriend = getIntent().getBooleanExtra(FriendsFragment.IS_FRIEND_EDIT, false);
        if (isEditFriend){
            title = "Edit friend";
            Long friendId = getIntent().getLongExtra(FriendsFragment.EDITED_FRIEND_ID, 0);
            friend = Select.from(Friend.class).where(Condition.prop("id").eq(friendId)).first();
        } else {
            title = "Add new friend";
            friend = new Friend();
        }


        getSupportActionBar().setTitle(title);
    }

    @Override
    public void loadFriend(Friend friend) {

    }

    @Override
    public void saveFriend(Friend friend) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.details_actions_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
