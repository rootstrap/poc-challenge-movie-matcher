package com.moviematcher

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
//import com.google.android.material.snackbar.Snackbar
import com.moviematcher.customView.RecommendedByAdapter
import com.moviematcher.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : Activity() {

    private val fakeList = listOf(
        RecommendedBy(name = "Juan Perez", imageUrl = "https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/avatars/d7/d7f64c179408973acf7aeb0aeb9ac3f21cd40c2a.jpg", isFriend = false),
        RecommendedBy(name = "Maria Fernandez", imageUrl = "https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/avatars/a3/a3b6aa056df855b239bc5e8342a5bd987f59ac8a.jpg", isFriend = false),
        RecommendedBy(name = "Martín Baez", imageUrl = "https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/avatars/c0/c0947bd922a20a2affc9175dc7251e14c50397c7.jpg", isFriend = false),
        RecommendedBy(name = "Lucía Martinez", imageUrl = "https://cdn.cloudflare.steamstatic.com/steamcommunity/public/images/avatars/bf/bfcb87529e39bbee65f5482c658008fe7f014eb3.jpg", isFriend = false),
    )

    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var genresAdapter: GenreListAdapter

    private var movie = com.moviematcher.models.Movie(
        genres = listOf("Action", "SCI-FI", "Drama"),
        title = "Wakanda forever",
        id = 1.0,
        overview = "Queen Ramonda, Shuri, M'Baku, Okoye and the Dora Milaje fight to protect their nation from intervening world powers in the wake of King T'Challa's death. As the Wakandans strive to embrace their next chapter, the heroes must band together with the help of War Dog Nakia and Everett Ross and forge a new path for the kingdom of Wakanda.",
        posterPath = "https://image.tmdb.org/t/p/original//sv1xJUazXeYqALzczSZ3O6nkH75.jpg",
        isInMyList = false,
        isRecommended = false
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.backBtn.setOnClickListener {
            finish()
        }

        binding.recommendBtn.setOnClickListener {
            onRecommendClick()
        }

        binding.addToListBtn.setOnClickListener {
            onAddToMyListClick()
        }

        Glide.with(applicationContext)
            .load(movie.posterPath)
            .transition(
                DrawableTransitionOptions.withCrossFade().transition(android.R.anim.fade_in)
            )
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(binding.movieImage)

        setRecommendedByList()
        initGenresList(movie.genres)
        binding.overview.text = movie.overview
    }

    private fun setRecommendedByList() {
        with(binding.peopleList) {
            layoutManager = LinearLayoutManager(
                this@MovieDetailActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = RecommendedByAdapter(fakeList).also {
                it.notifyDataSetChanged()
            }
        }
    }

    private fun initGenresList(genres: List<String>) {
        genresAdapter = GenreListAdapter(genres)
        binding.genresList.adapter = genresAdapter
    }

    private fun onRecommendClick() {
        val isRecommended = movie.isRecommended
        /*
        if (isRecommended) {
            Snackbar.make(binding.root, "Removed from your recommendations", Snackbar.LENGTH_LONG)
                .show()
            binding.recommendBtn.text = getString(R.string.recommend)

        } else {
            Snackbar.make(binding.root, "Added to your recommendations", Snackbar.LENGTH_LONG)
                .show()
            binding.recommendBtn.text = getString(R.string.remove_recommendation)
        }
        */
        
        movie = movie.copy(isRecommended = isRecommended.not())
    }

    private fun onAddToMyListClick() {
        val isInMyList = movie.isInMyList
        if (isInMyList) {
            //Snackbar.make(binding.root, "Removed from your watch list", Snackbar.LENGTH_LONG).show()
            binding.addToListBtn.text = getString(R.string.add_to_my_list)
        } else {
            //Snackbar.make(binding.root, "Added to your watch list", Snackbar.LENGTH_LONG).show()
            binding.addToListBtn.text = getString(R.string.remove_my_list)
        }

        movie = movie.copy(isInMyList = isInMyList.not())
    }
}