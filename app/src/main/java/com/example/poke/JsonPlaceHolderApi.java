package com.example.poke;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @GET("codigo")
    Call<List<Pokemon>> getPokemons();

    @POST("crear")
    Call<Pokemon> createPokemon(Pokemon pokemon);
}
