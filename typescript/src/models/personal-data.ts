import { Role } from "../enums/role.enum";

export class PersonalData {
  private _name: string;
  private _cpf: string;
  private _role: Role;
  private _salary: number;

  constructor(name: string, cpf: string, role: Role, salary: number) {
    this._name = name;
    this._cpf = cpf;
    this._role = role;
    this._salary = salary;
  }

  get name() {
    return this._name;
  }

  get cpf() {
    return this._cpf;
  }

  get role() {
    return this._role;
  }

  get salary() {
    return this._salary;
  }

  set role(role: Role) {
    this._role = role;
  }

  set salary(salary: number) {
    this._salary = salary;
  }
}
