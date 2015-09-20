package de.roskenet.simplestorage.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.IOException;
import java.io.InputStream;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.util.IOUtils;

import de.roskenet.simplestorage.storage.PersistentStorage;

@RestController
public class UploadControllerImpl implements UploadController {

    @Autowired
    private PersistentStorage storage;

    @Override
    @RequestMapping(value = "/files/{id}", method = RequestMethod.POST, consumes = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Void> upload(@PathVariable("id") final String id, final InputStream bytes) {

        try {
			storage.write(id, IOUtils.toByteArray(bytes) );
		} catch (IOException e) {
			e.printStackTrace();
		}

        return ResponseEntity.created(getLocation(id)).build();

    }

    @Override
    @RequestMapping(value = "/files/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<InputStream> download(@PathVariable("id") final String id) {

        return ResponseEntity.ok(storage.read(id));
    }

    private URI getLocation(final String id) {
        URI location = linkTo(methodOn(UploadControllerImpl.class).download(id)).toUri();
        return location;
    }

}
