package dev.shailendra.repositories;

import dev.shailendra.models.Employee;
import dev.shailendra.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeRepo implements CrudRepository<Employee>{
    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();
    @Override
    public Employee add(Employee employee) {
        try(Connection conn = cu.getConnection()){
            String sql = "insert into employees values (default, ?, ?, ? ,? )returning *";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,employee.getEmpFirstName());
            ps.setString(2, employee.getEmpLastName());
            ps.setString(3, employee.getEmpUsername());
            ps.setString(4, employee.getEmpPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                employee.setEmployeeId(rs.getInt("emp_id"));
                return employee;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Employee getByUsername(String employeeUsername){
        try(Connection conn = cu.getConnection()){
            String sql = "select * from employees where emp_username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, employeeUsername);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Employee e = new Employee(
                rs.getInt("emp_id"),
                rs.getString("emp_firstname"),
                rs.getString("emp_lastname"),
                rs.getString("emp_username"),
                rs.getString("emp_password")
                );
                return e;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public Employee getById(Integer id) {
        try(Connection conn = cu.getConnection()){
            String sql = "SELECT emp_id, emp_firstname, emp_lastname, emp_username, emp_password FROM employees WHERE emp_id=?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Employee e = new Employee(
                        rs.getInt("emp_id"),
                rs.getString("emp_firstname"),
                rs.getString("emp_lastname"),
                rs.getString("emp_username"),
                rs.getString("emp_password")
                );
                return e;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public void update(Employee emp) {
        try(Connection conn = cu.getConnection()){
            String sql = "update employees set emp_firstname = ? , emp_lastname = ? where emp_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, emp.getEmpFirstName());
            ps.setString(2, emp.getEmpLastName());
            ps.setInt(3, emp.getEmployeeId());
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {

    }
}
