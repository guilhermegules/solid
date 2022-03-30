import { Role } from "../enums/role.enum";
import { PersonalData } from "./personal-data";

export class Employee {
  private _personalData: PersonalData;
  private _lastReadjustDate: Date;

  constructor(name: string, cpf: string, role: Role, salary: number) {
    this._personalData = new PersonalData(name, cpf, role, salary);
    this._lastReadjustDate = new Date();
  }

  public readjustSalary(salary: number) {
    this._personalData.salary = salary;
    this._lastReadjustDate = new Date();
  }

  public promote(newRole: Role) {
    this.personalData.role = newRole;
  }

  get personalData() {
    return this._personalData;
  }

  get lastReadjustDate() {
    return this._lastReadjustDate;
  }
}
