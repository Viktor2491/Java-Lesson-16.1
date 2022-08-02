package ru.netology.tournament;

public class Player {
    protected int id;
    protected String name;
    protected int strength;

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public String getName() {
        return name;
    }

    //Сделал не акктивным, т.к. по условию нам нужны только getStrength и getName

    //  public int getId() {
    //     return id;
    //  }

    // public void setId(int id) {
    //     this.id = id;
    //}

    // public void setName(String name) {
    //    this.name = name;
    // }

    // public void setStrength(int strength) {
    //    this.strength = strength;
    //}
}


