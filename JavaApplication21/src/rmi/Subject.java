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
public interface Subject {
  public void Notify(Object obj , boolean status);
  public void AddObserver(Observer o);
  public void DeleteObserver(Observer o);
 
}
