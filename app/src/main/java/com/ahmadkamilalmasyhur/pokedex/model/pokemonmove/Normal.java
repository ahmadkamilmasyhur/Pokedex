package com.ahmadkamilalmasyhur.pokedex.model.pokemonmove;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Normal implements Serializable
{

    @SerializedName("use_after")
    @Expose
    private List<UseAfter> useAfter = null;
    @SerializedName("use_before")
    @Expose
    private Object useBefore;
    private final static long serialVersionUID = -2086884609654782804L;

    public List<UseAfter> getUseAfter() {
        return useAfter;
    }

    public void setUseAfter(List<UseAfter> useAfter) {
        this.useAfter = useAfter;
    }

    public Object getUseBefore() {
        return useBefore;
    }

    public void setUseBefore(Object useBefore) {
        this.useBefore = useBefore;
    }

}