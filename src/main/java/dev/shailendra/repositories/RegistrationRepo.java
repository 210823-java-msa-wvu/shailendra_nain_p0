package dev.shailendra.repositories;

import com.sun.xml.internal.bind.v2.TODO;
import dev.shailendra.models.Registration;
import dev.shailendra.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationRepo implements CrudRepository<Registration>{
    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Registration add(Registration registration) {
        try(Connection conn = cu.getConnection()){
            String sql = "insert into registration values (default, ?, ?, ?,?,?) returning *";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,registration.getReg_health());
            ps.setInt(2, registration.getReg_dob());
            ps.setString(3, registration.getReg_approval());
            ps.setInt(4, registration.getDonor_id());
            ps.setInt(5,registration.getDrive_id());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                registration.setReg_id(rs.getInt("reg_id"));
                return registration;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Registration getById(Integer id) {
        try(Connection conn = cu.getConnection()){
            String sql = "Select * from registration where reg_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Registration registration = new Registration();
                registration.setReg_id(rs.getInt("reg_id"));
                registration.setReg_health(rs.getString("reg_health"));
                registration.setReg_dob(rs.getInt("reg_dob"));
                registration.setReg_approval(rs.getString("reg_approval"));
                return registration;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Registration> getAll() {
        List<Registration> registrationsList = new ArrayList<>();
        try(Connection conn = cu.getConnection()){
            String sql = "Select * from registration";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Registration registration = new Registration(
                  rs.getInt("reg_id"),
                        rs.getString("reg_health"),
                        rs.getInt("reg_dob"),
                        rs.getString("reg_approval"),
                        rs.getInt("donor_id"),
                        rs.getInt("drive_id")
                );
                registrationsList.add(registration);

            }
            return registrationsList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Registration registration) {
        try(Connection conn = cu.getConnection()){
            String sql = "update registration set reg_approval = ? where reg_id =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,registration.getReg_approval());
            ps.setInt(2,registration.getReg_id());
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void getAllDetails(){
        List<Registration> registrationsList = new ArrayList<>();
        try(Connection conn = cu.getConnection()){
            String sql = "select drive_name, dfirst_name, dlast_name, reg_health, reg_dob, reg_approval from donors d\n" +
                    "inner join registration r \n" +
                    "on d.d_id = r.donor_id \n" +
                    "inner join drives d2 \n" +
                    "on d2.drive_id = r.drive_id ;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String driveName =  rs.getString("drive_name");
                String donorFirstName = rs.getString("dfirst_name");
                String donorLastName = rs.getString("dlast_name");
                String health = rs.getString("reg_health");
                int donorage = rs.getInt("reg_dob");
                String approval = rs.getString("reg_approval");
                System.out.println("Drive Name : " + driveName +" |  Donor Name : "+donorFirstName +" "+donorLastName +"  | Health Status : "+health +" | Age : "+ donorage +" | Approval Status : "+ approval +"\n\n\n");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    @Override
    public void delete(Integer id) {

    }
}
