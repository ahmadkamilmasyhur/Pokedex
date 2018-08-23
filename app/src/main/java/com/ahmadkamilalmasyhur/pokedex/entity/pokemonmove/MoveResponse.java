package com.ahmadkamilalmasyhur.pokedex.entity.pokemonmove;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MoveResponse implements Serializable {

    @SerializedName("effect_chance")
    @Expose
    private Object effectChance;
    @SerializedName("generation")
    @Expose
    private Generation generation;
    @SerializedName("stat_changes")
    @Expose
    private List<Object> statChanges = null;
    @SerializedName("effect_changes")
    @Expose
    private List<Object> effectChanges = null;
    @SerializedName("names")
    @Expose
    private List<Name> names = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("machines")
    @Expose
    private List<Machine> machines = null;
    @SerializedName("pp")
    @Expose
    private Integer pp;
    @SerializedName("contest_combos")
    @Expose
    private ContestCombos contestCombos;
    @SerializedName("effect_entries")
    @Expose
    private List<EffectEntry> effectEntries = null;
    @SerializedName("contest_type")
    @Expose
    private ContestType contestType;
    @SerializedName("priority")
    @Expose
    private Integer priority;
    @SerializedName("contest_effect")
    @Expose
    private ContestEffect contestEffect;
    @SerializedName("type")
    @Expose
    private Type type;
    @SerializedName("accuracy")
    @Expose
    private Integer accuracy;
    @SerializedName("power")
    @Expose
    private Integer power;
    @SerializedName("past_values")
    @Expose
    private List<PastValue> pastValues = null;
    @SerializedName("target")
    @Expose
    private Target target;
    @SerializedName("super_contest_effect")
    @Expose
    private SuperContestEffect superContestEffect;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("flavor_text_entries")
    @Expose
    private List<FlavorTextEntry> flavorTextEntries = null;
    @SerializedName("damage_class")
    @Expose
    private DamageClass damageClass;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    private final static long serialVersionUID = 8648668130868174340L;

    public Object getEffectChance() {
        return effectChance;
    }

    public void setEffectChance(Object effectChance) {
        this.effectChance = effectChance;
    }

    public Generation getGeneration() {
        return generation;
    }

    public void setGeneration(Generation generation) {
        this.generation = generation;
    }

    public List<Object> getStatChanges() {
        return statChanges;
    }

    public void setStatChanges(List<Object> statChanges) {
        this.statChanges = statChanges;
    }

    public List<Object> getEffectChanges() {
        return effectChanges;
    }

    public void setEffectChanges(List<Object> effectChanges) {
        this.effectChanges = effectChanges;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Machine> getMachines() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    public Integer getPp() {
        return pp;
    }

    public void setPp(Integer pp) {
        this.pp = pp;
    }

    public ContestCombos getContestCombos() {
        return contestCombos;
    }

    public void setContestCombos(ContestCombos contestCombos) {
        this.contestCombos = contestCombos;
    }

    public List<EffectEntry> getEffectEntries() {
        return effectEntries;
    }

    public void setEffectEntries(List<EffectEntry> effectEntries) {
        this.effectEntries = effectEntries;
    }

    public ContestType getContestType() {
        return contestType;
    }

    public void setContestType(ContestType contestType) {
        this.contestType = contestType;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public ContestEffect getContestEffect() {
        return contestEffect;
    }

    public void setContestEffect(ContestEffect contestEffect) {
        this.contestEffect = contestEffect;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public List<PastValue> getPastValues() {
        return pastValues;
    }

    public void setPastValues(List<PastValue> pastValues) {
        this.pastValues = pastValues;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public SuperContestEffect getSuperContestEffect() {
        return superContestEffect;
    }

    public void setSuperContestEffect(SuperContestEffect superContestEffect) {
        this.superContestEffect = superContestEffect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FlavorTextEntry> getFlavorTextEntries() {
        return flavorTextEntries;
    }

    public void setFlavorTextEntries(List<FlavorTextEntry> flavorTextEntries) {
        this.flavorTextEntries = flavorTextEntries;
    }

    public DamageClass getDamageClass() {
        return damageClass;
    }

    public void setDamageClass(DamageClass damageClass) {
        this.damageClass = damageClass;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}
