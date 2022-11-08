/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import ui.Login;

/**
 *
 * @author DELL
 */
public class MyMain {
    public static void main(String[] args) {
    try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) {
    
}
    
        Login login = new Login();
        login.setVisible(true);
    }
    }
