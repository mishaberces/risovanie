package home.misha.risowanie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    int[][] urok_res=new int[20][20];
    ImageView imageView;
    int urok_n=1, krok=0;
    Button but1,but2;
    TextView textView;
    urok Urok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        Urok=(urok)getIntent().getParcelableExtra("urok");
        textView=(TextView)findViewById(R.id.textView_test);
        urok_n=Urok.getNomer();
        ArrayList<Krok> ur1_k=Urok.getList_krok();
        textView.setText(Urok.getName()+" krok="+krok);

        int k=0;
        for (Krok tmp_res: ur1_k ) {

            urok_res[urok_n][k]=tmp_res.getID_res();
            k++;
        }

        imageView=(ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(urok_res[urok_n][krok]);
        but1=(Button)findViewById(R.id.btn);
        but2=(Button)findViewById(R.id.btn1);
        if (urok_res[urok_n][krok]==R.drawable.u00) {but2.setEnabled(false);}

    }



    public void onclick1(View view) {
        switch (view.getId()){
            case R.id.btn:  {
                krok--;
                but2.setEnabled(true);
                if(krok==0) but1.setEnabled(false);
                imageView.setImageResource(urok_res[urok_n][krok]);
                break;}
            case R.id.btn1: {
                krok++;
                but1.setEnabled(true);
                if (urok_res[urok_n][krok+1]==0) but2.setEnabled(false);
                imageView.setImageResource(urok_res[urok_n][krok]);
                break;}

        }

        textView.setText(Urok.getName()+" krok="+krok);

    }


}

