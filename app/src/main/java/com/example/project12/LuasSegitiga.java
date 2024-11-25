package com.example.project12;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LuasSegitiga extends AppCompatActivity {
    EditText edAlas, edTinggi, edHasil;
    Button btnHitung, btnHapus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_luas_segitiga);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edAlas = findViewById(R.id.editAlas);
        edTinggi = findViewById(R.id.editTinggi);
        edHasil = findViewById(R.id.Hasil);
        btnHitung = findViewById(R.id.btn_Hitung);
        btnHapus = findViewById(R.id.btn_Hapus);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuasSegitiga();
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hapusInput();
            }
        });
    }

    private void hitungLuasSegitiga(){
        String alas = edAlas.getText().toString();
        String tinggi = edTinggi.getText().toString();

        if (TextUtils.isEmpty(alas)|| TextUtils.isEmpty(tinggi)){
            Toast.makeText(this, "Alas dan Tinggi tidak boleh kosong!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            float alasF = Float.parseFloat(alas);
            float tinggiF = Float.parseFloat(tinggi);

            if (alasF <= 0 || tinggiF <= 0){
                Toast.makeText(this, "Alas dan Tinggi harus lebih dari 0!", Toast.LENGTH_SHORT).show();
                return;
            }

            float luas = (alasF * tinggiF)/2;

            edHasil.setText(String.valueOf(luas));
        }
        catch (NumberFormatException e){
            Toast.makeText(this, "Masukkan angka yang valid!", Toast.LENGTH_SHORT).show();
        }
    }

    private void hapusInput(){
        edAlas.setText("");
        edTinggi.setText("");
        edHasil.setText("");

    }
    }
