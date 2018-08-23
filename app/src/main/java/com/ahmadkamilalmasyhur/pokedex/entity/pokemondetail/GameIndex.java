package com.ahmadkamilalmasyhur.pokedex.entity.pokemondetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GameIndex implements Serializable
{

    @SerializedName("version")
    @Expose
    private Version version;
    @SerializedName("game_index")
    @Expose
    private Integer gameIndex;
    private final static long serialVersionUID = 2927269210578951345L;

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    public Integer getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(Integer gameIndex) {
        this.gameIndex = gameIndex;
    }

}