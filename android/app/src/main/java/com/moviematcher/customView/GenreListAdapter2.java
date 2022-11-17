package com.moviematcher.customView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moviematcher.databinding.GenreItemBinding;

import java.util.List;

public class GenreListAdapter2 extends RecyclerView.Adapter<GenreListAdapter2.GenreViewHolder2> {

    public List<String> genreList;

    @NonNull
    @Override
    public GenreListAdapter2.GenreViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        GenreItemBinding binding = GenreItemBinding.inflate(layoutInflater, parent, false);
        return new GenreViewHolder2(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreListAdapter2.GenreViewHolder2 holder, int position) {
        holder.bind(genreList.get(position));
    }

    @Override
    public int getItemCount() {
        return genreList.size();
    }

    class GenreViewHolder2 extends RecyclerView.ViewHolder {

        private GenreItemBinding binding;

        public GenreViewHolder2(GenreItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(String genre) {
            binding.chip.setText(genre);
        }
    }
}
