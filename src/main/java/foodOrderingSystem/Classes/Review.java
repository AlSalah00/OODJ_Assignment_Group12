package foodOrderingSystem.Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mazen
 */
public class Review {
    
    private String orderID;
    private String customerName;
    private String vendor;
    private String deliveryRunner;
    private String date;
    private String massage;
    private String vendorRating;
    private String DeliveryRating;
    private String ReviewType;
    
    
    public Review(String orderID, String customerName, String vendor, String deliveryRunner, 
            String date, String massage, String vendorRating, String DeliveryRating, String ReviewType) {
        
        this.orderID = orderID;
        this.customerName = customerName;
        this.vendor = vendor;
        this.deliveryRunner = deliveryRunner;
        this.date = date;
        this.massage = massage;
        this.vendorRating = vendorRating;
        this.DeliveryRating = DeliveryRating;   
        this.ReviewType = ReviewType;
    }

    
    public Review(){
        
        
        
    }
    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    
     public String getDeliveryRunner() {
        return deliveryRunner;
    }

    public void setDeliveryRunner(String deliveryRunner) {
        this.deliveryRunner = deliveryRunner;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMassage() {
        return massage;
    }
    public String getReviewType() {
        return ReviewType;
    }
       public void setReviewType(String ReviewType) {
        this.ReviewType = ReviewType;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getVendorRating() {
        return vendorRating;
    }

    public void setVendorRating(String vendorRating) {
        this.vendorRating = vendorRating;
    }

    public String getDeliveryRating() {
        return DeliveryRating;
    }

    public void setDeliveryRating(String DeliveryRating) {
        this.DeliveryRating = DeliveryRating;
    }
 

    
    
    public void addReview() {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Review.txt", true))) {
            writer.write(orderID + "--" + customerName + "--" + vendor + "--" + deliveryRunner + "--" + date + "--" + massage + "--" + vendorRating + "--" + DeliveryRating + "--" + ReviewType );
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Review added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not add review." , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public List<String[]> displayReviews() {
        
        List<String[]> records = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("Review.txt"))) {
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

    public List<String[]> ViewReview() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

    
    
            
