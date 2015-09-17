package de.roskenet.simplestorage.storage;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;

@Component
@Profile("default")
public class S3Storage implements PersistentStorage {

    @Autowired
    private AmazonS3 amazonS3;

    @Override
    public void write(final String id, final byte[] bytes) {

// String existingBucketName = "<your Bucket Name>";
//        String keyName = id;

//
// String filePath = "E://Pics//mypic.JPG";
//        String amazonFileUploadLocationOriginal = "feliximages";

//
//
// AmazonS3 s3Client = new AmazonS3Client(new
// PropertiesCredentials(UploadFile.class.getResourceAsStream("AwsCredentials.properties")));
//
// FileInputStream stream = new FileInputStream(filePath);
//        ObjectMetadata objectMetadata = new ObjectMetadata();
//        PutObjectRequest putObjectRequest = new PutObjectRequest(amazonFileUploadLocationOriginal, keyName, iStream,
//                objectMetadata);
//        putObjectRequest.getRequestClientOptions().setReadLimit(15000000);
//        PutObjectResult result = amazonS3.putObject(putObjectRequest);
//        System.out.println("Etag:" + result.getETag() + "-->" + result);

// TransferManager transferManager = new TransferManager(this.amazonS3);
// Upload upload = transferManager.upload("feliximages", id, bytes, new ObjectMetadata());
// // When we leave, we kill the upload here!!!???
// System.out.println(upload.getState());

    	Thread uploadThread = new Thread(new UploadTask(amazonS3, id, bytes));
    	uploadThread.start();
    	
    }

    @Override
    public byte[] read(final String id) {

// TransferManager transferManager = new TransferManager(amazonS3);
// transferManager.download("feliximages", id, path.toFile());
        return null;
    }

}
