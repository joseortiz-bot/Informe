package com.example.informe;

import android.content.Intent;
import android.hardware.input.InputManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre;
    private ImageView iv_personaje;

    int num_aleatorio = (int) (Math.random() * 10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_nombre = (EditText) findViewById(R.id.txt_nombre);
        iv_personaje = (ImageView) findViewById(R.id.imageView_personas);
        //poner icono action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        int id;
        if (num_aleatorio == 0 || num_aleatorio == 10) {
            id = getResources().getIdentifier("ministerio", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        } else if (num_aleatorio == 1 || num_aleatorio == 9) {
            id = getResources().getIdentifier("maleta", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        } else if (num_aleatorio == 2 || num_aleatorio == 8) {
            id = getResources().getIdentifier("feliz", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        } else if (num_aleatorio == 3 || num_aleatorio == 7) {
            id = getResources().getIdentifier("gente", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        } else if (num_aleatorio == 4 || num_aleatorio == 6 ) {
            id = getResources().getIdentifier("mano", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        } else if (num_aleatorio == 5 || num_aleatorio == 5 || num_aleatorio == 4) {
            id = getResources().getIdentifier("ministerio", "drawable", getPackageName());
            iv_personaje.setImageResource(id);
        }

    }

    public void siguiente(View view){
        String nombre = et_nombre.getText().toString();

        if(!nombre.equals("")) {

            Intent intent = new Intent(this, Main2Acttivity_Informe1.class);

            intent.putExtra("Bienvenido", nombre);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this, "Primero debes escribir tu nombre", Toast.LENGTH_LONG).show();

            et_nombre.requestFocus();
            InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
            imm.showSoftInput(et_nombre, InputMethodManager.SHOW_IMPLICIT);
        }
    }

    @Override
    public  void onBackPressed(){

    }
}
