package hu.bme.aut.mobsoft.manblockchain.ui.details;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.orm.query.Condition;
import com.orm.query.Select;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

    private EditText name;
    private EditText nickname;
    private EditText phone;
    private EditText email;
    private EditText facebookUrl;
    private EditText instagramUrl;
    private EditText linkedInUrl;
    private EditText birthdate;
    private EditText comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ManBlockchainApplication.injector.inject(this);

        name = (EditText) findViewById(R.id.edit_name);
        nickname = (EditText) findViewById(R.id.edit_nickname);
        phone = (EditText) findViewById(R.id.edit_phone);
        email = (EditText) findViewById(R.id.edit_email);
        facebookUrl = (EditText) findViewById(R.id.edit_facebook);
        instagramUrl = (EditText) findViewById(R.id.edit_instagram);
        linkedInUrl = (EditText) findViewById(R.id.edit_linkedin);
        birthdate = (EditText) findViewById(R.id.edit_birthdate);
        comments = (EditText) findViewById(R.id.edit_comments);

        detailsPresenter.attachScreen(this);
        String title;
        boolean isEditFriend = getIntent().getBooleanExtra(FriendsFragment.IS_FRIEND_EDIT, false);
        if (isEditFriend) {
            title = "Edit friend";
            Long friendId = getIntent().getLongExtra(FriendsFragment.EDITED_FRIEND_ID, 0);
            detailsPresenter.loadFriend(friendId);
        } else {
            title = "Add new friend";
            detailsPresenter.loadNewFriend();
        }

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(title);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private class ReflectiveTextWatch implements TextWatcher {

        private Friend friend;
        private String methodName;

        ReflectiveTextWatch(Friend friend, String fieldName) {
            this.friend = friend;
            this.methodName = fieldName;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            try {
                Method method = Friend.class.getDeclaredMethod("set" + methodName, String.class);
                method.invoke(friend, s.toString());
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }

    @Override
    public void loadFriend(final Friend friend) {
        name.setText(friend.getName());
        name.addTextChangedListener(new ReflectiveTextWatch(friend, "Name"));
        nickname.setText(friend.getNickName());
        nickname.addTextChangedListener(new ReflectiveTextWatch(friend, "NickName"));
        phone.setText(friend.getPhoneNumber());
        phone.addTextChangedListener(new ReflectiveTextWatch(friend, "PhoneNumber"));
        email.setText(friend.getEmail());
        email.addTextChangedListener(new ReflectiveTextWatch(friend, "Email"));
        facebookUrl.setText(friend.getFacebookProfilURL());
        facebookUrl.addTextChangedListener(new ReflectiveTextWatch(friend, "FacebookProfilURL"));
        instagramUrl.setText(friend.getInstagramProfilURL());
        instagramUrl.addTextChangedListener(new ReflectiveTextWatch(friend, "InstagramProfilURL"));
        linkedInUrl.setText(friend.getLinkedinProfilURL());
        linkedInUrl.addTextChangedListener(new ReflectiveTextWatch(friend, "LinkedinProfilURL"));
        birthdate.setText(friend.getFromattedBirthDate());

        final Calendar calendar = new GregorianCalendar();
        calendar.setTime(friend.getBirthDate());

        birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(DetailsActivity.this, 0, new OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        friend.setBirthDateSeparate(year, month, dayOfMonth);
                        birthdate.setText(friend.getFromattedBirthDate());
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        comments.setText(friend.getComments());
        comments.addTextChangedListener(new ReflectiveTextWatch(friend, "Comments"));
    }

    @Override
    public void saveFriend() {
        detailsPresenter.saveFriend();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.details_actions_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
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
            saveFriend();
            detailsPresenter.detachScreen();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
