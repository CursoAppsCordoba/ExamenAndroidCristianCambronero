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

public class BorrarActivity extends AppCompatActivity implements View.OnClickListener {

    private AlertDialog ventana;
    private EditText et_nombre,et_edad,et_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar);
        et_nombre=(EditText) findViewById(R.id.et_contacto);
        et_edad=(EditText)findViewById(R.id.et_edad);
        et_email=(EditText)findViewById(R.id.et_email);
        Button bborrar=(Button)findViewById(R.id.borrar);
        bborrar.setOnClickListener(this);
        Button bcanceled=(Button)findViewById(R.id.canceled);
        bcanceled.setOnClickListener(this);

    }

    public AlertDialog CreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Quieres salir de borrar el contacto?");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                BorrarActivity.this.finish();
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
        alert.setMessage("¿Quieres salir de borrar el contacto?");
        alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                BorrarActivity.this.finish();
            }
        });
        alert.setNegativeButton(android.R.string.no,null);
        alert.show();
    }

    public void borrar(Intent intent){
        Contacto contacto=new Contacto(et_nombre.getText().toString(),et_email.getText().toString(),Integer.parseInt(et_edad.getText().toString()));
        intent.putExtra("contactos",contacto);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.borrar:
                Contacto contacto=new Contacto();
                if (contacto!=null){
                    Intent intent=new Intent();
                    borrar(intent);
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
