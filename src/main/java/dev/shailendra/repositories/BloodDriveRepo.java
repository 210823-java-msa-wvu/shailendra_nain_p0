package dev.shailendra.repositories;

import dev.shailendra.models.BloodDrive;
import dev.shailendra.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BloodDriveRepo implements CrudRepository<BloodDrive> {
    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public BloodDrive add(BloodDrive bloodDrive) {
        try(Connection conn = cu.getConnection()){
            String sql = "insert into drives values (default, ?, ?) returning *";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,bloodDrive.getDriveName());
            ps.setString(2,bloodDrive.getDriveAddress());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                bloodDrive.setDriveId(rs.getInt("drive_id"));
                return bloodDrive;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BloodDrive getById(Integer id) {
        try(Connection conn = cu.getConnection()){
            String sql = "select * from drives where drive_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                BloodDrive b = new BloodDrive();
                b.setDriveId(rs.getInt("drive_id"));
                b.setDriveName(rs.getString("drive_name"));
                b.setDriveAddress(rs.getString("drive_address"));
                return b;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<BloodDrive> getAll() {
        List<BloodDrive> bloodDrives = new ArrayList<>();
        try(Connection conn = cu.getConnection()){
            String sql = "select * from drives";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                BloodDrive bd = new BloodDrive(
                        rs.getInt("drive_id"),
                        rs.getString("drive_name"),
                        rs.getString("drive_address")
                );
                bloodDrives.add(bd);
            }
            return bloodDrives;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(BloodDrive d) {
        try(Connection conn = cu.getConnection()){
            String sql = "update drives set drive_name = ?, drive_address = ? where drive_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, d.getDriveName());
            ps.setString(2, d.getDriveAddress());
            ps.setInt(3, d.getDriveId());
            ps.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try(Connection conn = cu.getConnection()){
            String sql = "delete from drives where drive_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
