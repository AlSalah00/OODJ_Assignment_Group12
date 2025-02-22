
package foodOrderingSystem.jFrames;
import foodOrderingSystem.Classes.ButtonStyler;
import foodOrderingSystem.Classes.Notification;
import foodOrderingSystem.Classes.Order;
import foodOrderingSystem.Classes.Review;
import foodOrderingSystem.Classes.Task;
import foodOrderingSystem.Classes.User;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
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

public class DeliveryRunnerPage extends javax.swing.JFrame {

    Color orange = new Color(255, 153, 0, 255); 
    private String DeliveryRunner;
    
    Icon defaultIcon1 = new ImageIcon(ButtonStyler.class.getResource("/task.png"));
    Icon hoverIcon1 = new ImageIcon(ButtonStyler.class.getResource("/taskHover.png"));
        
    Icon defaultIcon2 = new ImageIcon(ButtonStyler.class.getResource("/task-status.png"));
    Icon hoverIcon2 = new ImageIcon(ButtonStyler.class.getResource("/task-statusHover.png"));
    
    Icon defaultIcon3 = new ImageIcon(ButtonStyler.class.getResource("/task-history.png"));
    Icon hoverIcon3 = new ImageIcon(ButtonStyler.class.getResource("/task-historyHover.png"));
    
    Icon defaultIcon4 = new ImageIcon(ButtonStyler.class.getResource("/review.png"));
    Icon hoverIcon4 = new ImageIcon(ButtonStyler.class.getResource("/reviewHover.png"));
    
    Icon defaultIcon5 = new ImageIcon(ButtonStyler.class.getResource("/profit.png"));
    Icon hoverIcon5 = new ImageIcon(ButtonStyler.class.getResource("/profitHover.png"));
    
    Icon defaultIcon6 = new ImageIcon(ButtonStyler.class.getResource("/logout.png"));
    Icon hoverIcon6 = new ImageIcon(ButtonStyler.class.getResource("/logoutHover.png"));
    
