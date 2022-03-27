package br.com.rh.services.promotion;

import br.com.rh.enums.Role;
import br.com.rh.exceptions.PromotionException;
import br.com.rh.interfaces.TaxableReadjust;
import br.com.rh.models.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PromotionService implements TaxableReadjust {
    private BigDecimal value;
    private LocalDate date;

    public PromotionService(BigDecimal value, LocalDate date) {
        this.value = value;
        this.date = date;
    }

    public void promote(Employee employee, boolean beatenMeta) {
        if (employee.getPersonalData().getRole() == Role.MANAGER) throw new PromotionException("Managers cannot be promoted");

        if(!beatenMeta) throw new PromotionException("Employee have not beaten the meta");

        Role newRole = employee.getPersonalData().getRole().getNextRole();
        employee.promote(newRole);
    }

    @Override
    public BigDecimal value() {
        return this.value;
    }

    @Override
    public LocalDate date() {
        return this.date;
    }

    @Override
    public BigDecimal taxValue() {
        return this.value.multiply(new BigDecimal("0.1"));
    }
}
