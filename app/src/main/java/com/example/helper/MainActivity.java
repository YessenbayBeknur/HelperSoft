package com.example.helper;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText stud_id,password;
    Button sign_in;
    static FirebaseAuth mAuth;
    static String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stud_id = findViewById(R.id.student_id);
        password = findViewById(R.id.student_password);
        sign_in = findViewById(R.id.sign_in);

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();




        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callLogin(stud_id.getText().toString().trim(),password.getText().toString());
            }
        });

    }

    public void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user != null){
            email = user.getEmail();
            Intent intent = new Intent(getApplicationContext(), Nav_activity.class);
            startActivity(intent);
        }
    }




    public void callLogin(String stud_id, String password){
        mAuth.signInWithEmailAndPassword(stud_id, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Intent intent = new Intent(getApplicationContext(), Nav_activity.class);
                            startActivity(intent);

                        } else {

                            Log.w("$$$$$", "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }
}
