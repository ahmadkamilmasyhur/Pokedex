package com.ahmadkamilalmasyhur.pokedex.entity.pokemonmove;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SuperContestEffect implements Serializable
{

    @SerializedName("url")
    @Expose
    private String url;
    private final static long serialVersionUID = 5790380996491036571L;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}