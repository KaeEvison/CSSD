/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.text.DecimalFormat;

/**
 *
 * @author thoma
 */
public class AMSGUI_User extends javax.swing.JFrame {

    private ProductLineManager currentUser = null;
    protected Order currentOrder = null;
    protected Server currentServer = null;
    private ArrayList<Planting> availableCrops;
    private SetOfFarmers suitableFarmers = null;
    private Planting requiredPlanting = null;

    private MenuPanel_User menu;
    private OrdersPanel1_User_Selection op1;
    protected OrdersPanel2_OrderHistory op2;
    private OrdersPanel4_ProductSelection op4;
    private OrdersPanel5_SuitableFarmers op5;
    private OrdersPanel6_OrderDetails op6;
    private ManageFarmersPanel mfp;

    protected DecimalFormat df;
    protected CardLayout layout;

    /**
     * Creates new form AMSGUI_User
     */
    public AMSGUI_User(ProductLineManager currentUser, Server server, ArrayList<Planting> crops) {
        initComponents();
        initManualComponents();

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("AMS");
        setSize(660, 550);

        this.currentServer = server;
        this.currentUser = currentUser;

        jbl_username.setText(currentUser.getUsername());

        this.availableCrops = crops;

        addListeners();
    }

    // Default Constructor user by AMSGUI_Farmer to initialise inherited variables
    public AMSGUI_User() {
        initComponents();
        getContentPane().setBackground(new Color(102, 153, 0));
        addListeners();
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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        container.setBackground(new java.awt.Color(102, 153, 0));

        header.setBackground(new java.awt.Color(102, 102, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("AMS");

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        contentPane.setBackground(new java.awt.Color(102, 153, 0));

        javax.swing.GroupLayout contentPaneLayout = new javax.swing.GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Welcome,");

        jbl_username.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jbl_username.setText("User!");

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(260, Short.MAX_VALUE))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(containerLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    protected void initManualComponents() {
        df = new DecimalFormat("##.##");
        menu = new MenuPanel_User();
        op1 = new OrdersPanel1_User_Selection();
        op2 = new OrdersPanel2_OrderHistory();
        op4 = new OrdersPanel4_ProductSelection();
        op5 = new OrdersPanel5_SuitableFarmers();
        op5.model = new DefaultListModel<Farmer>();
        op2.model = new DefaultListModel<Order>();
        op6 = new OrdersPanel6_OrderDetails();
        mfp = new ManageFarmersPanel();
        mfp.jlPickFarmer.setModel(mfp.model);

        layout = new CardLayout();

        contentPane.setLayout(layout);
        contentPane.add(menu, "menu");
        contentPane.add(op1, "op1");
        contentPane.add(op2, "op2");
        contentPane.add(op4, "op4");
        contentPane.add(op5, "op5");
        contentPane.add(op6, "op6");
        contentPane.add(mfp, "mfp");

        pack();
        setLocationByPlatform(true);

        layout.show(contentPane, "menu");
    }

    //Shows the view orders screen
    protected void displayOrders() {
        this.layout.show(contentPane, "op1");
    }

    //As long as there is at least one order tied to the current user, displays all orders, else informs the user that there were no orders found
    public void displayOrderHistory() {
        if (currentUser != null
                && currentUser.orders.size() > 0) {

            op2.model.clear();

            for (int i = 0; i < currentUser.orders.size(); ++i) {
                op2.model.addElement("#" + (i + 1)
                        + ".       Supplier: " + currentUser.orders.get(i).
                        getSupplier().getFirstName()
                        + currentUser.orders.get(i).getSupplier().getSurname()
                        + "   " + currentUser.orders.get(i).getSupplier().getPhoneNumber()
                        + "   Delivery Date: " + currentUser.orders.get(i).getEstimatedDeliveryDate().toLocalDate()
                        + "   Crop: " + currentUser.orders.get(i).getCrop()
                        + "   Total: " + df.format(currentUser.orders.get(i).getCost())
                        + "   Status: " + currentUser.orders.get(i).getStatus()
                );
            }

            op2.jlPickOrder.setModel(op2.model);
            this.layout.show(contentPane, "op2");
        } else {
            JOptionPane.showMessageDialog(getContentPane(), "No order(s) found.");
        }
    }

    //Handles searching for farmers by crop required
    private void clickSelectCrop(int crop) {

        //Adds all farmers with the required crop
        requiredPlanting = availableCrops.get(crop);
        suitableFarmers = currentServer.getSuitableFarmers(requiredPlanting);
        
        //Removes all farmers on the user's blocklist
        for(int i=0; i<currentUser.blockList.size(); ++i){
            
            for(int j=0; j<suitableFarmers.size(); ++j){
                
                if( currentUser.blockList.get(i).getUsername().toLowerCase().
                    equals(suitableFarmers.get(j).getUsername().toLowerCase())){
                    suitableFarmers.remove(j);
                }
            }
        }
        
        if (suitableFarmers != null
                && suitableFarmers.size() > 0) {
            //JOptionPane.showMessageDialog(getContentPane(), "Suitable farmer(s) found for: " + aPlanting.getType());
            op5.model.clear();

            Planting planting;
            float price = 0.0f;

            //Fetches and displays the details of all relevant plantings
            for (int i = 0; i < suitableFarmers.size(); ++i) {
                
                for (int j = 0; j < (suitableFarmers.get(i).getFields()).size(); ++j) {

                    planting = suitableFarmers.get(i).getFields().getFieldByIndex(j).currentPlanting;

                    if (planting.getType().toLowerCase().
                            equals(requiredPlanting.getType().toLowerCase())) {
                        price = planting.getPricePerTon();
                    }
                }

                op5.model.addElement(
                        "Name: " + suitableFarmers.get(i).getFirstName() + " "
                        + suitableFarmers.get(i).getSurname()
                        + "           Location: " + suitableFarmers.get(i).getLocation()
                        + "           Price: " + price);
            }

            op5.jlPickFarmer.setModel(op5.model);
            displaySuitableFarmers();
        } else {
            JOptionPane.showMessageDialog(getContentPane(), "No suitable farmer(s) found");
        }

    }

    //Displays order details based on the selected farmer
    private void clickSelectFarmer() {
        Farmer aFarmer = suitableFarmers.get(op5.jlPickFarmer.getSelectedIndex());
        Planting aPlanting = null;

        for (int i = 0; i < aFarmer.getFields().size(); ++i) {
            
            if (aFarmer.getFields().getFieldByIndex(i).currentPlanting.getType().
                    toLowerCase().equals(requiredPlanting.getType().toLowerCase())) {
                aPlanting = aFarmer.getFields().getFieldByIndex(i).currentPlanting;
            }
        }

        if (aFarmer != null
                && aPlanting != null) {
            displayOrderDetails(aFarmer, aPlanting);
        } else {
            JOptionPane.showMessageDialog(getContentPane(), 
                "There was an error with the requested farmer or planting");
        }
    }
    
    // This function will enable product line managers to remove troublesome
    // suppliers from their suitable farmers results for product queries
    
    private void addFarmerToBlockList() {

        if (mfp.jlPickFarmer.getSelectedValue() != null) {
            Farmer aFarmer = currentServer.getFarmers().
                get(mfp.jlPickFarmer.getSelectedIndex());

            if (!currentUser.blockList.contains(aFarmer)) {
                currentUser.blockList.add(aFarmer);
                displayManageFarmers();
                JOptionPane.showMessageDialog(getContentPane(), 
                    "Farmer successfully added to block list.");
               
                
            } else {
                JOptionPane.showMessageDialog(getContentPane(), 
                    "Error: Farmer is already on block list");
            }
        } else {
            JOptionPane.showMessageDialog(getContentPane(), "No farmer selected.");
        }
    }
    
    //Allows a user to remove a farmer from their blocklist
    private void removeFarmerFromBlockList() {

        if (mfp.jlPickFarmer.getSelectedValue() != null) {
            Farmer aFarmer = currentServer.getFarmers().
                get(mfp.jlPickFarmer.getSelectedIndex());

            if (currentUser.blockList.contains(aFarmer)) {
                
                currentUser.blockList.remove(aFarmer);
                displayManageFarmers();
                JOptionPane.showMessageDialog(getContentPane(), 
                    "Farmer successfully removed from block list.");
                
            } else {
                JOptionPane.showMessageDialog(getContentPane(), 
                    "Error: Farmer not found on block list.");
            }
        } else {
            JOptionPane.showMessageDialog(getContentPane(), "No farmer selected.");
        }
    }

    //Populates the UI with a list of farmers
    private void displayManageFarmers() {
        suitableFarmers = currentServer.getFarmers();

        mfp.model.clear();
        String blocked = "";

        for (int i = 0; i < suitableFarmers.size(); ++i) {

            blocked = "Block";

            for (int j = 0; j < currentUser.blockList.size(); ++j) {
                
                if (suitableFarmers.get(i).getUsername().toLowerCase().
                        equals(currentUser.blockList.
                            get(j).getUsername().toLowerCase())) {
                    blocked = "Unblock";
                }
            }

            mfp.model.addElement("Name: " + suitableFarmers.get(i).
                    getFirstName() + " "
                    + suitableFarmers.get(i).
                    getSurname()
                    + "             Location: " + suitableFarmers.
                    get(i).getLocation() + "           "
                    + blocked);
        }
    }

    //Shows the farmer selection screen
    private void displaySuitableFarmers() {
        layout.show(contentPane, "op5");
    }

    //Creates and displays an order
    private void displayOrderDetails(Farmer aFarmer, Planting aPlanting) {

        //The order is generated using current values from the user's selections
        currentOrder = new Order(
                
            aPlanting.getType(),
            aPlanting.getPricePerTon(),
            aFarmer,
            currentUser,
            LocalDateTime.now().plusDays(aPlanting.getGrowthTime()),
            LocalDateTime.now(),
            "active"
        );

        if (currentOrder != null) {
            op6.lbl_name.setText(currentOrder.getSupplier().getFirstName() + " "
                    + currentOrder.getSupplier().getSurname());
            op6.lbl_location.setText(currentOrder.getSupplier().getLocation());
            op6.lbl_phone.setText(currentOrder.getSupplier().getPhoneNumber());
            op6.lbl_product.setText(currentOrder.getCrop());
            op6.lbl_delivery.setText(currentOrder.getEstimatedDeliveryDate().toLocalDate() + "");
            op6.lbl_price.setText(df.format(currentOrder.getCost()) + "");

            layout.show(contentPane, "op6");
        } else {
            JOptionPane.showMessageDialog(getContentPane(), 
                "Sorry, There was an issue with the order.");
        }
    }

    //Adds an order to the list of orders and updates the relevant objects
    public void clickSendOrder() {
        if (currentOrder != null) {
            
            currentUser.orders.add(currentOrder);
            currentOrder = null;
            JOptionPane.showMessageDialog(getContentPane(), 
                "Order Successfully created.");
            
            layout.show(contentPane, "menu");
            currentServer.updateUser(currentUser);
            currentServer.updateOrders(currentUser.orders);
        } else {
            JOptionPane.showMessageDialog(getContentPane(), 
               "Error: Order could not be saved.");
        }
    }

    //Adds listeners for UI components
    public void addListeners() {
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(getContentPane(), "Logging Off");
            }
        });

        op1.jbtn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "menu");
            }
        });

        menu.jbtn_viewOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayOrders();
            }
        });

        menu.jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getContentPane(), "Coming Soon");
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

        op1.jbtn_makeOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "op4");
            }
        });

        op4.jbtn_selectCrop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (op4.jrb_broccoli.isSelected()) {
                    clickSelectCrop(5);
                } else if (op4.jrb_carrots.isSelected()) {
                    clickSelectCrop(0);
                } else if (op4.jrb_peas.isSelected()) {
                    clickSelectCrop(2);
                } else if (op4.jrb_potatoes.isSelected()) {
                    clickSelectCrop(4);
                } else if (op4.jrb_sprouts.isSelected()) {
                    clickSelectCrop(3);
                } else if (op4.jrb_sweetcorn.isSelected()) {
                    clickSelectCrop(1);
                } else {
                    JOptionPane.showMessageDialog(getContentPane(), 
                        "Please select a crop");
                }
            }
        });

        op4.jbtn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "op1");
            }
        });

        op5.jbtn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "op4");
            }
        });

        op5.jbtn_selectFarmer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (suitableFarmers != null) {

                    clickSelectFarmer();
                } else {
                    JOptionPane.showMessageDialog(getContentPane(), 
                        "No suitable farmers available");
                }
            }
        });

        op6.jbtn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "op5");
            }
        });

        op6.jbtn_sendOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickSendOrder();
            }
        });

        op1.jbtn_manageFarmers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayManageFarmers();
                layout.show(contentPane, "mfp");
            }
        });

        mfp.jbtn_blockFarmer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addFarmerToBlockList();
            }
        });
        
        mfp.jbtn_unblockFarmer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeFarmerFromBlockList();
            }
        });
        
        mfp.jbtn_back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layout.show(contentPane, "op1");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JPanel container;
    protected javax.swing.JPanel contentPane;
    protected javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel3;
    protected javax.swing.JLabel jbl_username;
    // End of variables declaration//GEN-END:variables
}
