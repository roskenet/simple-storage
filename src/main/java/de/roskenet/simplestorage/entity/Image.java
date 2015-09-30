package de.roskenet.simplestorage.entity;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;

@Entity
public class Image {
	
	@Id
	@Type(type = "pg-uuid")
	public UUID id;
	public String title;
	@ManyToMany
	public Set<Tag> tags;
	public String status;
	
}
