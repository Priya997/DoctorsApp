package com.priyankaj.doctorsapp.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.priyankaj.doctorsapp.R;
import com.priyankaj.doctorsapp.model.Doctors;
import com.priyankaj.doctorsapp.ui.DoctorDetailsActivity;

import java.util.ArrayList;


public class DoctorDetailsAdapter extends RecyclerView.Adapter<DoctorDetailsAdapter.MyViewHolder> {

    private ArrayList<Doctors> dataSet;

    public class MyViewHolder extends RecyclerView.ViewHolder  {

        TextView textViewName;
        TextView textViewVersion;
        RippleView rvDoctor;
        ImageView imageView;
        //ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.textViewVersion);
            this.rvDoctor = itemView.findViewById(R.id.rv_doctor);
            this.imageView = itemView.findViewById(R.id.imageView);


         //   this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }


    }

    public DoctorDetailsAdapter(ArrayList<Doctors> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_l2, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        //ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getName());
        holder.rvDoctor.setTag(listPosition);
        textViewVersion.setText(dataSet.get(listPosition).getMobile());

        holder.rvDoctor.setOnRippleCompleteListener(new RippleView.OnRippleCompleteListener() {
            @Override
            public void onComplete(RippleView rippleView) {
                Intent intent = new Intent(rippleView.getContext(), DoctorDetailsActivity.class);
                int position = (Integer)rippleView.getTag();
                intent.putExtra("doctor",dataSet.get(position));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions options = ActivityOptions
                            .makeSceneTransitionAnimation((Activity) rippleView.getContext(), holder.imageView, "doctor");
                    // start the new activity
                    rippleView.getContext().startActivity(intent, options.toBundle());
                }else
                {
                    rippleView.getContext().startActivity(intent);
                }
            }
        });
    //    imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
