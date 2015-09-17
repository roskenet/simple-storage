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

	public UploadTask(AmazonS3 amazonS3, String id, byte[] bytes) {
		this.amazonS3 = amazonS3;
		this.id = id;
		this.bytes = bytes;
	}

	@Override
	public void run() {

		ObjectMetadata objectMetadata = new ObjectMetadata();
		objectMetadata.setContentLength(bytes.length);
		PutObjectRequest putObjectRequest = 
				new PutObjectRequest("feliximages", id, new ByteArrayInputStream(bytes),
				objectMetadata);
		// putObjectRequest.getRequestClientOptions().setReadLimit(15000000);
		 PutObjectResult result = amazonS3.putObject(putObjectRequest);
		// System.out.println("Etag:" + result.getETag() + "-->" + result);

	}

}
