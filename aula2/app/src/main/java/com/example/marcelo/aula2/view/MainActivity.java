package com.example.marcelo.aula2.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.SuperscriptSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.marcelo.aula2.R;
import com.example.marcelo.aula2.constants.FimDeAnoConstants;
import com.example.marcelo.aula2.util.SecurityPreferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.mViewHolder.textToday = (TextView) findViewById(R.id.text_today);
        this.mViewHolder.textDayLeft = (TextView) findViewById(R.id.text_day_left);
        this.mViewHolder.buttonConfirm = (Button) findViewById(R.id.button_confirm);
        this.mViewHolder.buttonConfirm.setOnClickListener(this);
        this.mSecurityPreferences = new SecurityPreferences(this);
        this.LoadDataFromActivity();

        this.mViewHolder.textToday.setText(SIMPLE_DATE_FORMAT.format(Calendar.getInstance().getTime()));

        String daysLeft = String.format("%s %s",String.valueOf(this.getDaysLeftToEndofYers()), getString(R.string.dias) );
        this.mViewHolder.textDayLeft.setText(daysLeft);
    }

    private int getDaysLeftToEndofYers()
    {
        Calendar calendarToDay = Calendar.getInstance();
        int today = calendarToDay.get(Calendar.DAY_OF_YEAR);
        Calendar calendarLastDay = Calendar.getInstance();

        int dayDecenber31 = calendarLastDay.getActualMaximum(Calendar.DAY_OF_YEAR);

        return  dayDecenber31 - today;
     }

    @Override
    protected void onStart() {

        super.onStart();
    }

    @Override
    protected void onResume() {
        this.VerifyPresense();
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private void LoadDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String presence = extras.getString(FimDeAnoConstants.PRESENCE);
        }
    }

    private void VerifyPresense() {
        String presence = this.mSecurityPreferences.getStoredString(FimDeAnoConstants.PRESENCE);
        if (presence == "") {
            this.mViewHolder.buttonConfirm.setText(R.string.Nao_Confirmado);
        } else if (presence.equals(FimDeAnoConstants.CONFIRMED_WILL_GO)) {
            this.mViewHolder.buttonConfirm.setText(R.string.sim);
        } else {
            this.mViewHolder.buttonConfirm.setText(R.string.Nao);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        String presence = this.mSecurityPreferences.getStoredString(FimDeAnoConstants.PRESENCE);
        if (id == R.id.button_confirm) {
            Intent intent = new Intent(this, DetailsActivity.class);

            intent.putExtra(FimDeAnoConstants.PRESENCE, presence);


            startActivity(intent);
        }
    }

    private static class ViewHolder {
        TextView textToday;
        TextView textDayLeft;
        Button buttonConfirm;
    }
}
