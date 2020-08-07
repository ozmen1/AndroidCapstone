package com.esrayakut.habersayfasi;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread thread = new Thread()
        {
            @Override
            public void run()
            {
                try {
                    this.sleep(1500);                                                       // 3 saniye bekle
                }

                catch (InterruptedException e) {

                }

                finally {
                    startActivity(new Intent(Splash.this, MainActivity.class));     // Giris'e geç
                }
            }
        };

        thread.start();
    }
}
