/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.ParseException;
import java.util.Date;
/**
 *
 * @author DELL
 */
public class Auctionserver  {
        public static void main(String[] args) throws ParseException, RemoteException {
        try {
            // My remote object [Skeleton]
            AuctionInterface AI = new Auction();
            
            // My RMI Registry
            Registry registry = LocateRegistry.createRegistry(1099);
            /*
            MongoClient client = new MongoClient();

            MongoDatabase charity=client.getDatabase("CharityDB");
            
            charity.createCollection("Donor");
            charity.createCollection("Event");
charity.createCollection("Item");
charity.createCollection("Merch");
charity.createCollection("Payment");
charity.createCollection("Sponsor");
charity.createCollection("Stockk");
charity.createCollection("Volunteer");
charity.createCollection("User");

            */
            
            //Add my object to the RMI Registry
            registry.bind("Auction", AI);
            System.out.println("Auction server side is running...");  
            
            /*
            Admin ad = Admin.getAdminobj();
       Sponsor s = new Sponsor(0,"Alaa",21,"alaa@alaa","share3 alaa");
       Event t = new Event();
       t.AddObserver(s);
       
      t.ReserveEvent("alaa@alaa", 101,"my Event Name", "1-2-2021", "fi baty", 5, true);
      t.Notify(s,ad.status );*/
            
            
        } catch (Exception ex) {
           System.out.println(ex);
        }   


    }

}
