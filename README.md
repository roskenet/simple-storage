# simple-storage

Simple REST service example for uploading binary files to Amazon S3 and storing meta data in a PostgreSQL Database.

Limitations:
   Only works with image/jpeg right now.

TODOs:
   * Provide more RESTful things (e.g. OPTIONS)
   * Provide search for tags.

Plans:
   * Read EXIF information from images and store them.
   * Create thumbnails for web galleries.
   * Mark images as public to access them directly via S3-Link.
