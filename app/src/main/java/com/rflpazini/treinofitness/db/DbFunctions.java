package com.rflpazini.treinofitness.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.rflpazini.treinofitness.anamnese.AnamneseInfo;
import com.rflpazini.treinofitness.physical.PhysicalActivity;
import com.rflpazini.treinofitness.physical.PhysicalAval;

import java.util.ArrayList;

public class DbFunctions {
    private  ListView listView;
    private ArrayList<String> items;
    private ArrayList<String> subItems;
    private ArrayAdapter<String> itemsAdapter;

    private final static String TAG = DbFunctions.class.getSimpleName();

    protected DbHelper mHelper;

    public DbFunctions(Context context) {
        mHelper = new DbHelper(context);
    }

    public void addPhysicalActivity(PhysicalAval physicalAval) {
        Log.i(TAG, "addPhysicalActivity");

        SQLiteDatabase db = mHelper.getWritableDatabase();
        ContentValues physicalValues = new ContentValues();
        physicalValues.put(DbInfo.DbEntry.AVAL_PEITO, physicalAval.getPeito().toString());
        physicalValues.put(DbInfo.DbEntry.AVAL_ALTURA, physicalAval.getAlt().toString());
        physicalValues.put(DbInfo.DbEntry.AVAL_OMBRO, physicalAval.getOmbro().toString());
        physicalValues.put(DbInfo.DbEntry.AVAL_CINTURA, physicalAval.getCintura().toString());
        physicalValues.put(DbInfo.DbEntry.AVAL_BRA_DIR, physicalAval.getBracoDir().toString());
        physicalValues.put(DbInfo.DbEntry.AVAL_BRA_ESQ, physicalAval.getBracoEsq().toString());
        physicalValues.put(DbInfo.DbEntry.AVAL_ANT_BRA_DIR, physicalAval.getAnteDir().toString());
        physicalValues.put(DbInfo.DbEntry.AVAL_ANT_BRA_ESQ, physicalAval.getAnteEsq().toString());
        physicalValues.put(DbInfo.DbEntry.AVAL_COXA_DIR, physicalAval.getCoxaDir().toString());
        physicalValues.put(DbInfo.DbEntry.AVAL_COXA_ESQ, physicalAval.getCoxaEsp().toString());
        physicalValues.put(DbInfo.DbEntry.AVAL_PESO, physicalAval.getPeso().toString());

        db.insertWithOnConflict(DbInfo.DbEntry.AVALIACOES_TABLE, null, physicalValues, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public void addAnamnese(AnamneseInfo info) {
        Log.i(TAG, "addAnamnese");

        SQLiteDatabase db = mHelper.getWritableDatabase();
        ContentValues anamValues = new ContentValues();
        anamValues.put(DbInfo.DbEntry.ANAM_HIPERT, info.getHipertensao().toString());
        anamValues.put(DbInfo.DbEntry.ANAM_DIABETE, info.getDiabete().toString());
        anamValues.put(DbInfo.DbEntry.ANAM_ARTICU, info.getArticulacao().toString());
        anamValues.put(DbInfo.DbEntry.ANAM_FUMA, info.getFuma().toString());
        anamValues.put(DbInfo.DbEntry.ANAM_ESTRES, info.getEstresse().toString());
        anamValues.put(DbInfo.DbEntry.ANAM_CARDIACO, info.getCardiaco().toString());
        anamValues.put(DbInfo.DbEntry.ANAM_MUSCULAR, info.getMuscular().toString());

        db.insertWithOnConflict(DbInfo.DbEntry.ANAMNESE_TABLE, null, anamValues, SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
    }

    public Cursor getDataAval(int position) {
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM " +
                DbInfo.DbEntry.AVALIACOES_TABLE + " WHERE " +
                DbInfo.DbEntry._ID+ "="+position+"", null);
        return res;
    }

    public Cursor getDataAnam(int position) {
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " +
                DbInfo.DbEntry.ANAMNESE_TABLE + " WHERE " +
                DbInfo.DbEntry._ID+ "="+position+"", null);
        return cursor;
    }
}
