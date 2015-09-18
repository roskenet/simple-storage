package de.roskenet.simplestorage.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.annotation.Profile;

import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.AmazonS3;

@Component
@Profile("default")
public class S3Storage implements PersistentStorage {

    @Value("${storage.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 amazonS3;

    @Override
    public void write(final String id, final byte[] bytes) {

        Thread uploadThread = new Thread(new UploadTask(amazonS3, id, bytes, bucketName));
        uploadThread.start();

    }

    @Override
    public byte[] read(final String id) {

        return null;
    }

}
