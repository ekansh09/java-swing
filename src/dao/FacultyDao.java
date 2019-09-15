/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Faculty;

/**
 *
 * @author cm
 */
public class FacultyDao {
        public static Connection getCon() throws ClassNotFoundException, SQLException{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","");
            return con;
        }
        public static Faculty get(int id){
            try {
                PreparedStatement ps = getCon().prepareStatement("select * from faculty where id = ? ");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Faculty s = new Faculty();
                    s.setId(rs.getInt("id"));
                    s.setName(rs.getString("name"));
                    s.setContNo(rs.getString("cont_no"));
                    s.setDept(rs.getString("dept"));
                    return s;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        public static List<Faculty> getAllFaculty(){
            List<Faculty> list = new ArrayList<>();
            try {
                PreparedStatement ps = getCon().prepareStatement("select * from faculty");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Faculty s = new Faculty();
                    s.setId(rs.getInt("id"));
                    s.setName(rs.getString("name"));
                    s.setContNo(rs.getString("cont_no"));
                    s.setDept(rs.getString("dept"));
                    
                    list.add(s);
                }
                return list;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }
        public static List<String[]> getAllFacultys2(){
            List<String[]> list = new ArrayList<>();
            try {
                PreparedStatement ps = getCon().prepareStatement("select * from faculty");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String[] s = new String[4];
                    for(int i=0;i<4;i++){
                        s[i] = rs.getString((i+1));
                    }
                    list.add(s);
                }
                return list;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }
        
        public static int addFaculty(Faculty s){
            try {
                PreparedStatement ps = getCon().prepareStatement("INSERT INTO `faculty`(`name`, `dept`, `cont_no`) VALUES (?,?,?)");
                ps.setString(1, s.getName());
                ps.setString(2, s.getDept());
                ps.setString(3, s.getContNo());
                
                int res = ps.executeUpdate();
                return res;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }
        
        public static int updateFaculty(Faculty s){
            try {
                PreparedStatement ps = getCon().prepareStatement("UPDATE `faculty` SET `name`=?,`dept`=?,`cont_no`=? WHERE id = ?");
                ps.setString(1, s.getName());
                ps.setString(2, s.getDept());
                ps.setString(3, s.getContNo());
                ps.setInt(4, s.getId());
                
                int res = ps.executeUpdate();
                return res;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }
        
        public static int deleteFaculty(int id){
            try {
                int option = JOptionPane.showConfirmDialog(new Frame(), "Delete Faculty Alert !","Are you sure to delete faculty ID : "+id+" ?",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.YES_OPTION){
                    PreparedStatement ps = getCon().prepareStatement("DELETE from faculty WHERE id = ?");
                    ps.setInt(1, id);

                    int res = ps.executeUpdate();
                    return res;
                }else{
                    return -1;
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }
        
}
