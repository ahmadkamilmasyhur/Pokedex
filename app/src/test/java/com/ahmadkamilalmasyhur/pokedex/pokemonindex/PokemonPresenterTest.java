package com.ahmadkamilalmasyhur.pokedex.pokemonindex;

import com.ahmadkamilalmasyhur.pokedex.entity.pokemonlist.Pokemon;
import com.ahmadkamilalmasyhur.pokedex.entity.pokemonlist.PokemonListResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/*
 * Test For PokemonIndex Package
 */
public class PokemonPresenterTest {

    private PokemonContract.PokemonView view;
    private PokemonPresenter presenter;
    private PokemonListResponse response;

    @Before
    public void setup(){
        view = Mockito.mock(PokemonContract.PokemonView.class);
        presenter = new PokemonPresenter(view);
    }


    @Test
    public void testProcessPokemonListResponses(){
        presenter.getNextListPokemon();
        Mockito.verify(view).showShortErrorSnackbarMessage("No More Data Provided");
    }
}