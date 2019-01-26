package com.learn.hibernate.entity.inheritance;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.learn.mangodbHibernatecon.HibernateUtil;



public class Respository extends HibernateUtil{
	Respository(){
		super();
	}
	
	public void saveUpdateMessagingSession(MessagingEnablerCfg e){

		Session session = getSession();
 	    session.saveOrUpdate(e);;  
 	    tx.commit();
 	    session.close();
		
	} 
	public void mergeUpdateMessagingEnabler(MessagingEnablerCfg e){
		Session session = getSession();
 	    session.merge(e);
 	    tx.commit();
 	    session.close();
		
	} 
	
	public MessagingEnablerCfg getMessagingEnablerCfg(){

		Session session = getSession();
		System.out.println("inside repo for read connnector");
		String queryStr = "From MessagingEnablerCfg where serviceName = 'serviceName5'";
		Query query = session.createQuery(queryStr);
		List<MessagingEnablerCfg> list = query.list();
		session.close();
		System.out.println("inside repo for read connnector");
		return list.get(0);
	}
	
	public MessagingConfigEntity getMessagingSession(String name){
		Session session = getSession();
		String queryStr = "From MessagingSessionCfg session where session.sessionName = '"+name+"'";
		Query query = session.createQuery(queryStr);
		List<MessagingConfigEntity> list = query.list();		
		session.close();
		return list.size() > 0 ? list.get(0): null;
	}
	
	

	public void clean(){
		///t.commit();
		  
	}
}
