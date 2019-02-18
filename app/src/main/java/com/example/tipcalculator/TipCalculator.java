package com.example.tipcalculator;

public class TipCalculator {

    //data members
    private double tipPercent;
    private double billAmount;
    //private int numPerson;
    //private double taxRate;

    //constructor
    public TipCalculator(double tipPercent, double billAmount) {
        this.tipPercent = tipPercent;
        this.billAmount = billAmount;
    }

    public double getTipPercent() {
        return tipPercent;
    }

    public void setTipPercent(double tipPercent) {
        this.tipPercent = tipPercent;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    //instance method
    public double calTip()
    {
        return tipPercent*billAmount;
    }





}
