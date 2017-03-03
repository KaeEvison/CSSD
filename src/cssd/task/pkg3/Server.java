/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;

/**
 *
 * @author thoma
 */
public class Server extends javax.swing.JFrame {
  
    Location testData = new Location(2,3);
    private SetOfSensorReadings sensorReadings;
    private static String FILENAME = "readingsLog.ser";
    File outputFile = new File(FILENAME);
    private SetOfSensorMonitors allSensors = new SetOfSensorMonitors();
    public ArrayList<Planting> availableCrops;
    
    private SetOfUsers users;
    private SetOfFarmers farmers;
    private SetOfOrders orders;
    
    
    public Server(SetOfSensorMonitors initialSensors) {
        initComponents();
        getContentPane().setBackground(new Color(102,153,0));
        setTitle("AMS Login");
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                serializeAll(farmers, users, orders);
            }
        });
        
        allSensors = initialSensors;
        
        users = new SetOfUsers();
        farmers = new SetOfFarmers();
        orders = new SetOfOrders();
        deserializeAll();
        availableCrops = new ArrayList<Planting>();
        
        //testData_initialiseUsers();
    }
    
    public static void serializeAll(SetOfFarmers farmerData, SetOfUsers userData, SetOfOrders orderData)
    {
        try
        {
            Serialize(farmerData, "farmers.ser");
            Serialize(userData, "users.ser");
            Serialize(orderData, "orders.ser");
        }
        catch (IOException ex)
        {
            System.out.println(ex);
        }
    }
    
    public void deserializeAll()
    {
        users = readUsers();
        farmers = readFarmers();
        orders = readOrders();
    }
    
    public SetOfSensorReadings getReadingsForFieldArea(FieldArea fieldArea)
    {
        SetOfSensorReadings readingsForArea = new SetOfSensorReadings();
        for (int i = 0; i < allSensors.size(); i++)
        {
            if (fieldArea.isLocationInArea(allSensors.get(i).getLocation()))
            {
                readingsForArea.add(allSensors.get(i).getNewReading(21.0, "Celcius", "Soil temperature", testData));
            }
        }
        return readingsForArea;
    }
    
    private static void Serialize(Object obj, String filename) throws IOException
    {
        FileOutputStream out = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        
        oos.writeObject(obj);
        out.close();
    }
     
    private static Object Deserialize(String filename) throws IOException, ClassNotFoundException
    {
        FileInputStream in = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(in);
        Object obj = ois.readObject();
        in.close();

        return obj;
    }
    
    public void updateFarmer(Farmer farmer){
        for(int i=0; i<farmers.size(); ++i){
            if( farmers.get(i).getUsername().toLowerCase().
                    equals(farmer.getUsername().toLowerCase()) ){
                farmers.set(i, farmer);
            }
        }
    }
    
    public void updateUser(User user){
        for(int i=0; i<users.size(); ++i){
            if( users.get(i).getUsername().toLowerCase().
                    equals(user.getUsername().toLowerCase()) ){
                users.set(i, user);
            }
        }
    }
    
    public static SetOfUsers readUsers()
    {
        SetOfUsers data = new SetOfUsers();
        File fileCheck = new File("users.ser");
        if (fileCheck.exists() == true)
        {
            try
            {
                data = (SetOfUsers)Deserialize("users.ser");
            }
            catch (IOException e)
            {
                System.out.println(e);
            }
            catch (ClassNotFoundException e)
            {
                System.out.println(e);
            }
        }
        else
            System.out.println("USERS FILE NOT FOUND");
        return data;
    }
    
    public static SetOfFarmers readFarmers()
    {
        SetOfFarmers data = new SetOfFarmers();
        File fileCheck = new File("farmers.ser");
        if (fileCheck.exists() == true)
        {
            try
            {
                data = (SetOfFarmers)Deserialize("farmers.ser");
            }
            catch (IOException e)
            {
                System.out.println(e);
            }
            catch (ClassNotFoundException e)
            {
                System.out.println(e);
            }
        }
        else
            System.out.println("FARMERS FILE NOT FOUND");
        return data;
    }
    
    public static SetOfOrders readOrders()
    {
        SetOfOrders data = new SetOfOrders();
        File fileCheck = new File("orders.ser");
        if (fileCheck.exists() == true)
        {
            try
            {
                data = (SetOfOrders)Deserialize("orders.ser");
            }
            catch (IOException e)
            {
                System.out.println(e);
            }
            catch (ClassNotFoundException e)
            {
                System.out.println(e);
            }
        }
        else
            System.out.println("ORDERS FILE NOT FOUND");
        return data;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtf_password = new javax.swing.JPasswordField();
        jbtn_submit = new javax.swing.JButton();
        jtf_username = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtf_password.setText("password");
        jtf_password.setName("jPasswordField_password"); // NOI18N

        jbtn_submit.setText("Submit");
        jbtn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_submitActionPerformed(evt);
            }
        });

        jtf_username.setText("admin");
        jtf_username.setName("jtf_username"); // NOI18N
        jtf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_usernameActionPerformed(evt);
            }
        });

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn_submit)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jtf_username)
                        .addComponent(jtf_password, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf_username, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtf_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtn_submit)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_submitActionPerformed

        User currentUser = users.login(
            jtf_username.getText(),
            new String( jtf_password.getPassword() )
        );

        if( currentUser != null){
            this.jtf_username.setText("");
            this.jtf_password.setText("");

            new AMSGUI_User(currentUser, this, availableCrops).setVisible(true);
        }
        else
        {
            Farmer currentFarmer = farmers.login(
                jtf_username.getText(),
                new String( jtf_password.getPassword())
            );

            if( currentFarmer != null)
            {
                this.jtf_username.setText("");
                this.jtf_password.setText("");

                new AMSGUI_Farmer(currentFarmer, this).setVisible(true);
            }
            else
                JOptionPane.showMessageDialog(this, "Invalid username or password!");
        }
    }//GEN-LAST:event_jbtn_submitActionPerformed
    
    public SetOfFarmers getSuitableFarmers(Planting aPlanting)
    {
        SetOfFarmers suitableFarmers = new SetOfFarmers();
        
        for(int i=0; i<farmers.size(); ++i){
            for(int j=0; j<(farmers.get(i).getFields()).size(); ++j){

                if(farmers.get(i).getFields().getFieldByIndex(j).
                        currentPlanting.getType().toLowerCase().
                        equals(aPlanting.getType().toLowerCase()) ){
                    suitableFarmers.add(farmers.get(i));
                }
            }
        }
        return suitableFarmers;
    }
    
    public void displayLogin(){
        this.setVisible(true);
    }
    
    void getFarmerOrders(Farmer farmer)
    {
        if(orders.size() > 0){
            for(int i=0; i<orders.size(); ++i){
                if(orders.get(i).getSupplier() == farmer){
                    farmer.addOrder(orders.get(i));
                }
            }
        }
    }
    
    void getUserOrders(User user){
        if(orders.size() > 0){
            for(int i=0; i<orders.size(); ++i){
                if(orders.get(i).getSupplier() == user){
                    user.addOrder(orders.get(i));
                }
            }
        }
    }
    
