package com.example.ham.goralets;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private EditText TFEmail, TFPassword;
    private FirebaseAuth auth;

    private Button BtnLogin;
    private Button BtnRegister;
    private ProgressBar progressBarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

       // if (auth.getCurrentUser() != null) {
       //     startActivity(new Intent(Login.this, MainActivity.class));
       //     finish();
       // }

        TFEmail = (EditText) findViewById(R.id.TFEmail);
        TFPassword = (EditText) findViewById(R.id.TFPassword);

        BtnLogin = (Button) findViewById(R.id.BtnLogin);
        BtnRegister = (Button)findViewById(R.id.BtnRegister);

        auth = FirebaseAuth.getInstance();
        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                final String email = TFEmail.getText().toString();
                final String password = TFPassword.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter an email address", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent i = new Intent(Login.this, FetchedDataAcct.class);
                i.putExtra("Email", email);

                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                        Intent i = new Intent(Login.this, Account.class);
                                        i.putExtra("Email", email);

                                        Intent intent = new Intent(Login.this, MainActivity.class);
                                        progressBarLogin = findViewById(R.id.progressBarLogin);
                                        progressBarLogin.setVisibility(View.VISIBLE);
                                        startActivity(intent);
                                        progressBarLogin.setVisibility(View.GONE);
                                        finish();
                                }
                            }
                        });
            }
        });

        BtnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Registration.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
