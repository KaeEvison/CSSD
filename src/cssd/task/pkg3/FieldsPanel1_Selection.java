/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import javax.swing.DefaultListModel;

/**
 *
 * @author thoma
 */
public class FieldsPanel1_Selection extends javax.swing.JPanel {
    
    public DefaultListModel model;
    
    /**
     * Creates new form AMSGUI_ViewFields
     */
    public FieldsPanel1_Selection() {
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

        jLabel1 = new javax.swing.JLabel();
        jbtn_back = new javax.swing.JButton();
        jbtn_selectField = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlPickField = new javax.swing.JList<>();
        btnAddField = new javax.swing.JButton();
        btnRemoveField = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 153, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("View Fields - Fields Selection");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 340, -1));

        jbtn_back.setText("Back");
        add(jbtn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 89, 44));

        jbtn_selectField.setText("View Field");
        jbtn_selectField.setActionCommand("");
        add(jbtn_selectField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 132, 47));

        jlPickField.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jlPickField);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 278, 114));

        btnAddField.setText("Add new field");
        add(btnAddField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 140, -1));

        btnRemoveField.setText("Remove field");
        add(btnRemoveField, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 140, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAddField;
    public javax.swing.JButton btnRemoveField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtn_back;
    public javax.swing.JButton jbtn_selectField;
    public javax.swing.JList<String> jlPickField;
    // End of variables declaration//GEN-END:variables
}
