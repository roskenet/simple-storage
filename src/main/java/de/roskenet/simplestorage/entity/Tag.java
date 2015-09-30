package de.roskenet.simplestorage.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tag {
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String id;

	public Tag() {
		//
	}
	
	public Tag(String id) {
		this.id = id;
	}
	
}
