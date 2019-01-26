package com.learn.mangodbHibernatecon;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.ogm.cfg.OgmConfiguration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {  
	private static SessionFactory SESSION_FACTORY;
	private static ServiceRegistry SERVICE_REGISTRY;
	public Transaction tx;
	public HibernateUtil() {
	}

	public static SessionFactory getInstance() {

		if (SESSION_FACTORY == null) {
			synchronized (SessionFactory.class) {
				if (SESSION_FACTORY == null) {
					Configuration config = new OgmConfiguration().configure("hibernate.cfg.xml");
					config.addAnnotatedClass(com.learn.mangodbHibernatecon.Testing.class);
					config.addAnnotatedClass(com.learn.hibernate.entity.inheritance.MessagingConfigEntity.class);
					config.addAnnotatedClass(com.learn.hibernate.entity.inheritance.MessagingEnablerCfg.class);
					config.addAnnotatedClass(com.learn.hibernate.entity.inheritance.MessagingProfileCfg.class);
					config.addAnnotatedClass(com.learn.hibernate.entity.inheritance.MessagingSessionCfg.class);
					System.out.println("session factory");
					SERVICE_REGISTRY = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
					System.out.println("session registry:"+SERVICE_REGISTRY);
					SESSION_FACTORY = config.buildSessionFactory(SERVICE_REGISTRY);
					System.out.println("session factory:"+SESSION_FACTORY);
				}
			}
		}
		return SESSION_FACTORY;

	}
	public Session getSession(){
		Session session = getInstance().openSession();
		tx = session.beginTransaction();
		return session;
	}
	public Transaction getTransaction(){
		return tx;
	}
 }
