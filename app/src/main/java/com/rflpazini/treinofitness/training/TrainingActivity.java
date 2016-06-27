package com.rflpazini.treinofitness.training;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.rflpazini.treinofitness.R;

import java.util.ArrayList;

public class TrainingActivity extends AppCompatActivity {

    private  ListView listView;
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        listView = (ListView) findViewById(R.id.listItemsTraining);

        updateTrainings();
        setListener();
    }

    public void updateTrainings() {
        items = new ArrayList<String>();
        addTraings();

        if (itemsAdapter == null) {
            itemsAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items);
            listView.setAdapter(itemsAdapter);
        } else {
            itemsAdapter.clear();
            itemsAdapter.addAll(items);
            itemsAdapter.notifyDataSetChanged();
        }
    }

    public void addTraings() {
        items.add("Peito");
        items.add("Braços");
        items.add("Pernas");
        items.add("Costas");
    }

    public void setListener() {
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View item, int position, long id) {
                        Context ct = item.getContext();
                        Intent intent = new Intent(ct, DetailActivity.class);
                        intent.putExtra(DetailActivity.EXTRA_POSITION, position);
                        ct.startActivity(intent);
                    }
                }
        );
    }
}
