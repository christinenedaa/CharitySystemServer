/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.sun.istack.internal.logging.Logger;
import java.io.Serializable;
import java.util.List;
import org.bson.Document;
/**
 *
 * @author DELL
 */
public class Documentation implements Serializable{
    private static int count=0;
    private int id;
    private Owner docOwner;
    private String Description;
    private String Authority;
     MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection doc=charity.getCollection("Documentation");

public Documentation(){
    this.id=count++;
    this.docOwner=new Owner();
    this.Description="";
    this.Authority="";
    
    Document d=new Document("ID",id).append("DocOwner", "Notspecified").append("Description", "Not Specified").append("Authority", this.Authority);
    doc.insertOne(d);
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    Document d=new Document("ID",id);
    doc.insertOne(d);
        
    }

    public Owner getDocOwner() {
        Document r=(Document) doc.find(Filters.all("DocOWner", this.docOwner)).first();
        return docOwner;
    }

    public void setDocOwner(Owner docOwner) {
        this.docOwner = docOwner;
        Document d=new Document("ID",id).append("Owner", this.docOwner.getEmail());
        doc.insertOne(d);
       
    }

    public String getDescription() {
          Document r=(Document) doc.find(Filters.all("Description", this.Description)).first();
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
        Document d=new Document("ID",id).append("Description", this.getDescription());
        doc.insertOne(d);
    }

    public String getAuthority() {
          Document r=(Document) doc.find(Filters.all("Authority", this.Authority)).first();
        return Authority;
    }

    public void setAuthority(String Authority) {
        this.Authority = Authority;
        
       Document d=new Document("ID",id).append("Authority", this.Authority);
        doc.insertOne(d);
    }
    
    public void UploadDocumentation(Owner owner,String description, String authority){
        this.docOwner=owner;
        this.Description=description;
        this.Authority=authority;
        
     Document d1=new Document("ID",id).append("Owner", "sm").append("Description",description).append("Authority",authority);
     MongoCollection doc=charity.getCollection("Documentation");
     doc.insertOne(d1);
    
    }
}
