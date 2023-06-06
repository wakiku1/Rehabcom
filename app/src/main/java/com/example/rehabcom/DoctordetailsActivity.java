package com.example.rehabcom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctordetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Elvis Enock1", "Hospital Address : Kampala", "Experience : 3yrs", "Tel No: 0771231231", "4000"},
                    {"Doctor Name : Lutada Solyn1", "Hospital Address : Mukono", "Experience : 4yrs", "Tel No: 0772031231", "4000"},
                    {"Doctor Name : Pauline Peace1", "Hospital Address : Kitgum", "Experience : 6yrs", "Tel No: 0771230931", "4000"},
                    {"Doctor Name : Kayizzi Abdul1", "Hospital Address : Nakasongola", "Experience : 20yrs", "Tel No: 07712871231", "6000"},
                    {"Doctor Name : Lisa Enid1", "Hospital Address : Butaleja", "Experience : 25yrs", "Tel No: 0771431231", "10000"}
            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Elvis Enock2", "Hospital Address : Kampala", "Experience : 3yrs", "Tel No: 0771231231", "4000"},
                    {"Doctor Name : Lutada Solyn2", "Hospital Address : Mukono", "Experience : 4yrs", "Tel No: 0772031231", "4000"},
                    {"Doctor Name : Pauline Peace2", "Hospital Address : Kitgum", "Experience : 6yrs", "Tel No: 0771230931", "4000"},
                    {"Doctor Name : Kayizzi Abdul2", "Hospital Address : Nakasongola", "Experience : 20yrs", "Tel No: 07712871231", "6000"},
                    {"Doctor Name : Lisa Enid2", "Hospital Address : Butaleja", "Experience : 25yrs", "Tel No: 0771431231", "10000"}
            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Elvis Enock3", "Hospital Address : Kampala", "Experience : 3yrs", "Tel No: 0771231231", "4000"},
                    {"Doctor Name : Lutada Solyn3", "Hospital Address : Mukono", "Experience : 4yrs", "Tel No: 0772031231", "4000"},
                    {"Doctor Name : Pauline Peace3", "Hospital Address : Kitgum", "Experience : 6yrs", "Tel No: 0771230931", "4000"},
                    {"Doctor Name : Kayizzi Abdul3", "Hospital Address : Nakasongola", "Experience : 20yrs", "Tel No: 07712871231", "6000"},
                    {"Doctor Name : Lisa Enid3", "Hospital Address : Butaleja", "Experience : 25yrs", "Tel No: 0771431231", "10000"}
            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Elvis Enock4", "Hospital Address : Kampala", "Experience : 3yrs", "Tel No: 0771231231", "4000"},
                    {"Doctor Name : Lutada Solyn4", "Hospital Address : Mukono", "Experience : 4yrs", "Tel No: 0772031231", "4000"},
                    {"Doctor Name : Pauline Peace4", "Hospital Address : Kitgum", "Experience : 6yrs", "Tel No: 0771230931", "4000"},
                    {"Doctor Name : Kayizzi Abdul4", "Hospital Address : Nakasongola", "Experience : 20yrs", "Tel No: 07712871231", "6000"},
                    {"Doctor Name : Lisa Enid4", "Hospital Address : Butaleja", "Experience : 25yrs", "Tel No: 0771431231", "10000"}
            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Elvis Enock5", "Hospital Address : Kampala", "Experience : 3yrs", "Tel No: 0771231231", "4000"},
                    {"Doctor Name : Lutada Solyn5", "Hospital Address : Mukono", "Experience : 4yrs", "Tel No: 0772031231", "4000"},
                    {"Doctor Name : Pauline Peace5", "Hospital Address : Kitgum", "Experience : 6yrs", "Tel No: 0771230931", "4000"},
                    {"Doctor Name : Kayizzi Abdul5", "Hospital Address : Nakasongola", "Experience : 20yrs", "Tel No: 07712871231", "6000"},
                    {"Doctor Name : Lisa Enid5", "Hospital Address : Butaleja", "Experience : 25yrs", "Tel No: 0771431231", "10000"}
            };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctordetails);

        tv = findViewById(R.id.textViewCartPackageName);
        btn = findViewById(R.id.buttonBMBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Physicians") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Dieticians") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Audiologists") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeons") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctordetailsActivity.this, DoctorActivity.class));

            }
        });

        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees" + doctor_details[i][4] + "/=");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "Line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.editTextLDTextMultiLine);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctordetailsActivity.this, BookAppointmentActivity2.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}