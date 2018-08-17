package com.ahmadkamilalmasyhur.pokedex.pokemonindex;

import com.ahmadkamilalmasyhur.pokedex.model.pokemonlist.PokemonListResponse;
import com.ahmadkamilalmasyhur.pokedex.model.pokemonlist.Pokemon;
import com.ahmadkamilalmasyhur.pokedex.utils.retrofit.ApiClient;
import com.ahmadkamilalmasyhur.pokedex.utils.retrofit.pokeapi.v2.iPokemon;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonPresenter implements PokemonContract.PokemonPresenter {

    private PokemonContract.PokemonView pokemonView;

    public PokemonPresenter(PokemonContract.PokemonView view) {
        pokemonView = view;
        pokemonView.setPresenter(this);
    }

    @Override
    public void start() {
        getListPokemonByIndex(20, 0);
    }

    @Override
    public void getListPokemonByIndex(int limit, int offset){
        iPokemon apiService = ApiClient.getClient().create(iPokemon.class);
        Call<PokemonListResponse> call = apiService.getPokemon(String.valueOf(limit), String.valueOf(offset));
        call.enqueue(new Callback<PokemonListResponse>() {
            @Override
            public void onResponse(Call<PokemonListResponse> call, Response<PokemonListResponse> response) {
                processServerResponse(response);
            }

            @Override
            public void onFailure(Call<PokemonListResponse> call, Throwable t) {

            }
        });
    }

    private void processServerResponse(Response<PokemonListResponse> response) {
        String responseS = "{\"count\":949,\"previous\":null,\"results\":[{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/1\\/\",\"name\":\"bulbasaur\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/2\\/\",\"name\":\"ivysaur\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/3\\/\",\"name\":\"venusaur\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/4\\/\",\"name\":\"charmander\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/5\\/\",\"name\":\"charmeleon\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/6\\/\",\"name\":\"charizard\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/7\\/\",\"name\":\"squirtle\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/8\\/\",\"name\":\"wartortle\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/9\\/\",\"name\":\"blastoise\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/10\\/\",\"name\":\"caterpie\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/11\\/\",\"name\":\"metapod\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/12\\/\",\"name\":\"butterfree\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/13\\/\",\"name\":\"weedle\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/14\\/\",\"name\":\"kakuna\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/15\\/\",\"name\":\"beedrill\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/16\\/\",\"name\":\"pidgey\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/17\\/\",\"name\":\"pidgeotto\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/18\\/\",\"name\":\"pidgeot\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/19\\/\",\"name\":\"rattata\"},{\"url\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/20\\/\",\"name\":\"raticate\"}],\"next\":\"https:\\/\\/pokeapi.co\\/api\\/v2\\/pokemon\\/?limit=20&offset=20\"}";
        Gson gson = new Gson();
        List<Pokemon> sd = gson.fromJson(responseS, PokemonListResponse.class).getResults();
        pokemonView.updateDataSource(sd);
//        if (response.code() == HttpsURLConnection.HTTP_OK){
//            List<Pokemon> pokemons = response.body().getResults();
//            pokemonView.updateDataSource(pokemons);
//        } else {
//            pokemonView.showShortErrorSnackbarMessage(response.message());
//        }
    }
}
