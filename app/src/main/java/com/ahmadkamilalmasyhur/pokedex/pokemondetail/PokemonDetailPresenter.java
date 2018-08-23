package com.ahmadkamilalmasyhur.pokedex.pokemondetail;

import com.ahmadkamilalmasyhur.pokedex.entity.pokemondetail.Ability;
import com.ahmadkamilalmasyhur.pokedex.entity.pokemondetail.Move;
import com.ahmadkamilalmasyhur.pokedex.entity.pokemondetail.PokemonDetailResponse;
import com.ahmadkamilalmasyhur.pokedex.entity.pokemondetail.Stat;
import com.ahmadkamilalmasyhur.pokedex.entity.pokemondetail.Type;
import com.ahmadkamilalmasyhur.pokedex.entity.pokemonmove.MoveResponse;
import com.ahmadkamilalmasyhur.pokedex.utils.retrofit.ApiClient;
import com.ahmadkamilalmasyhur.pokedex.utils.retrofit.pokeapi.v2.iPokemon;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonDetailPresenter implements PokemonDetailContract.IPokemonDetailPresenter {
    private PokemonDetailContract.IPokemonDetailView pokemonDetailView;
    private String pokemonName = "";

    public PokemonDetailPresenter(PokemonDetailContract.IPokemonDetailView IPokemonDetailView) {
        pokemonDetailView = IPokemonDetailView;
        pokemonDetailView.setPresenter(this);
    }

    @Override
    public void setPokemonNameForData(String stringExtra) {
        pokemonName = stringExtra;
    }

    public void getPokemonDataByName() {
        pokemonDetailView.togglePokemonDetailProgressVisible();
        iPokemon apiService = ApiClient.getClient().create(iPokemon.class);
        Call<PokemonDetailResponse> call = apiService.getPokemonByName(pokemonName);
        call.enqueue(new Callback<PokemonDetailResponse>() {
            @Override
            public void onResponse(Call<PokemonDetailResponse> call, Response<PokemonDetailResponse> response) {
                processServerResponse(response);
                pokemonDetailView.togglePokemonDetailProgressGone();
            }

            @Override
            public void onFailure(Call<PokemonDetailResponse> call, Throwable t) {
                pokemonDetailView.togglePokemonDetailProgressGone();
            }
        });
    }

    @Override
    public void getPokemonMoveDetailByUrl(String url) {
        String id = url.substring(31);
        getPokemonMoveDetailById(id.replace("/", ""));
    }

    private void getPokemonMoveDetailById(String moveId) {
        pokemonDetailView.togglePokemonDetailProgressVisible();
        iPokemon apiService = ApiClient.getClient().create(iPokemon.class);
        Call<MoveResponse> call = apiService.getPokemonMoveById(moveId);
        call.enqueue(new Callback<MoveResponse>() {
            @Override
            public void onResponse(Call<MoveResponse> call, Response<MoveResponse> response) {
                processServerMoveResponse(response);
                pokemonDetailView.togglePokemonDetailProgressGone();
            }

            @Override
            public void onFailure(Call<MoveResponse> call, Throwable t) {
                pokemonDetailView.togglePokemonDetailProgressGone();
            }
        });
    }

    private void processServerMoveResponse(Response<MoveResponse> response) {
        if (response.code() == HttpsURLConnection.HTTP_OK) {
            MoveResponse moveDetailResponse = response.body();
            if (null != moveDetailResponse) {
                String accuracy = checkIfValueIsNotNull(moveDetailResponse.getAccuracy());
                String critRate = checkIfValueIsNotNull(moveDetailResponse.getMeta().getCritRate());
                String healing = checkIfValueIsNotNull(moveDetailResponse.getMeta().getHealing());
                String category = moveDetailResponse.getMeta().getCategory().getName();
                String demageClass = moveDetailResponse.getDamageClass().getName();
                String power = checkIfValueIsNotNull(moveDetailResponse.getPower());
                String effect = moveDetailResponse.getEffectEntries().get(0).getEffect();
                String shortEffect = moveDetailResponse.getEffectEntries().get(0).getShortEffect();
                StringBuilder stringBuilder = new StringBuilder();

                stringBuilder.append("Short Effect : " + shortEffect + "\nEffect : " + effect);

                for (int i = 0; i < moveDetailResponse.getFlavorTextEntries().size(); i++) {
                    if (moveDetailResponse.getFlavorTextEntries().get(i).getLanguage().getName().equalsIgnoreCase("en")) {
                        String concate = "\n" + moveDetailResponse.getFlavorTextEntries().get(i).getVersionGroup().getName() + " : " +
                                moveDetailResponse.getFlavorTextEntries().get(i).getFlavorText().replaceAll("\n", "");
                        stringBuilder.append(concate);
                    }
                }
                pokemonDetailView.setPokemonMoveDetail(stringBuilder.toString());

                pokemonDetailView.setPokemonMove("Accuracy : " + accuracy +
                        "\nCritical Rate : " + critRate +
                        "\nHealing : " + healing +
                        "\nCategory : " + category +
                        "\nDemage Class : " + demageClass +
                        "\nPower : " + power
                );
            }
        } else {
            pokemonDetailView.showShortErrorSnackbarMessage("");
        }
    }

    private String checkIfValueIsNotNull(Integer s) {
        String newValue = "-";
        try {
            if (null != s) {
                newValue = String.valueOf(s);
            }
        } catch (NullPointerException e) {
            newValue = "-";
        }
        return newValue;
    }

    private void processServerResponse(Response<PokemonDetailResponse> response) {
        if (response.code() == HttpsURLConnection.HTTP_OK) {
            PokemonDetailResponse detailResponse = response.body();
            if (null != detailResponse){
                addImageToSlider(detailResponse);
                setPokemonType(detailResponse.getTypes());
                setPokemonHeight(detailResponse.getHeight());
                setPokemonWeight(detailResponse.getWeight());
                setPokemonAbility(detailResponse.getAbilities());
                setPokemonStats(detailResponse.getStats());
                setPokemonMoves(detailResponse.getMoves());
                setPokemonNameAndExp(detailResponse.getName(), detailResponse.getBaseExperience());
            } else {
                pokemonDetailView.showShortErrorSnackbarMessage("");
            }
        } else {
            pokemonDetailView.showShortErrorSnackbarMessage("");
        }
    }

    private void setPokemonMoves(List<Move> moves) {
        pokemonDetailView.updatePokemonMoves(moves);
    }

    private void setPokemonNameAndExp(String name, Integer baseExperience) {
        pokemonDetailView.setPokemonName(capitalizeFirstSentence(name) + " (Exp : " + baseExperience + ")");
    }

    private void setPokemonStats(List<Stat> stats) {
        pokemonDetailView.updatePokemonStats(stats);
    }

    private void setPokemonAbility(List<Ability> abilities) {
        pokemonDetailView.updatePokemonAbility(abilities);
    }

    private void setPokemonWeight(double weight) {
        pokemonDetailView.setPokemonWeight(String.valueOf(weight));
    }

    private void setPokemonHeight(double height) {
        pokemonDetailView.setPokemonHeight(String.valueOf(height));
    }

    private void setPokemonType(List<Type> types) {
        if (null != types) {
            if (types.size() > 1) {
                String type1 = types.get(0).getType().getName() + " / ";
                String type2 = types.get(1).getType().getName();
                pokemonDetailView.setPokemonType(capitalizeFirstSentence(type1) +
                        capitalizeFirstSentence(type2));
            } else {
                String type = types.get(0).getType().getName();
                pokemonDetailView.setPokemonType(capitalizeFirstSentence(type));
            }
        }
    }

    private void addImageToSlider(PokemonDetailResponse detailResponse) {
        String linkUrl = detailResponse.getSprites().getFrontDefault();
        String name = detailResponse.getName() + " Front Default";
        pokemonDetailView.addImageToSlide(capitalizeFirstSentence(name), linkUrl);

        linkUrl = detailResponse.getSprites().getBackDefault();
        name = detailResponse.getName() + " Back Default";
        pokemonDetailView.addImageToSlide(capitalizeFirstSentence(name), linkUrl);

        linkUrl = detailResponse.getSprites().getFrontShiny();
        name = detailResponse.getName() + " Front Shiny";
        pokemonDetailView.addImageToSlide(capitalizeFirstSentence(name), linkUrl);

        linkUrl = detailResponse.getSprites().getBackShiny();
        name = detailResponse.getName() + " Back Shiny";
        pokemonDetailView.addImageToSlide(capitalizeFirstSentence(name), linkUrl);
    }

    private String capitalizeFirstSentence(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

}
