package com.alliance.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class list extends AppCompatActivity {
    ListView mListView;
    String[] arrayOfString=null;
    String total="";
    ArrayAdapter<String> mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        String data=getIntent().getStringExtra("par1");
        int no=Integer.parseInt(data);
        mListView=findViewById(R.id.list_view);
        for(int i=1;i<=no;i++){
            total=total+"item "+i+",";
        }
        arrayOfString=total.split(",");
        mArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayOfString);
        mListView.setAdapter(mArrayAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                position++;
                Snackbar.make(findViewById(R.id.rel),"item "+position+" clicked!",Snackbar.LENGTH_SHORT).show();

            }
        });


    }
}
