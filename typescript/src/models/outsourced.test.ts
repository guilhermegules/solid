import { Role } from "../enums/role.enum";
import { Outsourced } from "./outsourced";

describe("Outsourced", () => {
  it("should be instantiated and set properties correctly", () => {
    const outsourced = new Outsourced(
      "name",
      "123123123",
      Role.ANALYST,
      1000,
      "Enterprise"
    );

    const { name, cpf, role, salary } = outsourced.getPersonalData();

    expect(name).toBe("name");
    expect(cpf).toBe("123123123");
    expect(role).toBe(Role.ANALYST);
    expect(salary).toBe(1000);
    expect(outsourced.getEnterprise()).toBe("Enterprise");
  });
});
