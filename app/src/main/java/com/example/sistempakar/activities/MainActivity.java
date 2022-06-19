package com.example.sistempakar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.sistempakar.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardViewInfoKerusakan = findViewById(R.id.info_kerusakan_card_view);
        CardView cardViewKonsultasi = findViewById(R.id.konsultasi_card_view);
        CardView cardViewBantuan = findViewById(R.id.bantuan_card_view);
        CardView cardViewKeluar = findViewById(R.id.keluar_card_view);

        cardViewInfoKerusakan.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, InformasiKerusakanActivity.class);
            startActivity(intent);
        });

        cardViewKonsultasi.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PertanyaanGejalaActivity.class);
            startActivity(intent);
        });

        cardViewBantuan.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BantuanAplikasiActivity.class);
            startActivity(intent);
        });

        cardViewKeluar.setOnClickListener(v -> alertDialogExit());
    }


    public void alertDialogExit() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Keluar")
                .setMessage("Apakah anda ingin keluar dari apalikasi?")
                .setPositiveButton("ok", (dialog1, which) -> finish())
                .setNegativeButton("cancel", (dialog12, which) -> dialog12.cancel());
        dialog.show();

    }

    @Override
    public void onBackPressed() {
        alertDialogExit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.tentang_aplikasi, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.tentang_app_menu) {
            Intent intent = new Intent(MainActivity.this, TentangAppActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
