package de.roskenet.simplestorage.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import de.roskenet.simplestorage.serializer.TagListSerializer;

@Entity
public class Image {
	
	@Id
	@Type(type = "pg-uuid")
	@JsonIgnore
	public UUID id;
	public String title;
	@ManyToMany
	@RestResource(exported = false)
	@JsonSerialize(using=TagListSerializer.class)
	@Cascade(CascadeType.ALL)
	public List<Tag> tags;
	@JsonIgnore
	public String status;
	
}
