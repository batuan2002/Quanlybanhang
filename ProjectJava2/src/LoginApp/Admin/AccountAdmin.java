/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginApp.Admin;

import Database.Connect_db;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;

/**
 *
 * @author tuan
 */
public class AccountAdmin implements Initializable{

    //fields
    //staff
    
    @FXML
     private TextField username;
    @FXML
     private PasswordField password;
    
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    public AccountAdmin(){
        connection = ConnectionUtil.connectdb();
    }
    
    
    
    
    public void Login(ActionEvent event){
        String user = username.getText().toString();
        String pass = password.getText().toString();
        
        
        String sql = "SELECT * FRM employee WHERE user = ? and pass = ?";
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    String nameadmin, theEmail, thePhone, theBirthyear, theUsername;

    //getter
    //staff

    public String getnameadmin() {
        return nameadmin;
    }

    public String gettheEmail() {
        return theEmail;
    }

    public String getthePhone() {
        return thePhone;
    }

    public String gettheBirthyear() {
        return theBirthyear;
    }

    public String gettheUsername() {
        return theUsername;
    }

    //setter
    //staff
    public void setusername(String username) {
        this.theEmail = username;
    }

    public void setnameadmin(String nameadmin) {
        this.nameadmin = nameadmin;
    }

    public void settheEmail(String theEmail) {
        this.theEmail = theEmail;
    }

    public void setthePhone(String thePhone) {
        this.thePhone = thePhone;
    }

    public void settheBirthyear(String theBirthyear) {
        this.theBirthyear = theBirthyear;
    }

    public void settheUsername(String theUsername) {
        this.theUsername = theUsername;
    }

    //methods
    //load manager data
    public void loadData(String username) {

        String sql = "select * from users join user_detail on users.id = user_detail.user_id where username = '" + username + "'";

        try {
            Connection conn = Connect_db.getConnection();
            //ResultSet
            ResultSet a = conn.createStatement().executeQuery(sql);

            //add data
            while (a.next()) {
                //Iterate Row
                setusername(a.getString("username"));
                setnameadmin(a.getString("nameadmin"));
                settheEmail(a.getString("theEmail"));
                setthePhone(a.getString("thePhone"));
                settheBirthyear(a.getString("theBirthyear"));
                settheUsername(a.getString("theUsername"));

            }
        } catch (SQLException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
