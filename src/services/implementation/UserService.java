/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.implementation;

import entities.User;
import services.interfaces.BasicInterface;
import services.interfaces.IUserService;
import techniques.DataSource;
import techniques.Navigation;
import techniques.EmailAttachmentSender;
import utils.BCrypt;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.stage.Stage;
import entities.Sms;
/**
 *
 * @author Ons Ben Othmen
 */


public class UserService implements IUserService{
private Event event;
    private Connection connection;
    public UserService() {
        connection = DataSource.getInstance().getConnection();
    }
    
    @Override
    public boolean Authentification(String login, String password) {
        boolean status=false ;
       try{
     String req = "select * from user where username=? ";
        PreparedStatement st = connection.prepareStatement(req);
       st.setString(1,login);
    
        ResultSet rs = st.executeQuery();
          
     while(rs.next()){
        if(BCrypt.checkpw(password,rs.getString(8))==true){
         User.setIdofuserAlreadyloggedin(rs.getInt(1));
         User.setMyemail(rs.getString(4));
         status= true ;
          
            
         }else{
            status= false;
         }
         
     }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       return status; 
    }


 
   @Override
    public User getUserbyId(int id){
     User user = null ;
        try{
    String req = "select * from user where id=? ";
   PreparedStatement st = connection.prepareStatement(req);
   st.setInt(1,id );
   ResultSet rs = st.executeQuery();
   
    while(rs.next()){
   user = new User(rs.getInt(1),
           rs.getString(2),
           rs.getString(13), 
           rs.getDate(15),
           rs.getString(17), 
           rs.getString(4), 
           rs.getString(18), 
           rs.getString(14), 
           rs.getString(16));
         
    }
   }catch(Exception a){
        a.printStackTrace();
    }
       return user; 
    }
    
    @Override
    public User findById(Integer id) {
         User user = null ;
        try{
    String req = "select * from user where id=? ";
   PreparedStatement st = connection.prepareStatement(req);
   st.setInt(1,id );
   ResultSet rs = st.executeQuery();
   
    while(rs.next()){
   user = new User(rs.getInt(1),
           rs.getString(2),
           rs.getString(13), 
           rs.getDate(15),
           rs.getString(17), 
           rs.getString(4), 
           rs.getString(18), 
           rs.getString(14), 
           rs.getString(16));
         
    }
   }catch(Exception a){
        a.printStackTrace();
    }
       return user; 
    }

 

    @Override
    public void add(User user) {
          try{
        String req = "insert into user (username,username_canonical,email,email_canonical,password,enabled,confirmation_token,roles) values (?,?,?,?,?,?,?,?)";
        PreparedStatement st = connection.prepareStatement(req);
         String token = UUID.randomUUID().toString();
        String Role = user.getRoles();
        st.setString(1, user.getUsername());
        st.setString(2, user.getUsername());
        st.setString(3, user.getEmail());
        st.setString(4, user.getEmail());
        st.setString(5,user.getPassword());
        st.setInt(6, 0);
        st.setString(7,token);
        if(Role.equals("Admin")){
            st.setString(8,"a:1:{i:0;s:5:\"ADMIN\";}");  
        }else{
           st.setString(8,"a:0:{}");   
        }
        
        EmailAttachmentSender.sendEmailWithAttachments(user.getEmail(),"code de confirmation de compte ",token);

        st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
         try{
        String req = "update user SET "
                + "username=?,"
                + "username_canonical=?,"
                + "datedenaissance=?,"
                + "ville=?,"
                + "intro=?,"
                + "phone=?,"
                + "URL=?,"
                + "Sexe=?,"
                + "nom=? "
                + "where id=?";
        PreparedStatement st = connection.prepareStatement(req);
        st.setString(1, user.getUsername());
        st.setString(2, user.getUsername());
        st.setDate(3, user.getDatedenaissance());
        st.setString(4, user.getVille());
        st.setString(5, user.getDescrption());
        st.setString(6, user.getPhone());
        st.setString(7, user.getURL());
        st.setString(8, user.getSexe());
        st.setString(9, user.getNom());
    
        st.setInt(8, user.getId());
        st.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    

    @Override
    public void delete(User user) {
                
           try {
            String req = "delete from user where id = ?";
            PreparedStatement ps = connection.prepareStatement(req);
            ps.setInt(1,user.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
    List<User> users = new ArrayList<>();
        try {
            String req = "select * from user";
            PreparedStatement ps = connection.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getString(2), rs.getString(13), rs.getString(17), rs.getString(4));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;    
    
    
    }

    @Override
    public String CheckRole(User u) {
        String role=null;
            if(u.getRoles().equals("a:1:{i:0;s:5:\"ADMIN\";}")){
             role = "guide";
                    }
                  else{
             role = "users";
                     }
           
        return role;
    }

    @Override
    public User getUserByEmail(String email) {
       
             User user = null ;
        try{
    String req = "select * from user where email=? ";
   PreparedStatement st = connection.prepareStatement(req);
   st.setString(1,email );
   ResultSet rs = st.executeQuery();
   
    while(rs.next()){
                user = new User(rs.getString(2), rs.getString(13), rs.getString(17), rs.getString(4));
    }
   }catch(Exception a){
        a.printStackTrace();
    }
       return user; 
        
        
        
    }

    @Override
    public void SendMailAndAddTokenToUser(User u,String HashedToken) {
            try{
        String req = "update user SET tokenForPassword=?  where email=?";
        PreparedStatement st = connection.prepareStatement(req);
        st.setString(1, HashedToken);
        st.setString(2, u.getEmail());

         st.executeUpdate();
       EmailAttachmentSender.sendEmailWithAttachments(u.getEmail(),"code de récupération de mot de passe ",HashedToken);
       }catch(Exception ex){
            ex.printStackTrace();
        }
    }
 @Override
    public void SendSMSAndAddTokenToUser(String HashedToken,User u) {
             try{
        String req = "update user SET tokenForPassword=?  where email=?";
        PreparedStatement st = connection.prepareStatement(req);
        st.setString(1, HashedToken);
        st.setString(2, u.getEmail());
    
         st.executeUpdate();
          
      new SmsService().sendSms(new Sms("+216"+u.getPhone(), "Code de Recuperation : "+HashedToken));
  
       }catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        
    }
    @Override
    public Boolean CheckIfUserExist(String email) {
                  boolean check = false ;
        try{
    String req = "select * from user where email=? ";
   PreparedStatement st = connection.prepareStatement(req);
   st.setString(1,email );
   ResultSet rs = st.executeQuery();
   int i =0;
    while(rs.next()){
         i++;
                 if(i==1){
                     check=true;
                 }else{
                     check=false;
                 }
    }
   }catch(Exception a){
        a.printStackTrace();
    }
       return check; 
    }

    @Override
    public Boolean CheckToken(User user, String token) {
                boolean check = false ;
        try{
    String req = "select * from user where email=? and tokenForPassword=?  ";
   PreparedStatement st = connection.prepareStatement(req);
   st.setString(1,user.getEmail());
   st.setString(2,token);
   ResultSet rs = st.executeQuery();
   int i =0;
    while(rs.next()){
         i++;
                 if(i==1){
                     check=true;
                 }else{
                     check=false;
                 }
    }
   }catch(Exception a){
        a.printStackTrace();
    }
       return check;

    }

    @Override
    public void ressettingpassword(User u) {

        try{
        String req = "update user SET password=?,tokenForPassword=?  where email=?";
        PreparedStatement st = connection.prepareStatement(req);
      String password = BCrypt.hashpw(u.getPassword(),BCrypt.gensalt(13));
        st.setString(1, password);
        st.setString(2, null);
        st.setString(3, u.getEmail());
      st.executeUpdate();

       }catch(Exception ex){
            ex.printStackTrace();
        }

    }

  
    

    @Override
    public  Boolean Checkconfirmationtoken(User user, String Token) {
        boolean exisit=false;
        try{
        String req = "select * from user where email=? and confirmation_token=? ";
        PreparedStatement st = connection.prepareStatement(req);
        st.setString(1, user.getEmail());
        st.setString(2, Token);
        ResultSet rs = st.executeQuery();
        int i=0;
        while(rs.next()){
         exisit=true;
       
                    
        }
    
  
       }catch(Exception ex){
            ex.printStackTrace();
        }
        return exisit;
    }

    @Override
    public void ConfirmAccount(User user, String Token) {
        String req2 ="update user set enabled=? , confirmation_token=? where email=?  ";
    
    try {
         PreparedStatement st1 = connection.prepareStatement(req2);
         st1.setInt(1,1);
         st1.setString(2, null);
         st1.setString(3,user.getEmail());
         st1.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
     
    }

    @Override
    public boolean checkEnabled(User u) {
            boolean exisit=false;
        try{
        String req = "select * from user where email=? ";
        PreparedStatement st = connection.prepareStatement(req);
        st.setString(1, u.getEmail());
        
        ResultSet rs = st.executeQuery();
      
        while(rs.next()){
        
       if(rs.getInt(6)==0){
            exisit=false;
       }else{
           exisit=true; 
       }
                    
        }
    
  
       }catch(Exception ex){
            ex.printStackTrace();
        }
        return exisit;
    }

   
    
    
    }
