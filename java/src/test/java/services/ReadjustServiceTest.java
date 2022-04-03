package services;

import br.com.rh.enums.Role;
import br.com.rh.exceptions.SalaryException;
import br.com.rh.interfaces.AdjustValidation;
import br.com.rh.models.Employee;
import br.com.rh.services.readjust.ReadjustService;
import br.com.rh.services.readjust.validations.PeriodicityBetweenReadjustsValidation;
import br.com.rh.services.readjust.validations.SalaryPercentValidation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

public class ReadjustServiceTest {
    ReadjustService readjustService;

    @BeforeEach
    public void init() {
        var validations = new ArrayList<AdjustValidation>();
        validations.add(new SalaryPercentValidation());
        validations.add(new PeriodicityBetweenReadjustsValidation());
        readjustService = new ReadjustService(validations);
    }

    @Test
    public void shouldThrowSalaryExceptionWhenTheSalaryIncreaseIsMoreThe40Percent() {
        Assertions.assertThrows(SalaryException.class, () -> {
            var employee = new Employee("Employee", "123", Role.ANALYST, new BigDecimal(1000));
           readjustService.readjustSalary(employee, new BigDecimal(1000));
        });
    }

    @Test
    public void shouldThrowSalaryExceptionWhenPeriodicityBetweenReadjustsIsLesserThanSixMonths() {
        Assertions.assertThrows(SalaryException.class, () -> {
            var employee = new Employee("Employee", "123", Role.ANALYST, new BigDecimal(1000));
            employee.setLastReadjustDate(LocalDate.now());
            readjustService.readjustSalary(employee, new BigDecimal(10));
        });
    }

    @Test
    public void shouldReadjustEmployeeSalary() {
        var employee = new Employee("Employee", "123", Role.ANALYST, new BigDecimal(1000));
        LocalDate localDate = LocalDate.of(2021, Month.JANUARY, 25);
        employee.setLastReadjustDate(localDate);
        readjustService.readjustSalary(employee, new BigDecimal(10));
        Assertions.assertEquals(employee.getPersonalData().getSalary(), new BigDecimal(1010));
    }
}
