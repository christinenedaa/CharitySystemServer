 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package charitysystem;

//import charitysystem.Event;
package rmi;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author a_h_s
 */
public class Sponsor extends User implements Observer{
   
    private ArrayList<Event> Events = new ArrayList<>(); 
    private ArrayList<Merch> Merch = new ArrayList<>(); //{merch1 {item 1 ,item2,item3 item4 } , merch2 , merch3}
    private double ProfitGain;
    private ArrayList<Observer> allObservers= new ArrayList<>();
    private ArrayList<Sponsor> allsponsors = new ArrayList<>();
     SponsorROI roi;
  MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection Sponsor=charity.getCollection("Sponsor");
   
    
    public Sponsor(){
    //allObservers = new ArrayList<>();
     this.allObservers = allObservers;
     allsponsors.add(this);
       this.roi = roi;
       allObservers.add(this);
    
    }

    

    public Sponsor(double ProfitGain, String Name, int Age, String Email, String Address) {
        super(Name, Age, Email, Address);
        this.ProfitGain = ProfitGain;
     //  this.allObservers = allObservers;
        allsponsors.add(this);
        allObservers.add(this);
          this.roi = roi;
    }
    
    /***************************************************************setters and getters***************************/

    public ArrayList<Sponsor> getAllsponsors() {
        return allsponsors;
    } 
    public void setAllsponsors(ArrayList<Sponsor> allsponsors) {
        this.allsponsors = allsponsors;
    }

    public ArrayList<Event> getEvents() {
        return Events;
    }

    public void setEvents(ArrayList<Event> Events) {
        this.Events = Events;
    }

    public ArrayList<Merch> getMerch() {
        return Merch;
    }

    public void setMerch(ArrayList<Merch> Merch) {
        this.Merch = Merch;
    }


    public double getProfitGain() {
        return ProfitGain;
    }

    public void setProfitGain(double ProfitGain) {
        this.ProfitGain = ProfitGain;
    }

   /* public ArrayList<Observer> getAllObservers() {
        return allObservers;
    }

    public void setAllObservers(ArrayList<Observer> allObservers) {
        this.allObservers = allObservers;
    }
    
    
    */
    
    /**************************************************end of setters and getters*****************************************/
  
   public double CalculateProfit(String mail)
           
    {
        Sponsor s = new Sponsor();
        
        for ( int j =0; j<getAllsponsors().size();j++){
        if (mail == getAllsponsors().get(j).getEmail())
            s = getAllsponsors().get(j);
        }
        
        double d = 0;
        
        for(int i = 0; i < getMerch().size(); i++)
         {
    d =+ getMerch().get(i).getItems().get(i).getPrice()* getMerch().get(i).getNumofpurchase();
           
          }
         
        s.setProfitGain(d);
        return s.getProfitGain();
    }
   
  
   
   
    @Override
    public void update(Object o ,boolean status) {
        System.out.println("top of update");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (o instanceof Sponsor)
        { 
        System.out.println("before true");
if (status == true)   
    System.out.println("ur request is confirmed");
if (status == false) 
    System.out.print("sorry , ur request is declined");
        }
    }
    
    
    public void ReserveEvent(String sponsMail,int eventid,String eventName,String eventDate,String location,int req ,boolean state)throws RemoteException{
    
    roi.ReserveEvent(sponsMail,eventid,eventName,eventDate,location,req,state);
    
    }
    
    
}
