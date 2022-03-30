import { AnueniumService } from "./taxation-service";

describe("TaxationService", () => {
  it("should return the date one year later and one third of the value", () => {
    const anueniumService = new AnueniumService(1000, new Date(2022, 2, 2));

    expect(anueniumService.date().getFullYear()).toBe(2023);
    expect(anueniumService.value()).toBe(300);
  });
});
