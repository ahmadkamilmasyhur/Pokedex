package com.ahmadkamilalmasyhur.pokedex.pokemondetail;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ahmadkamilalmasyhur.pokedex.R;
import com.ahmadkamilalmasyhur.pokedex.entity.pokemondetail.Ability;
import com.ahmadkamilalmasyhur.pokedex.entity.pokemondetail.Move;
import com.ahmadkamilalmasyhur.pokedex.entity.pokemondetail.Stat;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PokemonDetailActivity extends AppCompatActivity implements PokemonDetailContract.IPokemonDetailView {

    public static final String POKEMON_ID = "POKEMON_ID";
    PokemonDetailContract.IPokemonDetailPresenter presenter;
    @BindView(R.id.image_slider)
    SliderLayout imageSlider;

    @BindView(R.id.rcv_ability)
    RecyclerView abilityRecycler;
    PokemonAbilityAdapter abilityAdapter;
    LinearLayoutManager abilityLinearLayoutManager;

    @BindView(R.id.rcv_stats)
    RecyclerView statsRecycler;
    PokemonStatsAdapter statsAdapter;
    LinearLayoutManager statsLinearLayoutManager;

    @BindView(R.id.rcv_move)
    RecyclerView moveRecycler;
    PokemonMoveAdapter moveAdapter;
    LinearLayoutManager moveLinearLayoutManager;

    @BindView(R.id.txv_pokemon_type)
    TextView type;
    @BindView(R.id.txv_pokemon_weight)
    TextView weight;
    @BindView(R.id.txv_pokemon_height)
    TextView height;
    @BindView(R.id.txv_pokemon_name)
    TextView pokemonName;
    @BindView(R.id.txv_info_move)
    TextView pokemonMove;
    @BindView(R.id.txv_info_move_detail)
    TextView pokemonMoveDetail;

    @BindView(R.id.pgb_detail_pokemon)
    ProgressBar pokemonDetailProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
        ButterKnife.bind(this);
        setUpPresenter();
        prepareRecyclerView();
        setUpImageSlider();
        setUpBackInHome();
    }

    private void setUpBackInHome() {
        try {
            if (null != getSupportActionBar()) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowHomeEnabled(true);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setUpImageSlider() {
        imageSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        imageSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        imageSlider.setCustomAnimation(new DescriptionAnimation());
        imageSlider.setDuration(5000);
    }

    private void prepareRecyclerView() {
        abilityLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        abilityLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        abilityRecycler.setLayoutManager(abilityLinearLayoutManager);
        abilityAdapter = new PokemonAbilityAdapter();
        abilityRecycler.setAdapter(abilityAdapter);

        statsLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        statsLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        statsRecycler.setLayoutManager(statsLinearLayoutManager);
        statsAdapter = new PokemonStatsAdapter();
        statsRecycler.setAdapter(statsAdapter);

        moveLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        moveLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        moveRecycler.setLayoutManager(moveLinearLayoutManager);
        moveAdapter = new PokemonMoveAdapter(presenter);
        moveRecycler.setAdapter(moveAdapter);
    }


    public void addImageToSlide(String description, String link) {
        TextSliderView textSliderView = new TextSliderView(getApplicationContext());
        textSliderView.setPicasso(Picasso.get());
        textSliderView
                .description(description)
                .image(link)
                .setScaleType(BaseSliderView.ScaleType.Fit);

        imageSlider.addSlider(textSliderView);
    }

    @Override
    public void updatePokemonAbility(List<Ability> pokemonAbility) {
        abilityAdapter.updatePokemonAbilityList(pokemonAbility);
    }

    @Override
    public void updatePokemonStats(List<Stat> pokemonStats) {
        statsAdapter.updatePokemonStatsList(pokemonStats);
    }

    @Override
    public void updatePokemonMoves(List<Move> moves) {
        moveAdapter.updatePokemonMoves(moves);
    }

    @Override
    public void setPokemonType(String name) {
        type.setText(name);
    }

    @Override
    public void setPokemonWeight(String s) {
        weight.setText(s);
    }

    @Override
    public void setPokemonHeight(String s) {
        height.setText(s);
    }

    @Override
    public void setPokemonName(String name) {
        pokemonName.setText(name);
    }

    @Override
    public void setPokemonMove(String move) {
        pokemonMove.setText(move);
    }

    @Override
    public void setPokemonMoveDetail(String detail) {
        pokemonMoveDetail.setText(detail);
    }

    public void togglePokemonDetailProgressGone() {
        pokemonDetailProgressBar.setVisibility(View.GONE);
    }

    public void togglePokemonDetailProgressVisible() {
        pokemonDetailProgressBar.setVisibility(View.VISIBLE);
    }


    @Override
    public void showShortErrorSnackbarMessage(String message) {
        if (message.contains("<!DOCTYPE html>")) {
            message = getResources().getString(R.string.error_1);
        } else {
            message = getResources().getString(R.string.response_error);
        }
        Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
    }

    private void setUpPresenter() {
        presenter = new PokemonDetailPresenter(this);
        presenter.setPokemonNameForData(getIntent().getStringExtra(POKEMON_ID));
        presenter.getPokemonDataByName();
    }

    @Override
    public void setPresenter(PokemonDetailContract.IPokemonDetailPresenter mPresenter) {
        presenter = mPresenter;
    }

    @Override
    protected void onStop() {
        super.onStop();
        imageSlider.stopAutoCycle();
    }
}