//    private void testData_initialiseUsers()
//    {
//        Planting carrots, sweetcorn, peas, sprouts, potatoes, broccoli;
//        
//        carrots = new Planting( "Carrots", 1000.10f );
//        sweetcorn = new Planting("Sweetcorn", 909.99f);
//        peas = new Planting("Peas", 908.78f);
//        sprouts = new Planting("Sprouts", 808.45f);
//        potatoes = new Planting("Potatoes", 1101.12f);
//        broccoli = new Planting("Broccoli", 998.77f);
//        
//        availableCrops.add(carrots);
//        availableCrops.add(sweetcorn);
//        availableCrops.add(peas);
//        availableCrops.add(sprouts);
//        availableCrops.add(potatoes);
//        availableCrops.add(broccoli);
//        
//        farmers.addFarmer(
//                new Farmer(
//                        "admin",
//                        "John",
//                        "Smith",
//                        "Hull",
//                        "phoneno",
//                        "password"
//                )
//        );
//        
//        SetOfFields fields = new SetOfFields(new ArrayList<Field>());
//        
//        ArrayList<Harvest> harvests = new ArrayList<Harvest>();
//        
//        Location points[] = new Location[4];
//        points[0] = new Location(0, 0);
//        points[1] = new Location(1, 0);
//        points[2] = new Location(1, 1);
//        points[3] = new Location(0, 1);
//        
//        Location points2[] = new Location[4];
//        points2[0] = new Location(2, 4);
//        points2[1] = new Location(4, 2);
//        points2[2] = new Location(4, 4);
//        points2[3] = new Location(2, 4);
//        
//        Planting planting1 = new Planting();
//        planting1.setType("Bananas");
//        planting1.setPricePerTon(902.92f);
//        planting1.setGrowthTime(6);
//        planting1.setIsGrowing(false);
//        
//        Planting planting2 = new Planting();
//        planting2.setType("Peas");
//        planting2.setPricePerTon(109.33f);
//        planting2.setGrowthTime(2);
//        planting2.setIsGrowing(true);
//        
//        fields.addField(new Field(planting1, new FieldArea(points), harvests));
//        fields.addField(new Field(planting2, new FieldArea(points2), harvests));
//        
//        farmers.get(0).setFields(fields);
//        
//        users.addUser(
//                new User(
//                        "trkirk",
//                        "thomas",
//                        "kirk",
//                        "sheffield",
//                        "0114 2483710",
//                        "Pa55w0rd"
//                )
//        );
//        
//        users.addUser(
//                new User(
//                        "kevison",
//                        "kae",
//                        "evison",
//                        "sheffield",
//                        "0114 2456712",
//                        "Pa55w0rd2"
//                )
//        );
//        
//        users.addUser(
//                new User(
//                        "sgeorge",
//                        "sam",
//                        "george",
//                        "manchester",
//                        "07734737348",
//                        "password3"
//                )
//        );
//        
//        Order order1 = new Order(
//                "Peas",
//                12.33,
//                farmers.get(0),
//                users.get(0),
//                LocalDateTime.of(2017, Month.MARCH, 27, 17, 28),
//                LocalDateTime.now(),
//                "active"
//        );
//        
//        Order order2 = new Order(
//                "Carrots",
//                10.76,
//                farmers.get(0),
//                users.get(0),
//                LocalDateTime.of(2017, Month.MARCH, 26, 12, 21),
//                LocalDateTime.now(),
//                "complete"
//        );
//        
//        orders.add(order1);
//        orders.add(order2);
//        getFarmerOrders(farmers.get(0));
//        getUserOrders(farmers.get(0));
//    }
    
    private void jtf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_usernameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server(new SetOfSensorMonitors()).displayLogin();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton jbtn_submit;
    private javax.swing.JPasswordField jtf_password;
    private javax.swing.JTextField jtf_username;
    // End of variables declaration//GEN-END:variables
}
