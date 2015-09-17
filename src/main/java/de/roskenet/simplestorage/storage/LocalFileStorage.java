package de.roskenet.simplestorage.storage;

import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.text.MessageFormat;

import org.apache.commons.io.IOUtils;

import org.springframework.context.annotation.Profile;

import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class LocalFileStorage implements PersistentStorage {

    private String localFileName = "/tmp/{0}";

    @Override
    public void write(final String id, final InputStream iStream) {
        Path path = Paths.get(MessageFormat.format(localFileName, id));
        try {
            Files.copy(iStream, path);
        } catch (IOException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public byte[] read(final String id) {
        Path path = Paths.get(MessageFormat.format(localFileName, id));

        try {
            InputStream inputStream = Files.newInputStream(path);
            return IOUtils.toByteArray(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return null;
    }
}
