/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

/**
 *
 * @author thoma
 */
public class MenuPanel_User extends javax.swing.JPanel {

    /**
     * Creates new form AMSGUI_MenuPanel_User
     */
    public MenuPanel_User() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jbtn_viewOrders = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 153, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 153, 0));
        jPanel1.setLayout(new java.awt.GridBagLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Menu");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        jbtn_viewOrders.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtn_viewOrders.setText("View Orders");
        add(jbtn_viewOrders, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 358, 57));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton3.setText("My Account");
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 358, 57));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JButton jbtn_viewOrders;
    // End of variables declaration//GEN-END:variables
}