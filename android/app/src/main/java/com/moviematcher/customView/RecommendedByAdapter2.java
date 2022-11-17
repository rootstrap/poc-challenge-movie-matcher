package com.moviematcher.customView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.moviematcher.RecommendedBy2;
import com.moviematcher.databinding.ViewHolderRecommendedByBinding;

import java.util.List;

public class RecommendedByAdapter2 extends RecyclerView.Adapter<RecommendedByAdapter2.RecommendedByViewHolder>   {

    private List<RecommendedBy2> recommendedByList;

    public RecommendedByAdapter2(List<RecommendedBy2> list){
        recommendedByList = list;
    }

    @NonNull
    @Override
    public RecommendedByAdapter2.RecommendedByViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        ViewHolderRecommendedByBinding binding = ViewHolderRecommendedByBinding.inflate(layoutInflater, parent, false);
        return new RecommendedByViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendedByAdapter2.RecommendedByViewHolder holder, int position) {
        holder.bind(recommendedByList.get(position));
    }

    @Override
    public int getItemCount() {
        return recommendedByList.size();
    }


    class RecommendedByViewHolder extends RecyclerView.ViewHolder {
        ViewHolderRecommendedByBinding binding;

        public RecommendedByViewHolder(ViewHolderRecommendedByBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(RecommendedBy2 recommendedBy){
            binding.name.setText(recommendedBy.name);
            Glide.with(binding.getRoot().getContext())
                    .load(recommendedBy.imageUrl)
                    .transition(
                            DrawableTransitionOptions.withCrossFade().transition(android.R.anim.fade_in)
                    )
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(binding.image);
        }
    }
}

