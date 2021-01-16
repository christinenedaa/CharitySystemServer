/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;

/**
 *
 * @author a_h_s
 */
public class Volunteer  extends User implements Observer{
    
    private String Skill;
    private String EducationLevel;
    //private String Interests[];
    private ArrayList<String> Interests = new ArrayList<>(); 

    private boolean PerviousVolunteering;
    
     MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection Volunteer =charity.getCollection("Volunteer");
    
    public String UploadCertificate(String n){
    
    
    return n;
    }

    public Volunteer(String Skill, String EducationLevel, boolean PerviousVolunteering, String Name, int Age, String Email, String Address) {
        super(Name, Age, Email, Address);
        this.Skill = Skill;
        this.EducationLevel = EducationLevel;
        this.PerviousVolunteering = PerviousVolunteering;
    }

    public Volunteer(String Skill, String EducationLevel, boolean PerviousVolunteering) {
        this.Skill = Skill;
        this.EducationLevel = EducationLevel;
        this.PerviousVolunteering = PerviousVolunteering;
    }

    public Volunteer() {
    }
    
    

    
    
    
    
    
    @Override
    public void update(Object o, boolean status) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          // System.out.println("top of update");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (o instanceof Volunteer)
        { 
        System.out.println("before true");
if (status == true)   
    System.out.println("ur request is to volunteer is accepted");
else 
    System.out.print("sorry , ur request for volunteering is declined");
        }
    }
    
    
    
}
