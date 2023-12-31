/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import ConnectDB.OracleConnection;
import Model.Account;
import Model.Doctor;
import Model.Person;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author MyPC
 */
public class PersonController {
     public  ArrayList<Person> getPerson()
    {
        ArrayList<Person> ListPerson = new <Person>ArrayList();
        try{
            Connection con = OracleConnection.getOracleConnection();
            String sql = "SELECT * FROM Person";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Person person = new Person();
                
                person.setIdper(rs.getInt("IDPER"));
                person.setUsername(rs.getString("USERNAME"));
                person.setName(rs.getString("NAME"));
                person.setGender(rs.getInt("Gender"));
                person.setPhone(rs.getString("PHONE"));
                person.setProvince(rs.getString("PROVINCE"));
                person.setDistrict(rs.getString("DISTRICT"));
                person.setTown(rs.getString("TOWN"));
                person.setAddress(rs.getString("ADDRESS"));
                person.setStatus(rs.getInt("STATUS"));

                ListPerson.add(person);  
            }
            rs.close();
            //st.close();
            con.close();
            
        }
        catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } catch (UnsupportedOperationException uoe) {
            uoe.printStackTrace();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return ListPerson;
    }
     
     //Capậ nhật người cần giúp đỡ
    public static int UpdatePerson(Person person) {
        try {
            Connection con = OracleConnection.getOracleConnection();
            String sql = "{CALL PROC_UPDATE_PERSON(?,?,?,?,?,?,?,?)}";
            CallableStatement ps = con.prepareCall(sql);
            
            
            ps.setInt(1, person.getIdper());
            ps.setString(2, person.getName());
            ps.setInt(3, person.getGender());
            ps.setString(4, person.getPhone());
            ps.setString(5, person.getProvince());
            ps.setString(6, person.getDistrict());
            ps.setString(7, person.getTown());
            ps.setString(8, person.getAddress());
            
            ps.execute();
            
            ps.close();
            con.close();
        }catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 1407){
                JOptionPane.showMessageDialog(null, "Không được để trống các miền giá trị bắt buộc!",
                        "Lỗi!", JOptionPane.ERROR_MESSAGE);}
            else if (sqlex.getErrorCode() == 20021){
                JOptionPane.showMessageDialog(null, "Người này không còn tồn tại",
                        "Lỗi!", JOptionPane.ERROR_MESSAGE);}
            else if (sqlex.getErrorCode() == 1){
                JOptionPane.showMessageDialog(null, "Số điện thoại này đã tồn tại",
                        "Lỗi!", JOptionPane.ERROR_MESSAGE);}
            sqlex.printStackTrace();
            return 1;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
        
    }
    
    //Thêm người cần giúp đỡ
    public static int AddPerson(Person person, Account account) {
        try {
            Connection con = OracleConnection.getOracleConnection();
            String sql = "{CALL PROC_INSERT_PERSON(?,?,?,?,?,?,?,?,?)}";
            CallableStatement ps = con.prepareCall(sql);
            
            
            ps.setString(1, person.getUsername());
            ps.setString(2, account.getPassword());
            ps.setString(3, person.getName());
            ps.setInt(4, person.getGender());
            ps.setString(5, person.getPhone());
            ps.setString(6, person.getProvince());
            ps.setString(7, person.getDistrict());
            ps.setString(8, person.getTown());
            ps.setString(9, person.getAddress());
            
            ps.execute();
            
            ps.close();
            con.close();
        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 1400 ){
                JOptionPane.showMessageDialog(null, "Không được để trống các miền giá trị bắt buộc!",
                        "Lỗi!", JOptionPane.ERROR_MESSAGE);}
            else if (sqlex.getErrorCode() == 1){
                JOptionPane.showMessageDialog(null, "Số điện thoại hoặc tên người dùng này đã tồn tại",
                        "Lỗi!", JOptionPane.ERROR_MESSAGE);}
            sqlex.printStackTrace();
            return 1;
        } 
        
        catch (Exception ex) {
            ex.printStackTrace();
            return 1;
        }
        return 0;  
    }   
        
    //Thêm người cần giúp đỡ hotline
    public static int AddPersonHotLine(Person person) {
        try {
            Connection con = OracleConnection.getOracleConnection();
            String sql = "{CALL PROC_INSERT_HOTLINE(?,?,?,?,?,?,?)}";
            CallableStatement ps = con.prepareCall(sql);           
            
            
            ps.setString(1, person.getName());
            ps.setInt(2, person.getGender());
            ps.setString(3, person.getPhone());
            ps.setString(4, person.getProvince());
            ps.setString(5, person.getDistrict());
            ps.setString(6, person.getTown());
            ps.setString(7, person.getAddress());
            
            ps.execute();
            
            ps.close();
            con.close();
        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 1400 ){
                JOptionPane.showMessageDialog(null, "Không được để trống các miền giá trị bắt buộc!",
                        "Lỗi!", JOptionPane.ERROR_MESSAGE);}
            else if (sqlex.getErrorCode() == 1){
                JOptionPane.showMessageDialog(null, "Số điện thoại này đã tồn tại",
                        "Lỗi!", JOptionPane.ERROR_MESSAGE);}
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 1;
        }
        return 0;    
    }
    
    public static int DeletePerson (int Idper) {
        try {
            Connection con = OracleConnection.getOracleConnection();
            String sql = "{CALL PROC_DELETE_PERSON(?)}";
            CallableStatement ps = con.prepareCall(sql);           
            
            ps.setInt(1, Idper);
            
            ps.execute();
            
            ps.close();
            con.close();
            
        } catch (SQLException sqlex) {
            if (sqlex.getErrorCode() == 20032){
                JOptionPane.showMessageDialog(null, "Người cần giúp đỡ còn yêu cầu chưa được hoàn thành",
                        "Cảnh báo!", JOptionPane.WARNING_MESSAGE);}
                
            else if (sqlex.getErrorCode() == 20033){
                JOptionPane.showMessageDialog(null, "Người cần giúp đỡ còn yêu cầu tư vấn chưa được hoàn thành",
                        "Cảnh báo!", JOptionPane.WARNING_MESSAGE);}
            sqlex.printStackTrace();
            return 1;
        }  
        catch (Exception ex) {
            ex.printStackTrace();
            return 1;
        }
        return 0;    
    }
    
     public static String getNextValuePerson() {
        String id = "";
        try {
            Connection con = OracleConnection.getOracleConnection();
            String sql1 = "SELECT IDPER.NEXTVAL  s FROM DUAL";
            Statement statement1 = con.createStatement();
            ResultSet rs1 = statement1.executeQuery(sql1);
                       
            if (rs1.next()) {
                id = rs1.getString("s");
            }
            
            String sql2 = "ALTER SEQUENCE IDPER INCREMENT BY -1";
            Statement statement2 = con.createStatement();
            ResultSet rs2 = statement2.executeQuery(sql2);
            
            String sql3 = "SELECT IDPER.NEXTVAL FROM DUAL";
            Statement statement3 = con.createStatement();
            ResultSet rs3 = statement3.executeQuery(sql3);
            
            String sql4 = "ALTER SEQUENCE IDPER INCREMENT BY 1";
            Statement statement4 = con.createStatement();
            ResultSet rs4 = statement4.executeQuery(sql4);
            
            
            rs1.close();
            rs2.close();
            rs3.close();
            rs4.close();
            con.close();
            return id;
        } 
        
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    } 
     
      public static int getStatusPerson(String username){
        int statusPerson=-1;
        try {
            Connection con = OracleConnection.getOracleConnection();
            String sql = "SELECT status FROM Person WHERE username = ?";
            PreparedStatement  ps = con.prepareStatement(sql);
            ps.setString(1, username);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                statusPerson = rs.getInt("status");
                return statusPerson;
            }
            rs.close();
            //st.close();
            con.close();
        }
        catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } catch (UnsupportedOperationException uoe) {
            uoe.printStackTrace();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return statusPerson;
    }
    
      public  Person getPersonInfo(String username)
    {
        Person person = new Person();
    
         try {
            Connection con = OracleConnection.getOracleConnection();
            String sql = "SELECT * FROM Person WHERE Username = ?";
            PreparedStatement  ps = con.prepareStatement(sql);
            ps.setString(1, username);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                person.setIdper(rs.getInt("IDPER"));
                person.setUsername(rs.getString("USERNAME"));
                person.setName(rs.getString("NAME"));
                person.setGender(rs.getInt("Gender"));
                person.setPhone(rs.getString("PHONE"));
                person.setProvince(rs.getString("PROVINCE"));
                person.setDistrict(rs.getString("DISTRICT"));
                person.setTown(rs.getString("TOWN"));
                person.setAddress(rs.getString("ADDRESS"));
                person.setStatus(rs.getInt("STATUS"));
                return person;  
            }
            rs.close();
            //st.close();
            con.close();
            return person;
        }
        catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } catch (UnsupportedOperationException uoe) {
            uoe.printStackTrace();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return person;
    }
    
    
}