package com.example.willisproject2cs360;

public class Weight
{
    int id;
    String weight;

    public Weight() {super();}
    public Weight(int id,  String weight) {
        super();
        this.id = id;
        this.weight = weight;

    }

    public Weight( String weight) {
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setWeight(String weight) {
    this.weight = weight;
    }
}
