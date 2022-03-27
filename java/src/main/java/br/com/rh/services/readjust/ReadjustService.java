package br.com.rh.services.readjust;

import br.com.rh.interfaces.AdjustValidation;
import br.com.rh.models.Employee;

import java.math.BigDecimal;
import java.util.List;

public class ReadjustService {
    private List<AdjustValidation> validations;

    public ReadjustService(List<AdjustValidation> validations) {
        this.validations = validations;
    }

    public void readjustSalary(Employee employee, BigDecimal increase) {
        this.validations.forEach(validation -> validation.validate(employee, increase));

        var readjustedSalary = employee.getPersonalData().getSalary().add(increase);
        employee.readjustSalary(readjustedSalary);
    }
}
