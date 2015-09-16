package de.roskenet.simplestorage.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UploadControllerImpl {

	@RequestMapping(value="/files/{id}", method=RequestMethod.POST, consumes="*")
	public void upload(@PathVariable("id") String id, InputStream body) {
		System.out.println("Request for a file upload");
		
		Path path = Paths.get("/tmp/" + id + ".jpg");	
		
		/* You can get Path from file also: file.toPath() */
		try {
			Files.copy(body, path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
