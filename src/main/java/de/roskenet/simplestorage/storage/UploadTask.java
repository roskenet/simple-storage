package de.roskenet.simplestorage.storage;

import java.io.ByteArrayInputStream;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

public class UploadTask implements Runnable {

    private AmazonS3 amazonS3;
    private byte[] bytes;
    private String id;
    private String bucketName;

    public UploadTask(final AmazonS3 amazonS3, final String id, final byte[] bytes, final String bucketName) {
        this.amazonS3 = amazonS3;
        this.id = id;
        this.bytes = bytes;
        this.bucketName = bucketName;
    }

    @Override
    public void run() {

        // TODO check result and try again if necessary
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(bytes.length);

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, id, new ByteArrayInputStream(bytes),
                objectMetadata);
        PutObjectResult result = amazonS3.putObject(putObjectRequest);

    }

}
