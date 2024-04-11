// UserListAdapter.java
package pl.game.facebook2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class UserListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<User> userList;

    public UserListAdapter(Context context, ArrayList<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        }

        User user = userList.get(position);

        TextView textViewUserName = convertView.findViewById(R.id.textViewUserName);
        textViewUserName.setText(user.getName());

        TextView textViewUserLogin = convertView.findViewById(R.id.textViewUserLogin);
        textViewUserLogin.setText(user.getLogin());

        TextView textViewUserPassword = convertView.findViewById(R.id.textViewUserPassword);
        textViewUserPassword.setText(user.getPassword());

        Button buttonDelete = convertView.findViewById(R.id.buttonDelete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dodaj tutaj logikę usuwania użytkownika
            }
        });

        Button buttonBack = convertView.findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dodaj tutaj logikę przekierowania do HomeActivity
            }
        });

        return convertView;
    }
}
