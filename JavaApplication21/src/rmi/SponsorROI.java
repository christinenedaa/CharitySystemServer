/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package charitysystem;
package rmi;

import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author a_h_s
 */
public interface SponsorROI {
    /*
     public void ReserveEvent (Sponsor s,String date,String location,int Req);
*/
    public void ReserveEvent(String sponsMail,int eventid,String eventName,String eventDate,String location,int req ,boolean state)throws RemoteException;

}
