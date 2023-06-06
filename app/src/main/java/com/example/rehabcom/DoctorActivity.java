package com.example.rehabcom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        CardView exit = findViewById(R.id.cardDocBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorActivity.this,HomeActivity.class));
            }
        });
        CardView physician = findViewById(R.id.cardDocPhysician);
        physician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent it = new Intent (DoctorActivity.this, DoctordetailsActivity.class);
               it.putExtra("title", "Physicians");
               startActivity(it);
            }
        });
        CardView dietician = findViewById(R.id.cardDocDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DoctorActivity.this, DoctordetailsActivity.class);
                it.putExtra("title", "Dieticians");
                startActivity(it);
            }
        });
        CardView audiologist = findViewById(R.id.cardDocAudiologist);
        audiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DoctorActivity.this, DoctordetailsActivity.class);
                it.putExtra("title", "Audiologists");
                startActivity(it);
            }
        });
        CardView surgeon = findViewById(R.id.cardDocSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DoctorActivity.this, DoctordetailsActivity.class);
                it.putExtra("title", "Surgeons");
                startActivity(it);
            }
        });
        CardView neurologist = findViewById(R.id.cardDocNeurologist);
        neurologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(DoctorActivity.this, DoctordetailsActivity.class);
                it.putExtra("title", "Neurologist");
                startActivity(it);
            }
        });
    }
}