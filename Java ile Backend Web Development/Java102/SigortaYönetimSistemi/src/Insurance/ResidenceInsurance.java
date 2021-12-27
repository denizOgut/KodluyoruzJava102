package Insurance;

import java.util.Date;

public class ResidenceInsurance extends Insurance{
    public ResidenceInsurance(String ınsuranceName, double ınsuranceCost, Date ınsuranceStartDate, Date ınsuranceFinishDate) {
        super(ınsuranceName, ınsuranceCost, ınsuranceStartDate, ınsuranceFinishDate);
    }

    @Override
    public void calculate() {

    }
}
