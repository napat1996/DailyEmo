package com.kmutt.android.dailyemo;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kmutt.android.dailyemo.Model.User;

/**
 * A login screen that offers login via email/password.
 */
public class SignupActivity extends Activity implements LoaderCallbacks<Cursor> {

    private String TAG = SignupActivity.class.getSimpleName();
    EditText inputUsername, inputEmail, inputPassword, confirmpassword;
    Button btnRegister;
    DatabaseReference mRootRef, username;
    FirebaseDatabase database;

    private FirebaseAuthException auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Firebase
        database = FirebaseDatabase.getInstance();
        mRootRef = FirebaseDatabase.getInstance().getReference("Users");


        btnRegister = (Button)findViewById(R.id.sign_in_button);
        inputEmail = (EditText)findViewById(R.id.inputEmail);
        inputPassword = (EditText)findViewById(R.id.inputPassword);
        inputUsername = (EditText) findViewById(R.id.inputUsername);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRootRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-login-af02d.firebaseio.com/Users");
                final User user = new User(inputUsername.getText().toString(),
                        inputPassword.getText().toString(),
                        inputEmail.getText().toString());
                mRootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child(user.getUsername()).exists())
                            Toast.makeText(SignupActivity.this, "The Username is Already Exist!", Toast.LENGTH_SHORT).show();
                        else {
                            mRootRef.child(user.getUsername()).setValue(user);
                            Toast.makeText(SignupActivity.this, "Success Register!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e(TAG, "onCancelled: !!!!!!!!!!!!N O T   W O R K K K K!!!!!!!!" );
                    }
                });
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

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

