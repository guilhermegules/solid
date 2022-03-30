import { Role } from "../enums/role.enum";
import { Employee } from "./employee";

describe("Employee", () => {
  let employee: Employee;

  beforeEach(() => {
    employee = new Employee("Guilherme", "111111111", Role.ASSISTANT, 1000);
  });

  it("should create an instance", () => {
    expect(employee.personalData.name).toBe("Guilherme");
    expect(employee.personalData.cpf).toBe("111111111");
    expect(employee.personalData.role).toBe(Role.ASSISTANT);
    expect(employee.personalData.salary).toBe(1000);
  });

  it("should readjust salary", () => {
    employee.readjustSalary(2000);

    expect(employee.personalData.salary).toBe(2000);
    expect(employee.lastReadjustDate).toEqual(expect.any(Date));
  });

  it("should promote employee", () => {
    employee.promote(Role.ANALYST);

    expect(employee.personalData.role).toEqual(Role.ANALYST);
  });
});
