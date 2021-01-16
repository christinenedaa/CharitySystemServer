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
import java.io.Serializable;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author DELL
 */
public class Item  implements Serializable{
    public int ItemID;
    public int OwnerID;
    public boolean Authorized;
    public Documentation Document;
    public double Price;
    public int StockID;
    public String Category;
    public ArrayList<Item> Items= new ArrayList<>();
    
     MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection Item=charity.getCollection("Item");

    public Item() {
        this.ItemID = ItemID;
        this.OwnerID = OwnerID;
        this.Authorized = Authorized;
        this.Price = Price;
        this.StockID = StockID;
        this.Category = Category;
        Document d=new Document("ItemID",ItemID).append("OwnerID", OwnerID).append("Authorized", Authorized).append("Price", Price).append("StockID", StockID).append("Seller", "NOT SPECIFIED").append("HostedItem", "Not specified").append("Documentation", "notspecified");
    Item.insertOne(d);
    }

    public Item(int ItemID, int OwnerID, boolean Authorized, double Price, int StockID, String Category) {
        this.ItemID = ItemID;
        this.OwnerID = OwnerID;
        this.Authorized = Authorized;
        this.Price = Price;
        this.StockID = StockID;
        this.Category = Category;
    }
    

    public Documentation getDocument() {
        return Document;
    }

    public void setDocument(Documentation Document) {
        this.Document = Document;
    }

    public ArrayList<Item> getItems() {
        return Items;
    }

    public void setItems(ArrayList<Item> Items) {
        this.Items = Items;
    }

    public int getItemID() {
        Document r=(Document) Item.find(Filters.all("ItemID",this.ItemID)).first();
        return ItemID;
    }

    public void setItemID(int ItemID) {
        this.ItemID = ItemID;
    }

    public int getOwnerID() {
        Document r=(Document) Item.find(Filters.all("OwnerID",this.OwnerID)).first();
        return OwnerID;
    }

    public void setOwnerID(int OwnerID) {
        this.OwnerID = OwnerID;
    }

    public boolean isAuthorized() {
        return Authorized;
    }

    public void setAuthorized(boolean Authorized) {
        this.Authorized = Authorized;
    }

    public double getPrice() {
        Document r=(Document) Item.find(Filters.all("Price",this.Price)).first();
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getStockID() {
        Document r=(Document) Item.find(Filters.all("StockID",this.StockID)).first();
        return StockID;
    }

    public void setStockID(int StockID) {
        this.StockID = StockID;
    }

    public String getCategory() {
        Document r=(Document) Item.find(Filters.all("Category",this.Category)).first();
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }
    
    
}
