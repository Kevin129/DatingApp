package pl.game.facebook2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info);

        // Pobierz dane przekazane z poprzedniej aktywności
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");
        String description = intent.getStringExtra("description");

        // Wyświetl dane użytkownika
        TextView textViewName = findViewById(R.id.textViewName);
        TextView textViewAge = findViewById(R.id.textViewAge);
        TextView textViewDescription = findViewById(R.id.textViewDescription);

        if (name != null) textViewName.setText("Imię: " + name);
        if (age != null) textViewAge.setText("Wiek: " + age);
        if (description != null) textViewDescription.setText("Opis: " + description);

        // Przycisk "Wyloguj"
        Button buttonLogout = findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void logout() {
        // Przekieruj użytkownika do panelu logowania (MainActivity)
        Intent intent = new Intent(UserInfoActivity.this, MainActivity.class);
        // Ustaw flagi, aby wyczyścić stos aktywności i uniemożliwić powrót do UserInfoActivity
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        // Zakończ UserInfoActivity, aby nie można było do niego wrócić przyciskiem "Wstecz"
        finish();
    }
}
