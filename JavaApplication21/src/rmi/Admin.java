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
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import org.bson.Document;
import rmi.Documentation;
import rmi.Event;
import rmi.User;

/**
 *
 * @author DELL
 */
public class Admin extends User{
    private String Position;
    private ArrayList <Documentation> Documentations;
    private ArrayList <Event> Reservations;
     boolean status;
    
    MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection Admin=charity.getCollection("Admin");
    
    
    
    private static Admin AdminObj;
    
    private Admin(){
        this.Position="";
        this.Documentations.add(new Documentation());
        this.Reservations.add(new Event());
        
        Document d=new Document("Position",this.Position).append("Documentation", this.Documentations).append("Reservations", this.Reservations);
        Admin.insertOne(d);
    
    }
    
    
    public static Admin getAdminobj (){
    if(AdminObj==null){
    AdminObj=new Admin();
    }
    
    return AdminObj;
    }
    
    public void AuthinticateDocumentation (Documentation doc){
        Documentations.add(doc);
        
    }

    public String getPosition() {
        String mail=getEmail();
           Document r=(Document) Admin.find(Filters.all(mail,this.Position)).first();
        
        
        return Position;
        
     
    }

    public ArrayList<Documentation> getDocumentations() {
        return Documentations;
    }

    public void setPosition(String Position) {
        this.Position = Position;
        Document d=new Document("Position",this.Position);
        Admin.insertOne(d);
    
        
    }

    public void setDocumentations(ArrayList<Documentation> Documentations) {
        this.Documentations = Documentations;
        Document d=new Document("Documentation", this.Documentations);
        Admin.insertOne(d);
    
    }
    
    public boolean ApproveEvent( String Name , String Eventname, int eventid) throws RemoteException
    {
    System.out.println("do you wish to  accept the reservation for Sponosr :"+ Name+"for Event :"+Eventname+eventid);
    Scanner input = new Scanner(System.in);  
            status = input.nextBoolean();
           
            Sponsor s = new Sponsor();
        
        for ( int j =0; j<s.getAllsponsors().size();j++){
        if (Name == s.getAllsponsors().get(j).getEmail())
            s = s.getAllsponsors().get(j);
        }
        Event e = new Event();
      
      for ( int j =0; j<e.allevents.size();j++){
        if (eventid== e.allevents.get(j).getEventID())
            e= e.allevents.get(j);
        }
        System.out.println("test mn a5er satr fi el main");
        e.ConfirmEventReservation(s, eventid,status);
           //return status;
    return status;
    
    }
}
