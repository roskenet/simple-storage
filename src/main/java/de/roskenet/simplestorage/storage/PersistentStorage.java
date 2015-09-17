package de.roskenet.simplestorage.storage;

import java.io.InputStream;

public interface PersistentStorage {

    void write(String id, InputStream iStream);

    byte[] read(String id);
}
