package com.example.ham.goralets;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Ham on 3/8/2018.
 */

public class DealLayout extends AppCompatActivity {

    private static final String TAG = "deal_layout";
    private BottomNavigationView bottomNavigationView;
    private Button BtnBook;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deal_layout);
        Log.d(TAG, "onCreate started");

        getIncomingIntent();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.homeItem){
                    Intent i = new Intent(DealLayout.this, MainActivity.class);
                    //i.putExtra("Email", str);
                    startActivity(i);
                }
                else if(item.getItemId() == R.id.bookingItem){
                    Intent i = new Intent(DealLayout.this, Bookings.class);
                    startActivity(i);
                }
                else if (item.getItemId() == R.id.messagesItem){
                    Intent i = new Intent(DealLayout.this, Messages.class);
                    startActivity(i);
                }
                else if(item.getItemId() == R.id.accountItem){
                    Intent i = new Intent(DealLayout.this, Account.class);
                    startActivity(i);
                }

                return false;
            }
        });

        BtnBook = (Button) findViewById(R.id.BtnBook);
        BtnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DealLayout.this, Bookings.class);
                startActivity(i);
            }
        });
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: checking for incoming intents");
        if (getIntent().hasExtra("DealImage") && getIntent().hasExtra("DealTitle") && getIntent().hasExtra("DealPrice")){
            Log.d(TAG, "getIncomingIntent: found intent extras");

            String DealImage = getIntent().getStringExtra("DealImage");
            String DealImage2 = getIntent().getStringExtra("DealImage2");
            String DealImage3 = getIntent().getStringExtra("DealImage3");

            String DealTitle = getIntent().getStringExtra("DealTitle");
            String DealStartdate = getIntent().getStringExtra("DealStartdate");
            String DealEnddate = getIntent().getStringExtra("DealEnddate");

            String DealPrice = getIntent().getStringExtra("DealPrice");
            String DealRating = getIntent().getStringExtra("DealRating");
            String DealInclusions = getIntent().getStringExtra("DealInclusions");
            String DealExclusions = getIntent().getStringExtra("DealExclusions");

            setImage(DealImage, DealImage2, DealImage3, DealTitle, DealStartdate, DealEnddate, DealPrice, DealRating, DealInclusions, DealExclusions);
        }
    }

    private void setImage(String DealImage, String DealImage2, String DealImage3, String DealTitle, String DealStartdate, String DealEnddate, String DealPrice, String DealRating, String DealInclusions, String DealExclusions){
        Log.d(TAG, "setImage : setting images");

        ImageView img = findViewById(R.id.DealImage);
        Glide.with(this)
                .asBitmap()
                .load(DealImage)
                .into(img);

        ImageView img2 = findViewById(R.id.DealImage2);
        Glide.with(this)
                .asBitmap()
                .load(DealImage2)
                .into(img2);

        ImageView img3 = findViewById(R.id.DealImage3);
        Glide.with(this)
                .asBitmap()
                .load(DealImage3)
                .into(img3);

        TextView title = findViewById(R.id.DealTitle);
        title.setText(DealTitle);

        TextView startdate = findViewById(R.id.DealStartdate);
        startdate.setText(DealStartdate);

        TextView enddate = findViewById(R.id.DealEnddate);
        enddate.setText(DealEnddate);

        TextView price = findViewById(R.id.DealPrice);
        price.setText(DealPrice);

        TextView inclusions = findViewById(R.id.DealInclusions);
        inclusions.setText(DealInclusions);

        TextView exclusions = findViewById(R.id.DealExclusions);
        exclusions.setText(DealExclusions);

    }

}
