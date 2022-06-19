package com.example.sistempakar.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sistempakar.helper.DbHelper;
import com.example.sistempakar.models.*;
import com.example.sistempakar.R;

import java.util.ArrayList;

public class InformasiKerusakanActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informasi_kerusakan);

        DbHelper db = DbHelper.getInstance(this);

        ArrayList<Kerusakan> kerusakanArrayList = db.getListKerusakan();

        RecyclerView recyclerView = findViewById(R.id.recycler_View);
        ListInfoKerusakanAdapter adapter = new ListInfoKerusakanAdapter(this, kerusakanArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, 1));
        recyclerView.setAdapter(adapter);


    }
}
