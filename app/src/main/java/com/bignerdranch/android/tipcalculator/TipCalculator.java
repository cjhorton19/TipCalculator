package com.bignerdranch.android.tipcalculator;

public class TipCalculator {

    //constructor
    public TipCalculator(double billTotal, double tipTotal, double peopleTotal, String stateStr){
        this.billTotal = billTotal;
        this.tipTotal = tipTotal;
        this.peopleTotal = peopleTotal;
        this.stateStr = stateStr;
    }

    private double billTotal;
    private double tipTotal;
    private double peopleTotal;
    private String stateStr;

    public double getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(double billTotal) {
        this.billTotal = billTotal;
    }

    public double getTipTotal() { return tipTotal; }

    public void setTipTotal(double tipTotal) { this.tipTotal = tipTotal; }

    public double getPeopleTotal() {
        return peopleTotal;
    }

    public void setPeopleTotal(double peopleTotal) {
        this.peopleTotal = peopleTotal;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public double calTip(){


        //calculate tip amount
        double tipAmount = getPercentage(tipTotal) * calBill();
        return tipAmount;

    }

    public double calBill(){
        //determine state sales tax
        double salesTax;
        switch (stateStr.toLowerCase()) {
            case "ca":
                salesTax = 0.0725;
                break;
            case "or":
                salesTax = 0.0;
                break;
            case "va":
                salesTax = 0.043;
                break;
            default:
                salesTax = 0.0;
                break;
        }

        //calculate total after tax
        double totalSalesTax = salesTax * billTotal;

        double totalBillWithTax = totalSalesTax + billTotal;

        return totalBillWithTax;
    }

    public double calPerPerson(double totalValue){
        double valuePerPerson = totalValue / peopleTotal;
        return valuePerPerson;
    }

    public double getPercentage(double inputPercent){
        double percent = inputPercent / 100;
        return percent;
    }


}



