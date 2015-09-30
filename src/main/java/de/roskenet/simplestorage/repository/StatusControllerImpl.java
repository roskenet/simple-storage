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
	public void set(String id, ImageStatus status) {
		Image image = imageRepository.findOne(UUID.fromString(id));
		
		if(image==null) {
			// We set the state for a complete new one:
			image = new Image();
			image.id = UUID.fromString(id);
			image.title = "No Title";
		}
		
		image.status = status.name();
		imageRepository.save(image);
	}

	@Override
	public ImageStatus get(String id) {
		return ImageStatus.valueOf(imageRepository.findOne(UUID.fromString(id)).status);
		
	}

}
