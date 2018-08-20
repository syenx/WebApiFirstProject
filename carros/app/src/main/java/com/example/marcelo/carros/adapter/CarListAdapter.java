package com.example.marcelo.carros.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marcelo.carros.R;
import com.example.marcelo.carros.entities.Car;
import com.example.marcelo.carros.listener.OnListClickInteractionListener;
import com.example.marcelo.carros.viewholder.CarViewHolder;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Marcelo on 19/12/2017.
 */

public class CarListAdapter extends RecyclerView.Adapter<CarViewHolder> {

    private List<Car> mListCar;
    private int mContOnCreate = 0;
    private int mContOnbind = 0;
    private OnListClickInteractionListener mOnListClickInteractionListener;

    public CarListAdapter(List<Car> cars, OnListClickInteractionListener listener) {
        this.mListCar = cars;
        this.mOnListClickInteractionListener = listener;
    }


    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View carView = inflater.inflate(R.layout.row_car_list, parent, false);

        return new CarViewHolder(carView);
    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position) {
        this.mContOnbind++;
        Car car = this.mListCar.get(position);

        holder.bindData(car, this.mOnListClickInteractionListener);
    }

    @Override
    public int getItemCount() {
        return this.mListCar.size();
    }
}
