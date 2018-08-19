package com.ahmadkamilalmasyhur.pokedex.pokemonindex;

import com.ahmadkamilalmasyhur.pokedex.model.pokemondetail.PokemonDetailResponse;
import com.ahmadkamilalmasyhur.pokedex.model.pokemonlist.PokemonListResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;

import static org.junit.Assert.*;

public class PokemonPresenterTest {

    private PokemonContract.PokemonView view;
    private PokemonPresenter presenter;
    private PokemonListResponse response;

    @Before
    public void setup(){
        response = Mockito.mock(PokemonListResponse.class);
        view = Mockito.mock(PokemonContract.PokemonView.class);
        presenter = new PokemonPresenter(view);
    }


    @Test
    public void processPokemonListResponses(){
        presenter.processPokemonListResponse(response);
    }
}