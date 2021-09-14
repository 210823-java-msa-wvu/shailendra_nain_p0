package dev.shailendra.services;

import dev.shailendra.models.Donor;
import dev.shailendra.models.Employee;
import dev.shailendra.repositories.DonorRepo;

public class DonorServices {
    static DonorRepo donorRepo = new DonorRepo();

    public static boolean login(String username, String password){
        Donor d = donorRepo.getByUsername(username);
        if(d != null){
            if(username.equals(d.getDonUsername()) && password.equals(d.getDonPassword())){
                return true;
            }
        }
        return false;
    }

    public boolean checkId(int input){
        Donor id = donorRepo.getById(input);
        if(id.getDonorId() == input){
            return true;
        }else if(input != id.getDonorId()){
            return false;
        }
        return false;
    }

    public Donor updateDoninfo(int id , String firstname, String lastname){
        Donor d = new Donor();
        d.setDonorId(id);
        d.setDonFirstName(firstname);
        d.setDonLastName(lastname);

        return d;
    }
}
