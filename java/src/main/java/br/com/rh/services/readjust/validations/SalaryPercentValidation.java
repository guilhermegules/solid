package br.com.rh.services.readjust.validations;

import br.com.rh.exceptions.SalaryException;
import br.com.rh.interfaces.AdjustValidation;
import br.com.rh.models.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryPercentValidation implements AdjustValidation {
    private final String EMPLOYEE_ADJUSTMENT_PERCENT = "0.4";

    public void validate(Employee employee, BigDecimal increase) {
        var readjustPercent = increase.divide(employee.getPersonalData().getSalary(), RoundingMode.HALF_UP);

        if (readjustPercent.compareTo(new BigDecimal(this.EMPLOYEE_ADJUSTMENT_PERCENT)) > 0)  {
            throw new SalaryException("Salary readjust cannot be more than 40% of the salary");
        }
    }
}
