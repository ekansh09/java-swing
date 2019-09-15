package dao;

import static dao.FacultyDao.getCon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Faculty;
import model.Student;

public class StudentDao {
        public static Connection getCon() throws ClassNotFoundException, SQLException{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/management","root","");
            return con;
        }
        
        public static Student get(int id){
            try {
                PreparedStatement ps = getCon().prepareStatement("select * from student where id = ? ");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Student s = new Student();
                    s.setId(rs.getInt("id"));
                    s.setName(rs.getString("name"));
                    s.setCourse(rs.getString("course"));
                    s.setContact_no(rs.getString("contact"));
                    s.setAddress(rs.getString("address"));
                    s.setEmail(rs.getString("email"));
                    return s;
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(FacultyDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        
        public static List<Student> getAllStudents(){
            List<Student> list = new ArrayList<>();
            try {
                PreparedStatement ps = getCon().prepareStatement("select * from student");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Student s = new Student();
                    s.setId(rs.getInt("id"));
                    s.setName(rs.getString("name"));
                    s.setCourse(rs.getString("course"));
                    s.setContact_no(rs.getString("contact_no"));
                    s.setEmail(rs.getString("email"));
                    s.setAddress(rs.getString("address"));
                    
                    list.add(s);
                }
                return list;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }
        public static List<String[]> getAllStudents2(){
            List<String[]> list = new ArrayList<>();
            try {
                PreparedStatement ps = getCon().prepareStatement("select * from student");
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    String[] s = new String[6];
                    for(int i=0;i<6;i++){
                        s[i] = rs.getString((i+1));
                    }
                    list.add(s);
                }
                return list;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return list;
        }
        
        public static int addStudent(Student s){
            try {
                PreparedStatement ps = getCon().prepareStatement("INSERT INTO `student`(`name`, `course`, `contact`, `email`, `address`) VALUES (?,?,?,?,?)");
                ps.setString(1, s.getName());
                ps.setString(2, s.getCourse());
                ps.setString(3, s.getContact_no());
                ps.setString(4, s.getEmail());
                ps.setString(5, s.getAddress());
                
                int res = ps.executeUpdate();
                return res;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }
        
        public static int updateStudent(Student s){
            try {
                PreparedStatement ps = getCon().prepareStatement("UPDATE `student` SET `name`=?,`course`=?,`contact`=?,`email`=?,`address`= ? WHERE id = ?");
                ps.setString(1, s.getName());
                ps.setString(2, s.getCourse());
                ps.setString(3, s.getContact_no());
                ps.setString(4, s.getEmail());
                ps.setString(5, s.getAddress());
                ps.setInt(6, s.getId());
                
                int res = ps.executeUpdate();
                return res;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }
        
        public static int deleteStudent(int id){
            try {
                PreparedStatement ps = getCon().prepareStatement("DELETE from student WHERE id = ?");
                ps.setInt(1, id);
                
                int res = ps.executeUpdate();
                return res;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }
        
}
