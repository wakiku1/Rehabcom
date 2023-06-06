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

public class LabTestActivity extends AppCompatActivity {

    private String [][] packages =
            {
                    { "Package 1 :  Functional Movement Screen (FMS):", "", "", "","999" },
                    { "Package 2 :  Range of Motion (ROM)", "", "", "","965" },
                    { "Package 3 :  Manual Muscle Testing (MMT)", "", "", "","954" },
                    { "Package 4 :  Balance and Postural Stability Assessments", "", "", "","943" },
            };

    private String[] packages_details = {
            "fdssdsss/n"+
                    "fdssdsss/n" +
                    "fdssdsss/n"+
                    "fdssdsss/n"+
                    "fdssdsss/n"+
                    "fdssdsss/n"+
                    "fdssdsss/n",
            "fdssdsss/n",
            "fdssdsss/n",
            "fdssdsss/n" +
                    "fdssdsss/n"+
                    "fdssdsss/n"+
                    "fdssdsss/n"+
                    "fdssdsss/n"+
                    "fdssdsss/n"+
                    "fdssdssd"
            };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoTOCart,btnBack;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoTOCart = findViewById(R.id.buttonBMGoToCart);
        btnBack = findViewById(R.id.buttonBMBack);
        listView = findViewById(R.id.listviewBM);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Cons Fees" + packages[i][4] + "/=");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "Line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.listviewBM);
        listView.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", packages[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
        btnGoTOCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));

            }
        });
    }
}