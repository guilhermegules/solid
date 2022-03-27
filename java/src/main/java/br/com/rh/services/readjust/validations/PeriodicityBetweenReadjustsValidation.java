package br.com.rh.services.readjust.validations;

import br.com.rh.exceptions.SalaryException;
import br.com.rh.interfaces.AdjustValidation;
import br.com.rh.models.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PeriodicityBetweenReadjustsValidation implements AdjustValidation {
    public void validate(Employee employee, BigDecimal increase) {
        var lastReadjust = employee.getLastReadjustDate();
        var actualDate = LocalDate.now();
        var monthsOfTheLastReadjust = ChronoUnit.MONTHS.between(lastReadjust, actualDate);

        if (monthsOfTheLastReadjust < 6) {
            throw new SalaryException("Interval between the salary adjusts need to be at least 6 months");
        }
    }
}
