package com.example.ham.goralets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Ham on 3/1/2018.
 */

public class Account2 extends AppCompatActivity{

    private FirebaseAuth auth;
    public static TextView data;
    public static TextView TVFname;
    public static TextView TVLname;
    public static TextView TVContact;
    public static TextView TVBirthdate;
    public static TextView TVEmail;
    public static String Email;
    private static Context mCtx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_account);

            auth = FirebaseAuth.getInstance();

            BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
            BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    if(item.getItemId() == R.id.homeItem){
                        Intent i = new Intent(Account2.this, MainActivity.class);
                        //i.putExtra("Email", str);
                        startActivity(i);
                    }
                    else if(item.getItemId() == R.id.bookingItem){
                        Intent i = new Intent(Account2.this, Bookings.class);
                        startActivity(i);
                    }
                    else if (item.getItemId() == R.id.messagesItem){
                        Intent i = new Intent(Account2.this, Messages.class);
                        startActivity(i);
                    }
                    else if(item.getItemId() == R.id.accountItem){
                        Intent i = new Intent(Account2.this, Account.class);
                        startActivity(i);
                    }
                    return false;
                }
            });

            //data = (TextView)findViewById(R.id.TVSample);

            Email = getIntent().getStringExtra("Email");

            TVFname = (TextView)findViewById(R.id.TVFname);
            TVLname = (TextView)findViewById(R.id.TVLname);
            TVContact = (TextView)findViewById(R.id.TVContact);
            TVEmail = (TextView)findViewById(R.id.TVEmail);
            TVBirthdate = (TextView)findViewById(R.id.TVBirthdate);

            FetchedDataAcct process = new FetchedDataAcct();
            process.execute();
    }

    public void onLogout(View view){
        finish();
        Intent i = new Intent(Account2.this, Login.class);
        startActivity(i);
    }

    public void onEditAcct(View view){
        Intent i = new Intent(Account2.this, EditUser.class);
        startActivity(i);
    }
}
