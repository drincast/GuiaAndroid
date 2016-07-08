package com.guias.alternasoft.guiaandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerBasico extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    protected ArrayAdapter<CharSequence> charSequenceArrayAdapter;
    private Spinner spinner;

    private int posicion;
    private String seleccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_basico);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        InicializarControles();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void InicializarControles(){
        this.spinner = (Spinner)findViewById(R.id.spinnerBasico);
        this.charSequenceArrayAdapter = ArrayAdapter.createFromResource(this, R.array.DatosSpinnerBasico
                , android.R.layout.simple_spinner_item);
        this.charSequenceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter((this.charSequenceArrayAdapter));

        this.spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.posicion = position;
        seleccion = parent.getItemAtPosition(posicion).toString();
        Toast.makeText(this, "=> " + this.seleccion, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


/*
public class Lstclientes extends AppCompatActivity {
    private String[] strOpciones = {"opcion 1", "opcion 2", "opcion 3", "opcion 4"};
    private ArrayAdapter<String> adaptador;
    private Spinner spinner;
    private TextView lblMensajesDemo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lstclientes);

        this.lblMensajesDemo = (TextView) findViewById(R.id.lblMensajesDemo);
        this.spinner = (Spinner) findViewById(R.id.spinner);

        adaptador = new ArrayAdapter<String>(this, R.layout.activity_lstclientes, R.id.lblMensajesDemo, this.strOpciones);

        adaptador.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        lblMensajesDemo.setText("Seleccionado: " + parent.getItemAtPosition(position));
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        lblMensajesDemo.setText("");
                    }
                });
    }
}
*/