package com.ahmadkamilalmasyhur.pokedex.model.pokemonmove;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Machine_ implements Serializable
{

    @SerializedName("url")
    @Expose
    private String url;
    private final static long serialVersionUID = -5832299512554357169L;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}