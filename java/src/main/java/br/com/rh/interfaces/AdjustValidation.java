package br.com.rh.interfaces;

import br.com.rh.models.Employee;

import java.math.BigDecimal;

public interface AdjustValidation {
    void validate(Employee employee, BigDecimal increase);
}
