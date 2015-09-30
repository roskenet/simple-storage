package de.roskenet.simplestorage.storage;

import java.io.ByteArrayInputStream;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

import de.roskenet.simplestorage.repository.ImageStatus;
import de.roskenet.simplestorage.repository.StatusController;

public class UploadTask implements Runnable {

    private AmazonS3 amazonS3;
    private byte[] bytes;
    private String id;
    private String bucketName;
    private StatusController statusController;

    public UploadTask(final AmazonS3 amazonS3, final String id, final byte[] bytes, final String bucketName, StatusController statusController) {
        this.amazonS3 = amazonS3;
        this.id = id;
        this.bytes = bytes;
        this.bucketName = bucketName;
        this.statusController = statusController;
    }

    @Override
    public void run() {
    	statusController.set(id, ImageStatus.UPLOAD_IN_PROGRESS);
        // TODO check result and try again, set error if necessary
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(bytes.length);

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, id, new ByteArrayInputStream(bytes),
                objectMetadata);
        PutObjectResult result = amazonS3.putObject(putObjectRequest);
        
        statusController.set(id, ImageStatus.OK);
    }

}
