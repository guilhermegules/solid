package services;

import br.com.rh.services.taxation.AnueniumService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AnueniumServiceTest {
    AnueniumService anueniumService;

    @BeforeEach
    public void init() {
        anueniumService = new AnueniumService(new BigDecimal(100), LocalDate.now());
    }

    @Test
    public void shouldReturnAThirdOfTheValue() {
        Assertions.assertEquals(anueniumService.value(), new BigDecimal(100).multiply(new BigDecimal(0.2)));
    }

    @Test
    public void shouldReturnTheLocalDate() {
        Assertions.assertEquals(anueniumService.date(), LocalDate.now());
    }
}
