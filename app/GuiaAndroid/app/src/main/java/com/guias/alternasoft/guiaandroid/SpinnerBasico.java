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
import android.widget.TextView;
import android.widget.Toast;

public class SpinnerBasico extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView lblSeleccionado;
    protected ArrayAdapter<CharSequence> charSequenceArrayAdapter;
    private Spinner spinner;

    private int posicion;
    private String seleccion;

    private String[] strOpciones = {"Selección 1", "Selección 2", "Selección 3", "Selección 4"};
    private Spinner spinnerBasico2;
    protected ArrayAdapter<String> adaptadorString;

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
        this.lblSeleccionado = (TextView)findViewById(R.id.lblSeleccionado);

        this.spinner = (Spinner)findViewById(R.id.spinnerBasico);
        this.charSequenceArrayAdapter = ArrayAdapter.createFromResource(this, R.array.DatosSpinnerBasico
                , android.R.layout.simple_spinner_item);
        this.charSequenceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter((this.charSequenceArrayAdapter));
        this.spinner.setOnItemSelectedListener(this);

        this.spinnerBasico2 = (Spinner)findViewById(R.id.spinnerBasico2);
        this.adaptadorString = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.strOpciones);
        //adaptadorString.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        this.spinnerBasico2.setAdapter(this.adaptadorString);
        this.spinnerBasico2.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.posicion = position;
        seleccion = parent.getItemAtPosition(posicion).toString();
        Toast.makeText(this, "=> " + this.seleccion, Toast.LENGTH_LONG).show();

        Object o = parent.getItemAtPosition(posicion);
        //this.lblSeleccionado.setText(o.getClass().toString());

        if(o instanceof CharSequence){
            this.lblSeleccionado.append("S - Adaptador de CharSequense");
        }else if(o instanceof String){
            this.lblSeleccionado.append("C - Adaptador de String");
        }
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