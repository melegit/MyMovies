package mobi.mele.mymovies

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import mobi.mele.mymovies.databinding.ActivityMainBinding
import mobi.mele.mymovies.model.MovieDbClient
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val moviesAdapter = MoviesAdapter(emptyList()){ movie ->
            Toast.makeText(this@MainActivity,movie.title, Toast.LENGTH_SHORT).show()
        }
        binding.recycler.adapter = moviesAdapter

        thread {
            val apiKey = this.resources.getString(R.string.api_key)
            val popularMovies = MovieDbClient.service.listPopularMovies(apiKey)
            val body = popularMovies.execute().body()

            runOnUiThread {
                if(body != null)
                moviesAdapter.movies = body.results
                moviesAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy")
    }
}