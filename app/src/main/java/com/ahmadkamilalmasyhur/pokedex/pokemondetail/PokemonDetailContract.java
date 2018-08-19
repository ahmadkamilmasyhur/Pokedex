package com.ahmadkamilalmasyhur.pokedex.pokemondetail;

import com.ahmadkamilalmasyhur.pokedex.BasePresenter;
import com.ahmadkamilalmasyhur.pokedex.BaseView;
import com.ahmadkamilalmasyhur.pokedex.model.pokemondetail.Ability;
import com.ahmadkamilalmasyhur.pokedex.model.pokemondetail.Move;
import com.ahmadkamilalmasyhur.pokedex.model.pokemondetail.Stat;

import java.util.List;

public interface PokemonDetailContract {
    interface IPokemonDetailView extends BaseView<IPokemonDetailPresenter> {
        void addImageToSlide(String description, String link);

        void updatePokemonAbility(List<Ability> pokemonAbility);

        void updatePokemonStats(List<Stat> pokemonStats);

        void setPokemonType(String name);

        void setPokemonWeight(String s);

        void setPokemonHeight(String s);

        void setPokemonName(String name);

        void setPokemonMove(String move);

        void updatePokemonMoves(List<Move> moves);

        void setPokemonMoveDetail(String detail);

        void showShortErrorSnackbarMessage(String message);
    }

    interface IPokemonDetailPresenter extends BasePresenter {
        void setPokemonNameForData(String stringExtra);

        void getPokemonDataByName();

        void getPokemonMoveDetailByUrl(String url);
    }
}
