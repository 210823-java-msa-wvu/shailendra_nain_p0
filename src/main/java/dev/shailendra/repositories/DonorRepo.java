package dev.shailendra.repositories;

import dev.shailendra.models.Donor;
import dev.shailendra.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonorRepo implements CrudRepository<Donor>{
    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Donor add(Donor donor) {
       try(Connection conn = cu.getConnection()){
            String sql = "insert into donors values (default, ? ,? ,?, ? )returning *";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setString(1,donor.getDonFirstName());
           ps.setString(2,donor.getDonLastName());
           ps.setString(3,donor.getDonUsername());
           ps.setString(4,donor.getDonPassword());
           ResultSet rs = ps.executeQuery();
            if(rs.next()){
                donor.setDonorId(rs.getInt("d_id"));
                return donor;
            }
       }catch(SQLException e){
           e.printStackTrace();
       }
        return null;
    }

    @Override
    public Donor getById(Integer id) {
        try(Connection conn = cu.getConnection()){
            String sql = "select * from donors where d_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Donor d = new Donor();
                d.setDonorId(rs.getInt("d_id"));
                d.setDonFirstName(rs.getString("dfirst_name"));
                d.setDonLastName(rs.getString("dlast_name"));
                d.setDonUsername(rs.getString("dusername"));
                d.setDonPassword(rs.getString("dpassword"));
                return d;
            }
            return null;
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Donor> getAll() {
        List<Donor> donors = new ArrayList<>();
        try(Connection conn = cu.getConnection()){
            String sql = "Select * from donors";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Donor d = new Donor(
                        rs.getInt("d_id"),
                        rs.getString("dfirst_name"),
                        rs.getString("dlast_name"),
                        rs.getString("dusername"),
                        rs.getString("dpassword")
                );
                donors.add(d);
            }
             return donors;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Donor donor) {
        try(Connection conn = cu.getConnection()){
            String sql = "update donors set dfirst_name = ?, dlast_name = ?, dusername=?, dpassword=? where d_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,donor.getDonFirstName());
            ps.setString(2,donor.getDonLastName());
            ps.setString(3, donor.getDonUsername());
            ps.setString(4, donor.getDonPassword());
            ps.setInt(5,donor.getDonorId());
            ps.execute();
            System.out.println("Donor successfully updated");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection conn = cu.getConnection()){
            String sql = "delete from donors where d_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
