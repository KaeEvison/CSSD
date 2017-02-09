/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.ArrayList;


/**
 *
 * @author b3014277, trkirk
 */
public class AMSGUI extends JFrame
{
    private User currentUser;
    //private Field currentField;
    private SetOfSensorReadings currentSensorReadings;
    private Order currentOrder;
    private Server currentServer;
    //private SetOfFields fields;
    private ArrayList<Planting> availableCrops;

    private AMSGUI_MenuPanel menu;
    private AMSGUI_FieldsPanel1_Selection fp1;
    private AMSGUI_FieldsPanel2_Options fp2;
    private CardLayout layout;
    
    /**
     * Creates new form AMSGUI
     */
    public AMSGUI(User currentUser) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("AMS");
        setSize(680, 480);
        
        menu = new AMSGUI_MenuPanel();
        fp1 = new AMSGUI_FieldsPanel1_Selection();
        fp2 = new AMSGUI_FieldsPanel2_Options();
        
        currentUser = currentUser;
        jbl_username.setText( currentUser.getUsername() );
        
        layout = new CardLayout();
        
        contentPane.setLayout(layout);
        contentPane.add(menu, "menu");
        contentPane.add(fp1, "fp1");
        contentPane.add(fp2, "fp2");
        
        pack();
        setLocationByPlatform(true);
        layout.show(contentPane, "menu");
        
        addWindowListener(new WindowAdapter(){
            public void windowClosing( WindowEvent e){
                JOptionPane.showMessageDialog(getContentPane(), "Logging Off");
            }
        });
        
        menu.jbtn_viewFields.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(contentPane, "fp1");
            }
        });
        
        fp1.jbtn_back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(contentPane, "menu");
            }
        });
        
        fp1.jbtn_options.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(contentPane, "fp2");
            }
        });
        
        fp2.jbtn_back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                layout.show(contentPane, "fp1");
            }
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        contentPane = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jbl_username = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        container.setBackground(new java.awt.Color(102, 153, 0));

        header.setBackground(new java.awt.Color(102, 102, 0));
        header.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AMS");
        header.add(jLabel1, java.awt.BorderLayout.CENTER);

        contentPane.setLayout(new java.awt.CardLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Welcome,");

        jbl_username.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbl_username.setText("User!");

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(containerLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(containerLayout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JPanel contentPane;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jbl_username;
    // End of variables declaration//GEN-END:variables
}
