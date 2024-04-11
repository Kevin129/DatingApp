package pl.game.facebook2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextAge;
    private EditText editTextDescription;
    private static final int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextDescription = findViewById(R.id.editTextDescription);

        Button buttonOpenGallery = findViewById(R.id.buttonOpenGallery);
        buttonOpenGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        Button buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserData();
            }
        });

        Button buttonUserList = findViewById(R.id.buttonUserList);
        buttonUserList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showUserList();
            }
        });
    }

    private void openGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            // Tutaj możesz wykonać operacje na wybranym obrazie, jeśli potrzebne
        }
    }

    private void saveUserData() {
        String name = editTextName.getText().toString().trim();
        String age = editTextAge.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age) || TextUtils.isEmpty(description)) {
            Toast.makeText(this, "Uzupełnij wszystkie pola", Toast.LENGTH_SHORT).show();
        } else {
            // Przekieruj użytkownika do UserInfoActivity, przekazując mu dane
            Intent intent = new Intent(HomeActivity.this, UserInfoActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("age", age);
            intent.putExtra("description", description);
            startActivity(intent);
        }
    }

    private void showUserList() {
        // Przekieruj użytkownika do UsersListActivity
        startActivity(new Intent(HomeActivity.this, UsersListActivity.class));
    }
}
