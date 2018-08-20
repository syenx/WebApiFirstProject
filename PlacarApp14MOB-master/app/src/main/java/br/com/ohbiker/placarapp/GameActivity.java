package br.com.ohbiker.placarapp;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    private String timeCasa;
    private String timeVisitante;
    private int nbrPontoCasa;
    private TextView txtCasa;
    private TextView txtVisitante;
    private TextView nbrCasa;
    private TextView nbrVisitante;
    private int nbrPontoVisitante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        txtCasa = (TextView) findViewById(R.id.txtCasa);
        txtVisitante = (TextView) findViewById(R.id.txtVisitante);

        if (getIntent() != null) {
            timeCasa = getIntent().getStringExtra("TIMECASA");
            timeVisitante = getIntent().getStringExtra("TIMEVISITANTE");
            //Toast.makeText(this, timeCasa + " " + timeVisitante, Toast.LENGTH_SHORT).show();

            txtCasa.setText(timeCasa);
            txtVisitante.setText(timeVisitante);

        } else {
            Toast.makeText(this, "houve erro nessa bagaça", Toast.LENGTH_SHORT).show();
        }
        /*
        if (savedInstanceState != null) {
            nbrCasa.setText(savedInstanceState.getString("nbrCasa"));
            nbrVisitante.setText(savedInstanceState.getString("nbrVisitante"));
        }
        */
    }
/*
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("txtCasa", txtCasa.getText().toString());
        outState.putString("txtVisitante", txtVisitante.getText().toString());

        outState.putString("nbrPontoCasa", nbrCasa.getText().toString());
        outState.putString("nbrPontoVisitante", nbrVisitante.getText().toString());
    }
*/

    public void onGolCasa(View v) {

        nbrCasa = (TextView) findViewById(R.id.nbrCasa);
        nbrPontoCasa = Integer.parseInt(nbrCasa.getText().toString());

        nbrPontoCasa += 1;
        nbrCasa.setText(String.valueOf(nbrPontoCasa));
    }

    public void onGolVisitante(View v) {

        nbrVisitante = (TextView) findViewById(R.id.nbrVisitante);

        nbrPontoVisitante = Integer.parseInt(nbrVisitante.getText().toString());

        nbrPontoVisitante += 1;
        nbrVisitante.setText(String.valueOf(nbrPontoVisitante));


    }

    public void onReset(View v) {

        nbrVisitante.setText("0");
        nbrCasa.setText("0");

    }


}
