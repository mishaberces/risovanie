package home.misha.risowanie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    final String[] name_urok={"Урок 1", "Урок 2", "Урок 3"};

    final int[][] krok_urok={
            {R.drawable.u1k1, R.drawable.u1k2, R.drawable.u1k3, R.drawable.u1k4},
            {R.drawable.u2k1, R.drawable.u2k2, R.drawable.u2k3},
            {R.drawable.u00}};

    final String[] name_krok_ur1={"Крок 1", "Крок 2", "Крок 3", "Крок 4"};

    ListView listView;

    ArrayList<urok> list_urok=new ArrayList<urok>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listView);



        Krok krok;
        ArrayList<Krok> list_k;
        int k=0;

        for (String tmp_name_urok : name_urok ) {
            list_k=new ArrayList<Krok>();
            urok ur=new urok(tmp_name_urok,k);
            for (int j=0; j<krok_urok[k].length; j++){
                krok=new Krok(name_krok_ur1[j], krok_urok[k][j] );
                list_k.add(krok);
            }

            ur.setKrokList(list_k);
            list_urok.add(ur);

           k++;
        }


         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, name_urok);

        listView.setAdapter(adapter);



     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Intent intent = new Intent(MainActivity.this, Main2Activity.class);
              intent.putExtra("urok", list_urok.get(position));
              startActivity(intent);
          }
      });




    }




}
