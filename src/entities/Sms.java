/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Ons Ben Othmen
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class Sms {
    
   
    private String num;
    private String messagetel;

    public Sms(String num, String messagetel) {
        this.num = num;
        this.messagetel = messagetel;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getMessagetel() {
        return messagetel;
    }

    public void setMessagetel(String messagetel) {
        this.messagetel = messagetel;
    }
           

    public Sms() { 

    }
    
    
  
    
}