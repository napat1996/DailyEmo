package com.kmutt.android.dailyemo;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kmutt.android.dailyemo.Model.User;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity implements LoaderCallbacks<Cursor> {

    private String TAG = LoginActivity.class.getSimpleName();
    Button loginButton ;
    Button createNewAccount;
    ProgressBar loginProgress;
    //DatabaseReference users;

    FirebaseDatabase database;
    DatabaseReference mRootRef, users;

    EditText inputEmail, inputPassword, inputUsername;
    Button btnLogin, btnToSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        database = FirebaseDatabase.getInstance();
        mRootRef = database.getReference("Users");

        inputUsername = (EditText)findViewById(R.id.inputUsername);
        inputPassword = (EditText)findViewById(R.id.inputPassword) ;

        btnLogin = (Button)findViewById(R.id.log_in_button);
        btnToSignup = (Button)findViewById(R.id.createNewAccount);

        //loginButton = (Button) findViewById(R.id.log_in_button);
        // loginProgress = findViewById(R.id.login_progress);
        //loginProgress.setVisibility(View.INVISIBLE);

        //createNewAccount = (Button) findViewById(R.id.createNewAccount);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //loginProgress.setVisibility(View.VISIBLE);
                System.out.println(inputUsername.getText().toString());
                //btnLogin.setVisibility(View.INVISIBLE);
                logIn(inputUsername.getText().toString(),
                        inputPassword.getText().toString());
            }
        });

        // create new account
        btnToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("EIEI");
                Intent s = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(s);

            }
        });


    }

    private void logIn(final String username, final String password) {
        System.out.println("Hi, I'm a logIn method!!");
        mRootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // ไม่เข้าอันล่าง
                if(dataSnapshot.child(username).exists()){
                    if(!username.isEmpty()){
                        User login = dataSnapshot.child(username).getValue(User.class);
                        if (login.getPassword().equals(password)){
                            Toast.makeText(LoginActivity.this,"Success Login", Toast.LENGTH_SHORT).show();
                            Log.e(TAG, "onDataChange: ++++++++++++ S U C C E S S   F U L L ++++++++++++");

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Password is wrong!", Toast.LENGTH_SHORT).show();
                            Log.e(TAG, "onDataChange: !!!!!!!!!!! P A S S W O R D   W R O N G !!!!!!!!!!!!!");
                        }
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Username is Not Register!", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "onDataChange: !!!!!!!!!!! U S E R N A M E   W R O N G !!!!!!!!!!!!!");
                    }
                }
                else
                    Log.e(TAG, "onDataChange: !!!!!!!!!!! S O M E T H I N G  W R O N G !!!!!!!!!!!!!");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}

