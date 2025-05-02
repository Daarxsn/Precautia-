package com.example.precautia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeRemediesActivity extends AppCompatActivity {

    private String[][] packages = {
        {"Ginger: May help with stomachaches, diarrhea, nausea, and menstrual cramps"},
        {"Green tea: May lower your odds of heart disease and certain kinds of cancers"},
        {"Garlic: May lower blood cholesterol and blood pressure levels"},
        {"Chicken soup: May ease cold symptoms and help you get rid of it sooner"},
        {"Neti pot: May ease allergy or cold symptoms"},
        {"Turmeric: May help with pain and inflammation"},
        {"Chili peppers: May help with pain and soreness"},
        {"Fenugreek: May help with breastfeeding"},
            {"Magnesium-rich foods: May help with everything"},
            {"Pomegranate juice: May help with heart health"},
            {"Watermelon juice: May help with headaches"},
            {"Honey and ginger juice: May help with coughs"},
            {"Tomatoes, lemon juice, gram flour, and turmeric powder: May help with dark circles"},
            {"Eucalyptus products: May help subdue coughs and reduce mucus"}
    };

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_remedies);

        btnback = findViewById(R.id.buttonHomeback);
        lst = findViewById(R.id.listViewHome);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeRemediesActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", packages[i][4]);
            item.put("line6", packages[i][5]);
            item.put("line7", packages[i][6]);
            item.put("line8", packages[i][7]);
            item.put("line9", packages[i][8]);
            item.put("line10", packages[i][9]);
            item.put("line11", packages[i][10]);
            item.put("line12", packages[i][11]);
            item.put("line13", packages[i][12]);
            item.put("line14", packages[i][13]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines1,
                new String[]{"line1", "line2", "line3", "line4", "line5","line6","line7","line8","line9","line10","line11","line12","line13","line14"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e,R.id.line_f,R.id.line_g,R.id.line_h,R.id.line_i,R.id.line_j,R.id.line_k,R.id.line_l,R.id.line_m,R.id.line_n});
        lst.setAdapter(sa);

    }
}