
package foodOrderingSystem.jFrames;
import foodOrderingSystem.Classes.ButtonStyler;
import foodOrderingSystem.Classes.Item;
import foodOrderingSystem.Classes.Order;
import foodOrderingSystem.Classes.Review;
import foodOrderingSystem.Classes.User;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static java.awt.SystemColor.text;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class CustomerPage extends javax.swing.JFrame {

    Color orange = new Color(255, 153, 0, 255);  
    
    private double total = 0.0;
    private String totalQuantity = "";
    private String CustomerName;
    
    Icon defaultIcon1 = new ImageIcon(ButtonStyler.class.getResource("/menu.png"));
    Icon hoverIcon1 = new ImageIcon(ButtonStyler.class.getResource("/menuHover.png"));
        
    Icon defaultIcon2 = new ImageIcon(ButtonStyler.class.getResource("/track.png"));
    Icon hoverIcon2 = new ImageIcon(ButtonStyler.class.getResource("/trackHover.png"));
    
    Icon defaultIcon3 = new ImageIcon(ButtonStyler.class.getResource("/order-history.png"));
    Icon hoverIcon3 = new ImageIcon(ButtonStyler.class.getResource("/order-historyHover.png"));
    
    Icon defaultIcon4 = new ImageIcon(ButtonStyler.class.getResource("/transaction-history.png"));
    Icon hoverIcon4 = new ImageIcon(ButtonStyler.class.getResource("/transaction-historyHover.png"));
    
    Icon defaultIcon5 = new ImageIcon(ButtonStyler.class.getResource("/review.png"));
    Icon hoverIcon5 = new ImageIcon(ButtonStyler.class.getResource("/reviewHover.png"));
    
    Icon defaultIcon6 = new ImageIcon(ButtonStyler.class.getResource("/bell.png"));
    Icon hoverIcon6 = new ImageIcon(ButtonStyler.class.getResource("/bellHover.png"));
    
    Icon defaultIcon7 = new ImageIcon(ButtonStyler.class.getResource("/logout.png"));
    Icon hoverIcon7 = new ImageIcon(ButtonStyler.class.getResource("/logoutHover.png"));
    
    public CustomerPage(String username) {
        
        try { 
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception ignored){}
        
        initComponents();
        
        WelcomeLbl.setText("Welcome, " + username);
        TableHeaderStyle(MenuTable);
        TableHeaderStyle(OrderStatusTable);
        TableHeaderStyle(OrderHistoryTable);
        
        //CustomerName = username;
        String name = WelcomeLbl.getText();
        String[] parts = name.split(", ");
        CustomerName = parts[1];
        
        OrderList.setModel(new DefaultListModel<>());
                         
        JButton[] allButtons = {MenuBtn, OrderStatusBtn, OrderHisBtn, TransactionHisBtn, ReviewsBtn, NotificationBtn, LogoutBtn};      
        
        ButtonStyler.applyMouseEffects(MenuBtn, allButtons, defaultIcon1, hoverIcon1);
        ButtonStyler.applyMouseEffects(OrderStatusBtn, allButtons, defaultIcon2, hoverIcon2);
        ButtonStyler.applyMouseEffects(OrderHisBtn, allButtons, defaultIcon3, hoverIcon3);
        ButtonStyler.applyMouseEffects(TransactionHisBtn, allButtons, defaultIcon4, hoverIcon4);
        ButtonStyler.applyMouseEffects(ReviewsBtn, allButtons, defaultIcon5, hoverIcon5);
        ButtonStyler.applyMouseEffects(NotificationBtn, allButtons, defaultIcon6, hoverIcon6);
        ButtonStyler.applyMouseEffects(LogoutBtn, allButtons, defaultIcon7, hoverIcon7);
    }
    
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
    
    private void resetToDefault() {
        ButtonStyler.applyDefaultStyle(MenuBtn, defaultIcon1);
        ButtonStyler.applyDefaultStyle(OrderStatusBtn, defaultIcon2);
        ButtonStyler.applyDefaultStyle(OrderHisBtn, defaultIcon3);
        ButtonStyler.applyDefaultStyle(TransactionHisBtn, defaultIcon4);
        ButtonStyler.applyDefaultStyle(ReviewsBtn, defaultIcon5);
        ButtonStyler.applyDefaultStyle(NotificationBtn, defaultIcon6);
        ButtonStyler.applyDefaultStyle(LogoutBtn, defaultIcon7);
    }

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
    
    private void refreshRestaurants() {
        
        User user = new User();
        user.displayVendors(RestaurantsComboBox);
    }
    
    private void refreshMenu() {
        
        Item item = new Item();
        String vendor = RestaurantsComboBox.getSelectedItem().toString();
        
        DefaultTableModel model = (DefaultTableModel) MenuTable.getModel();
        model.setRowCount(0);
        
        List<String[]> records = item.ViewItems();
        
        for (String[] itemDetails : records) {
            if (itemDetails.length >= 5) {
                String name = itemDetails[1].trim();
                if (name.equalsIgnoreCase(vendor)) {
                    String id = itemDetails[0];
                    String itemName = itemDetails[2];
                    String itemPrice = itemDetails[3];
                    String itemType = itemDetails[4];          
            
                    model.addRow(
                            new Object[]{id, itemName, itemPrice, itemType
                                });
                }
            }
        }
    }
    
    
    private void refreshOrderStatus() {
        
        Order order = new Order();
        
        DefaultTableModel model = (DefaultTableModel) OrderStatusTable.getModel();
        model.setRowCount(0);
        
        List<String[]> records = order.ViewOrders();
        
        for (String[] orderDetails : records) {
          if (orderDetails.length >= 8) {
            String name = orderDetails[1].trim();
            if (name.equalsIgnoreCase(CustomerName)) {         
                model.addRow(
                    new Object[]{
                        orderDetails[0],
                        orderDetails[2],
                        orderDetails[3],
                        orderDetails[7]
                        });
            }
          }
        }
    }
    
    private void refreshOrderHistory() {
        
        Order order = new Order();
        
        DefaultTableModel model = (DefaultTableModel) OrderHistoryTable.getModel();
        model.setRowCount(0);
        
        Set<String> validStatuses = Set.of("Delivered", "Cancelled");
        List<String[]> records = order.ViewOrders();
        
        for (String[] orderDetails : records) {
          if (orderDetails.length >= 8) {
            String name = orderDetails[1].trim();
            String status = orderDetails[7].trim();
            if (name.equalsIgnoreCase(CustomerName) && validStatuses.contains(status)) {         
                model.addRow(
                    new Object[]{
                        orderDetails[0],
                        orderDetails[2],
                        orderDetails[5],
                        orderDetails[6],
                        orderDetails[3],
                        orderDetails[7]
                        });
            }
          }
        }
    }
    
    private static Set<String> getExistingIDs() {
        Set<String> existingIDs = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Order.txt"))) {
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
            newID = "O0" + ID.toString();
        } while (existingIDs.contains(newID));
        
        return newID;
    }     
    
    
    private void placeOrder() {
                
        if (OrderList.getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(null, "Your order list is empty!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        String orderID = generateID();

        String vendor = RestaurantsComboBox.getSelectedItem().toString();
        String items = OrderList.getModel().toString();
        String date = java.time.LocalDate.now().toString();
        String fullItems = String.join(",", items);
        
        Order order = new Order(orderID, CustomerName, vendor, date, 
                String.valueOf(total), fullItems, totalQuantity, "Pending");
        order.addOrder();
    }
    
    private void addToOrder() {
        
        int selectedRow = MenuTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No item selected!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String itemName = (String) MenuTable.getValueAt(selectedRow, 1);
        String price = (String) MenuTable.getValueAt(selectedRow, 2);
        int quantity = (int) QuantitySpinner.getValue();
        DefaultListModel<String> listModel = (DefaultListModel<String>) OrderList.getModel();
        listModel.addElement(itemName);
        
        if (!totalQuantity.isEmpty()) {
            totalQuantity += ", ";    
        }
        
        totalQuantity += String.valueOf(quantity);
        
        double dPrice = Double.parseDouble(price);
        total += (dPrice * quantity);
        
        AmountLbl.setText(Double.toString(total));
    }
    
    
    private void refreshReviews() {
        
        Order order = new Order();
        
        DefaultTableModel model = (DefaultTableModel) ReviewsTable.getModel();
        model.setRowCount(0);
        
        List<String[]> records = order.ViewOrders();
        
        
        for (String[] orderDetails : records) {
            if (orderDetails.length >= 5) {
                String name = orderDetails[1].trim();
                if (name.equalsIgnoreCase(CustomerName)) {
                    String id = orderDetails[0];
                    String vendor = orderDetails[1];
                    String date = orderDetails[3];          
            
                    model.addRow(
                            new Object[]{id, vendor, date
                                });
                }
            }
        }
    }
    
    private void submitReview() {
        
        int selectedRow = ReviewsTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No record selected for reviewing!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String comment = VendorCommentTxt.getText();
        String vendorRating = VendorSpinner.getValue().toString();
        String deliveryRating = DeliverySpinner.getValue().toString();
        
        String Id = (String) ReviewsTable.getValueAt(selectedRow, 0);
        String vendor = (String) ReviewsTable.getValueAt(selectedRow, 1);
        String deliveryRunner = (String) ReviewsTable.getValueAt(selectedRow, 2);
        String date = (String) ReviewsTable.getValueAt(selectedRow, 3);
        
        Review review = new Review(Id, CustomerName, vendor, deliveryRunner, date, comment, vendorRating, deliveryRating);
        review.addReview();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VendorCommentLbl2 = new javax.swing.JLabel();
        BackgroundPanel = new javax.swing.JPanel();
        SidePanel = new jPanelGradient();
        MenuBtn = new javax.swing.JButton();
        OrderStatusBtn = new javax.swing.JButton();
        OrderHisBtn = new javax.swing.JButton();
        TransactionHisBtn = new javax.swing.JButton();
        SeparatorPanel = new javax.swing.JPanel();
        LogoLbl = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JButton();
        ReviewsBtn = new javax.swing.JButton();
        NotificationBtn = new javax.swing.JButton();
        ParentPanel = new javax.swing.JPanel();
        WelcomePanel = new javax.swing.JPanel();
        BackgroundLbl = new javax.swing.JLabel();
        WelcomeLbl = new javax.swing.JLabel();
        PageTypeLbl = new javax.swing.JLabel();
        MenuPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MenuTable = new javax.swing.JTable();
        OrderBtn = new javax.swing.JButton();
        RestaurantsComboBox = new javax.swing.JComboBox<>();
        RestaurantsLbl = new javax.swing.JLabel();
        QuantitySpinner = new javax.swing.JSpinner();
        jScrollPane6 = new javax.swing.JScrollPane();
        OrderList = new javax.swing.JList<>();
        QuantityLbl = new javax.swing.JLabel();
        AddItemBtn = new javax.swing.JButton();
        TotalLbl = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        CurrencyLbl = new javax.swing.JLabel();
        AmountLbl = new javax.swing.JLabel();
        OrderStatusPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        OrderStatusTable = new javax.swing.JTable();
        OrderHistoryPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        OrderHistoryTable = new javax.swing.JTable();
        TransactionHisPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TransactionTable = new javax.swing.JTable();
        ReviewsPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ReviewsTable = new javax.swing.JTable();
        DeliverySpinner = new javax.swing.JSpinner();
        VendorCommentTxt = new javax.swing.JTextField();
        VendorCommentLbl = new javax.swing.JLabel();
        DeliveryRatingLbl = new javax.swing.JLabel();
        VendorCommentLbl3 = new javax.swing.JLabel();
        VendorSpinner = new javax.swing.JSpinner();
        SubmitBtn = new javax.swing.JButton();
        NotificationPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        NotificationTable2 = new javax.swing.JTable();

        VendorCommentLbl2.setBackground(new java.awt.Color(255, 255, 255));
        VendorCommentLbl2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        VendorCommentLbl2.setText("Rate Restaurant");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        SidePanel.setBackground(new java.awt.Color(255, 153, 0));

        MenuBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        MenuBtn.setForeground(new java.awt.Color(255, 255, 255));
        MenuBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menu.png"))); // NOI18N
        MenuBtn.setText("Menu");
        MenuBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        MenuBtn.setBorderPainted(false);
        MenuBtn.setContentAreaFilled(false);
        MenuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuBtn.setFocusPainted(false);
        MenuBtn.setFocusable(false);
        MenuBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MenuBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MenuBtn.setIconTextGap(10);
        MenuBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        MenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBtnActionPerformed(evt);
            }
        });

        OrderStatusBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        OrderStatusBtn.setForeground(new java.awt.Color(255, 255, 255));
        OrderStatusBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/track.png"))); // NOI18N
        OrderStatusBtn.setText("Order Status");
        OrderStatusBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        OrderStatusBtn.setBorderPainted(false);
        OrderStatusBtn.setContentAreaFilled(false);
        OrderStatusBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OrderStatusBtn.setFocusPainted(false);
        OrderStatusBtn.setFocusable(false);
        OrderStatusBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        OrderStatusBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        OrderStatusBtn.setIconTextGap(10);
        OrderStatusBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        OrderStatusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderStatusBtnActionPerformed(evt);
            }
        });

        OrderHisBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        OrderHisBtn.setForeground(new java.awt.Color(255, 255, 255));
        OrderHisBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/order-history.png"))); // NOI18N
        OrderHisBtn.setText("Order History");
        OrderHisBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        OrderHisBtn.setBorderPainted(false);
        OrderHisBtn.setContentAreaFilled(false);
        OrderHisBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OrderHisBtn.setFocusPainted(false);
        OrderHisBtn.setFocusable(false);
        OrderHisBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        OrderHisBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        OrderHisBtn.setIconTextGap(10);
        OrderHisBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        OrderHisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderHisBtnActionPerformed(evt);
            }
        });

        TransactionHisBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TransactionHisBtn.setForeground(new java.awt.Color(255, 255, 255));
        TransactionHisBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/transaction-history.png"))); // NOI18N
        TransactionHisBtn.setText("Transaction History");
        TransactionHisBtn.setToolTipText("");
        TransactionHisBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        TransactionHisBtn.setBorderPainted(false);
        TransactionHisBtn.setContentAreaFilled(false);
        TransactionHisBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TransactionHisBtn.setFocusPainted(false);
        TransactionHisBtn.setFocusable(false);
        TransactionHisBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TransactionHisBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        TransactionHisBtn.setIconTextGap(10);
        TransactionHisBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        TransactionHisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransactionHisBtnActionPerformed(evt);
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

        ReviewsBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ReviewsBtn.setForeground(new java.awt.Color(255, 255, 255));
        ReviewsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/review.png"))); // NOI18N
        ReviewsBtn.setText("Reviews");
        ReviewsBtn.setToolTipText("");
        ReviewsBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        ReviewsBtn.setBorderPainted(false);
        ReviewsBtn.setContentAreaFilled(false);
        ReviewsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ReviewsBtn.setFocusPainted(false);
        ReviewsBtn.setFocusable(false);
        ReviewsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ReviewsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ReviewsBtn.setIconTextGap(10);
        ReviewsBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        ReviewsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReviewsBtnActionPerformed(evt);
            }
        });

        NotificationBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        NotificationBtn.setForeground(new java.awt.Color(255, 255, 255));
        NotificationBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bell.png"))); // NOI18N
        NotificationBtn.setText("Notification");
        NotificationBtn.setToolTipText("");
        NotificationBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        NotificationBtn.setBorderPainted(false);
        NotificationBtn.setContentAreaFilled(false);
        NotificationBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        NotificationBtn.setFocusPainted(false);
        NotificationBtn.setFocusable(false);
        NotificationBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NotificationBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        NotificationBtn.setIconTextGap(10);
        NotificationBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        NotificationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NotificationBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TransactionHisBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(OrderHisBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(OrderStatusBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ReviewsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(NotificationBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(MenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrderStatusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OrderHisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TransactionHisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ReviewsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NotificationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
        PageTypeLbl.setText("Customer Page");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(BackgroundLbl))
        );

        ParentPanel.add(WelcomePanel, "card2");

        MenuPanel.setBackground(new java.awt.Color(255, 255, 255));

        MenuTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        MenuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Item Name", "Item Price", "Item Type"
            }
        ));
        MenuTable.setFocusable(false);
        MenuTable.setGridColor(new java.awt.Color(0, 0, 0));
        MenuTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        MenuTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        MenuTable.setShowGrid(true);
        MenuTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(MenuTable);

        OrderBtn.setBackground(new java.awt.Color(255, 153, 0));
        OrderBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        OrderBtn.setForeground(new java.awt.Color(255, 255, 255));
        OrderBtn.setText("Confirm Order");
        OrderBtn.setBorder(null);
        OrderBtn.setBorderPainted(false);
        OrderBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        OrderBtn.setFocusPainted(false);
        OrderBtn.setFocusable(false);
        OrderBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderBtnMouseClicked(evt);
            }
        });

        RestaurantsComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RestaurantsComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RestaurantsComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RestaurantsComboBox.setFocusable(false);
        RestaurantsComboBox.setOpaque(true);

        RestaurantsLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        RestaurantsLbl.setText("Restaurants");

        QuantitySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        QuantitySpinner.setFocusable(false);

        jScrollPane6.setViewportView(OrderList);

        QuantityLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        QuantityLbl.setText("Quantity");

        AddItemBtn.setBackground(new java.awt.Color(255, 153, 0));
        AddItemBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AddItemBtn.setForeground(new java.awt.Color(255, 255, 255));
        AddItemBtn.setText("Add +");
        AddItemBtn.setBorder(null);
        AddItemBtn.setBorderPainted(false);
        AddItemBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AddItemBtn.setFocusPainted(false);
        AddItemBtn.setFocusable(false);
        AddItemBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddItemBtnMouseClicked(evt);
            }
        });

        TotalLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TotalLbl.setText("Total");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        CurrencyLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CurrencyLbl.setText("RM");

        AmountLbl.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AmountLbl.setText("0");

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(OrderBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addComponent(TotalLbl)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(MenuPanelLayout.createSequentialGroup()
                                .addComponent(CurrencyLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AmountLbl)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addComponent(RestaurantsLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(QuantityLbl))
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addComponent(RestaurantsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(QuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RestaurantsLbl, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(QuantityLbl, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(MenuPanelLayout.createSequentialGroup()
                                .addComponent(RestaurantsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(MenuPanelLayout.createSequentialGroup()
                                .addComponent(QuantitySpinner)
                                .addGap(23, 23, 23)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(MenuPanelLayout.createSequentialGroup()
                                .addComponent(TotalLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CurrencyLbl)
                                    .addComponent(AmountLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(OrderBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(AddItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        ParentPanel.add(MenuPanel, "card3");

        OrderStatusPanel.setBackground(new java.awt.Color(255, 255, 255));

        OrderStatusTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        OrderStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "OrderID", "Restaurant", "Date", "Status"
            }
        ));
        OrderStatusTable.setFocusable(false);
        OrderStatusTable.setGridColor(new java.awt.Color(0, 0, 0));
        OrderStatusTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        OrderStatusTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        OrderStatusTable.setShowGrid(true);
        OrderStatusTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(OrderStatusTable);

        javax.swing.GroupLayout OrderStatusPanelLayout = new javax.swing.GroupLayout(OrderStatusPanel);
        OrderStatusPanel.setLayout(OrderStatusPanelLayout);
        OrderStatusPanelLayout.setHorizontalGroup(
            OrderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderStatusPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        OrderStatusPanelLayout.setVerticalGroup(
            OrderStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderStatusPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        ParentPanel.add(OrderStatusPanel, "card4");

        OrderHistoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        OrderHistoryTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        OrderHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "OrderID", "Restaurant", "Item", "Quantity", "Date", "Status"
            }
        ));
        OrderHistoryTable.setFocusable(false);
        OrderHistoryTable.setGridColor(new java.awt.Color(0, 0, 0));
        OrderHistoryTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        OrderHistoryTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        OrderHistoryTable.setShowGrid(true);
        OrderHistoryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(OrderHistoryTable);
        if (OrderHistoryTable.getColumnModel().getColumnCount() > 0) {
            OrderHistoryTable.getColumnModel().getColumn(2).setResizable(false);
            OrderHistoryTable.getColumnModel().getColumn(2).setHeaderValue("Item");
            OrderHistoryTable.getColumnModel().getColumn(3).setHeaderValue("Quantity");
        }

        javax.swing.GroupLayout OrderHistoryPanelLayout = new javax.swing.GroupLayout(OrderHistoryPanel);
        OrderHistoryPanel.setLayout(OrderHistoryPanelLayout);
        OrderHistoryPanelLayout.setHorizontalGroup(
            OrderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderHistoryPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        OrderHistoryPanelLayout.setVerticalGroup(
            OrderHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderHistoryPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        ParentPanel.add(OrderHistoryPanel, "card5");

        TransactionHisPanel.setBackground(new java.awt.Color(255, 255, 255));

        TransactionTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TransactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "OrderID", "Date", "Paid"
            }
        ));
        TransactionTable.setFocusable(false);
        TransactionTable.setGridColor(new java.awt.Color(0, 0, 0));
        TransactionTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        TransactionTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TransactionTable.setShowGrid(true);
        TransactionTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TransactionTable);
        if (TransactionTable.getColumnModel().getColumnCount() > 0) {
            TransactionTable.getColumnModel().getColumn(0).setHeaderValue("ID");
        }

        javax.swing.GroupLayout TransactionHisPanelLayout = new javax.swing.GroupLayout(TransactionHisPanel);
        TransactionHisPanel.setLayout(TransactionHisPanelLayout);
        TransactionHisPanelLayout.setHorizontalGroup(
            TransactionHisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransactionHisPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        TransactionHisPanelLayout.setVerticalGroup(
            TransactionHisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransactionHisPanelLayout.createSequentialGroup()
                .addContainerGap(242, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );

        ParentPanel.add(TransactionHisPanel, "card6");

        ReviewsPanel.setBackground(new java.awt.Color(255, 255, 255));

        ReviewsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ReviewsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "OrderID", "Vendor", "Delivery Runner", "Date"
            }
        ));
        ReviewsTable.setFocusable(false);
        ReviewsTable.setGridColor(new java.awt.Color(0, 0, 0));
        ReviewsTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        ReviewsTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ReviewsTable.setShowGrid(true);
        ReviewsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(ReviewsTable);

        DeliverySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 0, 5, 1));
        DeliverySpinner.setFocusable(false);

        VendorCommentTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        VendorCommentTxt.setForeground(java.awt.Color.gray);
        VendorCommentTxt.setText("Review");
        VendorCommentTxt.setBorder(null);
        VendorCommentTxt.setFocusable(false);
        VendorCommentTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                VendorCommentTxtFocusLost(evt);
            }
        });
        VendorCommentTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VendorCommentTxtMouseClicked(evt);
            }
        });

        VendorCommentLbl.setBackground(new java.awt.Color(255, 255, 255));
        VendorCommentLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        VendorCommentLbl.setText("Stars");

        DeliveryRatingLbl.setBackground(new java.awt.Color(255, 255, 255));
        DeliveryRatingLbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        DeliveryRatingLbl.setText("Rate Delivery Runner");

        VendorCommentLbl3.setBackground(new java.awt.Color(255, 255, 255));
        VendorCommentLbl3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        VendorCommentLbl3.setText("Rate Restaurant");

        VendorSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 0, 5, 1));
        VendorSpinner.setFocusable(false);

        SubmitBtn.setBackground(new java.awt.Color(255, 153, 0));
        SubmitBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SubmitBtn.setForeground(new java.awt.Color(255, 255, 255));
        SubmitBtn.setText("Submit");
        SubmitBtn.setBorder(null);
        SubmitBtn.setBorderPainted(false);
        SubmitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SubmitBtn.setFocusPainted(false);
        SubmitBtn.setFocusable(false);
        SubmitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubmitBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ReviewsPanelLayout = new javax.swing.GroupLayout(ReviewsPanel);
        ReviewsPanel.setLayout(ReviewsPanelLayout);
        ReviewsPanelLayout.setHorizontalGroup(
            ReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReviewsPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(ReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SubmitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeliverySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeliveryRatingLbl)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ReviewsPanelLayout.createSequentialGroup()
                        .addGroup(ReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VendorCommentTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(VendorCommentLbl3))
                        .addGap(69, 69, 69)
                        .addGroup(ReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VendorCommentLbl)
                            .addComponent(VendorSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        ReviewsPanelLayout.setVerticalGroup(
            ReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReviewsPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(ReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VendorCommentLbl)
                    .addComponent(VendorCommentLbl3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VendorCommentTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(VendorSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(DeliveryRatingLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeliverySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(SubmitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        ParentPanel.add(ReviewsPanel, "card7");

        NotificationPanel.setBackground(new java.awt.Color(255, 255, 255));

        NotificationTable2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NotificationTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Date", "Massage"
            }
        ));
        NotificationTable2.setFocusable(false);
        NotificationTable2.setGridColor(new java.awt.Color(0, 0, 0));
        NotificationTable2.setSelectionBackground(new java.awt.Color(255, 153, 0));
        NotificationTable2.setSelectionForeground(new java.awt.Color(255, 255, 255));
        NotificationTable2.setShowGrid(true);
        NotificationTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(NotificationTable2);

        javax.swing.GroupLayout NotificationPanelLayout = new javax.swing.GroupLayout(NotificationPanel);
        NotificationPanel.setLayout(NotificationPanelLayout);
        NotificationPanelLayout.setHorizontalGroup(
            NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NotificationPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        NotificationPanelLayout.setVerticalGroup(
            NotificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NotificationPanelLayout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );

        ParentPanel.add(NotificationPanel, "card8");

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

    private void MenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(MenuPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(MenuBtn, hoverIcon1);
        refreshRestaurants();
        refreshMenu();
    }//GEN-LAST:event_MenuBtnActionPerformed

    private void OrderStatusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderStatusBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(OrderStatusPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(OrderStatusBtn, hoverIcon2);
        refreshOrderStatus();
    }//GEN-LAST:event_OrderStatusBtnActionPerformed

    private void OrderHisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderHisBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(OrderHistoryPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(OrderHisBtn, hoverIcon3);
        refreshOrderHistory();
    }//GEN-LAST:event_OrderHisBtnActionPerformed

    private void TransactionHisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransactionHisBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(TransactionHisPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(TransactionHisBtn, hoverIcon4);
    }//GEN-LAST:event_TransactionHisBtnActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void ReviewsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReviewsBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(ReviewsPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(ReviewsBtn, hoverIcon5);
        refreshReviews();
    }//GEN-LAST:event_ReviewsBtnActionPerformed

    private void NotificationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NotificationBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(NotificationPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(NotificationBtn, hoverIcon6);
    }//GEN-LAST:event_NotificationBtnActionPerformed

    private void OrderBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderBtnMouseClicked
        placeOrder();
    }//GEN-LAST:event_OrderBtnMouseClicked

    private void AddItemBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddItemBtnMouseClicked
        addToOrder();
    }//GEN-LAST:event_AddItemBtnMouseClicked

    private void SubmitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitBtnMouseClicked
        submitReview();
    }//GEN-LAST:event_SubmitBtnMouseClicked

    private void VendorCommentTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_VendorCommentTxtFocusLost
        if ("".equals(VendorCommentTxt.getText())) {
            VendorCommentTxt.setText("Review");
            VendorCommentTxt.setForeground(Color.gray);
            VendorCommentTxt.setFocusable(false);
        }
    }//GEN-LAST:event_VendorCommentTxtFocusLost

    private void VendorCommentTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VendorCommentTxtMouseClicked
        VendorCommentTxt.setFocusable(true);
        VendorCommentTxt.requestFocusInWindow();
        VendorCommentTxt.setForeground(Color.black);

        if ("Review".equals(VendorCommentTxt.getText())) {
            VendorCommentTxt.setText("");
        }
    }//GEN-LAST:event_VendorCommentTxtMouseClicked

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
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerPage(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItemBtn;
    private javax.swing.JLabel AmountLbl;
    private javax.swing.JLabel BackgroundLbl;
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JLabel CurrencyLbl;
    private javax.swing.JLabel DeliveryRatingLbl;
    private javax.swing.JSpinner DeliverySpinner;
    private javax.swing.JLabel LogoLbl;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JButton MenuBtn;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JTable MenuTable;
    private javax.swing.JButton NotificationBtn;
    private javax.swing.JPanel NotificationPanel;
    private javax.swing.JTable NotificationTable2;
    private javax.swing.JButton OrderBtn;
    private javax.swing.JButton OrderHisBtn;
    private javax.swing.JPanel OrderHistoryPanel;
    private javax.swing.JTable OrderHistoryTable;
    private javax.swing.JList<String> OrderList;
    private javax.swing.JButton OrderStatusBtn;
    private javax.swing.JPanel OrderStatusPanel;
    private javax.swing.JTable OrderStatusTable;
    private javax.swing.JLabel PageTypeLbl;
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JLabel QuantityLbl;
    private javax.swing.JSpinner QuantitySpinner;
    private javax.swing.JComboBox<String> RestaurantsComboBox;
    private javax.swing.JLabel RestaurantsLbl;
    private javax.swing.JButton ReviewsBtn;
    private javax.swing.JPanel ReviewsPanel;
    private javax.swing.JTable ReviewsTable;
    private javax.swing.JPanel SeparatorPanel;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton SubmitBtn;
    private javax.swing.JLabel TotalLbl;
    private javax.swing.JButton TransactionHisBtn;
    private javax.swing.JPanel TransactionHisPanel;
    private javax.swing.JTable TransactionTable;
    private javax.swing.JLabel VendorCommentLbl;
    private javax.swing.JLabel VendorCommentLbl2;
    private javax.swing.JLabel VendorCommentLbl3;
    private javax.swing.JTextField VendorCommentTxt;
    private javax.swing.JSpinner VendorSpinner;
    private javax.swing.JLabel WelcomeLbl;
    private javax.swing.JPanel WelcomePanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}
