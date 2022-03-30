import { Role } from "./../../enums/role.enum";
import { Employee } from "../../models/employee";
import { ReadjustService } from "./readjust-service";

describe("ReadjustService", () => {
  it("should readjust salary when any validation is not throwing error", () => {
    const readjustService = new ReadjustService([{ validate: () => null }]);
    const employee = new Employee("name", "1", Role.ANALYST, 1000);

    readjustService.readjustSalary(employee, 1000);

    expect(employee.personalData.salary).toBe(2000);
  });
  it("should not readjust salary when any validation is triggered", () => {
    const readjustService = new ReadjustService([
      {
        validate: () => {
          throw new Error("error");
        },
      },
    ]);
    const employee = new Employee("name", "1", Role.ANALYST, 1000);

    expect(() => {
      readjustService.readjustSalary(employee, 1000);
    }).toThrowError("error");
  });
});
