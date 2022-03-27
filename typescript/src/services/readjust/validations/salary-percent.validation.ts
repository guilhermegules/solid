import { AdjustValidation } from "../../../interfaces/adjust-validation";
import { Employee } from "../../../models/employee";

export class SalaryPercentValidation implements AdjustValidation {
  validate(employee: Employee, increase: number) {
    if (
      this.getPercentageChange(employee.personalData.salary, increase) > 0.4
    ) {
      throw new Error("Salary readjust cannot be more than 40% of the salary");
    }
  }

  getPercentageChange(oldValue: number, newValue: number) {
    const decreasedValue = oldValue - newValue;

    return ((decreasedValue / oldValue) * 100) / 100;
  }
}
