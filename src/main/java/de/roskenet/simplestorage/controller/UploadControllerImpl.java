package de.roskenet.simplestorage.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.util.IOUtils;

import de.roskenet.simplestorage.storage.PersistentStorage;

@RestController
@RequestMapping("/files/{id}")
public class UploadControllerImpl implements UploadController {

    @Autowired
    private PersistentStorage storage;

    @Override
    @RequestMapping(method = RequestMethod.POST, consumes = "image/*")
    public ResponseEntity<Void> upload(@PathVariable("id") String id, InputStream bytes) {

        try {
			storage.write(id, IOUtils.toByteArray(bytes) );
		} catch (IOException e) {
			e.printStackTrace();
		}

        return ResponseEntity.accepted().header("Location", getLocation(id).toString()).build();

    }

    @Override
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<InputStreamResource> download(@PathVariable("id") String id) {
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.add("Content-Type", "image/jpeg");
    	ResponseEntity<InputStreamResource> responseEntity = new ResponseEntity<InputStreamResource>(storage.read(id), headers, HttpStatus.OK);
    	
    	return responseEntity;
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
    	storage.delete(id);
    	return ResponseEntity.accepted().build();
    }
    
    private URI getLocation(final String id) {
        URI location = linkTo(methodOn(UploadControllerImpl.class).download(id)).toUri();
        return location;
    }


}
