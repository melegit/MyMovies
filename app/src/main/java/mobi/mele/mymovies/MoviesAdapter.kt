package mobi.mele.mymovies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import mobi.mele.mymovies.databinding.ViewMovieItemBinding

class MoviesAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
/*
        Sin viewBinding
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_movie_item, parent, false)
        return ViewHolder(view)*/
/*
        con viewBinding
*/
        val binding = ViewMovieItemBinding.inflate(LayoutInflater.from(parent.context),
        parent,
        false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class ViewHolder(binding: ViewMovieItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie){

        }
    }
}