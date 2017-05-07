package me.satyabrat.popularmovies.service;

import me.satyabrat.popularmovies.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by princ on 5/7/2017.
 */

public interface APIService {
    @GET("3/movie/popular")
    Call<Movie> getMovieDetails(@Query("api_key") String API_KEY );
}
