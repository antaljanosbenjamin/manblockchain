package hu.bme.aut.mobsoft.manblockchain.ui.friends;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import hu.bme.aut.mobsoft.manblockchain.R;
import hu.bme.aut.mobsoft.manblockchain.model.Friend;

/**
 * Created by mobsoft on 2018. 04. 27..
 */

public class FriendsAdapter extends BaseAdapter {

    Context context;
    List<Friend> friendList;
    private static LayoutInflater inflater = null;

    public FriendsAdapter(Context context, List<Friend> friendList) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.friendList = friendList;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return friendList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return friendList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.friend_item, null);

        Friend friend = friendList.get(position);
        TextView nameView = (TextView) vi.findViewById(R.id.name);
        TextView phone = (TextView) vi.findViewById(R.id.text);

        nameView.setText(friend.getName());
        phone.setText(friend.getPhoneNumber());
        return vi;
    }
}