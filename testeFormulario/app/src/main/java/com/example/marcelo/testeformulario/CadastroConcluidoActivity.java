package com.example.marcelo.testeformulario;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CadastroConcluidoActivity extends AppCompatActivity {

    private EditText idDoc;
    private EditText idNome;
    private EditText dataNascimento;

    private TextView idDocCad;
    private TextView idNomeCad;
    private TextView iddataCad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_concluido);

        idNome = (EditText) findViewById(R.id.idNome);
        idDoc = (EditText) findViewById(R.id.idDoc);
        dataNascimento = (EditText) findViewById(R.id.dataNascimento);

        idDocCad = (TextView) findViewById(R.id.idDoc);
        idNomeCad = (TextView) findViewById(R.id.idNome);
        iddataCad = (TextView) findViewById(R.id.dataNascimento);


    }

}
