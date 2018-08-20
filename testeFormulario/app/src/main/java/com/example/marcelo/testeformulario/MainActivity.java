package com.example.marcelo.testeformulario;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText idDoc;
    private EditText idNome;
    private EditText dataNascimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idNome = (EditText) findViewById(R.id.idNome);
        idDoc = (EditText) findViewById(R.id.idDoc);
        dataNascimento = (EditText) findViewById(R.id.dataNascimento);
    }

    public void savarNovo(View v)
    {
        if (idNome.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Informe o nome", Toast.LENGTH_SHORT).show();
            return;
        }
        if (idDoc.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Informe o Doc", Toast.LENGTH_SHORT).show();
            return;
        }
        if (dataNascimento.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Informe o data de nascimento", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent proximaTela = new Intent(this, CadastroConcluidoActivity.class);
        startActivity(proximaTela);

    }



}
