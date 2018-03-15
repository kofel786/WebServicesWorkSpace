package com.kc.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
 
 
@SuppressWarnings("deprecation")
public class HibernateUtil {
     
    private static final SessionFactory sessionFactory;
     private static Logger log=Logger.getLogger(HibernateUtil.class.getName());
    static{
        try{
        	log.info("static block");
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
 
        }catch (Throwable ex) {
            System.err.println("Session Factory could not be created." + ex);
            throw new ExceptionInInitializerError(ex);
        }   
    }
     
    public static SessionFactory getSessionFactory() {
    	log.info("getSessionFactory");
        return sessionFactory;
    }
     
}