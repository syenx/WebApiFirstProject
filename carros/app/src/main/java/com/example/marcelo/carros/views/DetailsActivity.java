package com.example.marcelo.carros.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.marcelo.carros.R;
import com.example.marcelo.carros.constants.CarrosConstants;
import com.example.marcelo.carros.data.CarMock;
import com.example.marcelo.carros.entities.Car;

public class DetailsActivity extends AppCompatActivity {


    private ViewHolder mViewHolder = new ViewHolder();
    private CarMock mCarMock;
    private Car mCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mViewHolder.textModel = (TextView) findViewById(R.id.text_model);
        this.mViewHolder.textHorsePower = (TextView) findViewById(R.id.text_hose_power);
        this.mViewHolder.textPrice = (TextView) findViewById(R.id.text_price);

        this.mCarMock = new CarMock();

        this.getDataFromActivity();
        this.setData();
    }

    private void setData() {
        this.mViewHolder.textModel.setText(this.mCar.model);
        this.mViewHolder.textHorsePower.setText(String.valueOf(this.mCar.horsePower));
        this.mViewHolder.textPrice.setText(String.valueOf(this.mCar.price));
    }

    public void getDataFromActivity() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.mCar = this.mCarMock.get(extras.getInt(CarrosConstants.CARRO_ID));
        }

    }

    public static class ViewHolder {
        TextView textModel;
        TextView textHorsePower;
        TextView textPrice;
    }
}
