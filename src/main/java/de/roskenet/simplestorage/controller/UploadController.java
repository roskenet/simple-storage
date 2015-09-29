package de.roskenet.simplestorage.controller;

import java.io.InputStream;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

public interface UploadController {

    ResponseEntity<Void> upload(String id, InputStream bytes);

    ResponseEntity<InputStreamResource> download(String id);
    
    ResponseEntity<Void> delete(String id);

}
