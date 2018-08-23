package com.ahmadkamilalmasyhur.pokedex.entity.pokemonmove;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Meta implements Serializable
{

    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("healing")
    @Expose
    private Integer healing;
    @SerializedName("max_turns")
    @Expose
    private Object maxTurns;
    @SerializedName("drain")
    @Expose
    private Integer drain;
    @SerializedName("ailment")
    @Expose
    private Ailment ailment;
    @SerializedName("stat_chance")
    @Expose
    private Integer statChance;
    @SerializedName("flinch_chance")
    @Expose
    private Integer flinchChance;
    @SerializedName("min_hits")
    @Expose
    private Object minHits;
    @SerializedName("ailment_chance")
    @Expose
    private Integer ailmentChance;
    @SerializedName("crit_rate")
    @Expose
    private Integer critRate;
    @SerializedName("min_turns")
    @Expose
    private Object minTurns;
    @SerializedName("max_hits")
    @Expose
    private Object maxHits;
    private final static long serialVersionUID = 5227790666484167726L;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getHealing() {
        return healing;
    }

    public void setHealing(Integer healing) {
        this.healing = healing;
    }

    public Object getMaxTurns() {
        return maxTurns;
    }

    public void setMaxTurns(Object maxTurns) {
        this.maxTurns = maxTurns;
    }

    public Integer getDrain() {
        return drain;
    }

    public void setDrain(Integer drain) {
        this.drain = drain;
    }

    public Ailment getAilment() {
        return ailment;
    }

    public void setAilment(Ailment ailment) {
        this.ailment = ailment;
    }

    public Integer getStatChance() {
        return statChance;
    }

    public void setStatChance(Integer statChance) {
        this.statChance = statChance;
    }

    public Integer getFlinchChance() {
        return flinchChance;
    }

    public void setFlinchChance(Integer flinchChance) {
        this.flinchChance = flinchChance;
    }

    public Object getMinHits() {
        return minHits;
    }

    public void setMinHits(Object minHits) {
        this.minHits = minHits;
    }

    public Integer getAilmentChance() {
        return ailmentChance;
    }

    public void setAilmentChance(Integer ailmentChance) {
        this.ailmentChance = ailmentChance;
    }

    public Integer getCritRate() {
        return critRate;
    }

    public void setCritRate(Integer critRate) {
        this.critRate = critRate;
    }

    public Object getMinTurns() {
        return minTurns;
    }

    public void setMinTurns(Object minTurns) {
        this.minTurns = minTurns;
    }

    public Object getMaxHits() {
        return maxHits;
    }

    public void setMaxHits(Object maxHits) {
        this.maxHits = maxHits;
    }

}