package Insurance;

import java.util.Date;

public class TravelInsurance extends Insurance {

    public TravelInsurance(String ınsuranceName, double ınsuranceCost, Date ınsuranceStartDate, Date ınsuranceFinishDate) {
        super(ınsuranceName, ınsuranceCost, ınsuranceStartDate, ınsuranceFinishDate);
    }

    @Override
    public void calculate() {

    }
}
