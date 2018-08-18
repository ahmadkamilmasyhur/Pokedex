package com.ahmadkamilalmasyhur.pokedex.model.pokemondetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Move implements Serializable
{

    @SerializedName("version_group_details")
    @Expose
    private List<VersionGroupDetail> versionGroupDetails = null;
    @SerializedName("move")
    @Expose
    private MoveDetail move;
    private static long serialVersionUID = -7996507903524273606L;

    public List<VersionGroupDetail> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    public void setVersionGroupDetails(List<VersionGroupDetail> versionGroupDetails) {
        this.versionGroupDetails = versionGroupDetails;
    }

    public MoveDetail getMove() {
        return move;
    }

    public void setMove(MoveDetail move) {
        this.move = move;
    }

}
