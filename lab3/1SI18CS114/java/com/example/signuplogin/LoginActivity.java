package com.example.signuplogin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        Button loginButton = findViewById(R.id.button2);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = getIntent().getExtras();
                final String loginUsername = bundle.getString("UserName");
                final String loginPassword = bundle.getString("Password");
                EditText UserName = findViewById(R.id.edituserName);
                EditText PassWord = findViewById(R.id.editpassWord);
                String usr = UserName.getText().toString().trim();
                String psw = PassWord.getText().toString().trim();

                if(usr.equals(loginUsername)&&psw.equals(loginPassword)){
                    Toast.makeText(LoginActivity.this, "Successful Login!!", Toast.LENGTH_LONG).show();
                }else{
                    counter++;
                    if(counter == 1){
                        Toast.makeText(LoginActivity.this, "Invalid Credentials, 2 Attempts Left", Toast.LENGTH_SHORT).show();
                    }
                    else if(counter == 2){
                        Toast.makeText(LoginActivity.this, "Invalid Credentials, 1 Attempts Left", Toast.LENGTH_SHORT).show();
                    }
                    else if(counter == 3){
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        loginButton.setEnabled(false);
                    }
                }
            }
        });
    }


}

