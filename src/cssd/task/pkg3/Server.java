/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cssd.task.pkg3;

import java.awt.CardLayout;
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
    
    protected Server currentServer;
    
    protected logInPanel log;
    protected AccountCreationPanel crea;
    protected CardLayout layout;
    
    
    public Server(SetOfSensorMonitors initialSensors) {
        initComponents();
        initManualComponents();
        getContentPane().setBackground(new Color(102,153,0));
        setSize(353, 276);
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
        currentServer = this;
        
        users = new SetOfUsers();
        farmers = new SetOfFarmers();
        orders = new SetOfOrders();
        deserializeAll();
        availableCrops = new ArrayList<Planting>();
//        setCrops();
         
        File dataExists = new File("users.ser");
        if (dataExists.exists() == false)
        {
            testData_initialiseUsers();
        }
        
        //testData_initialiseUsers();
    }
    
    protected void initManualComponents(){
        log = new logInPanel();
        crea = new AccountCreationPanel();
        
        layout = new CardLayout();
        
        container.add(log, "log");
        container.setLayout(layout);
        
        pack();
        setLocationByPlatform(true);
        
        layout.show(container, "log");
           
        addListeners();
    }
    
    protected void addListeners(){
        addWindowListener(new WindowAdapter(){
            public void windowClosing( WindowEvent e){
                JOptionPane.showMessageDialog(getContentPane(), "Exiting...");
            }
        });
    
        log.jbtn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductLineManager currentUser = users.login(
                log.jtf_username.getText(),
                new String( log.jtf_password.getPassword() )
            );

        if( currentUser != null){
            log.jtf_username.setText("");
            log.jtf_password.setText("");

            new AMSGUI_User(currentUser, currentServer, availableCrops).setVisible(true);
        }
        else
        {
            Farmer currentFarmer = farmers.login(
                log.jtf_username.getText(),
                new String( log.jtf_password.getPassword())
            );

            if( currentFarmer != null)
            {
                log.jtf_username.setText("");
                log.jtf_password.setText("");

                new AMSGUI_Farmer(currentFarmer, currentServer).setVisible(true);
            }
            else
            JOptionPane.showMessageDialog(currentServer, "Invalid username or password!");
        }  
        }
    });

    log.jbtn_create.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            container.remove(log);
            container.add(crea, "crea");
            layout.show(container, "crea");
            setSize(400, 410);    
            
            crea.usernameInput.setText("");
            crea.firstnameInput.setText("");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
            crea.surnameInput.setText("");
            crea.phoneInput.setText("");
            crea.locationInput.setText("");
            crea.passwordInput.setText("");
            crea.reenterInput.setText("");
            crea.buttonGroup1.clearSelection();     
        }
    });
    
    crea.jbtn_back.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        container.remove(crea);
        container.add(log);
        layout.show(container, "log");
        setSize(353, 276);  
    }
    });
    crea.creationButton.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        
    String username;
    String firstName;
    String surname;
    String location;
    String phoneNo;
    String passW;
    String pass1;
    String pass2;
    Boolean userAdded = false;
    
   
    if (crea.farmerButton.isSelected()) 
    {
        pass1 = new String(crea.passwordInput.getPassword());
        pass2 = new String(crea.reenterInput.getPassword());
        if (!pass2.equals(pass1)) {
            JOptionPane.showMessageDialog(getContentPane(), "Passwords do not match!");
        }   
        else if(crea.usernameInput.getText().equals("") || crea.firstnameInput.getText().equals("")|| crea.surnameInput.getText().equals("")|| crea.locationInput.getText().equals("")|| crea.phoneInput.getText().equals("")|| crea.passwordInput.getText().equals(""))
        {
            JOptionPane.showMessageDialog(getContentPane(), "Some fields have not been entered!");
        }
        else{
            username = crea.usernameInput.getText();
            firstName = crea.firstnameInput.getText();
            surname = crea.surnameInput.getText();
            location = crea.locationInput.getText();
            phoneNo = crea.phoneInput.getText();
            passW = new String(crea.passwordInput.getPassword());
            
            

            
            if (((users.availability(username)) == true) || ((farmers.availability(username)) == true)) 
            {
                JOptionPane.showMessageDialog(getContentPane(), "Username is not available!");
            }
           
            else{
            farmers.addFarmer(
                    new Farmer(
                            username,
                            firstName,
                            surname,
                            location,
                            phoneNo,
                            passW
                    )
            );
            userAdded = true;
            }

                
        }
        
        
    }
    else if (crea.userButton.isSelected())
    {
        pass1 = new String(crea.passwordInput.getPassword());
        pass2 = new String(crea.reenterInput.getPassword());
        if (!pass2.equals(pass1)) {
            JOptionPane.showMessageDialog(getContentPane(), "Passwords do not match!");
        }
        else if(crea.usernameInput.getText().equals("") || crea.firstnameInput.getText().equals("")|| crea.surnameInput.getText().equals("")|| crea.locationInput.getText().equals("")|| crea.phoneInput.getText().equals("")|| crea.passwordInput.getText().equals(""))
        {
            JOptionPane.showMessageDialog(getContentPane(), "Some fields have not been entered!");
        }
        //else if(checkAvailabilty()){
            
       // }
        else{
            username = crea.usernameInput.getText();
            firstName = crea.firstnameInput.getText();
            surname = crea.surnameInput.getText();
            location = crea.locationInput.getText();
            phoneNo = crea.phoneInput.getText();
            passW = new String(crea.passwordInput.getPassword());
              
            if (((users.availability(username)) == true) || ((farmers.availability(username)) == true)) 
            {
                JOptionPane.showMessageDialog(getContentPane(), "Username is not available");
            }
            else
            {
                users.addUser(
                    new ProductLineManager(
                            username,
                            firstName,
                            surname,
                            location,
                            phoneNo,
                            passW,
                            ""
                    )
            );
                userAdded = true; 
            }
            
            
   
        }
    }
    else
    {
        JOptionPane.showMessageDialog(getContentPane(), "User type was not specified!");   
    }
    
    if (userAdded == true) {   
        JOptionPane.showMessageDialog(getContentPane(), "Welcome, "+ crea.usernameInput.getText()+ "!");
        container.remove(crea);
        container.add(log);
        layout.show(container, "log");
        setSize(353, 276);   
    }
    }
     
    });
    }
    
    private void addCrops() 
    { 
       Planting carrots, sweetcorn, peas, sprouts, potatoes, broccoli; 
         
        carrots = new Planting( "Carrots", 1000.10f ); 
        sweetcorn = new Planting("Sweetcorn", 909.99f); 
        peas = new Planting("Peas", 908.78f); 
        sprouts = new Planting("Sprouts", 808.45f); 
        potatoes = new Planting("Potatoes", 1101.12f); 
        broccoli = new Planting("Broccoli", 998.77f); 
         
        availableCrops.add(carrots); 
        availableCrops.add(sweetcorn); 
        availableCrops.add(peas); 
        availableCrops.add(sprouts); 
        availableCrops.add(potatoes); 
        availableCrops.add(broccoli); 
    }
    
    private void testData_initialiseUsers() 
    {   
        farmers.addFarmer( 
                new Farmer( 
                        "admin", 
                        "John", 
                        "Smith", 
                        "Hull", 
                        "phoneno", 
                        "password" 
                ) 
        ); 
         
        SetOfFields fields = new SetOfFields(new ArrayList<Field>()); 
         
        ArrayList<Harvest> harvests = new ArrayList<Harvest>(); 
         
        Location points[] = new Location[4]; 
        points[0] = new Location(0, 0); 
        points[1] = new Location(1, 0); 
        points[2] = new Location(1, 1); 
        points[3] = new Location(0, 1); 
         
        Location points2[] = new Location[4]; 
        points2[0] = new Location(2, 4); 
        points2[1] = new Location(4, 2); 
        points2[2] = new Location(4, 4); 
        points2[3] = new Location(2, 4); 
        
        Planting planting1 = new Planting(); 
        planting1.setType("Bananas"); 
        planting1.setPricePerTon(902.92f); 
        planting1.setGrowthTime(6); 
        planting1.setIsGrowing(false); 
         
        Planting planting2 = new Planting(); 
        planting2.setType("Peas"); 
        planting2.setPricePerTon(109.33f); 
        planting2.setGrowthTime(2); 
        planting2.setIsGrowing(true); 
         
        fields.addField(new Field(planting1, new FieldArea(points), harvests)); 
        fields.addField(new Field(planting2, new FieldArea(points2), harvests)); 
         
        farmers.get(0).setFields(fields); 
         
        users.addUser( 
                new ProductLineManager( 
                        "trkirk", 
                        "thomas", 
                        "kirk", 
                        "sheffield", 
                        "0114 2483710", 
                        "password",
                        "EvilCorp"
                ) 
        ); 
         
        users.addUser( 
                new ProductLineManager( 
                        "kevison", 
                        "kae", 
                        "evison", 
                        "sheffield", 
                        "0114 2456712", 
                        "password",
                        "GoodCorp"
                ) 
        ); 
         
        users.addUser( 
                new ProductLineManager( 
                        "sgeorge", 
                        "sam", 
                        "george", 
                        "manchester", 
                        "07734737348", 
                        "password",
                        "BigCorp"
                ) 
        ); 
         
        Order order1 = new Order( 
                "Peas", 
                12.33, 
                farmers.get(0), 
                users.get(0), 
                LocalDateTime.of(2017, Month.MARCH, 27, 17, 28), 
                LocalDateTime.now(), 
                "active" 
        ); 
         
        Order order2 = new Order( 
                "Carrots", 
                10.76, 
                farmers.get(0), 
                users.get(0), 
                LocalDateTime.of(2017, Month.MARCH, 26, 12, 21), 
                LocalDateTime.now(), 
                "complete" 
        ); 
         
        orders.add(order1); 
        orders.add(order2); 
        getFarmerOrders(farmers.get(0)); 
        getUserOrders(users.get(0)); 
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
                readingsForArea.add(allSensors.get(i).getNewReading());
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
    
    public void updateUser(ProductLineManager user){
        for(int i=0; i<users.size(); ++i){
            if( users.get(i).getUsername().toLowerCase().
                    equals(user.getUsername().toLowerCase()) ){
                users.set(i, user);
            }
        }
    }
    
    public void updateOrders(SetOfOrders aOrders){
        for(int i= 0; i< orders.size(); ++i ){
            for(int j=0; j<aOrders.size(); ++j){
                
                if( ( aOrders.get(j).getSupplier().getUsername().toLowerCase().
                      equals(orders.get(i).getSupplier().getUsername().toLowerCase()) )
                        && ( aOrders.get(j).getBuyer().getUsername().toLowerCase().
                                equals(orders.get(i).getBuyer().getUsername().toLowerCase() ))
                        && (aOrders.get(j).getCrop().toLowerCase().
                                equals(orders.get(i).getCrop().toLowerCase())  )
                        && (aOrders.get(j).getEstimatedDeliveryDate() ==
                                orders.get(i).getEstimatedDeliveryDate()  )   )
                {
                    orders.set(i, aOrders.get(j));
                }
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

        container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        container.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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
    
    public SetOfFarmers getFarmers(){
        return farmers;
    }
    
    public void displayLogin(){
        this.setVisible(true);
    }
    
    void getFarmerOrders(Farmer farmer)
    {
        farmer.orders.clear();
        
        if(orders.size() >= 0){
            for(int i=0; i<orders.size(); ++i){
                if(orders.get(i).getSupplier().getUsername().toLowerCase().
                        equals(farmer.getUsername().toLowerCase() )){
                    farmer.addOrder(orders.get(i));
                }
            }
        }
    }
    
    void getUserOrders(ProductLineManager user){
        
        user.orders.clear();
        
        if(orders.size() > 0){
            for(int i=0; i<orders.size(); ++i){
                if(orders.get(i).getBuyer().getUsername().toLowerCase().
                        equals(user.getUsername().toLowerCase() )){
                    user.addOrder(orders.get(i));
                }
            }
        }
    }
    
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
    private javax.swing.JPanel container;
    // End of variables declaration//GEN-END:variables
}
