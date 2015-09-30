package de.roskenet.simplestorage.repository;

public interface StatusController {

	void set(String id, String amazonPath, int size, ImageStatus status);
//	ImageStatus get(String id);
	
	RedirectStatus getRedirect(String id);
}
