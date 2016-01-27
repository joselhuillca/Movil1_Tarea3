package com.example.jose.eduticnow;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String cWhite = "#FFFFFFFF";
    String cMagenta = "#FF36BDC5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //REMOVE TITLE AND FULLSCREEN enable
        this.getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Relative Layout General
        RelativeLayout rlayoutG = new RelativeLayout(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        rlayoutG.setLayoutParams(params);
        rlayoutG.setBackgroundResource(R.drawable.afondo);
        rlayoutG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goActitityLogin();
            }
        });

        //LinearLayout General
        LinearLayout layoutLG = new LinearLayout(this);
        LinearLayout.LayoutParams paramsL = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutLG.setLayoutParams(paramsL);
        layoutLG.setOrientation(LinearLayout.VERTICAL);
        layoutLG.setGravity(Gravity.CENTER_VERTICAL);

        LinearLayout.LayoutParams paramsLY = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        //Fill Array of Linear Layout
        LinearLayout[] layoutList = new LinearLayout[4];
        for(int i=0; i<layoutList.length; i++){
            LinearLayout layoutTmp = new LinearLayout(this);
            layoutTmp.setOrientation(LinearLayout.HORIZONTAL);
            layoutTmp.setLayoutParams(paramsLY);
            layoutTmp.setGravity(Gravity.CENTER_HORIZONTAL);
            layoutList[i] = layoutTmp;
        }
        //Fill Array Text View
        TextView[] textList = new TextView[8];
        for(int i=0; i<textList.length; i++){
            TextView textTmp = new TextView(this);
            textTmp.setTextColor(Color.parseColor(cWhite));
            textTmp.setTextSize(dptopx(20));
            textList[i] = textTmp;
        }

        //String fp = "fonts/HelveticalNeue.ttf";
        //Typeface tf = Typeface.createFromAsset(getAssets(),fp);
        //SET TEXTLIST EDUTIC NOW
        textList[0].setText("EDUTIC ");
        //textList[0].setTypeface(tf);
        textList[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goActitityLogin();
            }
        });
        textList[0].setTypeface(textList[0].getTypeface(), Typeface.BOLD);
        textList[0].setTextSize(40);
        textList[1].setText("NOW ");
        textList[1].setTextSize(40);
        layoutList[0].setPadding(0, 0, 0, dptopx(30));

        //SET CONNECT CLASSMATES
        textList[2].setText("Connect ");
        textList[2].setTextColor(Color.parseColor(cMagenta));
        textList[3].setText("with your classmates ");

        //SET HELP HOMEWROK
        textList[4].setText("Get help ");
        textList[4].setTextColor(Color.parseColor(cMagenta));
        textList[5].setText("on homework ");

        //SET GRACES REAL
        textList[6].setText("Get better graces ");
        textList[6].setTextColor(Color.parseColor(cMagenta));
        textList[7].setText("for real ");

        //FILL LIST LAYOUT
        for (int i=0,cont=0;i<layoutList.length;i++){
            int tmp = cont;
            for (;cont<tmp+2;cont++){
                layoutList[i].addView(textList[cont]);
            }
            layoutLG.addView(layoutList[i]);
        }

        //FIN Global RLayout
        rlayoutG.addView(layoutLG);

        setContentView(rlayoutG);
    }

    //Convert dp to pixel
    public int dptopx(int dp){
        DisplayMetrics displayMetrics = getBaseContext().getResources().getDisplayMetrics();
        int px = Math.round(dp * displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT);
        return  px;
    }

    //Go to other activity : ActivityIniciarSesion
    public void goActitityLogin(){
        /*Toast mss = Toast.makeText(getApplicationContext(),"Hola mundo",Toast.LENGTH_LONG);
        mss.show();*/
        Intent myIntent = new Intent(MainActivity.this, ActivityIniciarSesion.class);
        MainActivity.this.startActivity(myIntent);
    }
}
