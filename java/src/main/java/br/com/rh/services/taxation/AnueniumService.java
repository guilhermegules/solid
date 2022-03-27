package br.com.rh.services.taxation;

import br.com.rh.interfaces.Readjust;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AnueniumService implements Readjust {
    private BigDecimal value;
    private LocalDate date;

    public AnueniumService(BigDecimal value, LocalDate date) {
        this.value = value;
        this.date = date;
    }

    @Override
    public BigDecimal value() {
        return this.value;
    }

    @Override
    public LocalDate date() {
        return this.date;
    }
}
