package com.example.rehabcom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthArticlesActivity extends AppCompatActivity {

    private final String[][] health_details =
            {
                    { "Walking Daily","","","","Click More Details"},
                    { "Home Care of COVID-19","","","","Click More Details"},
                    { "Stop Smoking","","","","Click More Details"},
                    { "Menstrual Cramps","","","","Click More Details"},
                    { "Healthy Gut","","","","Click More Details"},
            };
    private final int[] images = {
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4,
            R.drawable.health5,
    };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;

    Button btnBack;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles);

        lst = findViewById(R.id.listviewOD);
        btnBack = findViewById(R.id.buttonODBack);

        btnBack.setOnClickListener(view -> startActivity(new Intent(HealthArticlesActivity.this, HomeActivity.class)));

        list = new ArrayList<HashMap<String, String>>();
        for (String[] health_detail : health_details) {
            item = new HashMap<>();
            item.put("line 1", health_detail[0]);
            item.put("line 2", health_detail[1]);
            item.put("line 3", health_detail[2]);
            item.put("line 4", health_detail[3]);
            item.put("line 5", health_detail[4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line1", "line2", "line3", "Line4", "line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        lst.setAdapter(sa);

        lst.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent it = new Intent(HealthArticlesActivity.this, HealthArticlesDetailsActivity.class);
            it.putExtra("text1", health_details[i][0]);
            it.putExtra("text2", images[i]);
            startActivity(it);
        });
    }
}



