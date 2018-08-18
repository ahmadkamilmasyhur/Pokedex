package com.ahmadkamilalmasyhur.pokedex.model.pokemonmove;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ContestEffect implements Serializable
{

    @SerializedName("url")
    @Expose
    private String url;
    private final static long serialVersionUID = 886471823751816954L;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}