package de.roskenet.simplestorage.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

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
	public InputStreamResource read(final String id) {
		S3Object s3object = amazonS3.getObject(new GetObjectRequest(bucketName, id));

		InputStreamResource stream = new InputStreamResource(s3object.getObjectContent());
		//			return IOUtils.toByteArray(stream);
		return stream;
	}

}
