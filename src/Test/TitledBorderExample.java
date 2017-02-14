/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author eriyamo
 */
import javax.swing.*;
import javax.swing.border.TitledBorder;
 
public class TitledBorderExample {
 
  public static void main(String[] arguments) {
 
//    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("Titled Border Example");
    frame.setSize(300, 150);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
    TitledBorder border = new TitledBorder("This is my title");
    border.setTitleJustification(TitledBorder.CENTER);
    border.setTitlePosition(TitledBorder.TOP);
 
    JPanel panel = new JPanel();
    panel.setBorder(border);
 
    frame.add(panel);
 
    frame.setVisible(true);
  }
}
