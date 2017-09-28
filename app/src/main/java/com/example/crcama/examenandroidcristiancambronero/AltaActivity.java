package com.example.crcama.examenandroidcristiancambronero;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AltaActivity extends AppCompatActivity implements View.OnClickListener {
    private AlertDialog ventana;

    private EditText nombre, edad, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);
        Button bok = (Button) findViewById(R.id.ok);
        bok.setOnClickListener(this);
        Button bcanceled = (Button) findViewById(R.id.canceled);
        bcanceled.setOnClickListener(this);
        nombre = (EditText) findViewById(R.id.et_nombre);
        edad = (EditText) findViewById(R.id.et_edad);
        email = (EditText) findViewById(R.id.et_email);

    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
    }

    public AlertDialog CreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Quieres salir de mostrar los contactos?");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                AltaActivity.this.finish();
            }
        });
        builder.setNegativeButton("cancel",new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }

    public void AlertDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("¿Quieres salir de mostrar los contactos?");
        alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AltaActivity.this.finish();
            }
        });
        alert.setNegativeButton(android.R.string.no,null);
        alert.show();
    }

    public void Alta(Intent intent){
        Contacto contacto=new Contacto(nombre.getText().toString(),email.getText().toString(),Integer.parseInt(edad.getText().toString()));
        intent.putExtra("contactos",contacto);
    }

    @Override
    public void onClick(View view) {//hola
        switch (view.getId()){
            case R.id.ok:
                Contacto contacto=new Contacto();
                if (contacto!=null){
                    Intent intent=new Intent();
                    Alta(intent);
                    setResult(Activity.RESULT_OK,intent);
                    finish();
                    break;
                }
                break;
            case R.id.canceled:
                if(ventana==null){
                    ventana=CreateDialog();
                }
                ventana.show();
        }
    }
}
