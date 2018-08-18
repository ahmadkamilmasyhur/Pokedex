package com.ahmadkamilalmasyhur.pokedex.pokemonindex;

import com.ahmadkamilalmasyhur.pokedex.model.pokemonlist.Pokemon;
import com.ahmadkamilalmasyhur.pokedex.model.pokemonlist.PokemonListResponse;
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
    private int maximumPokemonData = 0;

    public PokemonPresenter(PokemonContract.PokemonView view) {
        pokemonView = view;
        pokemonView.setPresenter(this);
    }

    @Override
    public void start() {
        getListPokemonByIndex(limit, offset);
    }

    @Override
    public void getListPokemonByIndex(int limit, int offset) {
        iPokemon apiService = ApiClient.getClient().create(iPokemon.class);
        Call<PokemonListResponse> call = apiService.getPokemon(String.valueOf(limit), String.valueOf(offset));
        if (offset <= maximumPokemonData) {
            call.enqueue(new Callback<PokemonListResponse>() {
                @Override
                public void onResponse(Call<PokemonListResponse> call, Response<PokemonListResponse> response) {
                    processServerResponse(response);
                }

                @Override
                public void onFailure(Call<PokemonListResponse> call, Throwable t) {

                }
            });
        } else {
            pokemonView.showShortErrorSnackbarMessage("No More Data Provided");
        }
    }

    private void processServerResponse(Response<PokemonListResponse> response) {
        if (response.code() == HttpsURLConnection.HTTP_OK) {
            if (null != response.body()) {
                maximumPokemonData = response.body().getCount();
                List<Pokemon> pokemons = response.body().getResults();
                if (pokemons.size() > 0) {
                    pokemonView.updateDataSource(pokemons);
                }
            } else {
                pokemonView.showShortErrorSnackbarMessage("");
            }
        } else {
            try {
                pokemonView.showShortErrorSnackbarMessage(response.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
                pokemonView.showShortErrorSnackbarMessage("");
            } catch (NullPointerException e) {
                e.printStackTrace();
                pokemonView.showShortErrorSnackbarMessage("");
            }
        }
    }

    @Override
    public void getNextListPokemon() {
        getListPokemonByIndex(limit, (offset += limit));
    }
}
