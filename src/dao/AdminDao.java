/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cm
 */
public class AdminDao {
    public static Connection getCon() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","");
        return con;
    }
    
    public static boolean adminLogin(String uname,String pass){
        try {
            PreparedStatement ps = getCon().prepareStatement("select * from admin where username = ? and password = ?");
            ps.setString(1, uname);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static boolean updatePassword(String uname,String pass){
        try {
            PreparedStatement ps = getCon().prepareStatement("update admin set password = ? where username = ?");
            ps.setString(1, pass);
            ps.setString(2, uname);
            int i = ps.executeUpdate();
            if(i>0){
                return true;
            }else{
                return false;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
