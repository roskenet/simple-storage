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
import de.roskenet.simplestorage.repository.RedirectStatus;
import de.roskenet.simplestorage.repository.StatusController;
import de.roskenet.simplestorage.resources.UploadProgressResource;

@RestController
@RequestMapping("/images/{id}")
public class MetaDataControllerImpl {

	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private StatusController statusController;
	
	@RequestMapping(value="/public", method=RequestMethod.GET)
	public ResponseEntity<RedirectStatus> getPublicStatus(@PathVariable("id") String id) {
		return ResponseEntity.ok(statusController.getRedirect(id));
	}
	
	@RequestMapping(value="/public", method=RequestMethod.PUT)
	public ResponseEntity<Void> setPublicStatus(@PathVariable("id") String id, @RequestBody SimpleStatusWrapper status) {
//		System.out.println("Set to : " + status.status);
		// TODO Work in Progress: update the DB status and the permissions in S3
		
//		statusController.setPublicity(id, status.status);
		
		return ResponseEntity.accepted().build();
	}
	
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
		Image image = imageRepository.findOne(UUID.fromString(id));
		
		if(image==null) {
			// TODO: Return 404 
//			return ResponseEntity.status(null, null).build();
		}
		
		uploadProgressResource.status = ImageStatus.valueOf(image.status);
		
		return ResponseEntity.ok(uploadProgressResource);
	}
}
