package dev.shailendra.repositories;

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
            String sql ="insert into registration values (default, ?, ?,?) returning *";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,registration.getRegHealth());
            ps.setString(2, registration.getRegDOB());
            ps.setString(3, registration.getRegStatus());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                registration.setRegId(rs.getInt("reg_id"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Registration getById(Integer id) {
        try(Connection conn = cu.getConnection()){
            String sql = "select from registration where reg_id =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Registration r = new Registration();
                r.setRegId(rs.getInt("reg_id"));
                r.setRegHealth(rs.getString("reg_health"));
                r.setRegDOB(rs.getString("reg_dob"));
                r.setRegStatus(rs.getString("reg_status"));
                return r;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Registration> getAll() {
        List<Registration> registration = new ArrayList<>();
        try(Connection conn = cu.getConnection()){
            String sql = "select * from registration";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Registration  r = new Registration(
                  rs.getInt("reg_id"),
                        rs.getString("reg_health"),
                        rs.getString("reg_dob"),
                        rs.getString("reg_status")
                );
                registration.add(r);
            }
            return registration;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Registration registration) {
        try(Connection conn = cu.getConnection()){
            String sql = "update registration set reg_health = ?, reg_dob = ?, reg_status = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,registration.getRegHealth());
            ps.setString(2,registration.getRegDOB());
            ps.setString(3, registration.getRegStatus());
            ps.setInt(4, registration.getRegId());
            ps.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        try(Connection conn = cu.getConnection()){
            String sql = "delete from registration where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
