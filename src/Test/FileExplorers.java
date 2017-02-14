/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.TitledBorder;

public class FileExplorers {

    final JPanel Errorpanel = new JPanel();
    private JPanel ciassPanel;
    private JPanel storagePanel;
    private JPanel leavePanel;
    private int hgap, vgap;
    JButton button, button2;
    JButton button3, button4;
    ImagePanel imgpane;

    public FileExplorers() {
        hgap = 15;
        vgap = 15;
    }

    private void initialiseApp() {

        JFrame frame = new JFrame("Border Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(BorderFactory.createEmptyBorder(hgap, hgap, hgap, hgap));
        contentPane.setLayout(new BorderLayout(hgap, vgap));

        ciassPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        ciassPanel.setOpaque(true);
        ciassPanel.setBackground(Color.WHITE);
        ciassPanel.setBorder(BorderFactory.createTitledBorder("CIASS Panel"));
//        ciassPanel.setBackground(Color.red);

        button = new JButton("Photos");
        button2 = new JButton("IPM");

        ciassPanel.add(button);
        ciassPanel.add(button2);

        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        try {
                            Desktop.getDesktop().open(new File("C:\\Users\\ramo\\Documents\\Camera"));

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
                            Logger.getLogger(FileExplorers.class.getName()).log(Level.SEVERE, null, ex);

                        }
                    }
                }
        );
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        try {

                            Desktop.getDesktop().open(new File("C:\\Users\\ramo\\Documents\\IPM Goals 2016"));
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
                            Logger.getLogger(FileExplorers.class.getName()).log(Level.SEVERE, null, ex);

                        }
                    }
                }
        );

        storagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        storagePanel.setOpaque(true);
        storagePanel.setBackground(Color.WHITE);
        storagePanel.setBorder(BorderFactory.createTitledBorder("Storage Panel"));

        button3 = new JButton("Photos 2");
        button4 = new JButton("IPM 2");

        storagePanel.add(button3);
        storagePanel.add(button4);
        JPanel contentPane2 = new JPanel();
        leavePanel = new JPanel();
        imgpane = new ImagePanel("C:\\Users\\eriyamo\\Documents\\NetBeansProjects\\NetBeansProjects_1st_September\\HibernateExample\\Images\\emc.jpg");
        
        leavePanel.add(imgpane);
//        Grid
//        contentPane.setLayout(new GridBagLayout(1,2));
        contentPane.add(ciassPanel, BorderLayout.PAGE_START);
        contentPane.add(storagePanel, BorderLayout.CENTER);
        contentPane2.add(leavePanel, BorderLayout.PAGE_END);
//        contentPane.setBackground(Color.red);

//imgpane = new ImagePanel(new ImageIcon("C:\\Users\\eriyamo\\Documents\\NetBeansProjects\\NetBeansProjects_1st_September\\HibernateExample\\Images\\emc.jpg"));
        frame.setContentPane(contentPane);
        frame.setLayout(new GridLayout(1,2));
//        frame.setContentPane(contentPane2);
        frame.setSize(1000, 1000);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                 try {
//           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
              UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            Logger.getLogger(FileExplorers.class.getName()).log(Level.SEVERE, null, ex);
        }
                new FileExplorers().initialiseApp();
            }
        });

    }
}

class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}
