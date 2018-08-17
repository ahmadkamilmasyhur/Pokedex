package com.ahmadkamilalmasyhur.pokedex.pokemonindex;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ahmadkamilalmasyhur.pokedex.R;
import com.ahmadkamilalmasyhur.pokedex.model.pokemonlist.Pokemon;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PokemonActivity extends AppCompatActivity implements PokemonContract.PokemonView {

    @BindView(R.id.rcv_list_pokemon)
    RecyclerView pokemonRecyclerView;
    private List<Pokemon> pokemonList = new ArrayList<>();
    private PokemonPresenter presenter;
    PokemonAdapter adapter;
    private final int limit = 20;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        ButterKnife.bind(this);
        presenter = new PokemonPresenter(this);
        prepareRecyclerView();
        presenter.start();
        pokemonRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (linearLayoutManager.findLastVisibleItemPosition() == pokemonList.size()) {
                    presenter.getListPokemonByIndex(limit, pokemonList.size()+limit);
                }
            }
        });
    }

    private void prepareRecyclerView() {
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        pokemonRecyclerView.setLayoutManager(linearLayoutManager);
        adapter = new PokemonAdapter(pokemonList);
        pokemonRecyclerView.setAdapter(adapter);
    }

    @Override
    public void setPresenter(PokemonContract.PokemonPresenter mPresenter) {
        presenter = (PokemonPresenter) mPresenter;
    }

    @Override
    public void updateDataSource(List<Pokemon> pokemons) {
        adapter.updatePokemonDataSource(pokemons);
    }

    @Override
    public void showShortErrorSnackbarMessage(String message) {
        if (!message.equalsIgnoreCase("")){
            Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
        } else {
            Snackbar.make(findViewById(android.R.id.content), getResources().getText(R.string.response_error), Snackbar.LENGTH_SHORT).show();
        }
    }
}