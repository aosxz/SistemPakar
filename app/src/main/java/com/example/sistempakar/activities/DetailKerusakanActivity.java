package com.example.sistempakar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sistempakar.helper.DbHelper;
import com.example.sistempakar.models.*;
import com.example.sistempakar.R;
import com.squareup.picasso.Picasso;

public class DetailKerusakanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kerusakan);

        ImageView imageViewKerusakan = findViewById(R.id.image_view_kerusakan);
        TextView textViewNamaKerusakan = findViewById(R.id.text_view_nama_kerusakan);
        TextView textViewDeskripsi = findViewById(R.id.text_view_deskripsi);
        TextView textViewGejalaKerusakan = findViewById(R.id.text_view_gejala_kerusakan);
        TextView textViewSolusi = findViewById(R.id.text_view_solusi);

        Intent result = getIntent();
        int extraKodeKerusakan = result.getIntExtra("EXTRA_KODE_KERUSAKAN", 0);

        DbHelper dbHelper = DbHelper.getInstance(this);
        Kerusakan kerusakan = dbHelper.getKerusakanWhereKode(extraKodeKerusakan);

        Picasso.with(this).load(kerusakan.getImageKerusakan()).resizeDimen(R.dimen.image_picasso_w,R.dimen.image_picasso_h).into(imageViewKerusakan);
        textViewNamaKerusakan.setText(kerusakan.getNamaKerusakan());
        textViewDeskripsi.setText(kerusakan.getDeskripsi());
        textViewGejalaKerusakan.setText(kerusakan.getGejalaKerusakan());
        textViewSolusi.setText(kerusakan.getSolusi());
    }
}
