import { differenceInCalendarMonths } from "date-fns";

import { AdjustValidation } from "../../../interfaces/adjust-validation";
import { Employee } from "../../../models/employee";

export class PeriodicityBetweenReadjustsValidation implements AdjustValidation {
  validate(employee: Employee, increase: number) {
    const lastReadjust = employee.lastReadjustDate;
    const actualDate = new Date();
    const monthsOfTheLastReadjust = differenceInCalendarMonths(
      lastReadjust,
      actualDate
    );

    if (monthsOfTheLastReadjust < 6) {
      throw new Error(
        "Interval between the salary adjusts need to be at least 6 months"
      );
    }
  }
}
