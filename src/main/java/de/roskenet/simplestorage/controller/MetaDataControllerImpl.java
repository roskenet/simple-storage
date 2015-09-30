package de.roskenet.simplestorage.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.roskenet.simplestorage.entity.Image;
import de.roskenet.simplestorage.repository.ImageRepository;

@RestController
@RequestMapping("/files/{id}")
public class MetaDataControllerImpl {

	@Autowired
	private ImageRepository imageRepository;
	
	@RequestMapping(value = "/info", method=RequestMethod.GET)
	public ResponseEntity<Image> info(@PathVariable("id") String id){
		return ResponseEntity.ok(imageRepository.findOne(UUID.fromString(id)));
	}
	
	@RequestMapping(value = "/status", method=RequestMethod.GET)
	public ResponseEntity<String> status(@PathVariable("id") String id){
		return ResponseEntity.ok(imageRepository.findOne(UUID.fromString(id)).status);
	}
}
