package com.ahmadkamilalmasyhur.pokedex.pokemonindex;

import com.ahmadkamilalmasyhur.pokedex.BasePresenter;
import com.ahmadkamilalmasyhur.pokedex.BaseView;
import com.ahmadkamilalmasyhur.pokedex.entity.pokemonlist.Pokemon;

import java.util.List;

public interface PokemonContract {
    interface PokemonView extends BaseView<PokemonPresenter> {
        void updateDataSource(List<Pokemon> pokemons);

        void showShortErrorSnackbarMessage(String message);

        void togglePokemonDetailProgressGone();

        void togglePokemonDetailProgressVisible();
    }

    interface PokemonPresenter extends BasePresenter {

        void getNextListPokemon();
    }
}