    public DeliveryRunnerPage(String username) {
        
        try { 
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch(Exception ignored){}
        
        initComponents();
        
        TableHeaderStyle(TasksTable);
        TableHeaderStyle(TasksStatusTable);
        TableHeaderStyle(TasksHistoryTable);
        TableHeaderStyle(ReviewsTable);
        
        
        WelcomeLbl.setText("Welcome, " + username);
        String name = WelcomeLbl.getText();
        String[] parts = name.split(", ");
        DeliveryRunner = parts[1];
                         
        JButton[] allButtons = {TasksBtn, TaskStatusBtn, TaskHisBtn, CusReviewsBtn, RevenueBtn, LogoutBtn};      
        
        ButtonStyler.applyMouseEffects(TasksBtn, allButtons, defaultIcon1, hoverIcon1);
        ButtonStyler.applyMouseEffects(TaskStatusBtn, allButtons, defaultIcon2, hoverIcon2);
        ButtonStyler.applyMouseEffects(TaskHisBtn, allButtons, defaultIcon3, hoverIcon3);
        ButtonStyler.applyMouseEffects(CusReviewsBtn, allButtons, defaultIcon4, hoverIcon4);
        ButtonStyler.applyMouseEffects(RevenueBtn, allButtons, defaultIcon5, hoverIcon5);
        ButtonStyler.applyMouseEffects(LogoutBtn, allButtons, defaultIcon6, hoverIcon6);
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
        ButtonStyler.applyDefaultStyle(TasksBtn, defaultIcon1);
        ButtonStyler.applyDefaultStyle(TaskStatusBtn, defaultIcon2);
        ButtonStyler.applyDefaultStyle(TaskHisBtn, defaultIcon3);
        ButtonStyler.applyDefaultStyle(CusReviewsBtn, defaultIcon4);
        ButtonStyler.applyDefaultStyle(RevenueBtn, defaultIcon5);
        ButtonStyler.applyDefaultStyle(LogoutBtn, defaultIcon6);
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
    
    private void refreshTasks() {
        
        Order order = new Order();
             
        DefaultTableModel model = (DefaultTableModel) TasksTable.getModel();
        model.setRowCount(0);
        
        
        List<String[]> records = order.ViewOrders();
        
        for (String[] orderDetails : records) {
            if (orderDetails.length >= 8) {
                String status = orderDetails[7].trim();
                if (status.equalsIgnoreCase("Done")) {
                    
                    String id = orderDetails[0];
                    String customer = orderDetails[1];
                    String vendor = orderDetails[2];
                    String item = orderDetails[3];
                    String quantity = orderDetails[4];
                    String total = orderDetails[5];
                    String date = orderDetails[6];   
                   
            
                    model.addRow(
                            new Object[]{id, customer, vendor, item, quantity, total, date, "Pending"
                                });
                }
            }
        }
    }
    
    
     private void refreshTasksStatus() {
        
        Task task = new Task();
             
        DefaultTableModel model = (DefaultTableModel) TasksStatusTable.getModel();
        model.setRowCount(0);
        
       
        List<String[]> records = task.ViewTasks();
        
        for (String[] taskDetails : records) {
            if (taskDetails.length >= 8) {
                String status = taskDetails[7].trim();
                String name = taskDetails[3].trim();
                if (name.equalsIgnoreCase(DeliveryRunner) && 
                        status.equalsIgnoreCase("On the way")) {
                    
                    String id = taskDetails[0];
                    String customer = taskDetails[1];
                    String vendor = taskDetails[2];
                    String item = taskDetails[4];
                    String quantity = taskDetails[5];
                    String date = taskDetails[6];    
                   
            
                    model.addRow(
                            new Object[]{id, customer, vendor, item, quantity, date, status
                                });
                }
            }
        }
    }
     
   private void refreshTasksHistory() {
        
        Task task = new Task();
             
        DefaultTableModel model = (DefaultTableModel) TasksHistoryTable.getModel();
        model.setRowCount(0);
        
        
        Set<String> validStatuses = Set.of("Delivered", "Declined");
        List<String[]> records = task.ViewTasks();
        
        for (String[] taskDetails : records) {
            if (taskDetails.length >= 8) {
                String status = taskDetails[7].trim();
                String name = taskDetails[3].trim();
                if (name.equalsIgnoreCase(DeliveryRunner) && 
                        validStatuses.contains(status)) {
                    
                    String id = taskDetails[0];
                    String Customer = taskDetails[1];
                    String Restaurant = taskDetails[2];
                    String Date = taskDetails[6];                 
            
                    model.addRow(
                            new Object[]{id, Restaurant, Customer, Date, status
                                });
                }
            }
        }
        
        User user = new User();
        
        String amount = user.retrieveRevenue(DeliveryRunner);
        double doubleAmount = Double.parseDouble(amount);
        double revenue = doubleAmount + 10;
               
        user.updateRevenue(DeliveryRunner, "DeliveryRunner", String.valueOf(revenue));
    }
    
    
    private void addTask(String status, JTable table) {
     
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No record selected for updating!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            
        String Id = (String) table.getValueAt(selectedRow, 0);
        String CustomerName = (String) table.getValueAt(selectedRow, 1);
        String Vendor = (String) table.getValueAt(selectedRow, 2);
        String item = (String) table.getValueAt(selectedRow, 3);
        String quantity = (String) table.getValueAt(selectedRow, 4);
        String total = (String) table.getValueAt(selectedRow, 5);
        String date = (String) table.getValueAt(selectedRow, 6);
        
        Task task = new Task(Id, CustomerName, Vendor, DeliveryRunner,  item , quantity, date, status);
        task.addTask();
        Order order = new Order(Id, CustomerName, Vendor, item, quantity, total, date, "Delivery runner accepted");
        order.updateOrderStatus();
        refreshTasks();
    } 
    
    private void updateStatus(String status, JTable table) {
        
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No record selected for updating!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String Id = (String) table.getValueAt(selectedRow, 0);
        String CustomerName = (String) table.getValueAt(selectedRow, 1);
        String Vendor = (String) table.getValueAt(selectedRow, 2);
        String item = (String) table.getValueAt(selectedRow, 3);
        String quantity = (String) table.getValueAt(selectedRow, 4);
        String date = (String) table.getValueAt(selectedRow, 5);
        
        Task task = new Task(Id, CustomerName, Vendor, DeliveryRunner, item, quantity, date, status);
        task.updateTaskStatus();
        refreshTasksStatus();
    }
    
    private void refreshReview(){
        
        
        Review review = new Review();
             
        DefaultTableModel model = (DefaultTableModel) ReviewsTable.getModel();
        model.setRowCount(0);
        
        
        List<String[]> records = review.displayReviews();
        
        for (String[] reviewDetails : records) {
            if (reviewDetails.length >= 7) {
                String name = reviewDetails[2].trim();
                if (name.equalsIgnoreCase(DeliveryRunner)) {
                    
                    String id = reviewDetails[0];
                    String customer = reviewDetails[1];                
                    String rating = reviewDetails[7];     
                    String date = reviewDetails[4];          
                   
            
                    model.addRow(
                            new Object[]{id, customer, rating, date
                                });
                }
            }
        }
    }
    
    private void displayRevenue() {
        
        User user = new User();
        
        List<String[]> records = user.viewRevenues();
        
        for (String[] reviewDetails : records) {
            if (reviewDetails.length >= 3) {
                String name = reviewDetails[0].trim();
                if (name.equalsIgnoreCase(DeliveryRunner)) {
                    String revenue = reviewDetails[2];
                    RevenueLbl.setText("RM " + revenue);
                }
            }
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanel = new javax.swing.JPanel();
        SidePanel = new jPanelGradient();
        TasksBtn = new javax.swing.JButton();
        TaskStatusBtn = new javax.swing.JButton();
        TaskHisBtn = new javax.swing.JButton();
        CusReviewsBtn = new javax.swing.JButton();
        SeparatorPanel = new javax.swing.JPanel();
        LogoLbl = new javax.swing.JLabel();
        LogoutBtn = new javax.swing.JButton();
        RevenueBtn = new javax.swing.JButton();
        ParentPanel = new javax.swing.JPanel();
        WelcomePanel = new javax.swing.JPanel();
        BackgroundLbl = new javax.swing.JLabel();
        WelcomeLbl = new javax.swing.JLabel();
        PageTypeLbl = new javax.swing.JLabel();
        TasksPanel = new javax.swing.JPanel();
        AcctTaskBtn = new javax.swing.JButton();
        DecTaskBtn = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        TasksTable = new javax.swing.JTable();
        TaskStatusPanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TasksStatusTable = new javax.swing.JTable();
        DeliveredBtn = new javax.swing.JButton();
        TaskHistoryPanel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TasksHistoryTable = new javax.swing.JTable();
        CusReviewsPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ReviewsTable = new javax.swing.JTable();
        RevenuePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        RevenueLbl = new javax.swing.JLabel();
        RevenueLbl1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        SidePanel.setBackground(new java.awt.Color(255, 153, 0));

        TasksBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TasksBtn.setForeground(new java.awt.Color(255, 255, 255));
        TasksBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/task.png"))); // NOI18N
        TasksBtn.setText("Tasks");
        TasksBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        TasksBtn.setBorderPainted(false);
        TasksBtn.setContentAreaFilled(false);
        TasksBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TasksBtn.setFocusPainted(false);
        TasksBtn.setFocusable(false);
        TasksBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TasksBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        TasksBtn.setIconTextGap(10);
        TasksBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        TasksBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TasksBtnActionPerformed(evt);
            }
        });

        TaskStatusBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TaskStatusBtn.setForeground(new java.awt.Color(255, 255, 255));
        TaskStatusBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/task-status.png"))); // NOI18N
        TaskStatusBtn.setText("Task Status");
        TaskStatusBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        TaskStatusBtn.setBorderPainted(false);
        TaskStatusBtn.setContentAreaFilled(false);
        TaskStatusBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TaskStatusBtn.setFocusPainted(false);
        TaskStatusBtn.setFocusable(false);
        TaskStatusBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TaskStatusBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        TaskStatusBtn.setIconTextGap(10);
        TaskStatusBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        TaskStatusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaskStatusBtnActionPerformed(evt);
            }
        });

        TaskHisBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TaskHisBtn.setForeground(new java.awt.Color(255, 255, 255));
        TaskHisBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/task-history.png"))); // NOI18N
        TaskHisBtn.setText("Task History");
        TaskHisBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        TaskHisBtn.setBorderPainted(false);
        TaskHisBtn.setContentAreaFilled(false);
        TaskHisBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TaskHisBtn.setFocusPainted(false);
        TaskHisBtn.setFocusable(false);
        TaskHisBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TaskHisBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        TaskHisBtn.setIconTextGap(10);
        TaskHisBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        TaskHisBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaskHisBtnActionPerformed(evt);
            }
        });

        CusReviewsBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CusReviewsBtn.setForeground(new java.awt.Color(255, 255, 255));
        CusReviewsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/review.png"))); // NOI18N
        CusReviewsBtn.setText("Customer Reviews");
        CusReviewsBtn.setToolTipText("");
        CusReviewsBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        CusReviewsBtn.setBorderPainted(false);
        CusReviewsBtn.setContentAreaFilled(false);
        CusReviewsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CusReviewsBtn.setFocusPainted(false);
        CusReviewsBtn.setFocusable(false);
        CusReviewsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        CusReviewsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        CusReviewsBtn.setIconTextGap(10);
        CusReviewsBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        CusReviewsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CusReviewsBtnActionPerformed(evt);
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

        RevenueBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        RevenueBtn.setForeground(new java.awt.Color(255, 255, 255));
        RevenueBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profit.png"))); // NOI18N
        RevenueBtn.setText("Revenue");
        RevenueBtn.setToolTipText("");
        RevenueBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 10));
        RevenueBtn.setBorderPainted(false);
        RevenueBtn.setContentAreaFilled(false);
        RevenueBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RevenueBtn.setFocusPainted(false);
        RevenueBtn.setFocusable(false);
        RevenueBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RevenueBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        RevenueBtn.setIconTextGap(10);
        RevenueBtn.setMargin(new java.awt.Insets(5, 15, 5, 10));
        RevenueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RevenueBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SidePanelLayout = new javax.swing.GroupLayout(SidePanel);
        SidePanel.setLayout(SidePanelLayout);
        SidePanelLayout.setHorizontalGroup(
            SidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TasksBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CusReviewsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TaskHisBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(TaskStatusBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RevenueBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(TasksBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TaskStatusBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TaskHisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CusReviewsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RevenueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        PageTypeLbl.setText("Delivery Runner Page");

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

        TasksPanel.setBackground(new java.awt.Color(255, 255, 255));

        AcctTaskBtn.setBackground(new java.awt.Color(255, 153, 0));
        AcctTaskBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AcctTaskBtn.setForeground(new java.awt.Color(255, 255, 255));
        AcctTaskBtn.setText("Accept");
        AcctTaskBtn.setBorder(null);
        AcctTaskBtn.setBorderPainted(false);
        AcctTaskBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AcctTaskBtn.setFocusPainted(false);
        AcctTaskBtn.setFocusable(false);
        AcctTaskBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AcctTaskBtnMouseClicked(evt);
            }
        });
        AcctTaskBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AcctTaskBtnActionPerformed(evt);
            }
        });

        DecTaskBtn.setBackground(new java.awt.Color(255, 0, 0));
        DecTaskBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DecTaskBtn.setForeground(new java.awt.Color(255, 255, 255));
        DecTaskBtn.setText("Decline");
        DecTaskBtn.setBorder(null);
        DecTaskBtn.setBorderPainted(false);
        DecTaskBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DecTaskBtn.setFocusPainted(false);
        DecTaskBtn.setFocusable(false);
        DecTaskBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DecTaskBtnMouseClicked(evt);
            }
        });

        TasksTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TasksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer", "Vendor", "Item", "Quantity", "Total", "Date", "Status"
            }
        ));
        TasksTable.setFocusable(false);
        TasksTable.setGridColor(new java.awt.Color(0, 0, 0));
        TasksTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        TasksTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TasksTable.setShowGrid(true);
        TasksTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(TasksTable);

        javax.swing.GroupLayout TasksPanelLayout = new javax.swing.GroupLayout(TasksPanel);
        TasksPanel.setLayout(TasksPanelLayout);
        TasksPanelLayout.setHorizontalGroup(
            TasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TasksPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(TasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TasksPanelLayout.createSequentialGroup()
                        .addComponent(AcctTaskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DecTaskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        TasksPanelLayout.setVerticalGroup(
            TasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TasksPanelLayout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addGroup(TasksPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AcctTaskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DecTaskBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        ParentPanel.add(TasksPanel, "card3");

        TaskStatusPanel.setBackground(new java.awt.Color(255, 255, 255));

        TasksStatusTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TasksStatusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer", "Vendor", "Item", "Quantity", "Date", "Status"
            }
        ));
        TasksStatusTable.setFocusable(false);
        TasksStatusTable.setGridColor(new java.awt.Color(0, 0, 0));
        TasksStatusTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        TasksStatusTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TasksStatusTable.setShowGrid(true);
        TasksStatusTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(TasksStatusTable);

        DeliveredBtn.setBackground(new java.awt.Color(255, 153, 0));
        DeliveredBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DeliveredBtn.setForeground(new java.awt.Color(255, 255, 255));
        DeliveredBtn.setText("Delivered");
        DeliveredBtn.setBorder(null);
        DeliveredBtn.setBorderPainted(false);
        DeliveredBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeliveredBtn.setFocusPainted(false);
        DeliveredBtn.setFocusable(false);
        DeliveredBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeliveredBtnMouseClicked(evt);
            }
        });
        DeliveredBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeliveredBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TaskStatusPanelLayout = new javax.swing.GroupLayout(TaskStatusPanel);
        TaskStatusPanel.setLayout(TaskStatusPanelLayout);
        TaskStatusPanelLayout.setHorizontalGroup(
            TaskStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaskStatusPanelLayout.createSequentialGroup()
                .addGroup(TaskStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TaskStatusPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(DeliveredBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TaskStatusPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        TaskStatusPanelLayout.setVerticalGroup(
            TaskStatusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TaskStatusPanelLayout.createSequentialGroup()
                .addContainerGap(217, Short.MAX_VALUE)
                .addComponent(DeliveredBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        ParentPanel.add(TaskStatusPanel, "card4");

        TaskHistoryPanel.setBackground(new java.awt.Color(255, 255, 255));

        TasksHistoryTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TasksHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "OrderID", "Restaurant", "Customer", "Date", "Status"
            }
        ));
        TasksHistoryTable.setFocusable(false);
        TasksHistoryTable.setGridColor(new java.awt.Color(0, 0, 0));
        TasksHistoryTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        TasksHistoryTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TasksHistoryTable.setShowGrid(true);
        TasksHistoryTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(TasksHistoryTable);

        javax.swing.GroupLayout TaskHistoryPanelLayout = new javax.swing.GroupLayout(TaskHistoryPanel);
        TaskHistoryPanel.setLayout(TaskHistoryPanelLayout);
        TaskHistoryPanelLayout.setHorizontalGroup(
            TaskHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TaskHistoryPanelLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        TaskHistoryPanelLayout.setVerticalGroup(
            TaskHistoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TaskHistoryPanelLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        ParentPanel.add(TaskHistoryPanel, "card5");

        CusReviewsPanel.setBackground(new java.awt.Color(255, 255, 255));

        ReviewsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ReviewsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order ID", "Customer", "Rating (Stars)", "Date"
            }
        ));
        ReviewsTable.setFocusable(false);
        ReviewsTable.setGridColor(new java.awt.Color(0, 0, 0));
        ReviewsTable.setSelectionBackground(new java.awt.Color(255, 153, 0));
        ReviewsTable.setSelectionForeground(new java.awt.Color(255, 255, 255));
        ReviewsTable.setShowGrid(true);
        ReviewsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(ReviewsTable);

        javax.swing.GroupLayout CusReviewsPanelLayout = new javax.swing.GroupLayout(CusReviewsPanel);
        CusReviewsPanel.setLayout(CusReviewsPanelLayout);
        CusReviewsPanelLayout.setHorizontalGroup(
            CusReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CusReviewsPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        CusReviewsPanelLayout.setVerticalGroup(
            CusReviewsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CusReviewsPanelLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        ParentPanel.add(CusReviewsPanel, "card6");

        RevenuePanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        RevenueLbl.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        RevenueLbl.setForeground(new java.awt.Color(255, 255, 255));
        RevenueLbl.setText("RM 0");

        RevenueLbl1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        RevenueLbl1.setForeground(new java.awt.Color(255, 255, 255));
        RevenueLbl1.setText("Revenue");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(RevenueLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RevenueLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RevenueLbl)
                    .addComponent(RevenueLbl1))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RevenuePanelLayout = new javax.swing.GroupLayout(RevenuePanel);
        RevenuePanel.setLayout(RevenuePanelLayout);
        RevenuePanelLayout.setHorizontalGroup(
            RevenuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RevenuePanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        RevenuePanelLayout.setVerticalGroup(
            RevenuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RevenuePanelLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        ParentPanel.add(RevenuePanel, "card7");

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

    private void TasksBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TasksBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(TasksPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(TasksBtn, hoverIcon1);
        refreshTasks();
    }//GEN-LAST:event_TasksBtnActionPerformed

    private void TaskStatusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaskStatusBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(TaskStatusPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(TaskStatusBtn, hoverIcon2);
        refreshTasksStatus();
    }//GEN-LAST:event_TaskStatusBtnActionPerformed

    private void TaskHisBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaskHisBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(TaskHistoryPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(TaskHisBtn, hoverIcon3);
        refreshTasksHistory();
    }//GEN-LAST:event_TaskHisBtnActionPerformed

    private void CusReviewsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CusReviewsBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(CusReviewsPanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(CusReviewsBtn, hoverIcon4);
        refreshReview();
    }//GEN-LAST:event_CusReviewsBtnActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        LoginPage lp = new LoginPage();
        this.dispose();
        lp.setVisible(true);
    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void RevenueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RevenueBtnActionPerformed
        ParentPanel.removeAll();
        ParentPanel.add(RevenuePanel);
        ParentPanel.repaint();
        ParentPanel.revalidate();
        
        resetToDefault();
        ButtonStyler.applyHoverStyle(RevenueBtn, hoverIcon5);
        displayRevenue();
    }//GEN-LAST:event_RevenueBtnActionPerformed

    private void AcctTaskBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AcctTaskBtnMouseClicked
        addTask("On the way", TasksTable);
    }//GEN-LAST:event_AcctTaskBtnMouseClicked

    private void DecTaskBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DecTaskBtnMouseClicked
        addTask("Declined", TasksTable);
    }//GEN-LAST:event_DecTaskBtnMouseClicked

    private void AcctTaskBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AcctTaskBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AcctTaskBtnActionPerformed

    private void DeliveredBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeliveredBtnMouseClicked
        updateStatus("Delivered", TasksStatusTable);
    }//GEN-LAST:event_DeliveredBtnMouseClicked

    private void DeliveredBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeliveredBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeliveredBtnActionPerformed

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
            java.util.logging.Logger.getLogger(DeliveryRunnerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeliveryRunnerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeliveryRunnerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeliveryRunnerPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeliveryRunnerPage(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcctTaskBtn;
    private javax.swing.JLabel BackgroundLbl;
    private javax.swing.JPanel BackgroundPanel;
    private javax.swing.JButton CusReviewsBtn;
    private javax.swing.JPanel CusReviewsPanel;
    private javax.swing.JButton DecTaskBtn;
    private javax.swing.JButton DeliveredBtn;
    private javax.swing.JLabel LogoLbl;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JLabel PageTypeLbl;
    private javax.swing.JPanel ParentPanel;
    private javax.swing.JButton RevenueBtn;
    private javax.swing.JLabel RevenueLbl;
    private javax.swing.JLabel RevenueLbl1;
    private javax.swing.JPanel RevenuePanel;
    private javax.swing.JTable ReviewsTable;
    private javax.swing.JPanel SeparatorPanel;
    private javax.swing.JPanel SidePanel;
    private javax.swing.JButton TaskHisBtn;
    private javax.swing.JPanel TaskHistoryPanel;
    private javax.swing.JButton TaskStatusBtn;
    private javax.swing.JPanel TaskStatusPanel;
    private javax.swing.JButton TasksBtn;
    private javax.swing.JTable TasksHistoryTable;
    private javax.swing.JPanel TasksPanel;
    private javax.swing.JTable TasksStatusTable;
    private javax.swing.JTable TasksTable;
    private javax.swing.JLabel WelcomeLbl;
    private javax.swing.JPanel WelcomePanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables
}
