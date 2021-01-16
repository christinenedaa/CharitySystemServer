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
public class CashOnDeliveryPayer implements PaymentBehaviour {
    private String Name;
    private String Email;

    public CashOnDeliveryPayer(String Name, String Email) {
        this.Name = Name;
        this.Email = Email;
    }
    
    @Override
    public void paymentMethod(double Amount){
        System.out.println(Amount +" will be paid on delivery");
    }
}
