package de.roskenet.simplestorage.controller;

import java.io.InputStream;

import org.springframework.http.ResponseEntity;

public interface UploadController {

    ResponseEntity<Void> upload(String id, InputStream bytes);

    ResponseEntity<InputStream> download(String id);

}
