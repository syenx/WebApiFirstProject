package com.example.marcelo.carros.views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.marcelo.carros.R;
import com.example.marcelo.carros.adapter.CarListAdapter;
import com.example.marcelo.carros.constants.CarrosConstants;
import com.example.marcelo.carros.data.CarMock;
import com.example.marcelo.carros.entities.Car;
import com.example.marcelo.carros.listener.OnListClickInteractionListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewHolder mViewholder = new ViewHolder();
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mContext = this;
        CarMock carMock = new CarMock();
        List<Car> carList = new ArrayList<>();
        carList.addAll(carMock.getList());

        // obter item da tela (Recycle)
        this.mViewholder.recyclercars = (RecyclerView) this.findViewById(R.id.recycler_cars);

        OnListClickInteractionListener listener = new OnListClickInteractionListener() {
            @Override
            public void onClick(int id) {
                Bundle bundle = new Bundle();
                bundle.putInt(CarrosConstants.CARRO_ID, id);

                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtras(bundle);

                startActivity(intent);

            }
        };

        //Adapter.. adaptador entre recycle view e o adaptador
        CarListAdapter carListAdapter = new CarListAdapter(carList, listener);
        this.mViewholder.recyclercars.setAdapter(carListAdapter);

        //definir layout
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mViewholder.recyclercars.setLayoutManager(linearLayoutManager);
    }


    private static class ViewHolder {
        RecyclerView recyclercars;

    }
}
