package com.example.rehabcom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedpreferences = getSharedPreferences("shared_Prefs", Context.MODE_PRIVATE);
        String username = sharedpreferences.getString("username", "");
        Toast.makeText(getApplicationContext(), "Welcome" + username, Toast.LENGTH_SHORT).show();

        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();
            editor.apply();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        });
        CardView Doctor = findViewById(R.id.cardDoctor);
        Doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, DoctorActivity.class));

            }
        });
        CardView Health = findViewById(R.id.cardREHABARTICLES);
        Health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, HealthArticlesActivity.class));

            }
        });
        CardView LabTest = findViewById(R.id.cardLabTest);
        LabTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, LabTestActivity.class));

            }
        });
       CardView buyMedicine = findViewById(R.id.cardBuyMedicine);
        buyMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, BuyMedicineActivity.class));

            }
        });
        CardView orderDetails = findViewById(R.id.cardOrderDetails);
        orderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this, OrderDetailsActivity.class));

            }
        });
    }
}