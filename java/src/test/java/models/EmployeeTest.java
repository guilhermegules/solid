package models;

import br.com.rh.enums.Role;
import br.com.rh.models.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeTest {
    Employee employee;

    @BeforeEach
    public void init() {
        employee = new Employee("name", "123", Role.ANALYST, new BigDecimal(1000));
    }

    @Test
    public void shouldReadjustEmployeeSalary() {
        employee.readjustSalary(new BigDecimal(2000));

        Assertions.assertEquals(employee.getPersonalData().getSalary(), new BigDecimal(2000));
        Assertions.assertEquals(employee.getLastReadjustDate(), LocalDate.now());
    }

    @Test
    public void shouldInstantiateClassCorrectly() {
        Assertions.assertEquals(employee.getPersonalData().getSalary(), new BigDecimal(1000));
        Assertions.assertEquals(employee.getPersonalData().getRole(), Role.ANALYST);
        Assertions.assertEquals(employee.getPersonalData().getCpf(), "123");
        Assertions.assertEquals(employee.getPersonalData().getName(), "name");
    }
}
