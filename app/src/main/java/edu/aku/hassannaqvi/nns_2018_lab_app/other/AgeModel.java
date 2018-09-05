package edu.aku.hassannaqvi.nns_2018_lab_app.other;

public class AgeModel {
    public int days,years,months;

    public int getdays() {
        return days;
    }

    public void setdays(int days) {
        this.days = days;
    }

    public int getyears() {
        return years;
    }

    public void setyears(int years) {
        this.years = years;
    }

    public int getmonths() {
        return months;
    }

    public void setmonths(int months) {
        this.months = months;
    }

    public AgeModel(int days, int years, int months) {
        this.days = days;
        this.years = years;
        this.months = months;
    }
}
