package com.example.marcelo.carros.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.marcelo.carros.R;
import com.example.marcelo.carros.entities.Car;
import com.example.marcelo.carros.listener.OnListClickInteractionListener;

/**
 * Created by Marcelo on 19/12/2017.
 */

public class CarViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextModel;

    public CarViewHolder(View itemView) {
        super(itemView);
        this.mTextModel = (TextView) itemView.findViewById(R.id.text_model);
    }

    public void bindData(final Car car, final OnListClickInteractionListener listener) {
        this.mTextModel.setText(car.model);
        this.mTextModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(car.id);

            }
        });

    }
}
