package de.roskenet.simplestorage.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.roskenet.simplestorage.entity.Image;
import de.roskenet.simplestorage.repository.ImageRepository;
import de.roskenet.simplestorage.repository.ImageStatus;
import de.roskenet.simplestorage.resources.UploadProgressResource;

@RestController
@RequestMapping("/files/{id}")
public class MetaDataControllerImpl {

	@Autowired
	private ImageRepository imageRepository;
	
	@RequestMapping(value = "/info", method=RequestMethod.GET)
	public ResponseEntity<Image> info(@PathVariable("id") String id){
		return ResponseEntity.ok(imageRepository.findOne(UUID.fromString(id)));
	}
	
	@RequestMapping(value="/info", method=RequestMethod.PUT)
	public ResponseEntity<Void> updateInfo(@PathVariable("id") String id, @RequestBody Image image){
		Image persistedImage = imageRepository.findOne(UUID.fromString(id));
		
		if(persistedImage==null) {
			return ResponseEntity.notFound().build();
		}
		
		persistedImage.tags = image.tags;
		persistedImage.title = image.title;
		
		imageRepository.save(persistedImage);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/status", method=RequestMethod.GET)
	public ResponseEntity<UploadProgressResource> status(@PathVariable("id") String id){
		
		UploadProgressResource uploadProgressResource = new UploadProgressResource();
		uploadProgressResource.status = ImageStatus.valueOf(imageRepository.findOne(UUID.fromString(id)).status);
		
		return ResponseEntity.ok(uploadProgressResource);
	}
}
