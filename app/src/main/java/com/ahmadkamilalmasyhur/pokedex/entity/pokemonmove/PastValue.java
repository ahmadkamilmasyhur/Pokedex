package com.ahmadkamilalmasyhur.pokedex.entity.pokemonmove;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PastValue implements Serializable
{

    @SerializedName("pp")
    @Expose
    private Integer pp;
    @SerializedName("power")
    @Expose
    private Object power;
    @SerializedName("effect_entries")
    @Expose
    private List<Object> effectEntries = null;
    @SerializedName("effect_chance")
    @Expose
    private Object effectChance;
    @SerializedName("type")
    @Expose
    private Object type;
    @SerializedName("version_group")
    @Expose
    private VersionGroup_ versionGroup;
    @SerializedName("accuracy")
    @Expose
    private Object accuracy;
    private final static long serialVersionUID = -4214989683784595970L;

    public Integer getPp() {
        return pp;
    }

    public void setPp(Integer pp) {
        this.pp = pp;
    }

    public Object getPower() {
        return power;
    }

    public void setPower(Object power) {
        this.power = power;
    }

    public List<Object> getEffectEntries() {
        return effectEntries;
    }

    public void setEffectEntries(List<Object> effectEntries) {
        this.effectEntries = effectEntries;
    }

    public Object getEffectChance() {
        return effectChance;
    }

    public void setEffectChance(Object effectChance) {
        this.effectChance = effectChance;
    }

    public Object getType() {
        return type;
    }

    public void setType(Object type) {
        this.type = type;
    }

    public VersionGroup_ getVersionGroup() {
        return versionGroup;
    }

    public void setVersionGroup(VersionGroup_ versionGroup) {
        this.versionGroup = versionGroup;
    }

    public Object getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Object accuracy) {
        this.accuracy = accuracy;
    }

}