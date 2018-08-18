package com.ahmadkamilalmasyhur.pokedex.model.pokemonmove;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Name implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("language")
    @Expose
    private Language language;
    private final static long serialVersionUID = 3503832090251985429L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

}