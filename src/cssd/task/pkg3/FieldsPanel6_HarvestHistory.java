/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import javax.swing.DefaultListModel;

/**
 *
 * @author trkirk
 */
public class FieldsPanel6_HarvestHistory extends javax.swing.JPanel {
    
    DefaultListModel model;
    
    /**
     * Creates new form FieldsPanel6_HarvestHistory
     */
    public FieldsPanel6_HarvestHistory() {
        initComponents();
        model = new DefaultListModel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jlPickHarvest = new javax.swing.JList<>();

        setBackground(new java.awt.Color(102, 153, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("View Field - Harvest History");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 37, 304, 18));

        jbtn_back.setText("Back");
        add(jbtn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 240, 89, 44));

        jlPickHarvest.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jlPickHarvest);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 61, 425, 161));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbtn_back;
    public javax.swing.JList<String> jlPickHarvest;
    // End of variables declaration//GEN-END:variables
}