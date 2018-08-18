package com.ahmadkamilalmasyhur.pokedex.model.pokemondetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Stat implements Serializable
{

    @SerializedName("stat")
    @Expose
    private StatDetail stat;
    @SerializedName("effort")
    @Expose
    private Integer effort;
    @SerializedName("base_stat")
    @Expose
    private Integer baseStat;
    private final static long serialVersionUID = 5835842695826307588L;

    public StatDetail getStat() {
        return stat;
    }

    public void setStat(StatDetail stat) {
        this.stat = stat;
    }

    public Integer getEffort() {
        return effort;
    }

    public void setEffort(Integer effort) {
        this.effort = effort;
    }

    public Integer getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(Integer baseStat) {
        this.baseStat = baseStat;
    }

}