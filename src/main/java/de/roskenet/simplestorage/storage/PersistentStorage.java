package de.roskenet.simplestorage.storage;

import java.io.InputStream;

public interface PersistentStorage {

    void write(String id, byte[] bytes);

    InputStream read(String id);
}
