package com.example.precautia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView findDoctor = findViewById(R.id.cardFDBAck);
        findDoctor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class));
            }
        });
        CardView FamilyPhysician = findViewById((R.id.cardFDFamilyPhysician));
        FamilyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","FamilyPhysician");
                startActivity(it);
            }
        });

        CardView FamilyDietician = findViewById((R.id.cardFDDietician));
        FamilyDietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "FamilyDietician");
                startActivity(it);
            }
        });

        CardView FamilyDentist = findViewById((R.id.cardFDFamilyDEntist));
        FamilyDentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "FamilyDentist");
                startActivity(it);
            }
        });

        CardView FamilySurgeon = findViewById((R.id.cardFDFamilySurgeon));
        FamilySurgeon.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View v){
            Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
            it.putExtra("title", "FamilySurgeon");
            startActivity(it);
        }
    });

        CardView FamilyCardiologist = findViewById((R.id.cardFDFamilyCardiologist));
        FamilyCardiologist.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick (View v){
            Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
            it.putExtra("title", "FamilyCardiologist");
            startActivity(it);
        }
    });

}
}
