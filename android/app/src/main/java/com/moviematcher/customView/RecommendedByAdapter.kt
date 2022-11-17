package com.moviematcher.customView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.moviematcher.RecommendedBy
import com.swmansion.rnscreens.databinding.ViewHolderRecommendedByBinding

class RecommendedByAdapter constructor(
    private val recommendedByList: List<RecommendedBy>
): RecyclerView.Adapter<RecommendedByAdapter.RecommendedByViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedByViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewHolderRecommendedByBinding.inflate(layoutInflater, parent, false)
        return RecommendedByViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendedByViewHolder, position: Int) {
        holder.bind(recommendedByList[position])
    }

    override fun getItemCount(): Int = recommendedByList.size

    inner class RecommendedByViewHolder(
        private val binding: ViewHolderRecommendedByBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(recommendedBy: RecommendedBy) {
            with(binding) {
                name.text = recommendedBy.name
                Glide.with(binding.root.context)
                    .load(recommendedBy.imageUrl)
                    .transition(
                        DrawableTransitionOptions.withCrossFade().transition(android.R.anim.fade_in)
                    )
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .into(image)
            }
        }
    }
}