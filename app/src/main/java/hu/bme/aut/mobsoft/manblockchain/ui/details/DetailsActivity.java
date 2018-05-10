package hu.bme.aut.mobsoft.manblockchain.ui.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.orm.query.Condition;
import com.orm.query.Select;

import java.util.Date;

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

    EditText name;
    EditText nickname;
    EditText phone;
    EditText email;
    EditText facebookUrl;
    EditText instagramUrl;
    EditText linkedInUrl;
    EditText birthdate;
    EditText comments;

    Friend friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ManBlockchainApplication.injector.inject(this);

        String title;
        boolean isEditFriend = getIntent().getBooleanExtra(FriendsFragment.IS_FRIEND_EDIT, false);
        if (isEditFriend) {
            title = "Edit friend";
            Long friendId = getIntent().getLongExtra(FriendsFragment.EDITED_FRIEND_ID, 0);
            friend = Select.from(Friend.class).where(Condition.prop("id").eq(friendId)).first();
        } else {
            title = "Add new friend";
            friend = new Friend();
        }

        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = (EditText) findViewById(R.id.edit_name);
        nickname = (EditText) findViewById(R.id.edit_nickname);
        phone = (EditText) findViewById(R.id.edit_phone);
        email = (EditText) findViewById(R.id.edit_email);
        facebookUrl = (EditText) findViewById(R.id.edit_facebook);
        instagramUrl = (EditText) findViewById(R.id.edit_instagram);
        linkedInUrl = (EditText) findViewById(R.id.edit_linkedin);
        birthdate = (EditText) findViewById(R.id.edit_birthdate);
        comments = (EditText) findViewById(R.id.edit_comments);

        loadFriend(friend);
    }

    @Override
    public void loadFriend(Friend friend) {
        name.setText(friend.getName());
        phone.setText(friend.getPhoneNumber());
        email.setText(friend.getEmail());
        facebookUrl.setText(friend.getName());
        instagramUrl.setText(friend.getName());
        linkedInUrl.setText(friend.getName());
        birthdate.setText(friend.getName());
        comments.setText(friend.getName());
    }

    @Override
    public void saveFriend(Friend friend) {
        friend.setName(name.getText().toString());
        friend.setNickName(nickname.getText().toString());
        friend.setEmail(email.getText().toString());
        friend.setPhoneNumber(phone.getText().toString());
        friend.setFacebookProfilURL(facebookUrl.getText().toString());
        friend.setInstagramProfilURL(instagramUrl.getText().toString());
        friend.setLinkedinProfilURL(linkedInUrl.getText().toString());
        //friend.setBirthDate(birthdate.getText().toString());
        friend.setBirthDate(new Date());
        friend.setComments(comments.getText().toString());
        friend.save();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.details_actions_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.save) {
            saveFriend(friend);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
