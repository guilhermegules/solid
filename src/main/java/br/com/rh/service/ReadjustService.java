package br.com.rh.service;

import br.com.rh.exceptions.SalaryException;
import br.com.rh.model.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ReadjustService {
    public void readjustSalary(Employee employee, BigDecimal increase) {
        var readjustPercent = increase.divide(employee.getSalary(), RoundingMode.HALF_UP);

        if(readjustPercent.compareTo(new BigDecimal("0.4")) > 0)  {
            throw new SalaryException("Salary readjust cannot be more than 40% of the salary");
        }

        var readjustedSalary = employee.getSalary().add(increase);
        employee.readjustSalary(readjustedSalary);
    }
}
