package com.alvinmd.emiyamd.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alvinmd.emiyamd.R;
import com.alvinmd.emiyamd.activity.AnimeDetailActivity;
import com.alvinmd.emiyamd.model.ResponseAnime;
import com.alvinmd.emiyamd.model.Result;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RVAnime extends RecyclerView.Adapter<RVAnime.MyViewHolder> {

    private Context mContext;
    private List<Result> mData;

    public RVAnime(Context mContext, List<Result> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RVAnime.MyViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_anime, parent, false);

        final RVAnime.MyViewHolder viewHolder = new RVAnime.MyViewHolder(view);
        viewHolder.rrAnimeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(parent.getContext(), AnimeDetailActivity.class);
                Result result = new Result();
                result.setAnimeTitle(mData.get(viewHolder.getAdapterPosition()).getAnimeTitle());
                result.setAnimeDescription(mData.get(viewHolder.getAdapterPosition()).getAnimeDescription());
                result.setAnimeImages(mData.get(viewHolder.getAdapterPosition()).getAnimeImages());
                i.putExtra(AnimeDetailActivity.EXTRA_ANIME, result);
                parent.getContext().startActivity(i);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RVAnime.MyViewHolder holder, int position) {
        holder.tvTitle.setText(mData.get(position).getAnimeTitle());

        Glide.with(mContext)
                .load(mData.get(position).getAnimeImages())
                .into(holder.ivAnime);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView ivAnime;
        TextView tvTitle;
        RelativeLayout rrAnimeList;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            ivAnime = itemView.findViewById(R.id.ivItemAnime);
            tvTitle = itemView.findViewById(R.id.tvTitleAnime);
            rrAnimeList = itemView.findViewById(R.id.relativeItemAnime);
        }
    }
}
