package com.ahmadkamilalmasyhur.pokedex.pokemondetail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ahmadkamilalmasyhur.pokedex.R;
import com.ahmadkamilalmasyhur.pokedex.entity.pokemondetail.Stat;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PokemonStatsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Stat> stats = new ArrayList<>();

    public PokemonStatsAdapter() {
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonDetailViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_pokemon_detail, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PokemonDetailViewHolder pokemonDetailViewHolder = (PokemonDetailViewHolder) holder;
        pokemonDetailViewHolder.bind(stats.get(position));
    }

    @Override
    public int getItemCount() {
        return stats.size();
    }

    public void updatePokemonStatsList(List<Stat> pokemonStats) {
        stats = pokemonStats;
        notifyDataSetChanged();
    }

    class PokemonDetailViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txv_view_pokemon_detail)
        TextView statsDetail;

        public PokemonDetailViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bind(final @NonNull Stat stat) {
            String concate = stat.getStat().getName() + " :" +
                    "\n\teffort : " + stat.getEffort() +
                    "\n\tbase stat : " + stat.getBaseStat();
            statsDetail.setText(concate);

        }
    }
}
