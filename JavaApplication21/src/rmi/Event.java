
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import org.bson.Document;

/**
 *
 * @author a_h_s
 */
public class Event implements SponsorROI ,VolunteerROI , Subject, EventInterface{
    
    private int EventID;
    private String EventName;
    private String EventDate;
    private String EventLocation;
    private int RequrimentNum;
    //Volunteer Volunteers[];
    private ArrayList<Volunteer> Volunteers = new ArrayList<>(); 
    private boolean EventStatus;
    private ArrayList<Sponsor> Sponsors = new ArrayList<>(); 
    ArrayList<Observer> allObservers;
    ArrayList<Event>reservedevents;
    ArrayList<Event>allevents;
    
     MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection Event=charity.getCollection("Event");

    public Event() {
        this.EventID = EventID;
        this.EventName = EventName;
        this.EventDate = EventDate;
        this.EventLocation = EventLocation;
        this.RequrimentNum = RequrimentNum;
        this.EventStatus = EventStatus;
        this.allObservers = allObservers;
       allObservers = new ArrayList<>();
        reservedevents = new ArrayList<>();
        allevents = new ArrayList<>();
        
//        Document d=new Document("EventID",this.EventID).append("EventName", this.EventName).append("EventDate", this.EventDate)
//                .append("EventLocation", this.EventLocation).append("RequrimentNum", this.RequrimentNum)
//                .append("EventStatus", this.EventStatus).append("AllObservers", this.allObservers)
//                .append("reservedevents", this.reservedevents).append(" allevents", this. allevents).
//                append("Sponsors", this.Sponsors).append("Volunteers", this.Volunteers);
//        Event.insertOne(d);
       //Document a= new Document("allobservers",this.allObservers);
      // Event.insertMany(a);
        
    }

    public Event(int EventID, String EventName, String EventDate, String EventLocation, int RequrimentNum, boolean EventStatus) {
        this.EventID = EventID;
        this.EventName = EventName;
        this.EventDate = EventDate;
        this.EventLocation = EventLocation;
        this.RequrimentNum = RequrimentNum;
        this.EventStatus = EventStatus;
       allObservers = new ArrayList<>();
        reservedevents = new ArrayList<>();
        allevents = new ArrayList<>();
        this.allObservers = allObservers;
        
//        Document d=new Document("EventID",this.EventID).append("EventName", this.EventName).append("EventDate", this.EventDate)
//                .append("EventLocation", this.EventLocation).append("RequrimentNum", this.RequrimentNum)
//                .append("EventStatus", this.EventStatus).append("AllObservers", this.allObservers)
//                .append("reservedevents", this.reservedevents).append(" allevents", this. allevents).
//                append("Sponsors", this.Sponsors).append("Volunteers", this.Volunteers);
//        Event.insertOne(d);
       //Document a= new Document("allobservers",this.allObservers);
      // Event.insertMany(a);
        
    }

    public int getEventID() {
        return EventID;
    }

    public void setEventID(int EventID) throws RemoteException {
        this.EventID = EventID;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String EventName) {
        this.EventName = EventName;
    }

    public String getEventDate() {
        return EventDate;
    }

    public void setEventDate(String EventDate) {
        this.EventDate = EventDate;
    }

    public String getEventLocation() {
        return EventLocation;
    }

    public void setEventLocation(String EventLocation) {
        this.EventLocation = EventLocation;
    }

    public int getRequrimentNum() {
        return RequrimentNum;
    }

    public void setRequrimentNum(int RequrimentNum) {
        this.RequrimentNum = RequrimentNum;
    }

    public ArrayList<Volunteer> getVolunteers() {
        return Volunteers;
    }

    public void setVolunteers(ArrayList<Volunteer> Volunteers) {
        this.Volunteers = Volunteers;
    }

    public boolean isEventStatus() {
        return EventStatus;
    }

    public void setEventStatus(boolean EventStatus) {
        this.EventStatus = EventStatus;
    }

    public ArrayList<Sponsor> getSponsors() {
        return Sponsors;
    }

    public void setSponsors(ArrayList<Sponsor> Sponsors) {
        this.Sponsors = Sponsors;
    }
    
    
 /*********************************************************end of setters and getters ***********************************************/   
    
    
    

 
  
  public void ConfirmEventReservation(Sponsor s, int eventid  ,boolean state){
      
      System.out.println("awel satr fi el confirm");
      Event e = new Event();
      
      for ( int j =0; j<allevents.size();j++){
        if (eventid == allevents.get(j).getEventID())
            e= allevents.get(j);
        }
       System.out.println("mn abl el if"); 
      
  if (state == true)
  {
      System.out.println("mn gowa el while ahoo");
  reservedevents.add(e);
  e.Sponsors.add(s);
  e.setEventStatus(state);
  System.out.println("hal byd5ol fi el notify???");
  e.Notify(s, state);
   System.out.println(" notify???");
  
  
  
  }
  if (state == false){
      e.Notify(s, state);
      e.setEventStatus(state);
      e = null;//deleting the object
      
  
  }
  
   
  
  
  }
  
 public void confirmVolunteerRequest(boolean state ){ // deh ely hanktb feha notify()
 
 
 }
 
 public void Notify( Object obj  , boolean status){
     
     //call update ely fi el sponsors wel volunteer
     System.out.println(" feen list of ");
     for(int i =0; i<allObservers.size();i++){
         System.out.println("haaaaaaa??");
     allObservers.get(i).update(obj, status);
     
     
     
     }
 
 
 }

  

   
    //@Override
   public void RequestVolunteering(int reqnum ,Volunteer v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AddObserver(Observer o) {
       // throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
         allObservers.add(o);
    }

    @Override
    public void DeleteObserver(Observer o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        allObservers.remove(o);
    }

    /*@Override
    public void ReserveEvent(Sponsor s, String date, String location, int Req) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         String Spname = s.getName();
         String mail=  s.getEmail();
         String d = date;
         String loc = location;
         int requirments = Req;
         
         
    }*/
    
    @Override
    public  void ReserveEvent(String sponsMail,int eventid,String eventName,String eventDate,String location,int req ,boolean state) throws RemoteException{
    
     Sponsor s = new Sponsor();
        
        for ( int j =0; j<s.getAllsponsors().size();j++){
        if (sponsMail == s.getAllsponsors().get(j).getEmail())
            s = s.getAllsponsors().get(j);
        }
        Event NewEvent = new Event(eventid,eventName, eventDate, location, req, state);
        Document d=new Document("EventID",eventid).append("EventName", eventName).append("EventDate", eventDate)
                .append("EventLocation", location).append("RequrimentNum", req)
                .append("EventStatus", state);
        Event.insertOne(d);
        
     if (reservedevents.size() < 5){
      Admin admin = Admin.getAdminobj();
      
     boolean a= admin.ApproveEvent( sponsMail ,eventName,eventid);
      
      // ConfirmEventReservation(s, eventid,confirmStatus);
     
     } 
        
        
        
        
       
      
    }
    
    

    
   

    
    
    
}
