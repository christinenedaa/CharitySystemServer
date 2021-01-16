/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package charitysystem;

//import charitysystem.Sponsor;
package rmi;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author a_h_s
 */
public class Merch implements MerchInterface{
    private int MerchID;
    private String MerchName;
    private Sponsor Sponsor;
    private ArrayList<Item> Items = new ArrayList<>(); 
    int numofpurchase = 0;
     MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection Merch=charity.getCollection("Merch");

    public Merch(int MerchID, String MerchName, Sponsor Sponsor) {
        this.MerchID = MerchID;
        this.MerchName = MerchName;
        this.Sponsor = Sponsor;
    }

    public Merch() {
    }
    
    
    
    

    public int getMerchID() {
        return MerchID;
    }

    public void setMerchID(int MerchID) {
        this.MerchID = MerchID;
    }

    public String getMerchName() {
        return MerchName;
    }

    public void setMerchName(String MerchName) {
        this.MerchName = MerchName;
    }

    public Sponsor getSponsor() {
        return Sponsor;
    }

    public void setSponsor(Sponsor Sponsor) {
        this.Sponsor = Sponsor;
    }

    public ArrayList<Item> getItems() {
        return Items;
    }

    public void setItems(ArrayList<Item> Items) {
        this.Items = Items;
    }

    public int getNumofpurchase() {
        return numofpurchase;
    }

    public void setNumofpurchase(int numofpurchase) {
        this.numofpurchase = numofpurchase;
    }

     
    
    
    
    /***************************************end of setters and getters *************************************************/
   
    @Override
   public void PurchaseItem(int itemid , String buyerMail) throws RemoteException{
    
       Item temp = new Item();
       Buyer b = new Buyer();
      
      for (int i = 0; i < b.getAllbuyer().size();i++ ){
      if (buyerMail.equals(b.getAllbuyer().get(i).getEmail())){
          b = b.getAllbuyer().get(i);  
          
          
             for (int j=0;j<getItems().size();j++){//to check on list of items
         
     if (getItems().get(j).getItemID() == itemid)
     {
         temp = getItems().get(j);
         
         b.shoppingcart(itemid);
         this.Items.remove(j);
          numofpurchase++;
     }//end if item
     else System.out.println("invalid item number , or this item is not in the merch");
     }
           
      }//end if buyer
      else 
          System.out.println("incorrect buyer mail, please enter the correct mail");
      
      
      }//end buyer for loop
      
    
    }

    
  
    @Override
 public void HostMerch(String smail , String merchname , int Id) throws RemoteException
 {
     Sponsor s = new Sponsor();
     for ( int j =0; j<s.getAllsponsors().size();j++){
        if (smail == s.getAllsponsors().get(j).getEmail())
            s = s.getAllsponsors().get(j);
        }
 Merch temp = new Merch(Id ,merchname ,s);
     s.getMerch().add(temp);
 
 
 
 }   
 
  
   
}
