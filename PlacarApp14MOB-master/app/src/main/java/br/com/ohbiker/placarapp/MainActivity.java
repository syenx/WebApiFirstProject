package br.com.ohbiker.placarapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etTimeCasa;
    private EditText etTimeVisitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTimeCasa = (EditText) findViewById(R.id.etTimeCasa);
        etTimeVisitante = (EditText) findViewById(R.id.etTimeVisitante);

    }

    public void comecaJogo(View v) {
        if (etTimeCasa.getText().toString().isEmpty()) {
            Toast.makeText(this, "informe o time da casa", Toast.LENGTH_SHORT).show();
            return;
        }
        if (etTimeVisitante.getText().toString().isEmpty()) {
            Toast.makeText(this, "informe o time visitante", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent proximaTela = new Intent(this, GameActivity.class);
        proximaTela.putExtra("TIMEVISITANTE", etTimeVisitante.getText().toString());
        proximaTela.putExtra("TIMECASA", etTimeCasa.getText().toString());
        startActivity(proximaTela);
    }
}
