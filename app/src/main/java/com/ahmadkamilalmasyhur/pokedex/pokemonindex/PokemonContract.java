package com.ahmadkamilalmasyhur.pokedex.pokemonindex;

import com.ahmadkamilalmasyhur.pokedex.BasePresenter;
import com.ahmadkamilalmasyhur.pokedex.BaseView;
import com.ahmadkamilalmasyhur.pokedex.model.pokemonlist.Pokemon;

import java.util.List;

public interface PokemonContract {
    interface PokemonView extends BaseView <PokemonPresenter>{
        void updateDataSource(List<Pokemon> pokemons);

        void showShortErrorSnackbarMessage(String message);
    }
    interface PokemonPresenter extends BasePresenter {
        void getListPokemonByIndex(int limit, int offset);
        void getNextListPokemon();
    }
}
