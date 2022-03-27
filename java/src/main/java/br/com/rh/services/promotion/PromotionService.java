package br.com.rh.services.promotion;

import br.com.rh.enums.Role;
import br.com.rh.exceptions.PromotionException;
import br.com.rh.models.Employee;

public class PromotionService {
    public void promote(Employee employee, boolean beatenMeta) {
        if (employee.getPersonalData().getRole() == Role.MANAGER) throw new PromotionException("Managers cannot be promoted");

        if(!beatenMeta) throw new PromotionException("Employee have not beaten the meta");

        Role newRole = employee.getPersonalData().getRole().getNextRole();
        employee.promote(newRole);
    }
}
