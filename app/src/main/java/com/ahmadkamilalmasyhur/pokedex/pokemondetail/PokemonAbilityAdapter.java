package com.ahmadkamilalmasyhur.pokedex.pokemondetail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.ahmadkamilalmasyhur.pokedex.R;
import com.ahmadkamilalmasyhur.pokedex.model.pokemondetail.Ability;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PokemonAbilityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Ability> abilities = new ArrayList<>();

    public PokemonAbilityAdapter() {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonDetailViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_pokemon_detail,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PokemonDetailViewHolder pokemonDetailViewHolder = (PokemonDetailViewHolder) holder;
        pokemonDetailViewHolder.bind(abilities.get(position));
    }

    @Override
    public int getItemCount() {
        return abilities.size();
    }

    public void updatePokemonAbilityList(List<Ability> pokemonAbility) {
        abilities = pokemonAbility;
        notifyDataSetChanged();
    }

    class PokemonDetailViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txv_view_pokemon_detail)
        TextView abilityDetail;

        public PokemonDetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final Ability ability) {
            abilityDetail.setText(ability.getAbility().getName());
        }
    }
}
