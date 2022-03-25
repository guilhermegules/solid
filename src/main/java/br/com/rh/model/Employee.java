package br.com.rh.model;

import br.com.rh.enums.Role;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private String name;
    private String cpf;
    private Role role;
    private BigDecimal salary;
    private LocalDate lastReadjustDate;

    public Employee(String name, String cpf, Role role, BigDecimal salary) {
        this.name = name;
        this.cpf = cpf;
        this.role = role;
        this.salary = salary;
    }

    public void readjustSalary(BigDecimal newSalary) {
        this.salary = newSalary;
        this.lastReadjustDate = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getLastReadjustDate() {
        return lastReadjustDate;
    }

    public void setLastReadjustDate(LocalDate lastReadjustDate) {
        this.lastReadjustDate = lastReadjustDate;
    }
}