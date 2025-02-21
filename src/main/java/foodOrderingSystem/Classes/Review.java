package foodOrderingSystem.Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author mazen
 */
public class Review {
    
    private String orderID;
    private String customerName;
    private String vendor;
    private String date;
    private String massage;
    private String vendorRating;
    private String DeliveryRating;
    
    
    public Review(String orderID, String customerName, String vendor, String date, String massage, String vendorRating, String DeliveryRating) {
        
        this.orderID = orderID;
        this.customerName = customerName;
        this.vendor = vendor;
        this.date = date;
        this.massage = massage;
        this.vendorRating = vendorRating;
        this.DeliveryRating = DeliveryRating;        
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMassage() {
        return massage;
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
            writer.write(orderID + "--" + customerName + "--" + vendor + "--" + date + "--" + massage + "--" + vendorRating + "--" + DeliveryRating );
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Review added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not add review." , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    
    
            
