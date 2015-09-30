package de.roskenet.simplestorage.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RedirectStatus {

	@JsonProperty("status")
	public boolean isPublic;
	@JsonIgnore
	public String location;
}
