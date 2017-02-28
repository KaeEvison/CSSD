/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import javax.swing.SpinnerNumberModel;

/**
 *
 * @author trkirk
 */
public class FieldsPanel5_RecordPlanting extends javax.swing.JPanel {

    /**
     * Creates new form AMSGUI_FieldsPanel5_RecordPlanting
     */
    public FieldsPanel5_RecordPlanting() {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlbl_title = new javax.swing.JLabel();
        jbtn_back = new javax.swing.JButton();
        jns_growthTime = new javax.swing.JSpinner();
        jns_soilTemperatureLevel = new javax.swing.JSpinner();
        jns_soilAcidityLevel = new javax.swing.JSpinner();
        jbtn_submit = new javax.swing.JButton();
        jtf_type = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jns_airTemperatureLevel = new javax.swing.JSpinner();
        jns_pricePerTon = new javax.swing.JSpinner();
        jns_soilMoistureLevel = new javax.swing.JSpinner();

        setBackground(new java.awt.Color(102, 153, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Growth Time:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Pref. Soil Moisture Lvl:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Price (per Ton):");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Pref. Soil Acidity Lvl:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Pref. Soil Temp. Level:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        jlbl_title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jlbl_title.setText("View Fields - Record Planting");
        add(jlbl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jbtn_back.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtn_back.setText("Back");
        add(jbtn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, -1, -1));

        jns_growthTime.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        add(jns_growthTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 90, -1));

        jns_soilTemperatureLevel.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        add(jns_soilTemperatureLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 90, -1));

        jns_soilAcidityLevel.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        add(jns_soilAcidityLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 90, -1));

        jbtn_submit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtn_submit.setText("Submit");
        add(jbtn_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 278, -1));
        add(jtf_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 150, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Type:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setText("Pref. Air Temp. Level:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        jns_airTemperatureLevel.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        add(jns_airTemperatureLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 90, -1));

        jns_pricePerTon.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, 100.0f, 0.1f));
        add(jns_pricePerTon, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 90, -1));

        jns_soilMoistureLevel.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        add(jns_soilMoistureLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 90, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JButton jbtn_back;
    public javax.swing.JButton jbtn_submit;
    public javax.swing.JLabel jlbl_title;
    public javax.swing.JSpinner jns_airTemperatureLevel;
    public javax.swing.JSpinner jns_growthTime;
    public javax.swing.JSpinner jns_pricePerTon;
    public javax.swing.JSpinner jns_soilAcidityLevel;
    public javax.swing.JSpinner jns_soilMoistureLevel;
    public javax.swing.JSpinner jns_soilTemperatureLevel;
    public javax.swing.JTextField jtf_type;
    // End of variables declaration//GEN-END:variables
}