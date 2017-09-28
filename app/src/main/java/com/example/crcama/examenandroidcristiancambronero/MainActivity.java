package com.example.crcama.examenandroidcristiancambronero;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int ALTA=100;
    public static final int BAJA=200;
    public static final int LISTAR=300;
    private ArrayList<Contacto> Listacontactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button balta=(Button)findViewById(R.id.alta);
        balta.setOnClickListener(this);
        Button bbaja=(Button)findViewById(R.id.baja);
        bbaja.setOnClickListener(this);
        Button blistar=(Button)findViewById(R.id.listar);
        blistar.setOnClickListener(this);


        Listacontactos=new ArrayList<Contacto>();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ALTA) {
            if (resultCode == Activity.RESULT_OK) {
                if (data.hasExtra("contactos")) {
                    Contacto contacto = data.getParcelableExtra("contactos");
                    Listacontactos.add(contacto);
                    Toast.makeText(this, "El contacto: " + contacto.getNombre(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "no se ha creado nada", Toast.LENGTH_LONG).show();
                }
            }
        }
        if (requestCode == BAJA) {
            if (resultCode == Activity.RESULT_OK) {
                if (data.hasExtra("contactos")) {
                    Contacto contacto = data.getParcelableExtra("contactos");
                    Listacontactos.remove(contacto);
                    Toast.makeText(this, "El contacto: " + contacto.getNombre() + "se ha borrado con exito", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "no existe ese contacto", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.alta:
                Intent intent=new Intent(this,AltaActivity.class);
                this.startActivityForResult(intent,ALTA);
                setResult(ALTA);
                break;
            case R.id.baja:
                Intent intent1=new Intent(this,BorrarActivity.class);
                this.startActivityForResult(intent1,BAJA);
                setResult(BAJA);
                break;

            case R.id.listar:
                Intent intent2=new Intent(MainActivity.this,MostrarActivity.class);
                intent2.putParcelableArrayListExtra("Listacontactos",Listacontactos);
                this.startActivity(intent2);
                break;

        }

    }
}
