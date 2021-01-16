/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.Serializable;

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

    public Item() {
    }

    public Item(int ItemID, int OwnerID, boolean Authorized, double Price, int StockID, String Category) {
        this.ItemID = ItemID;
        this.OwnerID = OwnerID;
        this.Authorized = Authorized;
        this.Price = Price;
        this.StockID = StockID;
        this.Category = Category;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int ItemID) {
        this.ItemID = ItemID;
    }

    public int getOwnerID() {
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
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getStockID() {
        return StockID;
    }

    public void setStockID(int StockID) {
        this.StockID = StockID;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }
    
    
}
