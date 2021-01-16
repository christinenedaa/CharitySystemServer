package rmi;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Owner extends User {
    private int ItemID;
    private Auction Auction;
    private double TotalProfit;
   // private ArrayList <Item> owneditems; 
    private ArrayList <Documentation> Documentations;

    
    public Owner(){}
    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int ItemID) {
        this.ItemID = ItemID;
    }

    public Auction getAuction() {
        return Auction;
    }

    public void setAuction(Auction Auction) {
        this.Auction = Auction;
    }

    public double getTotalProfit() {
        return TotalProfit;
    }

    public void setTotalProfit(double TotalProfit) {
        this.TotalProfit = TotalProfit;
    }

    public ArrayList<Documentation> getDocumentations() {
        return Documentations;
    }

    public void setDocumentations(ArrayList<Documentation> Documentations) {
        this.Documentations = Documentations;
    }
    
    public double CalculateProfit(Auction auction){
    return 0.0;
    }
}
