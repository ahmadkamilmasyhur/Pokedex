package com.ahmadkamilalmasyhur.pokedex.model.pokemondetail;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class VersionGroupDetail implements Serializable
{

    @SerializedName("move_learn_method")
    @Expose
    private MoveLearnMethod moveLearnMethod;
    @SerializedName("level_learned_at")
    @Expose
    private Integer levelLearnedAt;
    @SerializedName("version_group")
    @Expose
    private VersionGroup versionGroup;
    private final static long serialVersionUID = 746913651898080550L;

    public MoveLearnMethod getMoveLearnMethod() {
        return moveLearnMethod;
    }

    public void setMoveLearnMethod(MoveLearnMethod moveLearnMethod) {
        this.moveLearnMethod = moveLearnMethod;
    }

    public Integer getLevelLearnedAt() {
        return levelLearnedAt;
    }

    public void setLevelLearnedAt(Integer levelLearnedAt) {
        this.levelLearnedAt = levelLearnedAt;
    }

    public VersionGroup getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(VersionGroup versionGroup) {
        this.versionGroup = versionGroup;
    }

}