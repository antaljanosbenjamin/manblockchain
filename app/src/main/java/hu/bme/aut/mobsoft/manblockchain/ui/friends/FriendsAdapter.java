package hu.bme.aut.mobsoft.manblockchain.ui.friends;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
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

    private Context context;
    private FriendsPresenter friendsPresenter;

    private static class ViewHolder {
        ImageView image;
        TextView name;
        TextView phone;
        TextView email;
        ImageView star;
        ImageView deleteBtn;
    }

    public FriendsAdapter(Context context, FriendsPresenter friendsPresenter, List<Friend> friendList) {
        this.context = context;
        this.friendsPresenter = friendsPresenter;
    }

    @Override
    public int getCount() {
        return friendsPresenter.getFriendsCount();
    }

    @Override
    public Object getItem(int position) {
        return friendsPresenter.getFriendByPosition(position);
    }

    @Override
    public long getItemId(int position) {
        return friendsPresenter.getFriendByPosition(position).getId();
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {

        final ViewHolder viewHolder;
        final Friend friend = friendsPresenter.getFriendByPosition(position);
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.friend_item, null);
            viewHolder.image = (ImageView) view.findViewById(R.id.profile_image);
            viewHolder.name = (TextView) view.findViewById(R.id.name);
            viewHolder.phone = (TextView) view.findViewById(R.id.phone);
            viewHolder.email = (TextView) view.findViewById(R.id.email);
            viewHolder.star = (ImageView) view.findViewById(R.id.star);
            viewHolder.deleteBtn = (ImageView) view.findViewById(R.id.delete);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        if (friend.hasProfileImage()) {
            Picasso.get().load(friend.getImageUrl()).into(viewHolder.image);
        } else {
            viewHolder.image.setImageResource(R.mipmap.ic_launcher);
        }

        viewHolder.star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friendsPresenter.changeStarOnFriend(position);
                notifyDataSetChanged();
            }
        });

        viewHolder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friendsPresenter.deleteFriend(position);
                notifyDataSetChanged();
            }
        });

        viewHolder.name.setText(friend.getName());
        viewHolder.phone.setText(friend.getPhoneNumber());
        viewHolder.email.setText(friend.getEmail());
        if (friend.isStarred()){
            viewHolder.star.setImageResource(R.drawable.ic_star_yellow_48dp);
        } else {
            viewHolder.star.setImageResource(R.drawable.ic_star_grey_48dp);
        }
        return view;
    }
}