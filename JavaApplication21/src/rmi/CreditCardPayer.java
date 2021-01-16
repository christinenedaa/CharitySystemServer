/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author DELL
 */
public class CreditCardPayer implements PaymentBehaviour{
    private String PayerName;
    private String cardNumber;
    private String cvv;
    

    public CreditCardPayer(String PayerName, String cardNumber, String cvv) {
        this.PayerName = PayerName;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        
    }
    
    @Override
    public void paymentMethod(double Amount){
        System.out.println(Amount +" paid with credit/debit card");
    }
}
