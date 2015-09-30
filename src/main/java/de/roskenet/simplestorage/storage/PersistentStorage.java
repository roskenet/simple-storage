package de.roskenet.simplestorage.storage;

import org.springframework.core.io.InputStreamResource;

import de.roskenet.simplestorage.repository.StatusController;

public interface PersistentStorage {

    void write(String id, byte[] bytes, StatusController statusController);

    InputStreamResource read(String id);
    
    void delete(String id);
}
