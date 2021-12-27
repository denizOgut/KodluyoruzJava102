package Insurance;

import java.util.Date;

public class CarInsurance extends Insurance{
    public CarInsurance(String ınsuranceName, double ınsuranceCost, Date ınsuranceStartDate, Date ınsuranceFinishDate) {
        super(ınsuranceName, ınsuranceCost, ınsuranceStartDate, ınsuranceFinishDate);
    }

    @Override
    public void calculate() {

    }
}
