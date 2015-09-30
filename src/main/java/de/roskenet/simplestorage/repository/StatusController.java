package de.roskenet.simplestorage.repository;

public interface StatusController {

	void set(String id, ImageStatus status);
	ImageStatus get(String id);
}
