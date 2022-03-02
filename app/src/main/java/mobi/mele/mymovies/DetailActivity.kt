package mobi.mele.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mobi.mele.mymovies.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "DetailActivity:title"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val title = intent.getStringExtra(EXTRA_TITLE)
        binding.title.text = title
    }
}