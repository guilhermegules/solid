import { AdjustValidation } from "../../../interfaces/adjust-validation";
import { Employee } from "../../../models/employee";

export class PeriodicityBetweenReadjustsValidation implements AdjustValidation {
  validate(employee: Employee, increase: number) {
    throw new Error("Method not implemented.");
  }
}
