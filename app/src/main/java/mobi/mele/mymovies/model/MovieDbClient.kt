package mobi.mele.mymovies.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by mele
 * date   : 22/12/21
 * e-mail : contact@mele.mobi
 */
object MovieDbClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(TheMovieDbService::class.java)
}