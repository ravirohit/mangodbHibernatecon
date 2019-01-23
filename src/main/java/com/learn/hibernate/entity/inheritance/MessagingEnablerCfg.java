package com.learn.hibernate.entity.inheritance;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Proxy;
import org.hibernate.search.annotations.Indexed;


@Entity
@Indexed
//@Table(name = "messagingEnablerCfg")
@Proxy(lazy=false)
public class MessagingEnablerCfg extends MessagingConfigEntity {    
  
	private String serviceName;
	
	
	@OneToMany(cascade = { CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(nullable=true) 
	private Set<MessagingProfileCfg> messagingProfiles = new HashSet<>();
	
	@OneToMany(cascade = { CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(nullable=true) 
    private Set<MessagingSessionCfg> messagingSessions  = new HashSet<>();
	
	public MessagingEnablerCfg(){
		
	}
	public MessagingEnablerCfg(String service){
		this.serviceName = service;
	}
	

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Set<MessagingSessionCfg> getMessagingSessions() {
		return messagingSessions;
	}

	public void setMessagingSessions(Set<MessagingSessionCfg> messagingSessions) {
		this.messagingSessions = messagingSessions;
	}
	public Set<MessagingProfileCfg> getMessagingProfiles() {
		return messagingProfiles;
	}
	public void setMessagingProfiles(Set<MessagingProfileCfg> messagingProfiles) {
		this.messagingProfiles = messagingProfiles;
	}
    public void addSession(MessagingSessionCfg session){
    	messagingSessions.add(session);
    	
    }
    public void addProfile(MessagingProfileCfg profile){
    	messagingProfiles.add(profile);
    	
    }
    public void removeSession(String sessionName){
    	messagingSessions.removeIf(s -> s.getSessionName().equals(sessionName));
    }
    public void removeProfile(String profileId){
    	messagingProfiles.removeIf(p -> p.getProfileId().equals(profileId));
    }
	
	
	
}