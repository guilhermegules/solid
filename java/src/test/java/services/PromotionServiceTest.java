package services;

import br.com.rh.enums.Role;
import br.com.rh.exceptions.PromotionException;
import br.com.rh.models.Employee;
import br.com.rh.services.promotion.PromotionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PromotionServiceTest {
    PromotionService promotionService;

    @BeforeEach
    public void init() {
        promotionService = new PromotionService(new BigDecimal(100), LocalDate.now());
    }

    @Test
    public void shouldThrowAnPromotionExceptionWhenEmployeeIsAManager() {
        Assertions.assertThrows(PromotionException.class, () -> {
            promotionService.promote(
                    new Employee("manager", "123", Role.MANAGER, new BigDecimal(10000)),
                    true
            );
        });
    }

    @Test
    public void shouldThrowAnPromotionExceptionWhenEmployeeIsNotBeatTheMeta() {
        Assertions.assertThrows(PromotionException.class, () -> {
            promotionService.promote(
                    new Employee("ANALYST", "123", Role.ANALYST, new BigDecimal(1000)),
                    false
            );
        });
    }

    @Test
    public void shouldPromoteEmployee() {
        var employee = new Employee("ANALYST", "123", Role.ANALYST, new BigDecimal(1000));

        promotionService.promote(employee,true);

        Assertions.assertEquals(employee.getPersonalData().getRole(), Role.SPECIALIST);
    }
}
