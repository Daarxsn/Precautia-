package com.example.precautia;

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

public class DoctorDetailsActivity extends AppCompatActivity {
    private  String[][] doctor_details1 =
            {
                    {"Doctor Name : Ajit Saste","Hospital Name : Pimpri","Exp : 5 years","Mobile No. : 9898023764","600"},
                    {"Doctor Name : Prasad Pawar","Hospital Name : Nigdi","Exp : 15 years","Mobile No. : 6241973690","900"},
                    {"Doctor Name : Sarad kale","Hospital Name : Pune","Exp : 8 years","Mobile No. : 7251438290","300"},
                    {"Doctor Name : Deepak Deshmukh","Hospital Name : chinchwad","Exp : 6 years","Mobile No. : 9452661835","500"},
                    {"Doctor Name : Ashok Gaware","Hospital Name : Katraj","Exp : 7 years","Mobile No. : 9983612002","800"}
            };
    private  String[][] doctor_details2 =
            {
                    {"Doctor Name : Neelam Patil","Hospital Name : Pimpri","Exp : 5 years","Mobile No. : 9898023764","600"},
                    {"Doctor Name : Swati Pawar","Hospital Name : Nigdi","Exp : 15 years","Mobile No. : 6241973690","900"},
                    {"Doctor Name : neerja kale","Hospital Name : Pune","Exp : 8 years","Mobile No. : 7251438290","300"},
                    {"Doctor Name : Mayuri Deshmukh","Hospital Name : chinchwad","Exp : 6 years","Mobile No. : 9452661835","500"},
                    {"Doctor Name : Minakshi Gaware","Hospital Name : Katraj","Exp : 7 years","Mobile No. : 9983612002","800"}
            };
    private  String[][] doctor_details3 =
            {
                    {"Doctor Name : seema Patil","Hospital Name : Pimpri","Exp : 5 years","Mobile No. : 9898023764","600"},
                    {"Doctor Name : Pankaj Parab","Hospital Name : Nigdi","Exp : 15 years","Mobile No. : 6241973690","900"},
                    {"Doctor Name : Manish Jain","Hospital Name : Pune","Exp : 8 years","Mobile No. : 7251438290","300"},
                    {"Doctor Name : Vishal Deshmukh","Hospital Name : chinchwad","Exp : 6 years","Mobile No. : 9452661835","500"},
                    {"Doctor Name : Shrikant Sharma","Hospital Name : Katraj","Exp : 7 years","Mobile No. : 9983612002","800"}
            };
    private  String[][] doctor_details4 =
            {
                    {"Doctor Name : Anmol Gawade","Hospital Name : Pimpri","Exp : 5 years","Mobile No. : 9898023764","600"},
                    {"Doctor Name : Nisha tiwari","Hospital Name : Nigdi","Exp : 15 years","Mobile No. : 6241973690","900"},
                    {"Doctor Name : Vaibhav Singh","Hospital Name : Pune","Exp : 8 years","Mobile No. : 7251438290","300"},
                    {"Doctor Name : Naman Kumar","Hospital Name : chinchwad","Exp : 6 years","Mobile No. : 9452661835","500"},
                    {"Doctor Name : Ankul J Patel ","Hospital Name : Katraj","Exp : 7 years","Mobile No. : 9983612002","800"}
            };
    private  String[][] doctor_details5 =
            {
                    {"Doctor Name : Nilesh Borate","Hospital Name : Pimpri","Exp : 5 years","Mobile No. : 9898023764","600"},
                    {"Doctor Name : Pankaj Silvare","Hospital Name : Nigdi","Exp : 15 years","Mobile No. : 6241973690","900"},
                    {"Doctor Name : Vivek Lele","Hospital Name : Pune","Exp : 8 years","Mobile No. : 7251438290","300"},
                    {"Doctor Name : Rishi Kumar","Hospital Name : chinchwad","Exp : 6 years","Mobile No. : 9452661835","500"},
                    {"Doctor Name : Animesh Jain","Hospital Name : Katraj","Exp : 7 years","Mobile No. : 9983612002","800"}
            };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv= findViewById(R.id.textViewCartPackageName1);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physician")==0)
                doctor_details = doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
                doctor_details = doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view){
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
        }

    });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);

        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}

        );

        ListView list = findViewById(R.id.listViewDD);
        list.setAdapter(sa);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);


            }
        });




            }
        }

