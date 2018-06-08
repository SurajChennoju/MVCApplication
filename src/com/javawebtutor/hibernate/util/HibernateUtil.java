package com.javawebtutor.hibernate.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

//import com.fasterxml.classmate.AnnotationConfiguration;
public class HibernateUtil {
 
    private static final SessionFactory sessionFactory;
 
    static 
    {
        try 
        {
            sessionFactory =  new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        	//serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        } 
        catch (Throwable ex) 
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static Session openSession() 
    {
        return sessionFactory.openSession();
    }
}