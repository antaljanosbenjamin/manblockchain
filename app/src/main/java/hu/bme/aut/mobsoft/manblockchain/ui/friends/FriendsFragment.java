package hu.bme.aut.mobsoft.manblockchain.ui.friends;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.manblockchain.ManBlockchainApplication;
import hu.bme.aut.mobsoft.manblockchain.R;
import hu.bme.aut.mobsoft.manblockchain.model.Friend;
import hu.bme.aut.mobsoft.manblockchain.ui.details.DetailsActivity;

/**
 * Created by Antal János Benjamin on 2018. 03. 24..
 */

public class FriendsFragment extends Fragment implements FriendsScreen {

    public static final String IS_FRIEND_EDIT = "IS_FRIEND_EDIT";
    public static final String EDITED_FRIEND_ID = "EDITED_FRIEND_ID";

    private FriendsAdapter adapter;

    @Inject
    FriendsPresenter friendsPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);
        ListView listview = (ListView) view.findViewById(R.id.friend_list);
        listview.setClickable(true);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onEditFriend(id);
            }
        });
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddNewFriend();
            }
        });
        adapter = new FriendsAdapter(getContext(), friendsPresenter, new ArrayList<Friend>());
        listview.setAdapter(adapter);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        friendsPresenter.refreshFriendsList();
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        friendsPresenter.attachScreen(this);
    }

    public FriendsFragment() {
        ManBlockchainApplication.injector.inject(this);}

    @Override
    public void onDetach() {
        friendsPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public void showFriends() {
        adapter.notifyDataSetChanged();
    }

    public void onAddNewFriend() {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(IS_FRIEND_EDIT, false);
        intent.putExtra(EDITED_FRIEND_ID, 0L);
        startActivity(intent);
    }

    public void onEditFriend(Long friendId) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(IS_FRIEND_EDIT, true);
        intent.putExtra(EDITED_FRIEND_ID, friendId);
        startActivity(intent);
    }

    //@Override
    public void showNetworkError(String errorMsg) {
        Toast.makeText(getContext(), errorMsg, Toast.LENGTH_LONG).show();
    }
}
