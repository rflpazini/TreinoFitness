package com.rflpazini.treinofitness.training;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rflpazini.treinofitness.R;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
       // collapsingToolbar.setTitle(user.getName());

        final int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Log.i("POSITION", String.valueOf(postion));
        Resources resources = getResources();
        String[] places = resources.getStringArray(R.array.exer);
        collapsingToolbar.setTitle(places[postion % places.length]);

        final int permissionCheck = ContextCompat.checkSelfPermission(DetailActivity.this,
                Manifest.permission.CALL_PHONE);

        String[] exerDetails = resources.getStringArray(R.array.exer_details);
        TextView placeDetail = (TextView) findViewById(R.id.ex_detail);
        placeDetail.setText(exerDetails[postion % exerDetails.length]);

        placeDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TrainingExerciseActivity.class);
                intent.putExtra(TrainingExerciseActivity.EXTRA_PAGE, postion);
                startActivity(intent);
            }
        });

        String[] exerDesc = resources.getStringArray(R.array.exer_desc);
        TextView placeLocation =  (TextView) findViewById(R.id.exer_detail);
        placeLocation.setText(exerDesc[postion % exerDesc.length]);

        TypedArray exerPictures = resources.obtainTypedArray(R.array.exer_picture);
        ImageView placePicutre = (ImageView) findViewById(R.id.image);
        placePicutre.setImageDrawable(exerPictures.getDrawable(postion % exerPictures.length()));
        exerPictures.recycle();
    }
}
