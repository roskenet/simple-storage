package de.roskenet.simplestorage.storage;

import org.springframework.core.io.InputStreamResource;

public interface PersistentStorage {

    void write(String id, byte[] bytes);

    InputStreamResource read(String id);
    
    void delete(String id);
}
