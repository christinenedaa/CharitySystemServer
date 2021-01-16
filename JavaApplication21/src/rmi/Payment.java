/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author DELL
 */
public class Payment {
    private double Amount;
    private String PaymentStatus;
    private PaymentBehaviour PaymentBehaviour;
    
     MongoClient client = new MongoClient();
    MongoDatabase charity=client.getDatabase("CharityDB");
    MongoCollection Payment=charity.getCollection("Payment");

    public Payment() {
    }

    public Payment(double Amount, String PaymentStatus) {
        this.Amount = Amount;
        this.PaymentStatus = PaymentStatus;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(String PaymentStatus) {
        this.PaymentStatus = PaymentStatus;
    }
    
    void paymentMethod(){
        
    }
}
