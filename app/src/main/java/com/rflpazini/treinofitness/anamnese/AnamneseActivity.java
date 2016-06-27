package com.rflpazini.treinofitness.anamnese;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rflpazini.treinofitness.R;
import com.rflpazini.treinofitness.db.DbFunctions;
import com.rflpazini.treinofitness.db.DbInfo;

public class AnamneseActivity extends AppCompatActivity {

    private Button confButton;

    private EditText hipertensao;
    private EditText diabete;
    private EditText articulacao;
    private EditText fuma;
    private EditText estresse;
    private EditText cardiaco;
    private EditText muscular;

    private DbFunctions func;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anamnese);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        hipertensao = (EditText) findViewById(R.id.hiperAna);
        diabete = (EditText) findViewById(R.id.diabeteAna);
        articulacao = (EditText) findViewById(R.id.artculacaoAna);
        fuma = (EditText) findViewById(R.id.fumaAna);
        estresse = (EditText) findViewById(R.id.estresseAna);
        cardiaco = (EditText) findViewById(R.id.cardioAna);
        muscular = (EditText) findViewById(R.id.musculoAna);
        confButton = (Button) findViewById(R.id.buttonAnamConfirmar);

        func = new DbFunctions(getApplicationContext());

        addListenersAnam();

        Cursor rs = func.getDataAnam(1);

        if (rs.moveToFirst()) {
            String hipertensaoString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.ANAM_HIPERT));
            String diabeteString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.ANAM_DIABETE));
            String articulacaoString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.ANAM_ARTICU));
            String fumaString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.ANAM_FUMA));
            String estresseString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.ANAM_ESTRES));
            String cardiacoString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.ANAM_CARDIACO));
            String muscularString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.ANAM_MUSCULAR));

            if (!rs.isClosed()) {
                rs.close();
            }

            hipertensao.setText((CharSequence) hipertensaoString);
            hipertensao.setFocusable(false);
            hipertensao.setClickable(false);

            diabete.setText((CharSequence) diabeteString);
            diabete.setFocusable(false);
            diabete.setClickable(false);

            articulacao.setText((CharSequence) articulacaoString);
            articulacao.setFocusable(false);
            articulacao.setClickable(false);

            fuma.setText((CharSequence) fumaString);
            fuma.setFocusable(false);
            fuma.setClickable(false);

            estresse.setText((CharSequence) estresseString);
            estresse.setFocusable(false);
            estresse.setClickable(false);

            cardiaco.setText((CharSequence) cardiacoString);
            cardiaco.setFocusable(false);
            cardiaco.setClickable(false);

            muscular.setText((CharSequence) muscularString);
            muscular.setFocusable(false);
            muscular.setClickable(false);

            confButton.setVisibility(View.INVISIBLE);
        }
    }

    public void addListenersAnam() {
        final AnamneseInfo info = new AnamneseInfo();

        confButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setHipertensao(hipertensao.getText().toString());
                info.setDiabete(diabete.getText().toString());
                info.setArticulacao(articulacao.getText().toString());
                info.setFuma(fuma.getText().toString());
                info.setEstresse(estresse.getText().toString());
                info.setCardiaco(cardiaco.getText().toString());
                info.setMuscular(muscular.getText().toString());

                DbFunctions func = new DbFunctions(getApplicationContext());
                func.addAnamnese(info);

                finish();
            }
        });
    }
}
