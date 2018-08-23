package com.ahmadkamilalmasyhur.pokedex.pokemonindex;

import com.ahmadkamilalmasyhur.pokedex.entity.pokemonlist.Pokemon;
import com.ahmadkamilalmasyhur.pokedex.entity.pokemonlist.PokemonListResponse;
import com.ahmadkamilalmasyhur.pokedex.utils.retrofit.ApiClient;
import com.ahmadkamilalmasyhur.pokedex.utils.retrofit.pokeapi.v2.iPokemon;

import java.io.IOException;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonPresenter implements PokemonContract.PokemonPresenter {

    private PokemonContract.PokemonView pokemonView;
    private final int limit = 20;
    private int offset = 0;
    private int maximumPokemonData = 20;

    public PokemonPresenter(PokemonContract.PokemonView view) {
        pokemonView = view;
        pokemonView.setPresenter(this);
    }

    private void getListPokemonByIndex(int limit, int offset) {
        pokemonView.togglePokemonDetailProgressVisible();
        iPokemon apiService = ApiClient.getClient().create(iPokemon.class);
        Call<PokemonListResponse> call = apiService.getPokemon(String.valueOf(limit), String.valueOf(offset));
        if (offset <= maximumPokemonData) {
            call.enqueue(new Callback<PokemonListResponse>() {
                @Override
                public void onResponse(Call<PokemonListResponse> call, Response<PokemonListResponse> response) {
                    processServerResponse(response);
                    pokemonView.togglePokemonDetailProgressGone();
                }

                @Override
                public void onFailure(Call<PokemonListResponse> call, Throwable t) {
                    pokemonView.togglePokemonDetailProgressGone();
                }
            });
        } else {
            pokemonView.showShortErrorSnackbarMessage("No More Data Provided");
            pokemonView.togglePokemonDetailProgressGone();
        }
    }

    private void processServerResponse(Response<PokemonListResponse> response) {
        if (response.code() == HttpsURLConnection.HTTP_OK) {
            if (null != response.body()) {
                processPokemonListResponse(response.body());
            } else {
                pokemonView.showShortErrorSnackbarMessage("");
            }
        } else {
            try {
                if (null != response.errorBody()){
                    pokemonView.showShortErrorSnackbarMessage(response.errorBody().string());
                } else {
                    pokemonView.showShortErrorSnackbarMessage("");
                }
            } catch (IOException e) {
                e.printStackTrace();
                pokemonView.showShortErrorSnackbarMessage("");
            } catch (NullPointerException e) {
                e.printStackTrace();
                pokemonView.showShortErrorSnackbarMessage("");
            }
        }
    }

    private void processPokemonListResponse(PokemonListResponse response) {
        maximumPokemonData = response.getCount();
        List<Pokemon> pokemons = response.getResults();
        if (pokemons.size() > 0) {
            pokemonView.updateDataSource(pokemons);
        }
    }

    @Override
    public void getNextListPokemon() {
        getListPokemonByIndex(limit, (offset += limit));
    }
}
