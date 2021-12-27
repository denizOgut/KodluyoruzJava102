package Insurance;

import java.util.Date;

public class HealthInsurance extends Insurance{

    public HealthInsurance(String ınsuranceName, double ınsuranceCost, Date ınsuranceStartDate, Date ınsuranceFinishDate) {
        super(ınsuranceName, ınsuranceCost, ınsuranceStartDate, ınsuranceFinishDate);
    }

    @Override
    public void calculate() {

    }
}
