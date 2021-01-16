/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author DELL
 */
public class Donor extends User implements DonorInterface {
    private ArrayList<String> PreviousDonations = new ArrayList<>(); 
    private double DonatedAmount;
    public String Type;
    public int Quantity;
    
     MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection Donor=charity.getCollection("Donor");

    public Donor(double DonatedAmount, String Type, int Quantity, String Name, int Age, String Email, String Address) throws RemoteException {
        super(Name, Age, Email, Address);
        this.DonatedAmount = DonatedAmount;
        this.Type = Type;
        this.Quantity = Quantity;
        Document d=new Document("DonatedAmount",this.DonatedAmount).append("Type", this.Type).append("Quantity", this.Quantity).append("Name", Name).append("Age", Age).append("Email", Email).append("Address", Address);
        Donor.insertOne(d);
    }

    public Donor() throws RemoteException {
        this.DonatedAmount = DonatedAmount;
        this.Type = Type;
        this.Quantity = Quantity;
        Document d=new Document("DonatedAmount",this.DonatedAmount).append("Type", this.Type).append("Quantity", this.Quantity);
        Donor.insertOne(d);
    }

    
    
    
    @Override
    public void setPreviousDonations(ArrayList<String> PreviousDonations) throws RemoteException {
        this.PreviousDonations = PreviousDonations;
        Document d=new Document("PreviousDonations",this.PreviousDonations);
        Donor.insertMany((List) d);
    }

    @Override
    public void setDonatedAmount(double DonatedAmount) throws RemoteException{
        this.DonatedAmount = DonatedAmount;
        Document d=new Document("DonatedAmount",this.DonatedAmount);
        Donor.insertOne(d);
    }

    @Override
    public void setType(String Type) throws RemoteException {
        this.Type = Type;
        Document d=new Document("Type",this.Type);
        Donor.insertOne(d);
    }

    @Override
    public void setQuantity(int Quantity) throws RemoteException{
        this.Quantity = Quantity;
        Document d=new Document("Quantity",this.Quantity);
        Donor.insertOne(d);
    }

    @Override
    public ArrayList<String> getPreviousDonations() throws RemoteException{
        ArrayList<String> result = new ArrayList();
//        ArrayList<Document> docs = Donor.find(Filters.eq("PreviousDonations", year)).into(new ArrayList<Document>());
//        for (int i = 0; i < docs.size(); i++) {
//            result.add(gson.fromJson(docs.get(i).toJson(), Donor.class));
//        }
       return result;
    }
    
    @Override
    public double getDonatedAmount() throws RemoteException{
        String mail=getEmail();
        Document r=(Document) Donor.find(Filters.all(mail,this.DonatedAmount)).first();
        return DonatedAmount;
    }
    @Override
    public String getType() throws RemoteException{
        String mail=getEmail();
        Document r=(Document) Donor.find(Filters.all(mail,this.Type)).first();
        return Type;
    }
    @Override
    public int getQuantity() throws RemoteException{
        String mail=getEmail();
        Document r=(Document) Donor.find(Filters.all(mail,this.Quantity)).first();
        return Quantity;
    }
    @Override
    public void PayDonation(PaymentBehaviour paymethod)throws RemoteException{
        paymethod.paymentMethod(DonatedAmount);
    }
    @Override
    public void DonateItem(int itemID, String category)throws RemoteException{
        Item i = new Item();
        for (int x = 0; x<i.getItems().size(); x++){
            if(itemID == i.getItems().get(x).getItemID()){
                i.getItems().remove(x);
                
            }
        }
        System.out.println("donate successfull");
    }
    
}
