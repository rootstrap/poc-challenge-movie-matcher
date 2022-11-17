package com.moviematcher

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
                val uri = Uri.parse(recommendedBy.imageUrl)
                image.setImageURI(uri)
            }
        }
    }
}