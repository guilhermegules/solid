package br.com.rh.interfaces;

import java.math.BigDecimal;

public interface TaxableReadjust extends Readjust {
    BigDecimal taxValue();
}
