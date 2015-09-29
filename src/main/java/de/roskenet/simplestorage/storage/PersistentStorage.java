package de.roskenet.simplestorage.storage;

import java.io.InputStream;

import org.springframework.core.io.InputStreamResource;

public interface PersistentStorage {

    void write(String id, byte[] bytes);

    InputStreamResource read(String id);
    
    void delete(String id);
}
