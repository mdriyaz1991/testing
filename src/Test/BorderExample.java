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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;

public class BorderExample {

    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    private int hgap;
    private int vgap;
    private JTextField tfield1, tfield2;
    private JComboBox cbox1, cbox2;
    private JButton button;
    private String[] data = {"One", "Two"};

    public BorderExample() {
        hgap = 10;
        vgap = 25;
    }

    private void displayGUI() {
        JFrame frame = new JFrame("Border Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(BorderFactory.createEmptyBorder(hgap, hgap, hgap, hgap));
        contentPane.setLayout(new BorderLayout(hgap, vgap));

        topPanel = new JPanel();
        topPanel.setOpaque(true);
        topPanel.setBackground(Color.WHITE);
        topPanel.setBorder(BorderFactory.createTitledBorder("Top Panel"));
        tfield1 = new JTextField(10);
        tfield1.setBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createEtchedBorder(
                                EtchedBorder.RAISED, Color.GRAY, Color.DARK_GRAY), "JTextField"));
        JPanel comboPanel = new JPanel();
        cbox1 = new JComboBox(data);
        cbox1.setBorder(
                BorderFactory.createTitledBorder("JComboBox"));
        topPanel.add(tfield1);
        topPanel.add(cbox1);

        centerPanel = new JPanel();
        centerPanel.setOpaque(true);
        centerPanel.setBackground(Color.WHITE);
        centerPanel.setBorder(
                BorderFactory.createTitledBorder("Center Panel"));
        tfield2 = new JTextField(10);
        tfield2.setBorder(
                BorderFactory.createLoweredBevelBorder());
        cbox2 = new JComboBox(data);
        cbox2.setBorder(
                BorderFactory.createRaisedBevelBorder());
        centerPanel.add(tfield2);
        centerPanel.add(cbox2);

        bottomPanel = new JPanel();
        bottomPanel.setOpaque(true);
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setBorder(
                BorderFactory.createTitledBorder("Center Panel"));
        button = new JButton("Photooos");
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        try {
                            Desktop.getDesktop().open(new File("C:\\Users\\eriyamo\\Documents\\Coorg\\Camera"));

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
                            Logger.getLogger(FileExplorers.class.getName()).log(Level.SEVERE, null, ex);

                        }
                    }
                }
        );
        bottomPanel.add(button);
        contentPane.add(topPanel, BorderLayout.PAGE_START);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(bottomPanel, BorderLayout.PAGE_END);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BorderExample().displayGUI();
            }
        });
        System.out.println(" Changes made to check git hub updates 1");
         System.out.println(" Changes made to check git hub updates 2");
           
           System.out.println("12345");
    }
}
