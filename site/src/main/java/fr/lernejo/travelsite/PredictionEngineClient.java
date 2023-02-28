package fr.lernejo.travelsite;

import org.springframework.context.annotation.Bean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface PredictionEngineClient{
    @GET("api/temperature")
    Call<PredictionRest> prediction(@Query("country") String country);
}
