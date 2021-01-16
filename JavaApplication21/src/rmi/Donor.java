/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Donor extends User {
    private ArrayList<String> PreviousDonations = new ArrayList<>(); 
    private double DonatedAmount;
    public String Type;
    public int Quantity;
    
     MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection Donor=charity.getCollection("Donor");

    public Donor(double DonatedAmount, String Type, int Quantity) {
        this.DonatedAmount = DonatedAmount;
        this.Type = Type;
        this.Quantity = Quantity;
    }

    public void setPreviousDonations(ArrayList<String> PreviousDonations) {
        this.PreviousDonations = PreviousDonations;
    }

    public void setDonatedAmount(double DonatedAmount) {
        this.DonatedAmount = DonatedAmount;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public ArrayList<String> getPreviousDonations() {
        return PreviousDonations;
    }

    public double getDonatedAmount() {
        return DonatedAmount;
    }

    public String getType() {
        return Type;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void PayDonation(PaymentBehaviour paymethod){
        paymethod.paymentMethod(DonatedAmount);
    }
    
    public void DonateItem(int itemID, String category){
        Item i = new Item();
        for (int x = 0; x<i.getItems().size(); x++){
            if(itemID == i.getItems().get(x).getItemID()){
                i.getItems().remove(x);
            }
        }
        System.out.println("donate successfull");
    }
    
}
