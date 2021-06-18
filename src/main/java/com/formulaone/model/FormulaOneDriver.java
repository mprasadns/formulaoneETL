package com.formulaone.model;

public class FormulaOneDriver {

    private String name;
    private double lap;

    public FormulaOneDriver(String name, double lap) {
        this.name = name;
        this.lap = lap;
    }

    public String getName() {
        return name;
    }

    public double getLap() {
        return lap;
    }

    public void setLap(double lap) {
        this.lap = lap;
    }
}
