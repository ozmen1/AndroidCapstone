package com.esrayakut.habersayfasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Haber extends AppCompatActivity {

    ImageView resim;
    TextView baslik;
    TextView icerik;
    TextView tarih;
    TextView yazar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.haber);

        resim = (ImageView)findViewById(R.id.img_haber);
        baslik = (TextView)findViewById(R.id.txt_baslik);
        icerik = (TextView)findViewById(R.id.txt_icerik);
        tarih = (TextView)findViewById(R.id.txt_tarih);
        yazar = (TextView)findViewById(R.id.txt_yazar);

        baslik.setText(MainActivity.baslik[MainActivity.index]);
        icerik.setText(MainActivity.icerik[MainActivity.index]);
        yazar.setText(MainActivity.yazar[MainActivity.index]);
        tarih.setText(MainActivity.tarih[MainActivity.index]);
        Picasso.get().load(MainActivity.resim[MainActivity.index]).into(resim);
    }

    public void gitAnaSayfa(View view) {
        startActivity(new Intent(Haber.this, MainActivity.class));
    }

    public void geriGit(View view) {
        MainActivity.index--;
        startActivity(new Intent(Haber.this, Haber.class));
    }

    public void ileriGit(View view) {
        MainActivity.index++;
        startActivity(new Intent(Haber.this, Haber.class));
    }
}
