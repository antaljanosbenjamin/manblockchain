package hu.bme.aut.android.spotifydemo.network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ArtistsApi {
    @GET("search")
    Call<ArtistsResult> getArtists(@Query("query") String artist,
                                   @Query("type") String type,
                                   @Query("offset") int offset,
                                   @Query("limit") int limit);
}
