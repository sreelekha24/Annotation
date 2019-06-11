package com.techouts.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.techouts.pojo.Employee;

public class Main 
{
    public static void main(String[] args)
    {
    	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
      
	    SessionFactory factory = meta.getSessionFactoryBuilder().build();  
	    Session session = factory.openSession();  
	    Transaction t = session.beginTransaction();   
	                
	        Employee e1=new Employee();    
	        e1.setEmpId(101);    
	        e1.setEmpName("Swathi");    
	        e1.setAddress("Vizag"); 
	        e1.setContact("1231231231");
	            
	        session.save(e1);  
	        t.commit();  
	        System.out.println("successfully saved....");    
	        factory.close();  
	        session.close();    
            
    }
}
