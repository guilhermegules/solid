package models;

import br.com.rh.enums.Role;
import br.com.rh.models.Outsourced;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class OutsourcedTest {
    Outsourced outsourced;

    @BeforeEach
    public void init() {
        outsourced = new Outsourced("outsourced", "123", Role.MANAGER, BigDecimal.TEN, "Enterprise");
    }

    @Test
    public void shouldSetEnterprise() {
        Assertions.assertEquals(outsourced.getEnterprise(), "Enterprise");

        outsourced.setEnterprise("new enterprise");

        Assertions.assertEquals(outsourced.getEnterprise(), "new enterprise");
    }
}
