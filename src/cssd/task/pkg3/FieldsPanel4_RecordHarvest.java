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
public class FieldsPanel4_RecordHarvest extends javax.swing.JPanel {

    //private UtilDateModel model;
    //private Properties p;
    //private JDatePanelImpl datePanel;
    //private JDatePickerImpl datePicker;
    
    /**
     * Creates new form AMSGUI_FieldsPanel4_RecordHarvest
     */
    public FieldsPanel4_RecordHarvest() {
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

        jbtn_back = new javax.swing.JButton();
        jdccRecordHarvest = new datechooser.beans.DateChooserCombo();
        jlbl_title = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jspnYield = new javax.swing.JSpinner();
        jbtn_submit = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 153, 0));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtn_back.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtn_back.setText("Back");
        add(jbtn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 242, -1, -1));
        add(jdccRecordHarvest, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        jlbl_title.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jlbl_title.setText("View Fields - Record Harvest");
        add(jlbl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Yield:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Date Harvested:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        jspnYield.setModel(new SpinnerNumberModel(0.0, 0.0, 100.00, 0.1));
        jspnYield.setName(""); // NOI18N
        add(jspnYield, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 152, -1));

        jbtn_submit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbtn_submit.setText("Submit");
        jbtn_submit.setName("btnRecordHarvest"); // NOI18N
        jbtn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_submitActionPerformed(evt);
            }
        });
        add(jbtn_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 360, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_submitActionPerformed
        //------------------------
        //Dont know how to fetch planting/farmer name
        //------------------------
//        Harvest newHarvest = new Harvest(new Planting(), jdccRecordHarvest.getCurrent().getTime(), (double)jspnYield.getValue());
//        Server.recordHarvest(newHarvest, "Jim");
    }//GEN-LAST:event_jbtn_submitActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JButton jbtn_back;
    public javax.swing.JButton jbtn_submit;
    public datechooser.beans.DateChooserCombo jdccRecordHarvest;
    public javax.swing.JLabel jlbl_title;
    public javax.swing.JSpinner jspnYield;
    // End of variables declaration//GEN-END:variables
}
