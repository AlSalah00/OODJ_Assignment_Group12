
package foodOrderingSystem.jFrames;
import foodOrderingSystem.Classes.ButtonStyler;
import foodOrderingSystem.Classes.Notification;
import foodOrderingSystem.Classes.Order;
import foodOrderingSystem.Classes.Review;
import foodOrderingSystem.Classes.User;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class AdminPage extends javax.swing.JFrame {
    
    Color orange = new Color(255, 153, 0, 255);    
       
    Icon defaultIcon1 = new ImageIcon(ButtonStyler.class.getResource("/add.png"));
    Icon hoverIcon1 = new ImageIcon(ButtonStyler.class.getResource("/addHover.png"));
        
    Icon defaultIcon2 = new ImageIcon(ButtonStyler.class.getResource("/top-up.png"));
    Icon hoverIcon2 = new ImageIcon(ButtonStyler.class.getResource("/top-upHover.png"));
    
    Icon defaultIcon3 = new ImageIcon(ButtonStyler.class.getResource("/transaction.png"));
    Icon hoverIcon3 = new ImageIcon(ButtonStyler.class.getResource("/transactionHover.png"));    
    
    Icon defaultIcon4 = new ImageIcon(ButtonStyler.class.getResource("/logout.png"));
    Icon hoverIcon4 = new ImageIcon(ButtonStyler.class.getResource("/logoutHover.png"));
    
    public AdminPage(String username) {
       
        try { 
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception ignored){}               
        
        initComponents();  
                   
        WelcomeLbl.setText("Welcome, " + username);
        TableHeaderStyle(UsersTable);
        TableHeaderStyle(UsersTable_TopUp);
        TableHeaderStyle(TransactionsTable);
        
        UsersTable.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting()) {
                    populateForm();
                }
            }
        });
        this.refreshData(PasswordsChkBox.isSelected());
        
        JButton[] allButtons = {UserRegBtn, TopUpBtn, TransactionBtn, LogoutBtn};      
        
        ButtonStyler.applyMouseEffects(UserRegBtn, allButtons, defaultIcon1, hoverIcon1);
        ButtonStyler.applyMouseEffects(TopUpBtn, allButtons, defaultIcon2, hoverIcon2);
        ButtonStyler.applyMouseEffects(TransactionBtn, allButtons, defaultIcon3, hoverIcon3);
        ButtonStyler.applyMouseEffects(LogoutBtn, allButtons, defaultIcon4, hoverIcon4);
    }
    
    // A method to reset the menu buttons style
    private void resetToDefault() {
        ButtonStyler.applyDefaultStyle(UserRegBtn, defaultIcon1);
        ButtonStyler.applyDefaultStyle(TopUpBtn, defaultIcon2);
        ButtonStyler.applyDefaultStyle(TransactionBtn, defaultIcon3);
        ButtonStyler.applyDefaultStyle(LogoutBtn, defaultIcon4);
    }

    // Customizing the side panel (menu) appearance
    class jPanelGradient extends JPanel {
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            int width = getWidth();
            int height = getHeight();
            
            Color c1 = new Color(255, 165, 0);
            Color c2 = new Color(255, 102, 0);
            
            GradientPaint gp = new GradientPaint(0,0,c1,180,height,c2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
        }
    }
    
    // customizing the table appearance
    private void TableHeaderStyle(JTable table) {
        JTableHeader header = table.getTableHeader();
        header.setOpaque(false);
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
            label.setBackground(orange);
            label.setForeground(Color.white);
            label.setFont(new Font("Segoe UI", Font.BOLD, 14));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            return label;
        }
        });
    }   
    
    private void resetFields() {
        
        UsernameTxt.setText("Username");
        UsernameTxt.setForeground(Color.gray);
        UsernameTxt.setFocusable(false);
        
        EmailTxt.setText("Email");
        EmailTxt.setForeground(Color.gray);
        EmailTxt.setFocusable(false);
        
        PhoneNoTxt.setText("Phone Number");
        PhoneNoTxt.setForeground(Color.gray);
        PhoneNoTxt.setFocusable(false);
    }
    
    // A method to generate a password
    public static String generatePassword() {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Generates 3 random letters
        for (int i = 0; i < 3; i++) {
            char randomLetter = (char) ('A' + random.nextInt(26));
            password.append(randomLetter);
        }

        // Generates 3 random digits
        for (int i = 0; i < 3; i++) {
            int randomDigit = random.nextInt(10);
            password.append(randomDigit);
        }

        return password.toString();
    }
    
    private static Set<String> getExistingIDs() {
        Set<String> existingIDs = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader("User.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("--");
                if (data.length > 0) {
                    existingIDs.add(data[0]);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the file: " + e.getMessage());
        }
        return existingIDs;
    }
    
    // A method to generate a unique ID
    public static String generateID() {
        
        Random random = new Random();
        Set<String> existingIDs = getExistingIDs();
        
        StringBuilder ID = new StringBuilder();
        String newID;
        
        do {
            ID.setLength(0);
            for (int i = 0; i < 3; i++) {
                int randomDigit = random.nextInt(10);
                ID.append(randomDigit);
            }
            newID = "U0" + ID.toString();
        } while (existingIDs.contains(newID));
        
        return newID;
    }    
    
    // A method to read data from the text file and display it in the table       
    private void refreshData(boolean showPasswords) {
        
        User user = new User();
        
        DefaultTableModel model = (DefaultTableModel) UsersTable.getModel();
        model.setRowCount(0);
        
        List<String[]> records = user.viewAll();
        String[][] data = records.toArray(new String[0][0]);
        
        for (String[] userDetails : data) {
            String id = userDetails[0];
            String username = userDetails[1];
            String email = userDetails[2];
            String phoneNo = userDetails[3];
            String password = userDetails[4];
            String role = userDetails[5];
            
            
            if (!showPasswords) {
                password = "*".repeat(password.length());
            }
            
            model.addRow(
                    new Object[]{id, username, email, phoneNo, password,
                        role});
        }
    }
    
    private void refreshBalance() {
        
        User user = new User();
        
        DefaultTableModel model = (DefaultTableModel) UsersTable_TopUp.getModel();
        model.setRowCount(0);
        
        List<String[]> records = user.viewBalance();
        String[][] data = records.toArray(new String[0][0]);
        
        for (String[] userDetails : data) {
            String id = userDetails[0];
            String username = userDetails[1];
            String balance = userDetails[2];          
            
            model.addRow(
                    new Object[]{id, username, balance});
        }
    }
    
    private void populateForm() {
        
        int selectedRow = UsersTable.getSelectedRow();
        if (selectedRow != -1) {
            String username = (String) UsersTable.getValueAt(selectedRow, 1);
            String email = (String) UsersTable.getValueAt(selectedRow, 2);
            String phoneNo = (String) UsersTable.getValueAt(selectedRow, 3);
            String role = (String) UsersTable.getValueAt(selectedRow, 5);
            
            UsernameTxt.setForeground(Color.black);
            UsernameTxt.setText(username);
            EmailTxt.setForeground(Color.black);
            EmailTxt.setText(email);
            PhoneNoTxt.setForeground(Color.black);
            PhoneNoTxt.setText(phoneNo);           
            RoleComboBox.setSelectedItem(role);
        }
    }
    
    private static String retrievePassword(String id) {
        
        String password = null;
        
        try (BufferedReader reader = new BufferedReader(new FileReader("User.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split("--");

                if (fields.length == 6 && fields[0].equals(id)) {
                    password = fields[4];
                    break;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return password;
    }
    
    private void addUser() {
        
        String ID = generateID();
        String username = UsernameTxt.getText();
        String email = EmailTxt.getText();
        String phoneNo = PhoneNoTxt.getText();
        String password = generatePassword();
        String role = RoleComboBox.getSelectedItem().toString();
        
        if ("Username".equals(username) || "Email".equals(email) || "Phone Number".equals(phoneNo)) {
            JOptionPane.showMessageDialog(null, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            User user = new User(ID, username, email, phoneNo, password, role);
            user.addUser();
            refreshData(PasswordsChkBox.isSelected());
        }
    }
    
    private void editUser() {
        
        String username = UsernameTxt.getText();
        String email = EmailTxt.getText();
        String phoneNo = PhoneNoTxt.getText();
        String role = RoleComboBox.getSelectedItem().toString();
            
        int selectedRow = UsersTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No record selected for editing!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            
        String Id = (String) UsersTable.getValueAt(selectedRow, 0);
        String password = retrievePassword(Id);
            
        User user = new User(Id, username, email, phoneNo, password, role);
        user.editUser();
        refreshData(PasswordsChkBox.isSelected());                      
            
    }
    
    private void delUser() {
        
        int selectedRow = UsersTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No record selected for deleting!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String id = (String) UsersTable.getValueAt(selectedRow, 0);
        User user = new User(id);
        user.delUser();
        refreshData(PasswordsChkBox.isSelected()); 
    }
    
    private void topUp() {
        
        if ("Amount".equals(AmountTxt.getText())) {
           
            JOptionPane.showMessageDialog(null, "Please enter amount first!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int amount = Integer.parseInt(AmountTxt.getText());
        
        int selectedRow = UsersTable_TopUp.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No user selected for top-up!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String Id = (String) UsersTable_TopUp.getValueAt(selectedRow, 0);
        String username = (String) UsersTable_TopUp.getValueAt(selectedRow, 1);
        String balance = (String) UsersTable_TopUp.getValueAt(selectedRow, 2);
        
        if (amount > 0) {
            
            int newBalance = Integer.parseInt(balance);
            newBalance += amount;
            
            User user = new User(Id, username, String.valueOf(newBalance));
            user.TopUp();
            refreshBalance();
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid amount!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    private void refreshTransactions() {
        
        Order order = new Order();
             
        DefaultTableModel model = (DefaultTableModel) TransactionsTable.getModel();
        model.setRowCount(0);
        
        
        List<String[]> records = order.ViewOrders();
        
        for (String[] orderDetails : records) {
      
                    String orderID = orderDetails[0];
                    String customer = orderDetails[1];
                    String vendor= orderDetails[2];
                    String date = orderDetails[5];
                    String total = orderDetails[6];
                             
                    model.addRow(
                            new Object[]{orderID, vendor, customer, date, total
                                });                     
        }
    }
    
    private void generateTransactionReceipt() {
        
        int selectedRow = TransactionsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No record selected for updating!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            
        String orderID = (String) TransactionsTable.getValueAt(selectedRow, 0);
        String vendor = (String) TransactionsTable.getValueAt(selectedRow, 1);
        String customer = (String) TransactionsTable.getValueAt(selectedRow, 2);
        String date = (String) TransactionsTable.getValueAt(selectedRow, 3);
        String total = (String) TransactionsTable.getValueAt(selectedRow, 4);
        
        Order order = new Order(orderID, vendor, customer, date, total);
        order.generateTransactionReceipt();
        
        String message = "Transaction Receipt: " + orderID + " | " + vendor + " | " + customer + " | " + 
                date + " | " + total;
        
        Notification nt = new Notification(customer, message, java.time.LocalDate.now().toString());
        nt.sendNotification();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        SidePanel = new jPanelGradient();
        UserRegBtn = new javax.swing.JButton();
        TopUpBtn = new javax.swing.JButton();
        TransactionBtn = new javax.swing.JButton();
        SeparatorPanel = new javax.swing.JPanel();
        LogoLbl = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JButton();
        ParentPanel = new javax.swing.JPanel();
        WelcomePanel = new javax.swing.JPanel();
        BackgroundLbl = new javax.swing.JLabel();
        WelcomeLbl = new javax.swing.JLabel();
        PageTypeLbl = new javax.swing.JLabel();
        UserRegPanel = new javax.swing.JPanel();
        AddUserBtn = new javax.swing.JButton();
        UsernameTxt = new javax.swing.JTextField();
        Separator1 = new javax.swing.JPanel();
        EmailTxt = new javax.swing.JTextField();
        Separator2 = new javax.swing.JPanel();
        PhoneNoTxt = new javax.swing.JTextField();
        Separator3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UsersTable = new javax.swing.JTable();
        RoleComboBox = new javax.swing.JComboBox<>();
        RoleLbl = new javax.swing.JLabel();
        EditBtn = new javax.swing.JButton();
        DelBtn = new javax.swing.JButton();
        PasswordsChkBox = new javax.swing.JCheckBox();
        UsernameExampleLbl = new javax.swing.JLabel();
        EmailExampleLbl = new javax.swing.JLabel();
        PhoneNoExampleLbl = new javax.swing.JLabel();
        SearchTxt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        TopUpPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        UsersTable_TopUp = new javax.swing.JTable();
        AmountTxt = new javax.swing.JTextField();
        Separator4 = new javax.swing.JPanel();
        ConfirmBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        SearchTxt_TopUp = new javax.swing.JTextField();
        TransactionsPanel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TransactionsTable = new javax.swing.JTable();
        GenerateRctBtn = new javax.swing.JButton();
        ReceiptsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        BackgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        SidePanel.setBackground(new java.awt.Color(255, 153, 0));

        UserRegBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UserRegBtn.setForeground(new java.awt.Color(255, 255, 255));
        UserRegBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        UserRegBtn.setText("User Registration");
        UserRegBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        UserRegBtn.setBorderPainted(false);
        UserRegBtn.setContentAreaFilled(false);
        UserRegBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        UserRegBtn.setFocusPainted(false);
        UserRegBtn.setFocusable(false);
        UserRegBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        UserRegBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        UserRegBtn.setIconTextGap(10);
        UserRegBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        UserRegBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserRegBtnActionPerformed(evt);
            }
        });

        TopUpBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TopUpBtn.setForeground(new java.awt.Color(255, 255, 255));
        TopUpBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/top-up.png"))); // NOI18N
        TopUpBtn.setText("Top-Up");
        TopUpBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        TopUpBtn.setBorderPainted(false);
        TopUpBtn.setContentAreaFilled(false);
        TopUpBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TopUpBtn.setFocusPainted(false);
        TopUpBtn.setFocusable(false);
        TopUpBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TopUpBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        TopUpBtn.setIconTextGap(10);
        TopUpBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        TopUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopUpBtnActionPerformed(evt);
            }
        });

        TransactionBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TransactionBtn.setForeground(new java.awt.Color(255, 255, 255));
        TransactionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transaction.png"))); // NOI18N
        TransactionBtn.setText("Transactions");
        TransactionBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        TransactionBtn.setBorderPainted(false);
        TransactionBtn.setContentAreaFilled(false);
        TransactionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TransactionBtn.setFocusPainted(false);
        TransactionBtn.setFocusable(false);
        TransactionBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TransactionBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        TransactionBtn.setIconTextGap(10);
        TransactionBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        TransactionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransactionBtnActionPerformed(evt);
            }
        });

        SeparatorPanel.setBackground(new java.awt.Color(255, 255, 255));
        SeparatorPanel.setPreferredSize(new java.awt.Dimension(256, 3));

        javax.swing.GroupLayout SeparatorPanelLayout = new javax.swing.GroupLayout(SeparatorPanel);
        SeparatorPanel.setLayout(SeparatorPanelLayout);
        SeparatorPanelLayout.setHorizontalGroup(
            SeparatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
        );
        SeparatorPanelLayout.setVerticalGroup(
            SeparatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        LogoLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo.png"))); // NOI18N

        LogoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LogoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logout.png"))); // NOI18N
        LogoutBtn.setText("Logout");
        LogoutBtn.setToolTipText("");
        LogoutBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        LogoutBtn.setBorderPainted(false);
        LogoutBtn.setContentAreaFilled(false);
        LogoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutBtn.setFocusPainted(false);
        LogoutBtn.setFocusable(false);
        LogoutBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LogoutBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        LogoutBtn.setIconTextGap(10);
        LogoutBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UserRegBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TransactionBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TopUpBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LogoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGroup(SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(LogoLbl))
                    .addGroup(SidePanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(SeparatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        SidePanelLayout.setVerticalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SidePanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(LogoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(UserRegBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TopUpBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransactionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeparatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ParentPanel.setBackground(new java.awt.Color(255, 255, 255));
        ParentPanel.setLayout(new java.awt.CardLayout());

        WelcomePanel.setBackground(new java.awt.Color(255, 255, 255));

        BackgroundLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.png"))); // NOI18N

        WelcomeLbl.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        WelcomeLbl.setText("Welcome, User");

        PageTypeLbl.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        PageTypeLbl.setText("Administrator Page");

        javax.swing.GroupLayout WelcomePanelLayout = new javax.swing.GroupLayout(WelcomePanel);
        WelcomePanel.setLayout(WelcomePanelLayout);
        WelcomePanelLayout.setHorizontalGroup(
            WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WelcomePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BackgroundLbl))
            .addGroup(WelcomePanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(WelcomePanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(PageTypeLbl))
                    .addComponent(WelcomeLbl))
                .addContainerGap(314, Short.MAX_VALUE))
        );
        WelcomePanelLayout.setVerticalGroup(
            WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WelcomePanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(WelcomeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PageTypeLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(BackgroundLbl))
        );

        ParentPanel.add(WelcomePanel, "card2");

        UserRegPanel.setBackground(new java.awt.Color(255, 255, 255));

        AddUserBtn.setBackground(new java.awt.Color(255, 153, 0));
        AddUserBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddUserBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddUserBtn.setText("Add +");
        AddUserBtn.setBorder(null);
        AddUserBtn.setBorderPainted(false);
        AddUserBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddUserBtn.setFocusPainted(false);
        AddUserBtn.setFocusable(false);
        AddUserBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddUserBtnMouseClicked(evt);
            }
        });

        UsernameTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        UsernameTxt.setForeground(java.awt.Color.gray);
        UsernameTxt.setText("Username");
        UsernameTxt.setBorder(null);
        UsernameTxt.setFocusable(false);
        UsernameTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                UsernameTxtFocusLost(evt);
            }
        });
        UsernameTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsernameTxtMouseClicked(evt);
            }
        });

        Separator1.setBackground(new java.awt.Color(0, 0, 0));
        Separator1.setMaximumSize(new java.awt.Dimension(300, 1));
        Separator1.setMinimumSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout Separator1Layout = new javax.swing.GroupLayout(Separator1);
        Separator1.setLayout(Separator1Layout);
        Separator1Layout.setHorizontalGroup(
            Separator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Separator1Layout.setVerticalGroup(
            Separator1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        EmailTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EmailTxt.setForeground(java.awt.Color.gray);
        EmailTxt.setText("Email");
        EmailTxt.setBorder(null);
        EmailTxt.setFocusable(false);
        EmailTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmailTxtFocusLost(evt);
            }
        });
        EmailTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmailTxtMouseClicked(evt);
            }
        });

        Separator2.setBackground(new java.awt.Color(0, 0, 0));
        Separator2.setMaximumSize(new java.awt.Dimension(300, 1));
        Separator2.setMinimumSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout Separator2Layout = new javax.swing.GroupLayout(Separator2);
        Separator2.setLayout(Separator2Layout);
        Separator2Layout.setHorizontalGroup(
            Separator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        Separator2Layout.setVerticalGroup(
            Separator2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        PhoneNoTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PhoneNoTxt.setForeground(java.awt.Color.gray);
        PhoneNoTxt.setText("Phone Number");
        PhoneNoTxt.setBorder(null);
        PhoneNoTxt.setFocusable(false);
        PhoneNoTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PhoneNoTxtFocusLost(evt);
            }
        });
        PhoneNoTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PhoneNoTxtMouseClicked(evt);
            }
        });

        Separator3.setBackground(new java.awt.Color(0, 0, 0));
        Separator3.setMaximumSize(new java.awt.Dimension(300, 1));
        Separator3.setMinimumSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout Separator3Layout = new javax.swing.GroupLayout(Separator3);
        Separator3.setLayout(Separator3Layout);
        Separator3Layout.setHorizontalGroup(
            Separator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        Separator3Layout.setVerticalGroup(
            Separator3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        UsersTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UsersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Username", "Email", "Phone No.", "Password", "Role"
            }
        ));
        UsersTable.setFocusable(false);
        UsersTable.setGridColor(new java.awt.Color(0, 0, 0));
        UsersTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        UsersTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        UsersTable.setShowGrid(true);
        UsersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(UsersTable);
        if (UsersTable.getColumnModel().getColumnCount() > 0) {
            UsersTable.getColumnModel().getColumn(3).setHeaderValue("Phone No.");
            UsersTable.getColumnModel().getColumn(4).setHeaderValue("Password");
            UsersTable.getColumnModel().getColumn(5).setHeaderValue("Role");
        }

        RoleComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RoleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Manager", "Customer", "Delivery Runner", "Vendor" }));
        RoleComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RoleComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RoleComboBox.setFocusable(false);
        RoleComboBox.setOpaque(true);

        RoleLbl.setBackground(new java.awt.Color(255, 255, 255));
        RoleLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        RoleLbl.setText("Role");

        EditBtn.setBackground(new java.awt.Color(255, 153, 0));
        EditBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EditBtn.setForeground(new java.awt.Color(255, 255, 255));
        EditBtn.setText("Edit");
        EditBtn.setBorder(null);
        EditBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        EditBtn.setFocusPainted(false);
        EditBtn.setFocusable(false);
        EditBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditBtnMouseClicked(evt);
            }
        });

        DelBtn.setBackground(new java.awt.Color(255, 0, 0));
        DelBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DelBtn.setForeground(new java.awt.Color(255, 255, 255));
        DelBtn.setText("Delete");
        DelBtn.setBorder(null);
        DelBtn.setBorderPainted(false);
        DelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DelBtn.setFocusPainted(false);
        DelBtn.setFocusable(false);
        DelBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DelBtnMouseClicked(evt);
            }
        });

        PasswordsChkBox.setBackground(new java.awt.Color(255, 255, 255));
        PasswordsChkBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        PasswordsChkBox.setText("Show passwords");
        PasswordsChkBox.setFocusPainted(false);
        PasswordsChkBox.setFocusable(false);
        PasswordsChkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordsChkBoxActionPerformed(evt);
            }
        });

        UsernameExampleLbl.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        UsernameExampleLbl.setForeground(java.awt.Color.gray);
        UsernameExampleLbl.setText("e.g. Joe123");

        EmailExampleLbl.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        EmailExampleLbl.setForeground(java.awt.Color.gray);
        EmailExampleLbl.setText("e.g. joe@gmail.com");

        PhoneNoExampleLbl.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        PhoneNoExampleLbl.setForeground(java.awt.Color.gray);
        PhoneNoExampleLbl.setText("e.g. 0123456789");

        SearchTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchTxt.setForeground(java.awt.Color.gray);
        SearchTxt.setText("Search");
        SearchTxt.setBorder(null);
        SearchTxt.setFocusable(false);
        SearchTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchTxtFocusLost(evt);
            }
        });
        SearchTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchTxtMouseClicked(evt);
            }
        });
        SearchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTxtKeyReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout UserRegPanelLayout = new javax.swing.GroupLayout(UserRegPanel);
        UserRegPanel.setLayout(UserRegPanelLayout);
        UserRegPanelLayout.setHorizontalGroup(
            UserRegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserRegPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(UserRegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UserRegPanelLayout.createSequentialGroup()
                        .addGroup(UserRegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UserRegPanelLayout.createSequentialGroup()
                                .addGroup(UserRegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(PhoneNoTxt)
                                    .addComponent(Separator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(PhoneNoExampleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UserRegPanelLayout.createSequentialGroup()
                                .addGroup(UserRegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(EmailTxt)
                                    .addComponent(Separator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(EmailExampleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UserRegPanelLayout.createSequentialGroup()
                                .addGroup(UserRegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(UsernameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(Separator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(UsernameExampleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UserRegPanelLayout.createSequentialGroup()
                                .addComponent(AddUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(DelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(UserRegPanelLayout.createSequentialGroup()
                                .addComponent(RoleLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(RoleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(UserRegPanelLayout.createSequentialGroup()
                        .addGroup(UserRegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UserRegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(UserRegPanelLayout.createSequentialGroup()
                                    .addComponent(SearchTxt)
                                    .addGap(115, 115, 115)
                                    .addComponent(PasswordsChkBox))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 73, Short.MAX_VALUE))))
        );
        UserRegPanelLayout.setVerticalGroup(
            UserRegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserRegPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(UserRegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(UserRegPanelLayout.createSequentialGroup()
                        .addGroup(UserRegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(UserRegPanelLayout.createSequentialGroup()
                                .addGroup(UserRegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(UserRegPanelLayout.createSequentialGroup()
                                        .addComponent(UsernameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Separator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(UsernameExampleLbl))
                                .addGap(18, 18, 18)
                                .addComponent(EmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Separator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(EmailExampleLbl))
                        .addGap(18, 18, 18)
                        .addComponent(PhoneNoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Separator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PhoneNoExampleLbl))
                .addGap(41, 41, 41)
                .addGroup(UserRegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RoleLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(UserRegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(UserRegPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PasswordsChkBox)
                    .addComponent(SearchTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        ParentPanel.add(UserRegPanel, "card3");

        TopUpPanel.setBackground(new java.awt.Color(255, 255, 255));

        UsersTable_TopUp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        UsersTable_TopUp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Username", "Balance (RM)"
            }
        ));
        UsersTable_TopUp.setFocusable(false);
        UsersTable_TopUp.setGridColor(new java.awt.Color(0, 0, 0));
        UsersTable_TopUp.setSelectionBackground(new java.awt.Color(255, 153, 0));
        UsersTable_TopUp.setSelectionForeground(new java.awt.Color(255, 255, 255));
        UsersTable_TopUp.setShowGrid(true);
        UsersTable_TopUp.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(UsersTable_TopUp);

        AmountTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AmountTxt.setForeground(java.awt.Color.gray);
        AmountTxt.setText("Amount");
        AmountTxt.setBorder(null);
        AmountTxt.setFocusable(false);
        AmountTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AmountTxtFocusLost(evt);
            }
        });
        AmountTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AmountTxtMouseClicked(evt);
            }
        });

        Separator4.setBackground(new java.awt.Color(0, 0, 0));
        Separator4.setMaximumSize(new java.awt.Dimension(300, 1));
        Separator4.setMinimumSize(new java.awt.Dimension(0, 1));

        javax.swing.GroupLayout Separator4Layout = new javax.swing.GroupLayout(Separator4);
        Separator4.setLayout(Separator4Layout);
        Separator4Layout.setHorizontalGroup(
            Separator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        Separator4Layout.setVerticalGroup(
            Separator4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        ConfirmBtn.setBackground(new java.awt.Color(255, 153, 0));
        ConfirmBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ConfirmBtn.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmBtn.setText("Confirm");
        ConfirmBtn.setBorder(null);
        ConfirmBtn.setBorderPainted(false);
        ConfirmBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ConfirmBtn.setFocusPainted(false);
        ConfirmBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConfirmBtnMouseClicked(evt);
            }
        });
        ConfirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmBtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 306, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        SearchTxt_TopUp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchTxt_TopUp.setForeground(java.awt.Color.gray);
        SearchTxt_TopUp.setText("Search");
        SearchTxt_TopUp.setBorder(null);
        SearchTxt_TopUp.setFocusable(false);
        SearchTxt_TopUp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchTxt_TopUpFocusLost(evt);
            }
        });
        SearchTxt_TopUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchTxt_TopUpMouseClicked(evt);
            }
        });
        SearchTxt_TopUp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchTxt_TopUpKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout TopUpPanelLayout = new javax.swing.GroupLayout(TopUpPanel);
        TopUpPanel.setLayout(TopUpPanelLayout);
        TopUpPanelLayout.setHorizontalGroup(
            TopUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopUpPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(TopUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SearchTxt_TopUp, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConfirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TopUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(AmountTxt)
                        .addComponent(Separator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        TopUpPanelLayout.setVerticalGroup(
            TopUpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TopUpPanelLayout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(AmountTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Separator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(ConfirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(SearchTxt_TopUp, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        ParentPanel.add(TopUpPanel, "card4");

        TransactionsPanel.setBackground(new java.awt.Color(255, 255, 255));

        TransactionsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TransactionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "OrderID", "Vendor", "Customer", "Date", "Total"
            }
        ));
        TransactionsTable.setFocusable(false);
        TransactionsTable.setGridColor(new java.awt.Color(0, 0, 0));
        TransactionsTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        TransactionsTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TransactionsTable.setShowGrid(true);
        TransactionsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(TransactionsTable);

        GenerateRctBtn.setBackground(new java.awt.Color(255, 153, 0));
        GenerateRctBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GenerateRctBtn.setForeground(new java.awt.Color(255, 255, 255));
        GenerateRctBtn.setText("Generate Receipt");
        GenerateRctBtn.setBorder(null);
        GenerateRctBtn.setBorderPainted(false);
        GenerateRctBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        GenerateRctBtn.setFocusPainted(false);
        GenerateRctBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GenerateRctBtnMouseClicked(evt);
            }
        });
        GenerateRctBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateRctBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TransactionsPanelLayout = new javax.swing.GroupLayout(TransactionsPanel);
        TransactionsPanel.setLayout(TransactionsPanelLayout);
        TransactionsPanelLayout.setHorizontalGroup(
            TransactionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransactionsPanelLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(TransactionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GenerateRctBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );
        TransactionsPanelLayout.setVerticalGroup(
            TransactionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionsPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(GenerateRctBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        ParentPanel.add(TransactionsPanel, "card5");

        ReceiptsPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ReceiptsPanelLayout = new javax.swing.GroupLayout(ReceiptsPanel);
        ReceiptsPanel.setLayout(ReceiptsPanelLayout);
        ReceiptsPanelLayout.setHorizontalGroup(
            ReceiptsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );
        ReceiptsPanelLayout.setVerticalGroup(
            ReceiptsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 585, Short.MAX_VALUE)
        );

        ParentPanel.add(ReceiptsPanel, "card6");

        javax.swing.GroupLayout BackgroundPanelLayout = new javax.swing.GroupLayout(BackgroundPanel);
        BackgroundPanel.setLayout(BackgroundPanelLayout);
        BackgroundPanelLayout.setHorizontalGroup(
            BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundPanelLayout.createSequentialGroup()
                .addComponent(SidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ParentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BackgroundPanelLayout.setVerticalGroup(
            BackgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SidePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ParentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UserRegBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserRegBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(UserRegPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(UserRegBtn, hoverIcon1);
    }//GEN-LAST:event_UserRegBtnActionPerformed

    private void TopUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopUpBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(TopUpPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(TopUpBtn, hoverIcon2);
        refreshBalance();
    }//GEN-LAST:event_TopUpBtnActionPerformed

    private void TransactionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransactionBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(TransactionsPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(TransactionBtn, hoverIcon3);
        refreshTransactions();
    }//GEN-LAST:event_TransactionBtnActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        this.dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void UsernameTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsernameTxtMouseClicked
        UsernameTxt.setFocusable(true);
        UsernameTxt.requestFocusInWindow();
        UsernameTxt.setForeground(Color.black);
        
        if ("Username".equals(UsernameTxt.getText())) {
            UsernameTxt.setText("");
        }
    }//GEN-LAST:event_UsernameTxtMouseClicked

    private void EmailTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmailTxtMouseClicked
        EmailTxt.setFocusable(true);
        EmailTxt.requestFocusInWindow();
        EmailTxt.setForeground(Color.black);
        
        if ("Email".equals(EmailTxt.getText())) {
            EmailTxt.setText("");
        }
    }//GEN-LAST:event_EmailTxtMouseClicked

    private void PhoneNoTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PhoneNoTxtMouseClicked
        
        PhoneNoTxt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }

                if (PhoneNoTxt.getText().length() >= 10) {
                    e.consume();
                }
            }
        });
        
        PhoneNoTxt.setFocusable(true);
        PhoneNoTxt.requestFocusInWindow();
        PhoneNoTxt.setForeground(Color.black);
        
        if ("Phone Number".equals(PhoneNoTxt.getText())) {
            PhoneNoTxt.setText("");
        }
    }//GEN-LAST:event_PhoneNoTxtMouseClicked

    private void UsernameTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UsernameTxtFocusLost
        if ("".equals(UsernameTxt.getText())) {
            UsernameTxt.setText("Username");
            UsernameTxt.setForeground(Color.gray);
            UsernameTxt.setFocusable(false);
        }
    }//GEN-LAST:event_UsernameTxtFocusLost

    private void EmailTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailTxtFocusLost
        if ("".equals(EmailTxt.getText())) {
            EmailTxt.setText("Email");
            EmailTxt.setForeground(Color.gray);
            EmailTxt.setFocusable(false);
        }
    }//GEN-LAST:event_EmailTxtFocusLost

    private void PhoneNoTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PhoneNoTxtFocusLost
                       
        if ("".equals(PhoneNoTxt.getText())) {
            
            for (KeyListener kl : PhoneNoTxt.getKeyListeners()) {
                PhoneNoTxt.removeKeyListener(kl);
            }
            
            PhoneNoTxt.setText("Phone Number");
            PhoneNoTxt.setForeground(Color.gray);
            PhoneNoTxt.setFocusable(false);
        }
    }//GEN-LAST:event_PhoneNoTxtFocusLost

    private void AddUserBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddUserBtnMouseClicked
        addUser();
        resetFields();
    }//GEN-LAST:event_AddUserBtnMouseClicked

    private void EditBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditBtnMouseClicked
        editUser();
        resetFields();
    }//GEN-LAST:event_EditBtnMouseClicked

    private void DelBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelBtnMouseClicked
        delUser();
        resetFields();
    }//GEN-LAST:event_DelBtnMouseClicked

    private void PasswordsChkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordsChkBoxActionPerformed
        refreshData(PasswordsChkBox.isSelected());
    }//GEN-LAST:event_PasswordsChkBoxActionPerformed

    private void SearchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTxtKeyReleased
        try {
            String searchText = SearchTxt.getText().trim();
            DefaultTableModel model = (DefaultTableModel) UsersTable.getModel();
            model.setRowCount(0);

            if (searchText.isEmpty()) {
                refreshData(PasswordsChkBox.isSelected());
            }

            FileReader fr = new FileReader("User.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("--");
                String id = data[0].trim();
                String username = data[1].trim();
                String email = data[2].trim();
                String phoneNo = data[3].trim();
                String password = data[4].trim();
                String role = data[5].trim();
                
                if (id.equalsIgnoreCase(searchText)
                        || username.equalsIgnoreCase(searchText)
                        || email.equalsIgnoreCase(searchText)
                        || phoneNo.equalsIgnoreCase(searchText)
                        || password.equalsIgnoreCase(searchText)
                        || role.equalsIgnoreCase(searchText)) {
                    model.addRow(new Object[]{id, username, email, phoneNo, password, role});
                }
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occured while reading the file." + e.getMessage());
        }
    }//GEN-LAST:event_SearchTxtKeyReleased

    private void SearchTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchTxtMouseClicked
       
        SearchTxt.setFocusable(true);
        SearchTxt.requestFocusInWindow();
        SearchTxt.setForeground(Color.black);
        
        if ("Search".equals(SearchTxt.getText())) {
            SearchTxt.setText("");
        }
    }//GEN-LAST:event_SearchTxtMouseClicked

    private void SearchTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchTxtFocusLost
        if ("".equals(SearchTxt.getText())) {
            SearchTxt.setText("Search");
            SearchTxt.setForeground(Color.gray);
            SearchTxt.setFocusable(false);
        }
    }//GEN-LAST:event_SearchTxtFocusLost

    private void AmountTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AmountTxtFocusLost
        if ("".equals(AmountTxt.getText())) {
            AmountTxt.setText("Amount");
            AmountTxt.setForeground(Color.gray);
            AmountTxt.setFocusable(false);
        }
    }//GEN-LAST:event_AmountTxtFocusLost

    private void AmountTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AmountTxtMouseClicked
        
        AmountTxt.setFocusable(true);
        AmountTxt.requestFocusInWindow();
        AmountTxt.setForeground(Color.black);
        
        if ("Amount".equals(AmountTxt.getText())) {
            AmountTxt.setText("");
        }
    }//GEN-LAST:event_AmountTxtMouseClicked

    private void ConfirmBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConfirmBtnMouseClicked
        topUp();
        refreshBalance();
    }//GEN-LAST:event_ConfirmBtnMouseClicked

    private void SearchTxt_TopUpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchTxt_TopUpFocusLost
        if ("".equals(SearchTxt_TopUp.getText())) {
            SearchTxt_TopUp.setText("Search");
            SearchTxt_TopUp.setForeground(Color.gray);
            SearchTxt_TopUp.setFocusable(false);
        }
    }//GEN-LAST:event_SearchTxt_TopUpFocusLost

    private void SearchTxt_TopUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchTxt_TopUpMouseClicked
        SearchTxt_TopUp.setFocusable(true);
        SearchTxt_TopUp.requestFocusInWindow();
        SearchTxt_TopUp.setForeground(Color.black);
        
        if ("Search".equals(SearchTxt_TopUp.getText())) {
            SearchTxt_TopUp.setText("");
        }
    }//GEN-LAST:event_SearchTxt_TopUpMouseClicked

    private void SearchTxt_TopUpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTxt_TopUpKeyReleased
        
        try {
            String searchText = SearchTxt_TopUp.getText().trim();
            DefaultTableModel model = (DefaultTableModel) UsersTable_TopUp.getModel();
            model.setRowCount(0);

            if (searchText.isEmpty()) {
                refreshBalance();
            }

            FileReader fr = new FileReader("Balance.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("--");
                String id = data[0].trim();
                String username = data[1].trim();
                String balance = data[2].trim();
                
                if (id.equalsIgnoreCase(searchText)
                        || username.equalsIgnoreCase(searchText)
                        || balance.equalsIgnoreCase(searchText)
                    ) {
                    model.addRow(new Object[]{id, username, balance});
                }
            }
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occured while reading the file." + e.getMessage());
        }
    }//GEN-LAST:event_SearchTxt_TopUpKeyReleased

    private void ConfirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmBtnActionPerformed
   
    }//GEN-LAST:event_ConfirmBtnActionPerformed

    private void GenerateRctBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenerateRctBtnMouseClicked
        generateTransactionReceipt();
    }//GEN-LAST:event_GenerateRctBtnMouseClicked

    private void GenerateRctBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateRctBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenerateRctBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddUserBtn;
    private javax.swing.JTextField AmountTxt;
    private javax.swing.JLabel BackgroundLbl;
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JButton ConfirmBtn;
    private javax.swing.JButton DelBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JLabel EmailExampleLbl;
    private javax.swing.JTextField EmailTxt;
    private javax.swing.JButton GenerateRctBtn;
    private javax.swing.JLabel LogoLbl;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JLabel PageTypeLbl;
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JCheckBox PasswordsChkBox;
    private javax.swing.JLabel PhoneNoExampleLbl;
    private javax.swing.JTextField PhoneNoTxt;
    private javax.swing.JPanel ReceiptsPanel;
    private javax.swing.JComboBox<String> RoleComboBox;
    private javax.swing.JLabel RoleLbl;
    private javax.swing.JTextField SearchTxt;
    private javax.swing.JTextField SearchTxt_TopUp;
    private javax.swing.JPanel Separator1;
    private javax.swing.JPanel Separator2;
    private javax.swing.JPanel Separator3;
    private javax.swing.JPanel Separator4;
    private javax.swing.JPanel SeparatorPanel;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton TopUpBtn;
    private javax.swing.JPanel TopUpPanel;
    private javax.swing.JButton TransactionBtn;
    private javax.swing.JPanel TransactionsPanel;
    private javax.swing.JTable TransactionsTable;
    private javax.swing.JButton UserRegBtn;
    private javax.swing.JPanel UserRegPanel;
    private javax.swing.JLabel UsernameExampleLbl;
    private javax.swing.JTextField UsernameTxt;
    private javax.swing.JTable UsersTable;
    private javax.swing.JTable UsersTable_TopUp;
    private javax.swing.JLabel WelcomeLbl;
    private javax.swing.JPanel WelcomePanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}
