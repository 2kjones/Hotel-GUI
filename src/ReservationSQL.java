/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kjones36
 */
public class ReservationSQL 
{   
    public String date;
    public String roomid;
    public String guestid;
    
    
    public ReservationSQL(String d, String r, String g)
    {
        date = d;
        roomid = r;
        guestid = g;
    }
            
            
    public void setDate(String d)
    {
        date = d;
    }
    
    public void setRoomID(String r)
    {
        roomid = r;
    }
    
    public void setGuestID(String g)
    {
        guestid = g; 
    }
    
    public String getDate()
    {
        return date;
    }
    
    public String getRoomID()
    {
        return roomid;
    }
    
    public String getGuestID()
    {
        return guestid;
    }
    
    public String toString ()
    {
       return "insert into reservations values (0,'"+date+"' , '"+roomid+"' , '"+guestid+"')";
    }
}
