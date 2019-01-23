package com.learn.hibernate.entity.inheritance;

import javax.persistence.Entity;

import org.hibernate.annotations.Proxy;
import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
@Proxy(lazy = false)

public class MessagingSessionCfg extends MessagingConfigEntity{
	
	private String sessionName;
	private String provider;
	
	
	public MessagingSessionCfg(){
		sessionName = null;
		provider = null;
		
	}
	public MessagingSessionCfg(String name,String provider){
		this.sessionName = name;
		this.provider = provider;
	}
	
	public String getSessionName() {
		return sessionName;
	}
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String toString(){
		return "sessionName:"+sessionName+"  provider:"+provider;
	}
	
	
}
