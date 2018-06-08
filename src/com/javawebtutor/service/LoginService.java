package com.javawebtutor.service;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.javawebtutor.hibernate.util.HibernateUtil;
import com.javawebtutor.model.Product;
import com.javawebtutor.model.User;

public class LoginService 
{

   public boolean authenticateUser(String username, String password)
   {
       User user = getUserByFirstName(username);         
       if(user!=null && user.getFirstName().equals(username) && user.getPassword().equals(password))
       {
           return true;
       }
       else
       {
           return false;
       }
   }

   public User getUserByFirstName(String username) 
   {
       Session session = HibernateUtil.openSession();
       Transaction tx = null;
       User user = null;
       try 
       {
           tx = session.getTransaction();
           tx.begin();
           
//           Query query = session.createQuery( " from User where User.firstName=:username ");
//           user = (User)query.uniqueResult();
//           System.out.println("query result "+user);
          
           
           
           Query query = session.createQuery("from User where firstName = :username");
           query.setParameter("username", username);
           List list = query.list(); // List of users
           user = (User) query.uniqueResult(); // Single user
           
           
           
           /*String hql = "from User ";
           Query query = session.createQuery(hql);
           //user = (User)query.list();
           //System.out.println("query result "+user);
           List<User> listUser = query.list();
           */
          /* if(listUser.contains(username))
           {
        	   System.out.println(username);
        	//  
           }*/
            
          /* 
           * for (User aUser : listUser) 
           {
               System.out.println(aUser.getFirstName());
           }
           */
           tx.commit();
       } 
       catch (Exception e) 
       {
           if (tx != null) 
           {
               tx.rollback();
           }
           e.printStackTrace();
       } 
       finally 
       {
          // session.close();
       }
       return user;
   }
    
   public List<User> getListOfUsers(){
       List<User> list = new ArrayList<User>();
       Session session = HibernateUtil.openSession();
       Transaction tx = null;       
       try {
           tx = session.getTransaction();
           tx.begin();
           list = session.createQuery("from User ").list();                       
           tx.commit();
       } catch (Exception e) {
           if (tx != null) {
               tx.rollback();
           }
           e.printStackTrace();
       } finally {
           session.close();
       }
       return list;
   }
   
   public List<Product> getListOfProducts(){
       List<Product> list = new ArrayList<Product>();
       Session session = HibernateUtil.openSession();
       Transaction tx = null;       
       try {
           tx = session.getTransaction();
           tx.begin();
           list = session.createQuery("from Product ").list();                       
           tx.commit();
       } catch (Exception e) {
           if (tx != null) {
               tx.rollback();
           }
           e.printStackTrace();
       } finally {
           session.close();
       }
       return list;
   }
}