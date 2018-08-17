package com.ahmadkamilalmasyhur.pokedex.pokemonindex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ahmadkamilalmasyhur.pokedex.R;
import com.ahmadkamilalmasyhur.pokedex.model.pokemonlist.Pokemon;

import java.lang.ref.WeakReference;
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
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_pokemon_list,parent,false), parent.getContext());
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

        WeakReference<Context> context;
        @BindView(R.id.txv_view_pokemon_name)
        TextView pokemonName;

        private PokemonViewHolder(View itemView, Context mContext) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = new WeakReference<>(mContext);
        }

        private void bind(final Pokemon pokemon){
            pokemonName.setText(pokemon.getName());
        }
    }
}
