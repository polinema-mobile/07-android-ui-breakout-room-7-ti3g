package com.example.senddataform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String NIM = intent.getStringExtra("NIM");
        String tanggal = intent.getStringExtra("tanggal");
        String gender = intent.getStringExtra("gender");
        String jurusan = intent.getStringExtra("jurusan");
        //read extra by tag name

        TextView nama = (TextView) findViewById(R.id.name);
        TextView no = (TextView) findViewById(R.id.nim);
        TextView date = (TextView) findViewById(R.id.date);
        TextView kelamin = (TextView) findViewById(R.id.sex);
        TextView major = (TextView) findViewById(R.id.jurusan);

        nama.setText(name);
        no.setText(NIM);
        date.setText(tanggal);
        kelamin.setText(gender);
        major.setText(jurusan);
    }
}