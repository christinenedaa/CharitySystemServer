/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
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
            
            //Add my object to the RMI Registry
            registry.bind("Auction", AI);
            System.out.println("Auction server side is running...");   
        } catch (Exception ex) {
           System.out.println(ex);
        }   


    }

}
