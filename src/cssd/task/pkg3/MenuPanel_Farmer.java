/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author thoma
 */
public class MenuPanel_Farmer extends javax.swing.JPanel {

    /**
     * Creates new form AMSGUI_Menu
     */
    public MenuPanel_Farmer() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jbtn_viewFields = new javax.swing.JButton();
        jbtn_viewOrders = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 153, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Menu");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        jbtn_viewFields.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtn_viewFields.setText("View Fields");
        jbtn_viewFields.setName(""); // NOI18N
        add(jbtn_viewFields, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 358, 57));

        jbtn_viewOrders.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtn_viewOrders.setText("View Orders");
        add(jbtn_viewOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 358, 57));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("My Account");
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 358, 57));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JButton jbtn_viewFields;
    public javax.swing.JButton jbtn_viewOrders;
    // End of variables declaration//GEN-END:variables
}
