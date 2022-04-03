import { Employee } from "../models/employee";

export interface AdjustValidation {
  validate(employee: Employee, increase?: number): void;
}
