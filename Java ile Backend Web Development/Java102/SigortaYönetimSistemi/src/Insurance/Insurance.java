package Insurance;

import java.util.Date;

public abstract class Insurance {
    private String ınsuranceName;
    private double ınsuranceCost;
    private Date ınsuranceStartDate, ınsuranceFinishDate;

    public Insurance(String ınsuranceName, double ınsuranceCost, Date ınsuranceStartDate, Date ınsuranceFinishDate) {
        this.ınsuranceName = ınsuranceName;
        this.ınsuranceCost = ınsuranceCost;
        this.ınsuranceStartDate = ınsuranceStartDate;
        this.ınsuranceFinishDate = ınsuranceFinishDate;
    }

    public String getInsuranceName() {
        return ınsuranceName;
    }

    public void setInsuranceName(String ınsuranceName) {
        this.ınsuranceName = ınsuranceName;
    }

    public double getInsuranceCost() {
        return ınsuranceCost;
    }

    public void setInsuranceCost(double ınsuranceCost) {
        this.ınsuranceCost = ınsuranceCost;
    }

    public Date getInsuranceStartDate() {
        return ınsuranceStartDate;
    }

    public void setInsuranceStartDate(Date ınsuranceStartDate) {
        this.ınsuranceStartDate = ınsuranceStartDate;
    }

    public Date getInsuranceFinishDate() {
        return ınsuranceFinishDate;
    }

    public void setInsuranceFinishDate(Date ınsuranceFinishDate) {
        this.ınsuranceFinishDate = ınsuranceFinishDate;
    }

    public abstract void calculate ();
}
