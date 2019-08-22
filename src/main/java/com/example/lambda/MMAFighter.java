package com.example.lambda;

public class MMAFighter {

    private String name;
    private int stamina;
    private int fightSkill;

    public MMAFighter(String name, int stamina, int fightSkill) {
        this.name = name;
        this.stamina = stamina;
        this.fightSkill = fightSkill;
    }

    public MMAFighter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getFightSkill() {
        return fightSkill;
    }

    public void setFightSkill(int fightSkill) {
        this.fightSkill = fightSkill;
    }

    @Override
    public String toString() {
        return "MMAFighter{" +
                "name='" + name + '\'' +
                ", stamina=" + stamina +
                ", fightSkill=" + fightSkill +
                '}';
    }
}
