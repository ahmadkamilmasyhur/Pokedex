package com.ahmadkamilalmasyhur.pokedex.model.pokemonmove;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ContestCombos implements Serializable
{

    @SerializedName("super")
    @Expose
    private Super _super;
    @SerializedName("normal")
    @Expose
    private Normal normal;
    private final static long serialVersionUID = -7009320003025628811L;

    public Super getSuper() {
        return _super;
    }

    public void setSuper(Super _super) {
        this._super = _super;
    }

    public Normal getNormal() {
        return normal;
    }

    public void setNormal(Normal normal) {
        this.normal = normal;
    }

}