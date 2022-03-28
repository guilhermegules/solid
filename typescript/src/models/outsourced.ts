import { Role } from "../enums/role.enum";
import { PersonalData } from "./personal-data";

export class Outsourced {
  private personalData: PersonalData;
  private enterprise: string;

  constructor(
    name: string,
    cpf: string,
    role: Role,
    salary: number,
    enterprise: string
  ) {
    this.enterprise = enterprise;
    this.personalData = new PersonalData(name, cpf, role, salary);
  }

  public getEnterprise() {
    return this.enterprise;
  }

  public getPersonalData() {
    return this.personalData;
  }
}
