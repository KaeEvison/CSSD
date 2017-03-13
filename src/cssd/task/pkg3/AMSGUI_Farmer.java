/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JOptionPane;

import java.util.ArrayList;

/**
 *
 * @author b3014277, trkirk
 */
public class AMSGUI_Farmer extends AMSGUI_User {

    private Farmer currentFarmer = null;

    private Field currentField;
    private SetOfSensorReadings currentSensorReadings;
    private SetOfFields fields;
    private SetOfFarmers farmers;
    private int page = 0;

    private MenuPanel_Farmer menu;
    private OrdersPanel1_Farmer_Selection op1;
    private OrdersPanel3_Farmer_Update op3;
    private FieldsPanel1_Selection fp1;
    private FieldsPanel2_Options fp2;
    private FieldsPanel3_CheckCrops fp3;
    private FieldsPanel4_RecordHarvest fp4;
    private FieldsPanel5_RecordPlanting fp5;
    private FieldsPanel6_HarvestHistory fp6;
    private myAccountPanel_Farmer ac;
    /**
     * Creates new form AMSGUI
     */
    public AMSGUI_Farmer(Farmer currentFarmer, Server server) {
        super();
        initComponents();

        this.currentServer = server;
        this.currentFarmer = currentFarmer;
        this.fields = currentFarmer.getFields();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("AMS");
        setSize(660, 550);

        initManualComponents();

        jbl_username.setText(currentFarmer.getUsername());

        addFarmerListeners();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 153, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 661, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Function resets and updates the lists of orders on the UI
    void resetOrderJLists() {
        op2.model.clear();
        op3.model.clear();

        // Append the status of order(s) to order listings
        String orderStatus = "";

        for (int i = 0; i < currentFarmer.orders.size(); ++i) {

            if (currentFarmer.orders.get(i).
                    getStatus().toLowerCase().equals("complete")
                    || currentFarmer.orders.get(i).
                    getStatus().toLowerCase().equals("cancelled")) {

                if (currentFarmer.orders.get(i).
                        getStatus().toLowerCase().equals("cancelled")) {
                    orderStatus = "Cancelled";
                } else {
                    orderStatus = "Delivered: " + currentFarmer.orders.get(i).
                            getEstimatedDeliveryDate().toLocalDate();
                }

                // Retrieve and display order details
                op2.model.addElement("#" + (i + 1)
                        + ".   Customer: " + currentFarmer.orders.get(i).
                        getBuyer().getUsername()
                        + "    Date: " + currentFarmer.orders.get(i).
                        getDateCreated().toLocalDate()
                        + "        " + orderStatus
                        + "    Crop: " + currentFarmer.orders.get(i).getCrop()
                        + "    Total: " + currentFarmer.orders.get(i).getCost()
                );
            }

            // Only display active orders on the current orders view
            if (currentFarmer.orders.get(i).
                    getStatus().toLowerCase().equals("active")) {
                op3.model.addElement("#" + (i + 1)
                        + ".    Customer: " + currentFarmer.orders.get(i).
                        getBuyer().getUsername()
                        + "           Date: " + currentFarmer.orders.get(i).
                        getDateCreated().toLocalDate()
                        + "           Due: " + currentFarmer.orders.get(i).
                        getEstimatedDeliveryDate().toLocalDate()
                        + "           Crop: " + currentFarmer.orders.get(i).getCrop()
                        + "           Total: " + currentFarmer.orders.get(i).getCost()
                );
            }
        }
    }

    //Function resets and updates the lists of fields on the UI
    void resetFieldJLists() {
        fp1.model.clear();

        for (int i = 0; i < currentFarmer.getFields().size(); ++i) {
            fp1.model.addElement("Field " + (i + 1) + " (" + currentFarmer.getFields().
                    getFieldByIndex(i).getPlanting().getType() + ")");
        }
    }

    protected void initManualComponents() {

        menu = new MenuPanel_Farmer();

        op1 = new OrdersPanel1_Farmer_Selection();
        op2 = new OrdersPanel2_OrderHistory();
        op3 = new OrdersPanel3_Farmer_Update();

        fp1 = new FieldsPanel1_Selection();
        fp2 = new FieldsPanel2_Options();
        fp3 = new FieldsPanel3_CheckCrops();
        fp4 = new FieldsPanel4_RecordHarvest();
        fp5 = new FieldsPanel5_RecordPlanting(currentServer.availableCrops);
        fp6 = new FieldsPanel6_HarvestHistory();
        
        ac = new myAccountPanel_Farmer();

        layout = new CardLayout();

        fp1.model = new DefaultListModel<Field>();
        op2.model = new DefaultListModel<Order>();
        op3.model = new DefaultListModel<Order>();

        resetFieldJLists();

        resetOrderJLists();

        fp1.jlPickField.setModel(fp1.model);
        op2.jlPickOrder.setModel(op2.model);
        op3.jlPickOrder.setModel(op3.model);
        fp6.jlPickHarvest.setModel(fp6.model);
        contentPane.setLayout(layout);
        contentPane.add(menu, "menu");
        contentPane.add(op1, "op1");
        contentPane.add(op2, "op2");
        contentPane.add(op3, "op3");
        contentPane.add(fp1, "fp1");
        contentPane.add(fp2, "fp2");
        contentPane.add(fp3, "fp3");
        contentPane.add(fp4, "fp4");
        contentPane.add(fp5, "fp5");
        contentPane.add(fp6, "fp6");
        contentPane.add(ac, "ac");

        pack();
        setLocationByPlatform(true);

        layout.show(contentPane, "menu");

        df = new DecimalFormat("##.##");
    }

    //Shows the manage fields screen
    private void displayFields() {
        layout.show(contentPane, "fp1");
    }

    //If a field is selected, shows the field options screen for that field, else alerts the user that no field is selected
    private void viewField() {
        if (fp1.jlPickField.getSelectedIndex() != -1) {
            layout.show(contentPane, "fp2");
        } else {
            JOptionPane.showMessageDialog(getContentPane(),
                    "No field selected");
        }
    }

    //Shows the record harvest screen
    private void displayRecordHarvest() {
        layout.show(contentPane, "fp4");
    }

    //Updates the title and shows the manage sensors screen
    private void displayCrops() {
        fp3.jbl_title.setText("Sensor readings - " + fp1.jlPickField.
                getSelectedValue());

        layout.show(contentPane, "fp3");
    }

    //Sets the current field based on user selection then calls viewField
    private void clickSelectField() {
        currentField = fields.getFieldByIndex(fp1.jlPickField.getSelectedIndex());
        viewField();
    }

    //If there is a valid planting, displays the record harvest screen, else informs the user that there is no current planting
    private void clickRecordHarvest() {
        if (!currentField.currentPlanting.getType().equals("Empty")) {
            fp4.jlbl_title.setText("View Fields - "
                    + fp1.jlPickField.getSelectedValue()
                    + " (Record Harvest)");
            displayRecordHarvest();
        } else {
            JOptionPane.showMessageDialog(getContentPane(),
                    "No current planting");
        }
    }

    //As long as there is not currently a valid planting, shows the record planting screen, else informs the user that there is already a planting
    private void clickRecordPlanting() {
        if (currentField != null
                && (currentField.currentPlanting == null || currentField.currentPlanting.getType().equals("Empty"))) {
            fp5.jlbl_title.setText(fp1.jlPickField.getSelectedValue() + " (Record Planting)");
            layout.show(contentPane, "fp5");
        } else {
            JOptionPane.showMessageDialog(getContentPane(),
                    "Planting harvest not yet recorded: "
                    + "Please record your latest harvest"
                    + " before recording a new planting.");
        }
    }

    //As long as all fields have relevant entries, records a narvest, else informs the user that fields are missing
    private void clickSaveHarvestDetails() {
        if (currentField != null
                && currentField.currentPlanting != null
                && !currentField.currentPlanting.getType().equals("Empty")
                && !currentField.currentPlanting.getType().equals("")
                && currentField.currentPlanting.getType() != null
                && fp4.jdccRecordHarvest.getSelectedDate() != null
                && fp4.jspnYield.getValue() != null) {

            fp2.jbl_fieldname.setText("View Fields - Field (Empty)");

            currentField.recordNewHarvest(
                    new Harvest(new Planting(
                            currentField.currentPlanting.getType(),
                            currentField.currentPlanting.getPricePerTon()
                    ),
                            fp4.jdccRecordHarvest.getSelectedDate().getTime(),
                            (double) fp4.jspnYield.getValue(),
                            fp1.jlPickField.getSelectedIndex()
                    )
            );

            JOptionPane.showMessageDialog(getContentPane(),
                    "Harvest successfully recorded");

            //currentServer.updateFarmer(currentFarmer);
            layout.show(contentPane, "fp2");
        } else {
            JOptionPane.showMessageDialog(getContentPane(),
                    "Failed to record harvest: "
                    + "Please make sure all "
                    + "of the required fields are filled in.");
        }
    }

    //Checks that all fields have a valid entry then records a new planting
    private void clickSavePlantingDetails() {
        if (currentField != null
                && (currentField.currentPlanting != null
                || !currentField.currentPlanting.getType().equals("Empty"))
                && fp5.jtf_type.getSelectedItem().toString() != null
                && fp5.jns_pricePerTon.getValue() != null
                && fp5.jns_growthTime.getValue() != null
                && fp5.jns_growthTime.getValue() != null
                && fp5.jns_soilTemperatureLevel.getValue() != null
                && fp5.jns_soilTemperatureLevel.getValue() != null
                && fp5.jns_soilAcidityLevel.getValue() != null
                && fp5.jns_airTemperatureLevel.getValue() != null) {
            currentField.recordNewPlanting(
                    new Planting(
                            fp5.jtf_type.getSelectedItem().toString(),
                            (float) fp5.jns_pricePerTon.getValue(),
                            (int) fp5.jns_growthTime.getValue(),
                            (int) fp5.jns_growthTime.getValue(),
                            (int) fp5.jns_soilTemperatureLevel.getValue(),
                            (int) fp5.jns_soilAcidityLevel.getValue(),
                            (int) fp5.jns_airTemperatureLevel.getValue()
                    )
            );
            JOptionPane.showMessageDialog(getContentPane(),
                    "Planting successfully recorded");

            //currentServer.updateFarmer(currentFarmer);
            layout.show(contentPane, "fp2");

        }
    }

    //As long as there is at least one order tied to the current user, displays all orders, else informs the user that there were no orders found
    @Override
    public void displayOrderHistory() {
        if (currentFarmer != null
                && currentFarmer.orders.size() > 0) {
            op2.model.clear();

            for (int i = 0; i < currentFarmer.orders.size(); ++i) {
                op2.model.addElement("#" + (i + 1)
                        + ".       Customer: " + currentFarmer.orders.get(i).
                        getBuyer().getFirstName()
                        + currentFarmer.orders.get(i).getBuyer().getSurname()
                        + "        Due: " + currentFarmer.orders.get(i).getEstimatedDeliveryDate().toLocalDate()
                        + "        Crop: " + currentFarmer.orders.get(i).getCrop()
                        + "        Total: " + df.format(currentFarmer.orders.get(i).getCost())
                        + "        Status: " + currentFarmer.orders.get(i).getStatus()
                );
            }

            op2.jlPickOrder.setModel(op2.model);
            this.layout.show(contentPane, "op2");
        } else {
            JOptionPane.showMessageDialog(getContentPane(), "No order(s) found.");
        }
    }

    //Displays the harvest history for the selected field
    private void displayHarvestHistory() {
        if (fp1.jlPickField.getSelectedIndex() != -1) {

            currentField = currentFarmer.fields.getFieldByIndex(fp1.jlPickField.getSelectedIndex());
            fp6.model.clear();

            for (int i = 0; i < currentField.harvestHistory.size(); ++i) {

                if (fp1.jlPickField.getSelectedIndex() == currentField.harvestHistory.get(i).field) {

                    fp6.model.addElement("Planting: " + currentField.harvestHistory.get(i).getPlanting().getType()
                            + "      Yield (%): " + currentField.harvestHistory.get(i).getYield()
                            + "      Price Per Ton (£): " + currentField.harvestHistory.get(i).getPlanting().getPricePerTon()
                            + "      Date Harvested: " + currentField.harvestHistory.get(i).getTimeHarvested().toGMTString()
                    );
                }
            }

            layout.show(contentPane, "fp6");
        } else {
            JOptionPane.showMessageDialog(getContentPane(),
                    "Please select re-select field and try again");
        }
    }

    //Updates the manage sensors screen, each of five sets of components is populated by values from the current field's sensor monitors
    //based on the current page
    private void updateSensorValues() {
        clearSensorScreen();
        fp3.lblPageNumber.setText((page + 1) + "");
        if (currentField.activeMonitors.size() > page * 5) {
            //Each element is set using attributes of the latest sensor reading in the relevant monitor's log then made visible
            fp3.lblType1.setText(currentField.getMonitors().get(page * 5).getReadings().mostRecent().getType());
            fp3.txtValue1.setText(currentField.getMonitors().get(page * 5).getReadings().mostRecent().getValue() + "");
            fp3.lblUnit1.setText(currentField.getMonitors().get(page * 5).getReadings().mostRecent().getUnit());
            fp3.lblType1.setVisible(true);
            fp3.txtValue1.setVisible(true);
            fp3.lblUnit1.setVisible(true);
            fp3.btnRemoveSensor1.setVisible(true);
            if (currentField.activeMonitors.size() > (page * 5) + 1) {
                fp3.lblType2.setText(currentField.getMonitors().get((page * 5) + 1).getReadings().mostRecent().getType());
                fp3.txtValue2.setText(currentField.getMonitors().get((page * 5) + 1).getReadings().mostRecent().getValue() + "");
                fp3.lblUnit2.setText(currentField.getMonitors().get((page * 5) + 1).getReadings().mostRecent().getUnit());
                fp3.lblType2.setVisible(true);
                fp3.txtValue2.setVisible(true);
                fp3.lblUnit2.setVisible(true);
                fp3.btnRemoveSensor2.setVisible(true);
                if (currentField.activeMonitors.size() > (page * 5) + 2) {
                    fp3.lblType3.setText(currentField.getMonitors().get((page * 5) + 2).getReadings().mostRecent().getType());
                    fp3.txtValue3.setText(currentField.getMonitors().get((page * 5) + 2).getReadings().mostRecent().getValue() + "");
                    fp3.lblUnit3.setText(currentField.getMonitors().get((page * 5) + 2).getReadings().mostRecent().getUnit());
                    fp3.lblType3.setVisible(true);
                    fp3.txtValue3.setVisible(true);
                    fp3.lblUnit3.setVisible(true);
                    fp3.btnRemoveSensor3.setVisible(true);
                    if (currentField.activeMonitors.size() > (page * 5) + 3) {
                        fp3.lblType4.setText(currentField.getMonitors().get((page * 5) + 3).getReadings().mostRecent().getType());
                        fp3.txtValue4.setText(currentField.getMonitors().get((page * 5) + 3).getReadings().mostRecent().getValue() + "");
                        fp3.lblUnit4.setText(currentField.getMonitors().get((page * 5) + 3).getReadings().mostRecent().getUnit());
                        fp3.lblType4.setVisible(true);
                        fp3.txtValue4.setVisible(true);
                        fp3.lblUnit4.setVisible(true);
                        fp3.btnRemoveSensor4.setVisible(true);
                        if (currentField.activeMonitors.size() > (page * 5) + 4) {
                            fp3.lblType5.setText(currentField.getMonitors().get((page * 5) + 4).getReadings().mostRecent().getType());
                            fp3.txtValue5.setText(currentField.getMonitors().get((page * 5) + 4).getReadings().mostRecent().getValue() + "");
                            fp3.lblUnit5.setText(currentField.getMonitors().get((page * 5) + 4).getReadings().mostRecent().getUnit());
                            fp3.lblType5.setVisible(true);
                            fp3.txtValue5.setVisible(true);
                            fp3.lblUnit5.setVisible(true);
                            fp3.btnRemoveSensor5.setVisible(true);
                            if (currentField.activeMonitors.size() > ((page + 1) * 5)) {
                                fp3.btnNextPage.setEnabled(true);
                            }
                        }
                    }
                }
            }
        }
    }

    //Sets the visible atrtibute of all sensor components on the manage sensors screen to false in preparation for updating
    private void clearSensorScreen() {
        fp3.lblType1.setVisible(false);
        fp3.txtValue1.setVisible(false);
        fp3.lblUnit1.setVisible(false);
        fp3.btnRemoveSensor1.setVisible(false);
        fp3.lblType2.setVisible(false);
        fp3.txtValue2.setVisible(false);
        fp3.lblUnit2.setVisible(false);
        fp3.btnRemoveSensor2.setVisible(false);
        fp3.lblType3.setVisible(false);
        fp3.txtValue3.setVisible(false);
        fp3.lblUnit3.setVisible(false);
        fp3.btnRemoveSensor3.setVisible(false);
        fp3.lblType4.setVisible(false);
        fp3.txtValue4.setVisible(false);
        fp3.lblUnit4.setVisible(false);
        fp3.btnRemoveSensor4.setVisible(false);
        fp3.lblType5.setVisible(false);
        fp3.txtValue5.setVisible(false);
        fp3.lblUnit5.setVisible(false);
        fp3.btnRemoveSensor5.setVisible(false);
    }

    @Override
    public void addListeners() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(getContentPane(), "Logging Off");
            }
        });
    }

    // Event handling located here:
    public void addFarmerListeners() {

        menu.jbtn_viewFields.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayFields();
            }
        });

        menu.jbtn_viewOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayOrders();
            }
        });

        menu.jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "ac");
                ac.firstname_field.setText(currentFarmer.getFirstName());
                ac.surname_field.setText(currentFarmer.getSurname());
                ac.loc_field.setText(currentFarmer.getLocation());
                ac.phone_field.setText(currentFarmer.getPhoneNumber());
            }
        });
        
        ac.updatePass_btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String pass1 = new String(ac.oldPasswordField1.getPassword());
                String pass2 = new String(ac.newPasswordField.getPassword());
                String pass3 = new String(ac.confirmField.getPassword());
        
                if (ac.oldPasswordField.getText() == "" || ac.newPasswordField.getText() == "" || ac.confirmField.getText() == "") {           
                    JOptionPane.showMessageDialog(getContentPane(), "Password field(s) missing!");
                }
                else if(!pass2.equals(pass3)){
                    JOptionPane.showMessageDialog(getContentPane(), "New passwords do not match!");
                }
                else if(!pass1.equals(currentFarmer.getPassword()))
                {
                    JOptionPane.showMessageDialog(getContentPane(), "Old password incorrect!");
                }
                else{
                    currentFarmer.changePassword(pass3, pass1);
                    JOptionPane.showMessageDialog(getContentPane(), "Password changed!");
                }
                
                ac.oldPasswordField1.setText("");
                ac.newPasswordField.setText("");
                ac.confirmField.setText("");
            }
        });
        ac.update_btn.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               if (!ac.firstname_field.getText().equals(currentFarmer.getFirstName())) {
                   currentFarmer.setFirstName(ac.firstname_field.getText());
               }
               if (!ac.surname_field.getText().equals(currentFarmer.getSurname())) {
                   currentFarmer.setSurname(ac.surname_field.getText());
               }
               if (!ac.loc_field.getText().equals(currentFarmer.getLocation())) {
                   currentFarmer.setLocation(ac.loc_field.getText());
               }
               if (!ac.phone_field.getText().equals(currentFarmer.getPhoneNumber())) {
                   currentFarmer.setPhoneNumber(ac.phone_field.getText());
               }     
               JOptionPane.showMessageDialog(getContentPane(), "Account information updated!");
           } 
        });
        
        ac.deleteAccount_btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                int result = JOptionPane.showConfirmDialog(getContentPane(), "Deleting your account is permanent. Do you wish to continue?", "DELETING ACCOUNT" ,JOptionPane.YES_NO_OPTION);
                
                if(result == JOptionPane.YES_OPTION)
                {
                   currentServer.removeFarmer(currentFarmer);   

                }
 
            }
        });
        
        ac.back_btn.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               layout.show(contentPane, "menu");
           } 
        });
        

        op1.jbtn_back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "menu");
            }
        });

        op1.jbtn_currentOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "op3");
            }
        });

        op1.jbtn_orderHistory.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                displayOrderHistory();
            }
        });

        op2.jbtn_back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "op1");
            }
        });

        op3.jbtn_back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "op1");
            }
        });

        fp1.jbtn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "menu");
            }
        });

        fp1.jlPickField.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                
                if (fp1.jlPickField.getSelectedValue() != null) {
                    currentField = fields.
                            getFieldByIndex(fp1.jlPickField.getSelectedIndex());
                }
            }
        });

        op3.jlPickOrder.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                
                for (int i = 0; i < currentFarmer.orders.size(); ++i) {
                    if (currentFarmer.orders.get(i).
                            getStatus().toLowerCase().equals("active")) {
                        currentOrder = currentFarmer.orders.get(i);
                    }
                }
            }
        });

        op3.jbtn_cancelOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentOrder != null) {

                    currentOrder.setStatus("cancelled");
                    JOptionPane.showMessageDialog(getContentPane(), "Order cancelled.");
                    resetOrderJLists();
                    //currentServer.updateFarmer(currentFarmer);
                    currentServer.updateOrders(currentFarmer.orders);

                } else {
                    JOptionPane.showMessageDialog(getContentPane(), "No order selected");
                }
            }
        });

        op3.jbtn_completeOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentOrder != null) {

                    currentOrder.setStatus("complete");
                    JOptionPane.showMessageDialog(getContentPane(), "Order Completed");
                    resetOrderJLists();
                    //currentServer.updateFarmer(currentFarmer);
                    currentServer.updateOrders(currentFarmer.orders);

                } else {
                    JOptionPane.showMessageDialog(getContentPane(), "No order selected");
                }
            }
        });

        fp1.jbtn_selectField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (currentField != null) {
                    fp2.jbl_fieldname.setText("View Fields - " + fp1.jlPickField.getSelectedValue());
                    clickSelectField();
                } else {
                    JOptionPane.showMessageDialog(getContentPane(), "No field selected");
                }
            }
        });

        fp1.btnAddField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentFarmer.getFields().addField(new Field());
                resetFieldJLists();
                //currentServer.updateFarmer(currentFarmer);
                JOptionPane.showMessageDialog(getContentPane(), "New field added");
            }
        });

        fp1.btnRemoveField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fp1.jlPickField.getSelectedIndex() != -1) {
                    int confirmDelete = JOptionPane.showConfirmDialog(getContentPane(), "Are you sure you want to delete the selected field?");
                    if (confirmDelete == 0) {
                        int pos = fp1.jlPickField.getSelectedIndex();
                        currentFarmer.getFields().removeField(pos);
                        //currentServer.updateFarmer(currentFarmer);
                        resetFieldJLists();
                        JOptionPane.showMessageDialog(getContentPane(), "Field removed");
                    }
                } else {
                    JOptionPane.showMessageDialog(getContentPane(),
                            "No field selected");
                }
            }
        });

        fp2.jbtn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "fp1");
            }
        });

        fp2.jbtn_checkCrops.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentField.currentPlanting != null) {
                    displayCrops();
                    updateSensorValues();
                } else {
                    JOptionPane.showMessageDialog(getContentPane(), "Please create a field planting first");
                }
            }
        });

        fp2.jbtn_recordHarvest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentField.currentPlanting != null) {
                    clickRecordHarvest();
                } else {
                    JOptionPane.showMessageDialog(getContentPane(),
                            "No active planting found. Please enter a new planting"
                            + " before recording your harvest.");
                }
            }
        });

        fp2.jbtn_recordPlanting.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickRecordPlanting();
            }
        });

        fp2.jbtn_harvestHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayHarvestHistory();
            }
        });

        fp3.jbtn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "fp2");
            }
        });

        fp3.btnGetReadings.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentField.activeMonitors.getNewReadings();
                updateSensorValues();
            }
        });

        //Creates a new sensor monitor with a sensor assigned to it and adds it to the current field, the sensor type is dependant on user input
        fp3.btnAddSensor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fp3.cmbSensorSelect.getSelectedIndex() == 0) {
                    currentField.activeMonitors.add(new SensorMonitor(new AirHumiditySensor(new Location(1, 1))));
                } else if (fp3.cmbSensorSelect.getSelectedIndex() == 1) {
                    currentField.activeMonitors.add(new SensorMonitor(new AirTemperatureSensor(new Location(1, 1))));
                } else if (fp3.cmbSensorSelect.getSelectedIndex() == 2) {
                    currentField.activeMonitors.add(new SensorMonitor(new LightSensor(new Location(1, 1))));
                } else if (fp3.cmbSensorSelect.getSelectedIndex() == 3) {
                    currentField.activeMonitors.add(new SensorMonitor(new SoilAciditySensor(new Location(1, 1))));
                } else if (fp3.cmbSensorSelect.getSelectedIndex() == 4) {
                    currentField.activeMonitors.add(new SensorMonitor(new SoilMoistureSensor(new Location(1, 1))));
                } else if (fp3.cmbSensorSelect.getSelectedIndex() == 5) {
                    currentField.activeMonitors.add(new SensorMonitor(new SoilTemperatureSensor(new Location(1, 1))));
                }
                updateSensorValues();
            }
        });
        
        fp3.btnRemoveSensor1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentField.activeMonitors.remove(page * 5);
                updateSensorValues();
            }
        });

        fp3.btnRemoveSensor2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentField.activeMonitors.remove((page * 5) + 1);
                updateSensorValues();
            }
        });

        fp3.btnRemoveSensor3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentField.activeMonitors.remove((page * 5) + 2);
                updateSensorValues();
            }
        });

        fp3.btnRemoveSensor4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentField.activeMonitors.remove((page * 5) + 3);
                updateSensorValues();
            }
        });

        fp3.btnRemoveSensor5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentField.activeMonitors.remove((page * 5) + 4);
                updateSensorValues();
            }
        });

        //Handles pagination fucntionality for the manage sensors screen, allowing for an unlimited number of sensors to be viewed
        fp3.btnNextPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                page++;
                if (currentField.activeMonitors.size() <= (page + 1) * 5) {
                    fp3.btnNextPage.setEnabled(false);
                }
                fp3.btnPreviousPage.setEnabled(true);
                updateSensorValues();
            }
        });

        //Handles pagination fucntionality for the manage sensors screen, allowing for an unlimited number of sensors to be viewed
        fp3.btnPreviousPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                page--;
                if (page == 0) {
                    fp3.btnPreviousPage.setEnabled(false);
                }
                fp3.btnNextPage.setEnabled(true);
                updateSensorValues();
            }
        });

        //Returns to the field options screen
        fp4.jbtn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "fp2");
            }
        });

        //Attempts to save harvest details then updates the field list on the UI, a variable is used to carry the field selection over the list's reset
        fp4.jbtn_submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                int temp = fp1.jlPickField.getSelectedIndex();
                clickSaveHarvestDetails();
                resetFieldJLists();
                fp1.jlPickField.setSelectedIndex(temp);
            }
        });

        //Returns to the field options screen
        fp5.jbtn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "fp2");
            }
        });

        //Attempts to save planting details then updates the field list on the UI, a variable is used to carry the field selection over the list's reset
        fp5.jbtn_submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                int temp = fp1.jlPickField.getSelectedIndex();
                clickSavePlantingDetails();
                resetFieldJLists();
                fp1.jlPickField.setSelectedIndex(temp);
            }
        });

        //Returns to the field options screen
        fp6.jbtn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "fp2");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
