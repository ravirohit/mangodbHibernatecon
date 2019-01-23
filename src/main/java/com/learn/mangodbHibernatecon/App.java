package com.learn.mangodbHibernatecon;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Session session = HibernateUtil.getInstance().openSession();
        System.out.println("session:"+session);
		Transaction tx = session.beginTransaction();
		
		Testing userProfile = new Testing("book1", "authore1","id1");
		session.save(userProfile);
		tx.commit();
		session.close();
		System.out.println("saved data");
		
    }
}
