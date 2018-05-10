package hu.bme.aut.mobsoft.manblockchain.ui.friends;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.List;

import hu.bme.aut.mobsoft.manblockchain.R;
import hu.bme.aut.mobsoft.manblockchain.model.Friend;

/**
 * Created by mobsoft on 2018. 04. 27..
 */

public class FriendsAdapter extends BaseAdapter {

    Context context;
    FriendsPresenter friendsPresenter;
    List<Friend> friendList;

    public FriendsAdapter(Context context, FriendsPresenter friendsPresenter, List<Friend> friendList) {
        this.context = context;
        this.friendsPresenter = friendsPresenter;
        this.friendList = friendList;
    }

    @Override
    public int getCount() {
        return friendList.size();
    }

    @Override
    public Object getItem(int position) {
        return friendList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return friendList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            vi = inflater.inflate(R.layout.friend_item, null);
        }
        final Friend friend = friendList.get(position);
        TextView nameView = (TextView) vi.findViewById(R.id.name);
        TextView phone = (TextView) vi.findViewById(R.id.phone);
        ImageView deleteBtn = (ImageView) vi.findViewById(R.id.delete);
        deleteBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                friendsPresenter.deleteFriend(friend.getId());
            }
        });

        nameView.setText(friend.getName());
        phone.setText(friend.getPhoneNumber());

        return vi;
    }

    private static class ImageDownloadTask extends AsyncTask<String, Integer, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... url) {
            try {
                return Picasso.get().load(url[0]).get();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}