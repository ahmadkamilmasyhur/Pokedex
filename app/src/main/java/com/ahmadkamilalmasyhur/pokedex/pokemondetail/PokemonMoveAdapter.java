package com.ahmadkamilalmasyhur.pokedex.pokemondetail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ahmadkamilalmasyhur.pokedex.R;
import com.ahmadkamilalmasyhur.pokedex.model.pokemondetail.Move;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PokemonMoveAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Move> moveList = new ArrayList<>();
    private PokemonDetailContract.IPokemonDetailPresenter presenter;

    public PokemonMoveAdapter(PokemonDetailContract.IPokemonDetailPresenter mPresenter) {
        presenter = mPresenter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonMoveViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_pokemon_detail, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        PokemonMoveViewHolder moveViewHolder = (PokemonMoveViewHolder) holder;
        moveViewHolder.bind(moveList.get(position));
    }

    @Override
    public int getItemCount() {
        return moveList.size();
    }

    public void updatePokemonMoves(List<Move> moves) {
        moveList = moves;
        notifyDataSetChanged();
    }

    class PokemonMoveViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txv_view_pokemon_detail)
        TextView moveDetail;

        public PokemonMoveViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bind(final @NonNull Move move) {
            moveDetail.setText(move.getMove().getName());
            moveDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.getPokemonMoveDetailByUrl(move.getMove().getUrl());
                }
            });
        }
    }
}
