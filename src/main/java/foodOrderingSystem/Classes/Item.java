
 
package foodOrderingSystem.Classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author ADEEL
 */
public class Item {
   
    private String itemId;
    private String vendor;
    private String itemPrice;
    private String itemName;
    private String itemType;
    
    public Item(String itemId, String vendor, String itemPrice,String itemName,String itemType) {
        this.itemId = itemId;
        this.vendor = vendor;
        this.itemPrice = itemPrice;
        this.itemName = itemName;
        this.itemType = itemType;
          
    }
    
    public Item(String itemPrice, String itemName, String itemType) {
        
        this.itemPrice = itemPrice;
        this.itemName = itemName;
        this.itemType = itemType;  
    }
    
    public Item() {
        
    }
    
    
    public String getItemId() {
        return itemId;
    }
    
    public String getVendor() {
        return vendor;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemType() {
        return itemType;
    }
    
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
    
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
 
    public void addItem() {
        
         try (BufferedWriter writer = new BufferedWriter(new FileWriter("Item.txt", true))) {
            writer.write(itemId + "--" + itemPrice + "--" + itemName + "--" + itemType);
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Item Added successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not Add Item." , "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    
    public void editItem(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Item.txt"));
            ArrayList<String> lines = new ArrayList<>();
            String line;
            
            while ((line = br.readLine()) != null) {
                lines.add(line);               
            }
            br.close();
            
            FileWriter fw = new FileWriter("Item.txt");
            for (int i = 0; i < lines.size(); i++) {
                String existingLine = lines.get(i);
                String[] data = existingLine.split("--");

                if (data[0].equals(itemId)) { 
                    fw.write(
                            itemId + "--"
                            + itemPrice + "--"
                            + itemName + "--"
                            + itemType
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
    
    
    
    public void delItem(){
        File inputFile = new File("Item.txt");
        StringBuilder updatedContent = new StringBuilder();
        boolean recordFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split("--");
                if (data.length > 0 && data[0].equals(itemId)) {
                    recordFound = true;
                    continue;
                }
                updatedContent.append(currentLine).append(System.lineSeparator());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while reading the file: " + e.getMessage());
            return;
        }

        if (!recordFound) {
            JOptionPane.showMessageDialog(null, "Record with ID " + itemId + " not found.","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write(updatedContent.toString());
            JOptionPane.showMessageDialog(null, "Record with ID " + itemId + " deleted successfully.","Info",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "An error occurred while writing to the file: " + e.getMessage());
        }
    }
    
    
    public List<String[]> ViewItems() {
        
        List<String[]> records = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("Item.txt"))) {
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
    
    
    
    
  


    
