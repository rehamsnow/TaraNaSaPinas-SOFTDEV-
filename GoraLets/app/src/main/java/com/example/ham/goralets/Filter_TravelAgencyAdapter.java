package com.example.ham.goralets;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Ham on 3/2/2018.
 */

public class Filter_TravelAgencyAdapter extends RecyclerView.Adapter<Filter_TravelAgencyAdapter.TAViewHolder>{

    private Context mCtx;
    private List<Filter_TravelAgencyGetSet> TAList;

    public Filter_TravelAgencyAdapter(Context mCtx, List<Filter_TravelAgencyGetSet> TAList){
        this.mCtx = mCtx;
        this.TAList = TAList;
    }

    @Override
    public TAViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.travelagency_list,null);
        return new TAViewHolder(view);

    }

    @Override
    public void onBindViewHolder(Filter_TravelAgencyAdapter.TAViewHolder holder, int position) {
        Filter_TravelAgencyGetSet Filter_TravelAgencyGetSet = TAList.get(position);

        Glide.with(mCtx)
                .load(Filter_TravelAgencyGetSet.getImg())
                .into(holder.ImgTA);
        holder.TAName.setText(Filter_TravelAgencyGetSet.getName());
        holder.TAReviews.setText(String.valueOf(Filter_TravelAgencyGetSet.getReview()));
        holder.TAStars.setText(String.valueOf(Filter_TravelAgencyGetSet.getStars()));
    }

    @Override
    public int getItemCount() {
        return TAList.size();
    }

    class TAViewHolder extends RecyclerView.ViewHolder{

        TextView TAName, TAReviews, TAStars;
        ImageView ImgTA;

        public TAViewHolder(View itemView) {
            super(itemView);

            ImgTA = itemView.findViewById(R.id.ImgTA);
            TAName = itemView.findViewById(R.id.TAName);
            TAReviews = itemView.findViewById(R.id.TAReviews);
            TAStars = itemView.findViewById(R.id.TAStars);


        }
    }
}

