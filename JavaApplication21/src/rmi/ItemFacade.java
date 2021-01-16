/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author DELL
 */
public class ItemFacade extends UnicastRemoteObject implements FacadeInterface{
Item i;
    public ItemFacade() throws RemoteException
    {
    i=new Item(0,0,false,0,0,"");
    
    }
    @Override
    public void setItemData(int ItemID, int OwnerID, boolean Authorized, double Price, int StockID, String Category) throws RemoteException{
        i.setItemID(ItemID);
        i.setOwnerID(OwnerID);
        i.setAuthorized(Authorized);
        i.setPrice(Price);
        i.setStockID(StockID);
        i.setCategory(Category);
    }

    @Override
    public String getItemData() throws RemoteException {
        String Itemdata=i.getItemID()+i.getOwnerID()+i.getPrice()+i.getStockID()+i.getCategory();
        return Itemdata;
    }

    @Override
    public ItemDTO getItem() throws RemoteException {
        ItemDTO dto=new ItemDTO(i.getItemID(),i.getOwnerID());
        return dto;
    }
    
}
