// UsersListActivity.java
package pl.game.facebook2;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class UsersListActivity extends AppCompatActivity {

    private ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        ListView listViewUsers = findViewById(R.id.listViewUsers);

        getUserList();

        UserListAdapter userListAdapter = new UserListAdapter(this, userList);
        listViewUsers.setAdapter(userListAdapter);
    }

    private void getUserList() {
        userList = new ArrayList<>();
        userList.add(new User("Użytkownik 1", "login1", "hasło1"));
        userList.add(new User("Użytkownik 2", "login2", "hasło2"));
    }
}
