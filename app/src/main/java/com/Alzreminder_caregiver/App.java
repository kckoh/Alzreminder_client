package com.Alzreminder_caregiver;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class App extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                // if defined
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        );

        setContentView(R.layout.activity_main);
    }



    public void switch_sign_up(View view){
        Toast.makeText(App.this,"Logged in", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Sign_up.class);
        startActivity(intent);
    }


    public void loggingIn(String username, String password){

        ParseUser.logInInBackground(username,password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(user != null){

                    Toast.makeText(getApplicationContext(),user.get("strings").toString(), Toast.LENGTH_SHORT).show();


                    //Toast.makeText(MainActivity.this,"Logged in", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
