package com.ahmadkamilalmasyhur.pokedex.utils.retrofit.pokeapi.v2;

import com.ahmadkamilalmasyhur.pokedex.entity.pokemondetail.PokemonDetailResponse;
import com.ahmadkamilalmasyhur.pokedex.entity.pokemonlist.PokemonListResponse;
import com.ahmadkamilalmasyhur.pokedex.entity.pokemonmove.MoveResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface iPokemon {
    @Headers("Accept: application/json")
    @GET("pokemon/")
    Call<PokemonListResponse> getPokemon(@Query("limit") String limit, @Query("offset") String offset);

    @Headers("Accept: application/json")
    @GET("pokemon/{id}")
    Call<PokemonDetailResponse> getPokemonById(@Path("id") String id);

    @Headers("Accept: application/json")
    @GET("pokemon/{name}")
    Call<PokemonDetailResponse> getPokemonByName(@Path("name") String name);

    @Headers("Accept: application/json")
    @GET("move/{id}/")
    Call<MoveResponse> getPokemonMoveById(@Path("id") String id);
}
