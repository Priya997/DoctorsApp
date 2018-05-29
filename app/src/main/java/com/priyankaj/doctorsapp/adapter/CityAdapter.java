package com.priyankaj.doctorsapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.model.City;

import java.util.ArrayList;


public class CityAdapter extends RecyclerView.Adapter<CityAdapter.MyViewHolder> {

    private static ArrayList<City> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName;
        TextView textViewVersion;
        RippleView rvCategory;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.textViewVersion);
            this.rvCategory = itemView.findViewById(R.id.rv_category);

            rvCategory.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
                @Override
                public void onComplete(RippleView rippleView) {
                    int position = (Integer)rippleView.getTag();
                    if(dataSet.get(position).getDoctorCount()>0){
                        mCityClickedListener.onCityClicked(position);
                    }
                }
            });
        //    this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
    }
    }

    public CityAdapter(ArrayList<City> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_layout, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {


        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        //ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getCity_name());
        textViewVersion.setText(dataSet.get(listPosition).getDoctorCount()+"");

        holder.rvCategory.setTag(listPosition);
       // imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public long getItemId(int position) {
        return Integer.parseInt(dataSet.get(position).getCity_ids());
    }

    public static interface CityClickedListener{
        public void onCityClicked(int position);
    }

    private static CityClickedListener mCityClickedListener;

    public static void setmCityClickedListener(CityClickedListener cityClickedListener){
        mCityClickedListener = cityClickedListener;
    }

}
