/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class Buyer extends User{
    private int ItemID;
    private int AuctionID;
    private double totalamount;
    
    MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection Buyer=charity.getCollection("Buyer");

    
    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int ItemID) {
        this.ItemID = ItemID;
    }

    public int getAuctionID() {
        return AuctionID;
    }

    public void setAuctionID(int AuctionID) {
        this.AuctionID = AuctionID;
    }
    
    public void BrowseCategory(String cat){
    
    }
    
    public double shoppingcart(int itemid){ return 0.0;}
    
}
