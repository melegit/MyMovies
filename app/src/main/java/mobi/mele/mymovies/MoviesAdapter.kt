package mobi.mele.mymovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mobi.mele.mymovies.databinding.ViewMovieItemBinding

interface MovieClickedListener {
    fun onMovieClicked(movie: Movie)
}

class MoviesAdapter(private val movies: List<Movie>, private val movieClickedListener: MovieClickedListener) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
/*
        //Sin viewBinding
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.view_movie_item, parent, false)
        return ViewHolder(view)
        */

        //con viewBinding

        val binding = ViewMovieItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener { movieClickedListener.onMovieClicked(movie) }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class ViewHolder(private val binding: ViewMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            binding.title.text = movie.title
            Glide
                .with(binding.root.context)
                .load(movie.cover)
                .into(binding.cover)
        }
    }
}