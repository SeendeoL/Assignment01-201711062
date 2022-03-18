package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        button = findViewById(R.id.login_button);

        Button login_button = (Button) findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                velidateEmail(username);
                velidatePassword(password);
            }
        });


    }
    private boolean velidateEmail(EditText username){
     String emailInput = username.getText().toString();

     if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
         Toast.makeText(this, "Email Validated Successfully", Toast.LENGTH_SHORT).show();
         return true;
     }
     else{
         Toast.makeText(this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
         return false;
     }
    }
    private boolean velidatePassword(EditText password){
        String passwordInput = password.getText().toString();
        if(!(passwordInput.isEmpty())){
            return true;
        }
        else{
            Toast.makeText(this, "Password Can Not Be Empty !", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}