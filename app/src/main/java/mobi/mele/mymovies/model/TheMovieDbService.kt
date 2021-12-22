package mobi.mele.mymovies.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by mele
 * date   : 22/12/21
 * e-mail : contact@mele.mobi
 */
interface TheMovieDbService {

    @GET("movie/popular")
    suspend fun listPopularMovies(@Query("api_key") apiKey: String): MovieDbResult

}