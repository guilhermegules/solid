import { Role } from "../../enums/role.enum";
import { Employee } from "../../models/employee";
import { PromotionService } from "./promotion-service";

describe("PromotionService", () => {
  let promotionService: PromotionService;

  beforeEach(() => {
    promotionService = new PromotionService(1000, new Date(2022, 2, 1));
  });

  it("should return value, taxValue and date", () => {
    expect(promotionService.date()).toEqual(new Date(2022, 2, 1));
    expect(promotionService.value()).toBe(2000);
    expect(promotionService.taxValue()).toBe(200);
  });

  describe("test promotion validation", () => {
    it("should throw an error when employee is a manager", () => {
      const employee = new Employee("name", "123", Role.MANAGER, 10000);

      expect(() => {
        promotionService.promote(employee, false);
      }).toThrowError("Managers cannot be promoted");
    });
    it("should throw an error when employee not beat the meta", () => {
      const employee = new Employee("name", "123", Role.ANALYST, 10000);
      expect(() => {
        promotionService.promote(employee, false);
      }).toThrowError("Employee have not beaten the meta");
    });
    it("should promote the employee", () => {
      const employee = new Employee("ASSISTANT", "1", Role.ASSISTANT, 1);

      promotionService.promote(employee, true);

      expect(employee.personalData.role).toBe(Role.ANALYST);

      const employee2 = new Employee("ANALYST", "2", Role.ANALYST, 10);

      promotionService.promote(employee2, true);

      expect(employee2.personalData.role).toBe(Role.SPECIALIST);

      const employee3 = new Employee("SPECIALIST", "3", Role.SPECIALIST, 100);

      promotionService.promote(employee3, true);

      expect(employee3.personalData.role).toBe(Role.MANAGER);

      expect(() => {
        const employee4 = new Employee("ANY", "4", "ANY" as any, 1000);

        promotionService.promote(employee4, true);
      }).toThrowError("Not a valid role");
    });
  });
});
