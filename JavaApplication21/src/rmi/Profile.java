/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import java.rmi.RemoteException;
//import rmi.LoginGUI;
import rmi.LoginInterface;
import java.awt.event.ActionListener;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import javax.swing.text.Document;
import org.bson.Document;
/**
 *
 * @author a_h_s
 */
class Profile extends UnicastRemoteObject implements LoginInterface{
    private int ProfileID;
    private String Username;
    private String Password;
     // LoginGUI gui;
      MongoClient client = new MongoClient();
   MongoDatabase charity=client.getDatabase("CharityDB");
              MongoCollection profile=charity.getCollection("Profile");
    
    

    public Profile() throws RemoteException {
         this.ProfileID = ProfileID;
        this.Username = Username;
        this.Password = Password;
        
       // Document doc=new Document("Username",Username).append("Password", Password);
    //profile.insertOne(doc);
        
        
        
    }

    public int getProfileID()throws RemoteException  {
        Document d=(Document) profile.find(Filters.all("ProfileID",this.ProfileID)).first();
       
        return ProfileID;
    }

    public String getUsername() throws RemoteException {
          Document d=(Document) profile.find(Filters.all("Username",this.Username)).first();
        return Username;
    }

    public String getPassword()throws RemoteException  {
          Document d=(Document) profile.find(Filters.all("Password",this.Password)).first();
        return Password;
    }

    public void setProfileID(int ProfileID)throws RemoteException  {
        this.ProfileID = ProfileID;
        Document doc=new Document("ProfileID",ProfileID);
        profile.insertOne(doc);
    }

    public void setUsername(String Username)throws RemoteException  {
        this.Username = Username;
        Document doc=new Document("ProfileID",Username);
        profile.insertOne(doc);
    }

    public void setPassword(String Password)throws RemoteException  {
        this.Password = Password;
        Document doc=new Document("ProfileID",Password);
        profile.insertOne(doc);
    }
    
    
    
   @Override 
    public boolean Login(String Username, String Password )  throws RemoteException{
       MongoDatabase charity=client.getDatabase("CharityDB");
       MongoCollection admin=charity.getCollection("Admin");
       MongoCollection buyer=charity.getCollection("Buyer");
       MongoCollection owner=charity.getCollection("Owner");
       MongoCollection donor=charity.getCollection("Donor");
       MongoCollection sponsor=charity.getCollection("Sponsor");
//   Document d=new Document("Username","sh").append("Password", Password);
//    admin.insertOne(d);
       Document adu=(Document) admin.find(Filters.eq("Username",Username)).first();
       Document adp=(Document) admin.find(Filters.eq("Password",Password)).first();
        Document bu=(Document) buyer.find(Filters.eq("Username",Username)).first();
       Document bp=(Document) buyer.find(Filters.eq("Password",Password)).first();
        Document ou=(Document) owner.find(Filters.eq("Username",Username)).first();
       Document op=(Document) owner.find(Filters.eq("Password",Password)).first();
        Document du=(Document) donor.find(Filters.eq("Username",Username)).first();
       Document dp=(Document) donor.find(Filters.eq("Password",Password)).first();
        Document su=(Document) sponsor.find(Filters.eq("Username",Username)).first();
       Document sp=(Document) sponsor.find(Filters.eq("Password",Password)).first();
       

       if(adu!=null && adp!=null || bu!=null && bp!=null || ou!=null && op!=null || du!=null && dp!=null || su!=null &&sp!=null )
       return true;
       else 
           return false;
    
       
    
    }
   
   public void Sign(String Username, String Password)throws RemoteException{
    this.Username = Username;
    this.Password = Password;
    
   Document doc= new Document("Username",this.Username).append("Password", this.Password);;
   profile.insertOne(doc);
   System.out.println("Successful Registration, you can login now");
        
        
   
    }
                
                
                
            
        
    

    @Override
    public String getUsername(String e) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword(String p) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int isValid(int v) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*private static class LoginBtnAction implements ActionListener {

        public LoginBtnAction() {
        }
    }*/

//To change body of generated methods, choose Tools | Templates.
    }

    
    

    
    
    
    
    
    
    

    
    
    
    
    
    
    
    
    
   

    