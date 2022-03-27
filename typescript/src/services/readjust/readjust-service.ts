import { AdjustValidation } from "../../interfaces/adjust-validation";
import { Employee } from "../../models/employee";

export class ReadjustService {
  private validations: AdjustValidation[];

  constructor(validations: AdjustValidation[]) {
    this.validations = validations;
  }

  public readjustSalary(employee: Employee, increase: number) {
    this.validations.forEach((validation) =>
      validation.validate(employee, increase)
    );

    const readjustedSalary = employee.personalData.salary + increase;
    employee.readjustSalary(readjustedSalary);
  }
}
