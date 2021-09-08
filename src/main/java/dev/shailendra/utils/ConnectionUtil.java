package dev.shailendra.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static ConnectionUtil cu = null;
    private static Properties props;

    private ConnectionUtil(){
        props = new Properties();
        InputStream dbprops = ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties");

        try{
            props.load(dbprops);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static synchronized ConnectionUtil getConnectionUtil(){
        if(cu == null){
            cu = new ConnectionUtil();
        }
        return cu;
    }

    public Connection getConnection(){
            Connection conn = null;

            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            try{
                conn = DriverManager.getConnection(url, username, password);
            }catch(SQLException e){
                e.printStackTrace();
            }
            return conn;
    }

    public static void main(String[] args){
        Connection connection = getConnectionUtil().getConnection();
        if(connection != null){
            System.out.println("Connection Successful");
        }else{
            System.out.println("Connection Error");
        }
    }
}
