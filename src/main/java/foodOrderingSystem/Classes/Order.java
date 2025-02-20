
package foodOrderingSystem.Classes;

import static foodOrderingSystem.Classes.User.usernameExists;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Order {
    
    
    private String OrderId;
    private String CustomerName;
    private String Vendor;
    private String Date;
    private String total;
    private String Status;
    
    
    private String ItemName;
    private String Quantity;
    
    
    public Order(String OrderId,String CustomerName, String Vendor,String Date, String total, String Status,String ItemName, String Quantity){
    
        this.OrderId = OrderId;
        this.CustomerName = CustomerName;
        this.Vendor = Vendor;
        this.Date = Date;
        this.total = total;
        this.Status = Status;
        this.ItemName = ItemName;
        this.Quantity = Quantity;
                
    
    }
    
     public Order() {
         
     }
    
    public Order(String OrderId, String Status) {
        this.OrderId = OrderId;
        this.Status = Status;
    }
    
    public String getOrderId() {
        return OrderId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getVendor() {
        return Vendor;
    }

    public String getDate() {
        return Date;
    }

    public String getTotal() {
        return total;
    }

    public String getStatus() {
        return Status;
    }
    
    public String getItemName() {
        return ItemName;
    }
    
    public String getQuantity() {
        return Quantity;
    }
    
    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public void setVendor(String Vendor) {
        this.Vendor = Vendor;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
      public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }
    
        public void setQuantity(String Quantity) {
        this.Quantity = Quantity;
    }
    
    public void addOrder() {
 
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("Order.txt", true))) {
            writer.write(OrderId + "--" + CustomerName + "--" + Vendor + "--" + Date + "--" + total + "--" + Status);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Order placed successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not place order." , "Error", JOptionPane.ERROR_MESSAGE);
        }
         
       
            
            
            
    }           
     public void updateOrderStatus() {
     
         
          try {
            BufferedReader br = new BufferedReader(new FileReader("User.txt"));
            ArrayList<String> lines = new ArrayList<>();
            String line;
            
            while ((line = br.readLine()) != null) {
                lines.add(line);               
            }
            br.close();
            
            FileWriter fw = new FileWriter("Order.txt");
            for (int i = 0; i < lines.size(); i++) {
                String existingLine = lines.get(i);
                String[] data = existingLine.split("--");

                if (data[0].equals(OrderId)) { 
                    fw.write(
                            OrderId + "--"
                            + CustomerName + "--"
                            + Vendor + "--"
                            + Date + "--"
                            + total + "--"
                            + Status + "--"
                            + ItemName + "--"
                            + Quantity + "--"
                            
                    );
                } else {
                    fw.write(existingLine + "\n");
                }
            }
            fw.close();
            
            JOptionPane.showMessageDialog(null, "Record updated successfully.","Info",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
     }
    
    public List<String[]> ViewOrders() {
        
        List<String[]> records = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("Order.txt"))) {
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split("--");
                records.add(data);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the file: " + e.getMessage());
        }

        return records;
    }
            
           
    
}
