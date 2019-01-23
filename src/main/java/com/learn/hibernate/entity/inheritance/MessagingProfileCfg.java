package com.learn.hibernate.entity.inheritance;

import javax.persistence.Entity;

import org.hibernate.annotations.Proxy;
import org.hibernate.search.annotations.Indexed;

@Entity
@Indexed
@Proxy(lazy=false)

public class MessagingProfileCfg extends MessagingConfigEntity {

	private String profileId;
	private String sourceAddress;
	
	public MessagingProfileCfg(){
		profileId = null;
		sourceAddress = null;
		
	}
	public MessagingProfileCfg(String profileId, String sourceAddress){
		this.profileId = profileId;
		this.sourceAddress = sourceAddress;
	}
	public String getProfileId() {
		return profileId;
	}
	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}
	public String getSourceAddress() {
		return sourceAddress;
	}
	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}
	
	
	
}
