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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Course;
import model.Faculty;

/**
 *
 * @author cm
 */
public class FeeStructureDao {
        public static Connection getCon() throws ClassNotFoundException, SQLException{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","");
            return con;
        }
        public static Course get(int id){
            try {
                PreparedStatement ps = getCon().prepareStatement("select * from course where id = ?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Course s = new Course();
                    s.setId(rs.getInt("id"));
                    s.setTitle(rs.getString("title"));
                    s.setDuration(rs.getString(3));
                    s.setFee(rs.getInt(4));
                    return s;
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        public static List<Course> getAll(){
            List<Course> list = new ArrayList<>();
            try {
                PreparedStatement ps = getCon().prepareStatement("select * from fee_structure");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Course s = new Course();
                    s.setId(rs.getInt("id"));
                    s.setTitle(rs.getString("title"));
                    s.setDuration(rs.getString(3));
                    s.setFee(rs.getInt(4));
                    
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
        public static List<String[]> getAll2(){
            List<String[]> list = new ArrayList<>();
            try {
                PreparedStatement ps = getCon().prepareStatement("select * from fee_structure");
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
        
        public static int add(Course s){
            try {
                PreparedStatement ps = getCon().prepareStatement("INSERT INTO `course`(`title`, `duration`, `fee`) VALUES (?,?,?)");
                ps.setString(1, s.getTitle());
                ps.setString(2, s.getDuration());
                ps.setInt(3, s.getFee());
                
                int res = ps.executeUpdate();
                return res;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }
        
        public static int update(Course s){
            try {
                PreparedStatement ps = getCon().prepareStatement("UPDATE `course` SET `title`=?,`duration`=?,`cont_no`=? WHERE id = ?");
                 ps.setString(1, s.getTitle());
                ps.setString(2, s.getDuration());
                ps.setInt(3, s.getFee());
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
        
        public static int delete(int id){
            try {
                PreparedStatement ps = getCon().prepareStatement("DELETE from course WHERE id = ?");
                ps.setInt(1, id);
                
                int res = ps.executeUpdate();
                return res;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }
}
