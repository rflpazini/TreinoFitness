package com.rflpazini.treinofitness.physical;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rflpazini.treinofitness.R;
import com.rflpazini.treinofitness.db.DbFunctions;
import com.rflpazini.treinofitness.db.DbInfo;


public class AddPhysicalAvalActivity extends AppCompatActivity {

    private Button btnAdd;
    private EditText peito;
    private EditText ombro;
    private EditText cintura;
    private EditText bracoDir;
    private EditText bracoEsq;
    private EditText anteDir;
    private EditText anteEsq;
    private EditText peso;
    private EditText altura;
    private EditText coxaDir;
    private EditText coxaEsq;

    public static final String EXTRA_POSITION = "position";

    private DbFunctions func;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_physical_aval);

        peito = (EditText) findViewById(R.id.peitoAdd);
        ombro = (EditText) findViewById(R.id.ombroAdd);
        cintura = (EditText) findViewById(R.id.cinturaAdd);
        bracoDir = (EditText) findViewById(R.id.bracoDirAdd);
        bracoEsq = (EditText) findViewById(R.id.bracoEsqAdd);
        anteDir = (EditText) findViewById(R.id.AntBracoDirAdd);
        anteEsq = (EditText) findViewById(R.id.AntBracoEsqAdd);
        peso = (EditText) findViewById(R.id.pesoAdd);
        altura = (EditText) findViewById(R.id.alturaAdd);
        coxaDir = (EditText) findViewById(R.id.coxaDirAdd);
        coxaEsq = (EditText) findViewById(R.id.coxaEsqAdd);
        btnAdd = (Button) findViewById(R.id.buttonAdd);

        func = new DbFunctions(getApplicationContext());

        addListeners();

        int position = getIntent().getIntExtra(EXTRA_POSITION, 0);

        if (position > 0) {
            Cursor rs = func.getDataAval(position);
            rs.moveToFirst();

            String peitoString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.AVAL_PEITO));
            String ombroString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.AVAL_OMBRO));
            String cinturaString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.AVAL_CINTURA));
            String bracoDirString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.AVAL_BRA_DIR));
            String bracoEsqString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.AVAL_BRA_ESQ));
            String anteDirString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.AVAL_ANT_BRA_DIR));
            String anteEsqString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.AVAL_ANT_BRA_ESQ));
            String pesoString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.AVAL_PESO));
            String alturaString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.AVAL_ALTURA));
            String coxaDirString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.AVAL_COXA_DIR));
            String coxaEsqString = rs.getString(rs.getColumnIndex(DbInfo.DbEntry.AVAL_COXA_ESQ));

            if (!rs.isClosed()) {
                rs.close();
            }

            peito.setText((CharSequence) peitoString);
            peito.setFocusable(false);
            peito.setClickable(false);

            ombro.setText((CharSequence) ombroString);
            ombro.setFocusable(false);
            ombro.setClickable(false);

            cintura.setText((CharSequence) cinturaString);
            cintura.setFocusable(false);
            cintura.setClickable(false);

            bracoDir.setText((CharSequence) bracoDirString);
            bracoDir.setFocusable(false);
            bracoDir.setClickable(false);

            bracoEsq.setText((CharSequence) bracoEsqString);
            bracoEsq.setFocusable(false);
            bracoEsq.setClickable(false);

            anteDir.setText((CharSequence) anteDirString);
            anteDir.setFocusable(false);
            anteDir.setClickable(false);

            anteEsq.setText((CharSequence) anteEsqString);
            anteEsq.setFocusable(false);
            anteEsq.setClickable(false);

            peso.setText((CharSequence) pesoString);
            peso.setFocusable(false);
            peso.setClickable(false);

            altura.setText((CharSequence) alturaString);
            altura.setFocusable(false);
            altura.setClickable(false);

            coxaDir.setText((CharSequence) coxaDirString);
            coxaDir.setFocusable(false);
            coxaDir.setClickable(false);

            coxaEsq.setText((CharSequence) coxaEsqString);
            coxaEsq.setFocusable(false);
            coxaEsq.setClickable(false);

            btnAdd.setVisibility(View.INVISIBLE);
        }
    }

    private void addListeners() {
        final PhysicalAval phyAval = new PhysicalAval();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phyAval.setPeito(peito.getText().toString());
                phyAval.setOmbro(ombro.getText().toString());
                phyAval.setCintura(cintura.getText().toString());
                phyAval.setBracoDir(bracoDir.getText().toString());
                phyAval.setBracoEsq(bracoEsq.getText().toString());
                phyAval.setAnteDir(anteDir.getText().toString());
                phyAval.setAnteEsq(anteEsq.getText().toString());
                phyAval.setCoxaDir(coxaDir.getText().toString());
                phyAval.setCoxaEsp(coxaEsq.getText().toString());
                phyAval.setAlt(altura.getText().toString());
                phyAval.setPeso(peso.getText().toString());


                func.addPhysicalActivity(phyAval);

                Intent backIntent = new Intent(getApplicationContext(), PhysicalActivity.class);
                startActivity(backIntent);

                finish();
            }
        });
    }
}
