package com.example.mohsin.customlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Zenab", "Anchal", "Tushar", "Dhruv", "Jagdish"};
    String ages[] = {"21", "21", "22", "22", "21"};
    String genders[] = {"female", "female", "male", "male", "male"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);


        MyAdapter adapter = new MyAdapter(this, mTitle, ages, genders);
        listView.setAdapter(adapter);

    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rGenders[];
        String rAges[];

        MyAdapter (Context c, String title[], String ages[], String genders[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rAges = ages;
            this.rGenders = genders;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView ages = row.findViewById(R.id.ages);
            TextView genders = row.findViewById(R.id.genders);


            // now set our resources on views
            myTitle.setText(rTitle[position]);
            ages.setText(rAges[position]);
            genders.setText(rGenders[position]);




            return row;
        }
    }
}
