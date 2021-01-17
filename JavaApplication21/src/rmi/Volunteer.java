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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//import java.util.logging.Logger;
import org.bson.Document;
/**
 *
 * @author a_h_s
 */
public class Volunteer  extends User implements Observer , Vinterface {
    
    private String Skill;
    private String EducationLevel;
    //private String Interests[];
    private String Interests ; 

    private String PerviousVolunteering;
    Event e = new Event();
    MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection volunteer=charity.getCollection("Volunteer");
     MongoCollection Rvolunteer=charity.getCollection("Requestvolunteer");
    
    
    

    public Volunteer(String Skill, String EducationLevel, String PerviousVolunteering, String Name, int Age, String Email, String Address) {
        super(Name, Age, Email, Address);
        this.Skill = Skill;
        this.EducationLevel = EducationLevel;
        this.PerviousVolunteering = PerviousVolunteering;
        
         Document d=new Document("VName",Name).append("Vemail", Email).append("Vaddress", Address).append("Vskill", Skill).append("VEducation", EducationLevel).append("Vexperience",PerviousVolunteering);
    volunteer.insertOne(d);
   Document dv=new Document("VName",Name).append("Vemail", Email).append("Vskill",this.Skill).append("Vexperience",PerviousVolunteering).append("event",PerviousVolunteering);//attrbuite eventid mn al event
   Rvolunteer.insertOne(dv);
   
    }

    public Volunteer(String Skill, String EducationLevel, String PerviousVolunteering) {
        this.Skill = Skill;
        this.EducationLevel = EducationLevel;
        this.PerviousVolunteering = PerviousVolunteering;
    }

    public Volunteer() {
    }
    
    

    
    
    public void Updatedata( String name, String Email, String skills, String level,String interest, String experience ){
         MongoDatabase charity=client.getDatabase("CharityDB");
       MongoCollection volunteer=charity.getCollection("Volunteer");
    this.setName(name);
    this.setEmail(Email);
 this.Skill = Skill;
 this.Interests= Interests;
        this.EducationLevel = EducationLevel;
        this.PerviousVolunteering = PerviousVolunteering;
         Document v=(Document) volunteer.find(Filters.eq("Vemail",Email)).first();
        
    }
    
    
    
    public void SendRequest(){
        //String Name, String Email, String Skill, boolean pv, int Eid
     Document d=new Document("VName",this.getName()).append("Vemail", this.getEmail()).append("Vskill",this.Skill).append("Vexperience",PerviousVolunteering).append("event",PerviousVolunteering);//attrbuite eventid mn al event
    Rvolunteer.insertOne(d);
    System.out.println("your request is sent");
    }
    
    
    @Override
    public void update(Object o, boolean status) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          // System.out.println("top of update");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (o instanceof Volunteer)
        { 
        System.out.println("processing...");
if (status == true)   
    System.out.println("ur request is to volunteer is accepted");
else 
    System.out.print("sorry , ur request for volunteering is declined");
        }
    }
    
    
    
}
