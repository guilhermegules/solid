export interface Readjust {
  value(): number;
  date(): Date;
}

export interface TaxableReadjust extends Readjust {
  taxValue(): number;
}
