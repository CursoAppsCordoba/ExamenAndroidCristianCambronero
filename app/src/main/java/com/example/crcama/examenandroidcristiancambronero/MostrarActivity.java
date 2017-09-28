package com.example.crcama.examenandroidcristiancambronero;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MostrarActivity extends AppCompatActivity  implements View.OnClickListener {

    private AlertDialog ventana;
    private ListView listView;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        Button bcancelar = (Button) findViewById(R.id.cancelar);
        bcancelar.setOnClickListener(this);

        listView=(ListView)findViewById(R.id.listview);

        ArrayList<Contacto> ListaContactos=getIntent().getParcelableArrayListExtra("Listacontactos");
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, ListaContactos);
        String nombre=ListaContactos.get(0).getNombre();
        System.out.println(nombre);
        listView.setAdapter(adapter);
    }

    public AlertDialog CreateDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Quieres cancelar el listar contactos?");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MostrarActivity.this.finish();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }


    public void AlertDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("¿Quieres cancelar el listar contactos?");
        alert.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MostrarActivity.this.finish();
            }
        });
        alert.setNegativeButton(android.R.string.no, null);
        alert.show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cancelar:
                if (ventana == null) {
                    ventana = CreateDialog();
                }
                ventana.show();
        }
    }
}
