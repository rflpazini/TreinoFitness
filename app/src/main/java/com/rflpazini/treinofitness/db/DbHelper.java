package com.rflpazini.treinofitness.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

    private final static String TAG = DbHelper.class.getSimpleName();

    public DbHelper(Context context) {
        super(context, DbInfo.DB_NAME, null, DbInfo.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableAval = "CREATE TABLE " + DbInfo.DbEntry.AVALIACOES_TABLE + "("+
                DbInfo.DbEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DbInfo.DbEntry.AVAL_PEITO + " TEXT NOT NULL, " +
                DbInfo.DbEntry.AVAL_OMBRO + " TEXT NOT NULL, " +
                DbInfo.DbEntry.AVAL_ALTURA + " TEXT NOT NULL, " +
                DbInfo.DbEntry.AVAL_PESO + " TEXT NOT NULL, " +
                DbInfo.DbEntry.AVAL_ANT_BRA_DIR + " TEXT NOT NULL, " +
                DbInfo.DbEntry.AVAL_ANT_BRA_ESQ + " TEXT NOT NULL, " +
                DbInfo.DbEntry.AVAL_BRA_DIR + " TEXT NOT NULL, " +
                DbInfo.DbEntry.AVAL_BRA_ESQ + " TEXT NOT NULL, " +
                DbInfo.DbEntry.AVAL_CINTURA + " TEXT NOT NULL, " +
                DbInfo.DbEntry.AVAL_COXA_DIR + " TEXT NOT NULL, " +
                DbInfo.DbEntry.AVAL_COXA_ESQ + " TEXT NOT NULL); ";

        String createTableAnam = "CREATE TABLE " + DbInfo.DbEntry.ANAMNESE_TABLE + "("+
                DbInfo.DbEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DbInfo.DbEntry.ANAM_HIPERT + " TEXT NOT NULL, " +
                DbInfo.DbEntry.ANAM_DIABETE + " TEXT NOT NULL, " +
                DbInfo.DbEntry.ANAM_ARTICU + " TEXT NOT NULL, " +
                DbInfo.DbEntry.ANAM_FUMA + " TEXT NOT NULL, " +
                DbInfo.DbEntry.ANAM_CARDIACO + " TEXT NOT NULL, " +
                DbInfo.DbEntry.ANAM_ESTRES + " TEXT NOT NULL, " +
                DbInfo.DbEntry.ANAM_MUSCULAR+ " TEXT NOT NULL); ";

        db.execSQL(createTableAval);
        db.execSQL(createTableAnam);

        Log.i(TAG, "DB CREATED...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DbInfo.DbEntry.AVALIACOES_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + DbInfo.DbEntry.ANAMNESE_TABLE);
        onCreate(db);
    }
}
