/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

/**
 *
 * @author a_h_s
 */
class User {
    private String Name;
    private int Age;
    private String Email;
    private String Address;

    public User(String Name, int Age, String Email, String Address) {
        this.Name = Name;
        this.Age = Age;
        this.Email = Email;
        this.Address = Address;
    }

    public User() {
       this.Name = Name;
        this.Age = Age;
        this.Email = Email;
        this.Address = Address; 
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    
    
    
    
}

