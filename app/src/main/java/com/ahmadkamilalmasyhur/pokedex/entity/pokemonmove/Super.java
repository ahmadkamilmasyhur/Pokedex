package com.ahmadkamilalmasyhur.pokedex.entity.pokemonmove;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Super implements Serializable
{

    @SerializedName("use_after")
    @Expose
    private Object useAfter;
    @SerializedName("use_before")
    @Expose
    private Object useBefore;
    private final static long serialVersionUID = 1407278391842345847L;

    public Object getUseAfter() {
        return useAfter;
    }

    public void setUseAfter(Object useAfter) {
        this.useAfter = useAfter;
    }

    public Object getUseBefore() {
        return useBefore;
    }

    public void setUseBefore(Object useBefore) {
        this.useBefore = useBefore;
    }

}