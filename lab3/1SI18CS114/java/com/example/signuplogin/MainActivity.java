package com.example.signuplogin;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.signuplogin.R.id.username;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signUpButton = findViewById(R.id.button1);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText usernameText = findViewById(R.id.editusername);
                EditText passwordText = findViewById(R.id.editpassword);


                String userName = usernameText.getText().toString();
                String passWord = passwordText.getText().toString();


                if(validatePassword(passWord)){
                    Toast.makeText(MainActivity.this, "Successful login", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    intent.putExtra("UserName", userName);
                    intent.putExtra("Password", passWord);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private boolean validatePassword(String passwd){
        boolean isValid = false;
        int passwdLength = passwd.length();

        for(int i=0 ; i<passwd.length() ; i++){
            char ch;
            ch = passwd.charAt(i);
            if(Character.isUpperCase(ch) || Character.isLowerCase(ch) || Character.isDigit(ch) || Character.isAlphabetic(ch) || (passwd.length() >= passwdLength) || (ch == '@') || (ch == '!') || (ch == '#') || (ch == '$') || (ch == '_')){
                isValid = true;
            }
            else{
                isValid = false;
            }
        }

        return isValid;
    }

}

