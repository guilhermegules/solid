package br.com.rh.models;

import br.com.rh.enums.Role;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private PersonalData personalData;
    private LocalDate lastReadjustDate;

    public Employee(String name, String cpf, Role role, BigDecimal salary) {
        this.personalData = new PersonalData(name, cpf, role, salary);
    }

    public void readjustSalary(BigDecimal newSalary) {
        this.personalData.setSalary(newSalary);
        this.lastReadjustDate = LocalDate.now();
    }

    public LocalDate getLastReadjustDate() {
        return lastReadjustDate;
    }

    public void promote(Role newRole) {
        this.personalData.setRole(newRole);
    }

    public PersonalData getPersonalData() {
        return personalData;
    }
}
