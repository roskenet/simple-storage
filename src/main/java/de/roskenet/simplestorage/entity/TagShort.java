package de.roskenet.simplestorage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="tag")
public class TagShort {

	@Id
	public String code;
}
