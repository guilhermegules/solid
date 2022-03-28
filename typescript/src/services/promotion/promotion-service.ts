import { Role } from "../../enums/role.enum";
import { TaxableReadjust } from "../../interfaces/readjust";
import { Employee } from "../../models/employee";

export class PromotionService implements TaxableReadjust {
  private _value: number;
  private _date: Date;

  constructor(value: number, date: Date) {
    this._value = value;
    this._date = date;
  }

  promote(employee: Employee, isMetaBeaten: boolean) {
    if (employee.personalData.role === Role.MANAGER)
      throw new Error("Managers cannot be promoted");

    if (!isMetaBeaten) throw new Error("Employee have not beaten the meta");

    const newRole = this.getNextRole(employee.personalData.role);
    employee.promote(newRole);
  }

  taxValue(): number {
    throw new Error("Method not implemented.");
  }

  value(): number {
    return this._value;
  }

  date(): Date {
    return this._date;
  }

  private getNextRole(actualRole: Role) {
    switch (actualRole) {
      case Role.ASSISTANT:
        return Role.ANALYST;
      case Role.ANALYST:
        return Role.SPECIALIST;
      case Role.SPECIALIST:
        return Role.MANAGER;
      case Role.MANAGER:
        return Role.MANAGER;
      default:
        throw new Error("Not a valid role");
    }
  }
}
