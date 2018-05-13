package com.example.erhan.myapplicationsqlite;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText isim = (EditText) findViewById(R.id.isim);
        final EditText telefon = (EditText) findViewById(R.id.telefon);

        Button ekle = (Button) findViewById(R.id.ekle);
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veritabani vt = new veritabani(MainActivity.this);
                vt.veriEkle(isim.getText().toString(),telefon.getText().toString());

            }
        });

        final Button listele = (Button) findViewById(R.id.listele);
        final ListView listView = (ListView) findViewById(R.id.listView);
        listele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veritabani vt = new veritabani(MainActivity.this);
                List<String> veriler = vt.veriListele();
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,android.R.id.text1,veriler);
                listView.setAdapter(adapter);
            }
        });

        Button sil = (Button) findViewById(R.id.sil);
        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veritabani vt = new veritabani(MainActivity.this);
                vt.veriSil(isim.getText().toString());
            }
        });

        Button guncelle = (Button) findViewById(R.id.guncelle);
        guncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veritabani vt = new veritabani(MainActivity.this);
                vt.veriGuncelle(isim.getText().toString(), telefon.getText().toString());
            }
        });
    }
}













