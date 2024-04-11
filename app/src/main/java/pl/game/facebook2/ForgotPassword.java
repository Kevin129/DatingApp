package pl.game.facebook2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {

    private EditText editTextEmail;
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        editTextEmail = findViewById(R.id.editTextEmail);
        buttonSend = findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        // Tutaj możesz dodać logikę wysyłania e-maila do użytkownika
        // np. wysłanie e-maila z linkiem do zresetowania hasła
        // Możesz również skorzystać z klasy UsersDataBase do sprawdzania istnienia użytkownika
        // na podstawie adresu e-mail.
        Toast.makeText(this, "E-mail z linkiem do resetowania hasła został wysłany", Toast.LENGTH_SHORT).show();
    }
}
