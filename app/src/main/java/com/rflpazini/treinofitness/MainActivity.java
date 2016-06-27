package com.rflpazini.treinofitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rflpazini.treinofitness.anamnese.AnamneseActivity;
import com.rflpazini.treinofitness.physical.PhysicalActivity;
import com.rflpazini.treinofitness.training.TrainingActivity;

public class MainActivity extends AppCompatActivity {

    private Button physicalButton;
    private Button anamneseButton;
    private Button trainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        physicalButton = (Button) findViewById(R.id.btn_aval_fisica);
        anamneseButton = (Button) findViewById(R.id.btn_anamnese);
        trainButton = (Button) findViewById(R.id.btn_treino);

        physicalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent physicalIntent = new Intent(getApplicationContext(),  PhysicalActivity.class);
                startActivity(physicalIntent);
            }
        });

        anamneseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent anamIntent = new Intent(getApplicationContext(), AnamneseActivity.class);
                startActivity(anamIntent);
            }
        });

        trainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trainIntent = new Intent(getApplicationContext(), TrainingActivity.class);
                startActivity(trainIntent);
            }
        });
    }
}
