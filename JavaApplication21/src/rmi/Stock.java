/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package charitysystem;
package rmi;

//import charitysystem.Item;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


/**
 *
 * @author a_h_s
 */
public class Stock {
   private  String StockLocation;
    private int Stock;
   private Item items[]; 
    MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection Stockk=charity.getCollection("Stock");
    
    
}
