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
            DonorInterface DI = new Donor();
            EventInterface EI = new Event();
            MerchInterface MI = new Merch();
            LoginInterface LG= new Profile();
            Vinterface VI=  new Volunteer();
            // My RMI Registry
            Registry registry = LocateRegistry.createRegistry(1099);
            
            
            
//            MongoClient client = new MongoClient();
//
//            MongoDatabase charity=client.getDatabase("CharityDB");
//            
//            charity.createCollection("Donor");
//            charity.createCollection("Event");
//charity.createCollection("Item");
//charity.createCollection("Merch");
//charity.createCollection("Payment");
//charity.createCollection("Sponsor");
//charity.createCollection("Stockk");
//charity.createCollection("Volunteer");
////charity.createCollection("User");

            
            
            //Add my object to the RMI Registry
            registry.bind("Auction", AI);
            registry.bind("Donor", DI);
            registry.bind("Event", EI);
            registry.bind("Merch", MI);
            registry.bind("Profile", LG);
            registry.bind("Volunteer", VI);
            System.out.println("project server side is running..."); 
            
            
            /*
            Admin ad = Admin.getAdminobj();
       Sponsor s = new Sponsor(0,"Alaa",21,"alaa@alaa","share3 alaa");
       Event t = new Event();
       t.AddObserver(s);
       
      t.ReserveEvent("alaa@alaa", 101,"my Event Name", "1-2-2021", "fi baty", 5, true);
      t.Notify(s,ad.status );*/
             //Admin ad = Admin.getAdminobj();
            // Sponsor s = new Sponsor(0,"Alaa",21,"alaa@alaa","share3 alaa");
             Merch m = new Merch();
             m.HostMerch("alaa@alaa", "alaa", 3);
            
        } catch (Exception ex) {
           System.out.println(ex);
        }   


    }

}
