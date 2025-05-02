package com.example.precautia;

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

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] Packages =
            {
            {"Uprise-03 1800IU Capsule","","","","50"},
    {"HealthVit Chromium Picolinate 200mcg Capsule","","","", "385"},
    {"Vitamin B Complex Capsules", "", "", "", "448"},
    {"Inlife Vitamin E Wheat Germ Oil Capsule","","","","539"},
    {"Dolo 650 Tablet", "","","", "30"},
    {"Crocin 658 Advance Tablet", "", "58"},
        {"Strepsils Medicated Lozenges for Sore Throat","","","","40"},
        {"Tata ing Calcium Vitamin 03", "","","","30"},
        {"Feronia -XT Tablet","","","","130"},
    };

    private String[] Pakage_details = {
            "Building and keeping the bones & teeth strong\n" +
        "Reducing Fatigue/stress and muscular pains\n" +
        "Boosting immunity and increasing resistance against infection",
        " Chromius is an essential trace mineral that plays an important role in helping insulin regulate blood glucose.",
        " Provides relief from vitamin B deficiencies\n" +
        "Helps in formation of red blood cells\n" +
        "Maintains healthy nervous system", "It promotes health as well as skin benefit.\n" +
        "It helps reduce skin blemish and pigmentation.\n" +
        "It act as safeguard the skin from the harsh UVA and UVB sun rays.",
        "Dolo 650 Tablet helps relieve pain and fever by blocking the release of certain chemical messengers resposible or fever and pain.",
        "Helps relieve fever and bring down a high temperature\n" +
        "Suitable for people with a heart condition or high blood pressure",
        "Relieves the symptoms of a bacterial throat infection and soothes the recovery process\n" +
        "Provides a wars and comforting feeling during sore throat",
        "Reduces the risk of calcium deficiency, Rickets, and Osteoporosis\n" + "Promotes mobility and flexibility of joints",
        "Helps to reduce the iron deficiency due to chronic blood loss or low intake of iron"
            };

    HashMap<String,String> item;
    ArrayList list;
    ListView lst;
    Button btnback,btngotocart;
    SimpleAdapter sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

    lst = findViewById(R.id.listViewBM);
    btnback = findViewById(R.id.ButtonBMback);
    btngotocart = findViewById(R.id.ButtonBMgotocart);

    btngotocart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
        }
    });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0;i<Packages.length;i++) {
            item.put("line1", Packages[i][0]);
            item.put("line2", Packages[i][1]);
            item.put("line3", Packages[i][2]);
            item.put("line4", Packages[i][3]);
            item.put("line5", "Total Cost:" + Packages[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line1" , "line2" , "line3" , "line4" , "line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",Packages[i][0]);
                it.putExtra("text2",Pakage_details[i]);
                it.putExtra("text3",Packages[i][4]);
                startActivity(it);


            }
        });



    }
}