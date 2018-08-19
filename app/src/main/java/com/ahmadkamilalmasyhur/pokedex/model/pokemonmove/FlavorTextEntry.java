package com.ahmadkamilalmasyhur.pokedex.model.pokemonmove;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FlavorTextEntry implements Serializable
{

    @SerializedName("flavor_text")
    @Expose
    private String flavorText;
    @SerializedName("language")
    @Expose
    private Language__ language;
    @SerializedName("version_group")
    @Expose
    private VersionGroup__ versionGroup;
    private final static long serialVersionUID = 8108391598204095099L;

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public Language__ getLanguage() {
        return language;
    }

    public void setLanguage(Language__ language) {
        this.language = language;
    }

    public VersionGroup__ getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(VersionGroup__ versionGroup) {
        this.versionGroup = versionGroup;
    }

}
