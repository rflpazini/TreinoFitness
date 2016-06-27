package com.rflpazini.treinofitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        intent = new Intent(this, LoginActivity.class);

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        startIntent();
                    }
                }, 600);
    }

    public void startIntent() {
        startActivity(intent);
        finish();
    }
}
