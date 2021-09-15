package dev.shailendra.services;

import dev.shailendra.models.Employee;
import dev.shailendra.models.Registration;
import dev.shailendra.repositories.RegistrationRepo;

public class RegistrationServices {

    public Registration updateApproval(int id , String approval){
        Registration reg = new Registration();
        reg.setReg_id(id);
        reg.setReg_approval(approval);
        return reg;
    }

}
