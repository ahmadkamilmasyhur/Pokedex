package com.ahmadkamilalmasyhur.pokedex.model.pokemonmove;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class EffectEntry implements Serializable
{

    @SerializedName("short_effect")
    @Expose
    private String shortEffect;
    @SerializedName("effect")
    @Expose
    private String effect;
    @SerializedName("language")
    @Expose
    private Language_ language;
    private final static long serialVersionUID = -3311999138877454660L;

    public String getShortEffect() {
        return shortEffect;
    }

    public void setShortEffect(String shortEffect) {
        this.shortEffect = shortEffect;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public Language_ getLanguage() {
        return language;
    }

    public void setLanguage(Language_ language) {
        this.language = language;
    }

}
