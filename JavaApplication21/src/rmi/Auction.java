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
import com.mongodb.client.model.Updates;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import rmi.Item;

/**
 *
 * @author DELL
 */
public class Auction extends UnicastRemoteObject implements AuctionInterface{
    private static int count=0;
    private int AuctionID;
    private Date Date;
    private String Duration;
    private Owner Seller;
    private ArrayList <Buyer> Bidder;
    private Buyer FinalBuyer;
    private double StartingPrice;
    private double FinalPrice;
    private boolean AuthoriezedItem;
    private double  CurrentBidPrice;
    private String AuctionState;
    private double VAT;
    private Item HostedItem;
    private Documentation doc;
    
     MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection auction=charity.getCollection("Auction");
    
    public Auction()  throws RemoteException {
         AuctionID=count++;
         
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        try {
            this.Date= simpleDateFormat.parse("0000-00-00");
        } catch (ParseException ex) {
            Logger.getLogger(Auction.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.Duration="Not specified";
        this.Seller=new Owner();
        this.FinalBuyer=new Buyer();
        this.FinalPrice=0.0;
        this.AuthoriezedItem=false;
        this.AuctionState="Off";
        this.CurrentBidPrice=0.0;
        this.VAT=0;
        this.HostedItem=new Item();
       

    Document d=new Document("AuctionID",AuctionID).append("Date", Date).append("Duration", Duration).append("Owner", "NOT SPECIFIED").append("Bidder", "NotSpecified").append("Seller", "NOT SPECIFIED").append("HostedItem", "Not specified").append("Documentation", "notspecified");
    auction.insertOne(d);
   
    }
    
    @Override
    public String UploadItem(int itemid, String ownermail, double startingprice,String auctionstate)  throws RemoteException{
        
    this.HostedItem.setItemID(itemid);
    
    this.Seller.setEmail(ownermail);
    this.StartingPrice=startingprice;
    this.AuctionState=auctionstate;

    
    
    
   
  Document d=new Document("Item",22).append("Starting Price", StartingPrice).append("Auctionstate", this.AuctionState);
    auction.insertOne(d);
    return "done";

    }
    
    
    @Override
    public double BidPrice(String buyermail, double price, int itemid)throws RemoteException{
    this.HostedItem.setItemID(itemid);
    for (Buyer bidder: this.Bidder){
        bidder.setEmail(buyermail);
    }
    if (price>this.CurrentBidPrice){
    this.CurrentBidPrice=price;
    
    
    }
   Document d=new Document("bidfor item",this.CurrentBidPrice);
   auction.insertOne(d);
        
    return CurrentBidPrice;
    }
  

 
    @Override
    public int getAuctionID() throws RemoteException {
        Document r=(Document) auction.find(Filters.all("AuctionID",this.AuctionID)).first();
        return AuctionID;
    }

    @Override
    public Date getDate() throws RemoteException{
         Document r=(Document) auction.find(Filters.all("AuctionID",this.Date)).first();
        return Date;
    }

    @Override
    public String getDuration() throws RemoteException {
         Document r=(Document) auction.find(Filters.all("AuctionID",this.Duration)).first();
        return Duration;
    }

    @Override
    public String getSeller() throws RemoteException{
         Document r=(Document) auction.find(Filters.all("AuctionID",this.Seller)).first();
        return Seller.getEmail();
    }

    @Override
    public String getBidder() throws RemoteException{
         String bider="";
        for(Buyer bidder: Bidder){
        bider=bidder.getEmail();}
        return bider;}

    @Override
    public String getFinalBuyer() throws RemoteException{
         Document r=(Document) auction.find(Filters.all("AuctionID",this.FinalBuyer)).first();
        return FinalBuyer.getEmail();
    }

    @Override
    public double getStartingPrice() throws RemoteException{
         Document r=(Document) auction.find(Filters.all("AuctionID",this.StartingPrice)).first();
        return StartingPrice;
    }

    @Override
    public double getFinalPrice()throws RemoteException {
         Document r=(Document) auction.find(Filters.all("AuctionID",this.FinalPrice)).first();
        return FinalPrice;
    }

    @Override
    public boolean isAuthoriezedItem()throws RemoteException {
        return AuthoriezedItem;
    }

    @Override
    public double getCurrentBidPrice()throws RemoteException {
         Document r=(Document) auction.find(Filters.all("AuctionID",this.CurrentBidPrice)).first();
        return CurrentBidPrice;
    }

    @Override
    public String getAuctionState()throws RemoteException {
         Document r=(Document) auction.find(Filters.all("AuctionID",this.AuctionState)).first();
        return AuctionState;
    }

    @Override
    public double getVAT()throws RemoteException {
         Document r=(Document) auction.find(Filters.all("AuctionID",this.VAT)).first();
        return VAT;
    }

    @Override
    public void setAuctionID(int AuctionID)throws RemoteException {
        this.AuctionID = AuctionID;
        Document d=new Document("AuctionID",AuctionID);
        auction.insertOne(d);
    }

    @Override
    public void setDate(Date Date)throws RemoteException {
        this.Date = Date;
        auction.updateOne(Filters.eq("AuctionID", AuctionID),Updates.set("Date", Date));
    }

    @Override
    public void setDuration(String Duration) throws RemoteException{
        this.Duration = Duration;
         auction.updateOne(Filters.eq("AuctionID", AuctionID),Updates.set("Duration", this.Duration));
    }

    @Override
    public void setSeller(String Sellermail) throws RemoteException{
        this.Seller.setEmail(Sellermail);
         auction.updateOne(Filters.eq("AuctionID", AuctionID),Updates.set("Seller", Seller));
    }

   
    public void setBidder(String biddermail) {
        for (Buyer bidder: this.Bidder){
        bidder.setEmail(biddermail);
    }
        auction.updateOne(Filters.eq("AuctionID", AuctionID),Updates.set("Bidder", Bidder));
    }

    @Override
    public void setFinalBuyer(String FinalBuyer) throws RemoteException{
        this.FinalBuyer.setEmail(FinalBuyer);
        auction.updateOne(Filters.eq("AuctionID", AuctionID),Updates.set("FinalBuyer", FinalBuyer));
    }

    @Override
    public void setStartingPrice(double StartingPrice)throws RemoteException {
        this.StartingPrice = StartingPrice;
       auction.updateOne(Filters.eq("AuctionID", AuctionID),Updates.set("StartingPrice", StartingPrice));
    }

    @Override
    public void setFinalPrice(double FinalPrice)throws RemoteException {
        this.FinalPrice = FinalPrice;
        auction.updateOne(Filters.eq("AuctionID", AuctionID),Updates.set("FinalPrice", FinalPrice));
    }

    @Override
    public void setAuthoriezedItem(boolean AuthoriezedItem)throws RemoteException {
        this.AuthoriezedItem = AuthoriezedItem;
     auction.updateOne(Filters.eq("AuctionID", AuctionID),Updates.set("AuthorizedItem", AuthoriezedItem));
    }

    @Override
    public void setCurrentBidPrice(double CurrentBidPrice) throws RemoteException{
        this.CurrentBidPrice = CurrentBidPrice;
             auction.updateOne(Filters.eq("AuctionID", AuctionID),Updates.set("CurrentBidPrice", CurrentBidPrice));

        
    }

    @Override
    public void setAuctionState(String AuctionState)throws RemoteException {
        this.AuctionState = AuctionState;
              auction.updateOne(Filters.eq("AuctionID", AuctionID),Updates.set("AuctionState", AuctionState));

        
    }

    @Override
    public void setVAT(double VAT)throws RemoteException {
        this.VAT = VAT;
             auction.updateOne(Filters.eq("AuctionID", AuctionID),Updates.set("VAT", VAT));

       
    }
@Override
    public int getHostedItem() {
        return HostedItem.getItemID();
    }

    public void setHostedItem(int itemid) {
        this.HostedItem.setItemID(itemid);
    }
       @Override
   public void creatdoc(int id,String d,String a)throws RemoteException {
     
        this.doc.setId(id);
        this.doc.setDescription(d);
        this.doc.setAuthority(a);
        
        
         Document don=new Document("DocumentationID",id);
        auction.insertOne(don);
        
    }




}
