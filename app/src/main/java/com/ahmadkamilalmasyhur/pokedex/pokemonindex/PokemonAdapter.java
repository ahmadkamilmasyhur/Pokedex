package com.ahmadkamilalmasyhur.pokedex.pokemonindex;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ahmadkamilalmasyhur.pokedex.R;
import com.ahmadkamilalmasyhur.pokedex.entity.pokemonlist.Pokemon;
import com.ahmadkamilalmasyhur.pokedex.pokemondetail.PokemonDetailActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PokemonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Pokemon> pokemon;

    public PokemonAdapter(List<Pokemon> pokemon) {
        this.pokemon = pokemon;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_pokemon_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PokemonViewHolder viewHolder = (PokemonViewHolder) holder;
        viewHolder.bind(pokemon.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }

    public void updatePokemonDataSource(List<Pokemon> pokemonList) {
        pokemon.addAll(pokemonList);
        notifyDataSetChanged();
    }

    class PokemonViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txv_view_pokemon_name)
        TextView pokemonName;

        private PokemonViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bind(final Pokemon pokemon){
            pokemonName.setText(pokemon.getName());
            pokemonName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), PokemonDetailActivity.class);
                    intent.putExtra(PokemonDetailActivity.POKEMON_ID, pokemon.getName());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
