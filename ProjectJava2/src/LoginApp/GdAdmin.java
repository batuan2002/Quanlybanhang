/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginApp;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author ASUS
 */
public class GdAdmin {
    
    @FXML
    private Button signout;
    
    
    private void uerLogout(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("Login.fmxl");
    }    
}
