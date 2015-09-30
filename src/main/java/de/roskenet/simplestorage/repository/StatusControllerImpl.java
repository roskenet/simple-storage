package de.roskenet.simplestorage.repository;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.roskenet.simplestorage.entity.Image;

@Component
public class StatusControllerImpl implements StatusController {

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public void set(String id, String amazonPath, int size, ImageStatus status) {
		Image image = imageRepository.findOne(UUID.fromString(id));
		
		if(image==null) {
			// We set the state for a complete new one:
			image = new Image();
			image.id = UUID.fromString(id);
			image.title = "No Title";
		}
		
		image.amazonpath = amazonPath;
		image.size = size;
		image.status = status.name();
		imageRepository.save(image);
	}

	@Override
	public RedirectStatus getRedirect(String id) {
		Image image = imageRepository.findOne(UUID.fromString(id));
		RedirectStatus redirectStatus = new RedirectStatus();
		
		if(image != null) {
			redirectStatus.location = image.amazonpath;
			redirectStatus.isPublic = image.wwwreadable;
		}
		return redirectStatus;
	}

}
