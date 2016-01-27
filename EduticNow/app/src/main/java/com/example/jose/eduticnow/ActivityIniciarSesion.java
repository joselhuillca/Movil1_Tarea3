package com.example.jose.eduticnow;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityIniciarSesion extends AppCompatActivity {

    String cWhite = "#FFFFFFFF";
    String cMagenta = "#FF36BDC5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_activity_iniciar_sesion);

        //REMOVE TITLE AND FULLSCREEN enable
        this.getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Relative Layout General
        RelativeLayout rlayoutG = new RelativeLayout(this);
        rlayoutG.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        rlayoutG.setBackgroundResource(R.drawable.afondo);

        //Linear Layout General
        LinearLayout layoutLG = new LinearLayout(this);
        layoutLG.setOrientation(LinearLayout.VERTICAL);
        layoutLG.setPadding(dptopx(35),dptopx(600),dptopx(35),dptopx(40));
        layoutLG.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));

        //Fill List Linear Layout
        final LinearLayout[] listLayout = new LinearLayout[4];
        for (int i = 0;i<listLayout.length;i++){
            LinearLayout layoutTmp = new LinearLayout(this);
            layoutTmp.setOrientation(LinearLayout.VERTICAL);
            layoutTmp.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            listLayout[i] = layoutTmp;
        }

        //Text View Iniciar Sesión
        final TextView textIS = new TextView(this);
        textIS.setText("Iniciar Sesión");
        textIS.setTextColor(Color.WHITE);
        textIS.setTextSize(22);
        listLayout[0].setPadding(0,0,0,dptopx(20));
        listLayout[0].addView(textIS);
        layoutLG.addView(listLayout[0]);

        //Fill List Edit Text
        final EditText[] listEdtitText = new EditText[2];
        for (int i=0; i<listEdtitText.length; i++){
            EditText editTmp = new EditText(this);
            editTmp.setPadding(dptopx(20), dptopx(10), 0, dptopx(10));
            editTmp.setGravity(Gravity.CENTER_VERTICAL);
            editTmp.setSingleLine();
            editTmp.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            editTmp.setBackgroundColor(Color.parseColor("#E0E0E0"));
            editTmp.getBackground().setAlpha(40);
            editTmp.setTextSize(20);
            editTmp.setTextColor(Color.parseColor("#BDBDBD"));
            editTmp.setHintTextColor(Color.parseColor("#BDBDBD"));
            listEdtitText[i] = editTmp;
        }

        //Edit Text User Name
        listEdtitText[0].setHint("Usuario");
        listLayout[1].setPadding(0, 0, 0, dptopx(10));
        listLayout[1].addView(listEdtitText[0]);
        layoutLG.addView(listLayout[1]);
        //Edit Text Password
        listEdtitText[1].setHint("Contraseña");
        listEdtitText[1].setTransformationMethod(PasswordTransformationMethod.getInstance());
        listLayout[2].setPadding(0, 0, 0, dptopx(35));
        listLayout[2].addView(listEdtitText[1]);
        layoutLG.addView(listLayout[2]);

        //Linear Layout Login
        LinearLayout layoutLogin = new LinearLayout(this);
        layoutLogin.setOrientation(LinearLayout.HORIZONTAL);
        layoutLogin.setWeightSum(10);
        layoutLogin.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        final Button btnLogin = new Button(this);
        btnLogin.setText("LOGIN");
        btnLogin.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 5));
        btnLogin.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        btnLogin.setBackgroundColor(Color.parseColor("#00B8D4"));
        btnLogin.setTextSize(24);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goActitityNavigator(listEdtitText[0]);
            }
        });
        btnLogin.setTextColor(Color.WHITE);
        layoutLogin.addView(btnLogin);

        //Linear Layout Vertical Login-Forgot
        final LinearLayout layoutLForgot = new LinearLayout(this);
        layoutLForgot.setOrientation(LinearLayout.VERTICAL);
        layoutLForgot.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 5));

        final TextView textForgot = new TextView(this);
        textForgot.setText("FORGOT PASSWORD?");
        textForgot.setTextSize(20);
        textForgot.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        textForgot.setTextColor(Color.WHITE);
        layoutLForgot.addView(textForgot);

        final TextView textChange = new TextView(this);
        textChange.setText("CHANGE");
        textChange.setTextSize(20);
        textChange.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        textChange.setTextColor(Color.parseColor("#00B8D4"));
        layoutLForgot.addView(textChange);

        layoutLogin.addView(layoutLForgot);

        layoutLG.addView(layoutLogin);

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
    public void goActitityNavigator(EditText ET){
        if (ET.getText().toString().isEmpty()){
            ET.setError("Llene este campo");
        }else{
            Toast mss = Toast.makeText(getApplicationContext(),"Cargando Perfil de " + ET.getText(),Toast.LENGTH_SHORT);
            mss.show();
            Intent myIntent = new Intent(ActivityIniciarSesion.this, NavigatorActivity.class);
            myIntent.putExtra("pk_username",ET.getText().toString());//Paso de datos de un activity a otro
            ActivityIniciarSesion.this.startActivity(myIntent);
        }
    }
}
