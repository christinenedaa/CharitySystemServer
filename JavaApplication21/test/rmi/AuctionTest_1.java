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
import java.util.Date;
import org.bson.Document;
/*
//import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class AuctionTest_1 {
     MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection auction=charity.getCollection("Auction");
    MongoCollection doc=charity.getCollection("Documentation");
    public AuctionTest_1() {
    }
    
    //@BeforeClass
    public static void setUpClass() {
    }
    
    //@AfterClass
    public static void tearDownClass() {
    }
    
    //@Before
    public void setUp() {
    }
    
   // @After
    public void tearDown() {
    }

    /**
     * Test of UploadItem method, of class Auction.
     */

   // @Test
    public void testSetAuctionID() throws Exception {
        System.out.println("setAuctionID");
        int AuctionID = 0;
        Auction instance = new Auction();
        instance.setAuctionID(AuctionID);
        Document ar=(Document) auction.find(Filters.all("AuctionID", AuctionID)).first();
        Document dd=(Document) doc.find(Filters.all("ID", AuctionID)).first();
     //   assertEquals(ar,dd);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    
}
