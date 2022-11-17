package com.moviematcher.customView.asd;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;


import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.moviematcher.Movie2;
import com.moviematcher.R;
import com.moviematcher.RecommendedBy2;
import com.moviematcher.customView.GenreListAdapter2;
import com.moviematcher.customView.RecommendedByAdapter2;
import com.moviematcher.databinding.ActivityMovieDetailBinding;

import java.util.Arrays;
import java.util.List;


public class MovieDetailActivity2 extends Activity {

    private List<RecommendedBy2> fakeList = Arrays.asList(
        new RecommendedBy2("Juan Perez", "https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/avatars/d7/d7f64c179408973acf7aeb0aeb9ac3f21cd40c2a.jpg", false),
        new RecommendedBy2("Maria Fernandez", "https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/avatars/a3/a3b6aa056df855b239bc5e8342a5bd987f59ac8a.jpg", false),
        new RecommendedBy2("Martín Baez", "https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/avatars/c0/c0947bd922a20a2affc9175dc7251e14c50397c7.jpg", false),
        new RecommendedBy2("Lucía Martinez", "https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/avatars/bf/bfcb87529e39bbee65f5482c658008fe7f014eb3.jpg", false)
    );

    private ActivityMovieDetailBinding binding;
    private GenreListAdapter2 genresAdapter;
    Movie2 movie = new Movie2(
            Arrays.asList("Action", "SCI-FI", "Drama"),
            1.0,
            "Wakanda forever",
            "Queen Ramonda, Shuri, M'Baku, Okoye and the Dora Milaje fight to protect their nation from intervening world powers in the wake of King T'Challa's death. As the Wakandans strive to embrace their next chapter, the heroes must band together with the help of War Dog Nakia and Everett Ross and forge a new path for the kingdom of Wakanda.",
            "https://image.tmdb.org/t/p/original//sv1xJUazXeYqALzczSZ3O6nkH75.jpg",
            false,
            false
    );
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieDetailBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        initView();
    }

    void initView() {
        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.recommendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRecommendClick();
            }
        });

        binding.addToListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddToMyListClick();
            }
        });

        Glide.with(getApplicationContext())
                .load(movie.posterPath)
                .transition(
                      new DrawableTransitionOptions().withCrossFade().transition(android.R.anim.fade_in)
                )
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(binding.movieImage);

        setRecommendedByList();
        initGenresList(movie.genres);
        binding.overview.setText(movie.overview);
    }

    void setRecommendedByList() {
        binding.peopleList.setLayoutManager(new LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL,
                    false
            ));
        RecommendedByAdapter2 adapter = new RecommendedByAdapter2(fakeList);
        binding.peopleList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    void initGenresList(List<String> genres) {
        genresAdapter = new GenreListAdapter2();
        genresAdapter.genreList = genres;
        binding.genresList.setAdapter(genresAdapter);
    }

    void onRecommendClick() {
        Boolean isRecommended = movie.isRecommended;
        if (isRecommended) {
            Toast.makeText(this, "Removed from your recommendations", Toast.LENGTH_LONG).show();
            binding.recommendBtn.setText(getString(R.string.recommend));

        } else {
            Toast.makeText(this, "Added to your recommendations", Toast.LENGTH_LONG).show();
            binding.recommendBtn.setText(getString(R.string.remove_recommendation));
        }

        movie.isRecommended = !movie.isRecommended;
    }

    void onAddToMyListClick() {
        Boolean isInMyList = movie.isInMyList;
        if (isInMyList) {
            Toast.makeText(this, "Removed from your watch list", Toast.LENGTH_LONG).show();
            binding.addToListBtn.setText(getString(R.string.add_to_my_list));
        } else {
            Toast.makeText(this, "Added to your watch list", Toast.LENGTH_LONG).show();
            binding.addToListBtn.setText(getString(R.string.remove_my_list));
        }

        movie.isInMyList = !movie.isInMyList;
    }
}