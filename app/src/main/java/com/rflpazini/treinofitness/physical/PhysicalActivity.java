package com.rflpazini.treinofitness.physical;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.rflpazini.treinofitness.R;
import com.rflpazini.treinofitness.db.DbHelper;
import com.rflpazini.treinofitness.db.DbInfo;
import com.rflpazini.treinofitness.physical.AddPhysicalAvalActivity;

import java.util.ArrayList;

public class PhysicalActivity extends AppCompatActivity {

    private  ListView listView;
    private ArrayList<String> items;
    private ArrayList<String> subItems;
    private ArrayAdapter<String> itemsAdapter;

    private final static String TAG = PhysicalActivity.class.getSimpleName();

    protected static DbHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.listItems);

        mHelper = new DbHelper(getApplicationContext());

        updateList();
        addListeners();

        final Intent addNew = new Intent(this, AddPhysicalAvalActivity.class);

        Button button = (Button) findViewById(R.id.button_graph);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PhysicalGraphActivity.class);
                startActivity(intent);

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(addNew);
                finish();
            }
        });
    }

    public static void startAlert(Context context, String msg, String title) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(msg)
                .setTitle(title)
                .setPositiveButton("Adicionar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                dialog.dismiss();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void updateList() {
        items = new ArrayList<String>();

        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(DbInfo.DbEntry.AVALIACOES_TABLE,
                new String[]{DbInfo.DbEntry._ID}, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int index = cursor.getColumnIndex(DbInfo.DbEntry._ID);
            items.add(cursor.getString(index)+"ª Avaliação");
        }

        if (itemsAdapter == null) {
            itemsAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items);
            listView.setAdapter(itemsAdapter);
        } else {
            itemsAdapter.clear();
            itemsAdapter.addAll(items);
            itemsAdapter.notifyDataSetChanged();
        }

        cursor.close();
        db.close();
    }

    public void addListeners() {
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View item, int position, long id) {
                        Context ct = item.getContext();
                        Intent intent = new Intent(ct, AddPhysicalAvalActivity.class);
                        intent.putExtra(AddPhysicalAvalActivity.EXTRA_POSITION, position);
                        ct.startActivity(intent);
                    }
                }
        );
    }

}
