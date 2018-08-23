package com.ahmadkamilalmasyhur.pokedex.entity.pokemonmove;

import com.ahmadkamilalmasyhur.pokedex.entity.pokemondetail.VersionGroup;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Machine implements Serializable
{

    @SerializedName("machine")
    @Expose
    private Machine_ machine;
    @SerializedName("version_group")
    @Expose
    private VersionGroup versionGroup;
    private final static long serialVersionUID = -6567794464110830173L;

    public Machine_ getMachine() {
        return machine;
    }

    public void setMachine(Machine_ machine) {
        this.machine = machine;
    }

    public VersionGroup getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(VersionGroup versionGroup) {
        this.versionGroup = versionGroup;
    }

}