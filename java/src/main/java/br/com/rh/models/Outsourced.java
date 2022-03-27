package br.com.rh.models;

import br.com.rh.enums.Role;

import java.math.BigDecimal;

public class Outsourced {
    private PersonalData personalData;
    private String enterprise;

    public Outsourced(String name, String cpf, Role role, BigDecimal salary, String enterprise) {
        this.enterprise = enterprise;
        this.personalData = new PersonalData(name, cpf, role, salary);
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }
}
