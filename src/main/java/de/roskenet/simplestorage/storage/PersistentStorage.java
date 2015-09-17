package de.roskenet.simplestorage.storage;

public interface PersistentStorage {

    void write(String id, byte[] bytes);

    byte[] read(String id);
}
