import { Role } from "../../../enums/role.enum";
import { Employee } from "../../../models/employee";
import { SalaryPercentValidation } from "./salary-percent.validation";

describe("SalaryPercentValidation", () => {
  let salaryPercentValidation: SalaryPercentValidation;

  beforeEach(() => {
    salaryPercentValidation = new SalaryPercentValidation();
  });

  it("should not throw error when difference of employee salary is lesser than 0.4 of the increase", () => {
    expect(() => {
      salaryPercentValidation.validate(
        new Employee("mock", "1", Role.ANALYST, 1000),
        1000
      );
    }).not.toThrowError();
  });

  it("should throw an error when difference of employee salary is bigger than 0.4 of the increase", () => {
    expect(() => {
      salaryPercentValidation.validate(
        new Employee("mock", "1", Role.ANALYST, 1000),
        600
      );
    }).toThrowError("Salary readjust cannot be more than 40% of the salary");
  });
});
