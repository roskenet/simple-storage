package de.roskenet.simplestorage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tag {

	@Id
	public String code;
}
