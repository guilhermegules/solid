import { Readjust } from "../../interfaces/readjust";

export class AnueniumService implements Readjust {
  private _value: number;
  private _date: Date;

  constructor(value: number, date: Date) {
    this._value = value;
    this._date = date;
  }

  value(): number {
    return this._value * 0.3;
  }

  date(): Date {
    return new Date(
      this._date.getFullYear() + 1,
      this._date.getMonth(),
      this._date.getDay()
    );
  }
}
