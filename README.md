# simple-storage

Simple REST service for uploading binary files to Amazon S3 and storing meta data in a PostgreSQL Database.

TODOs:
   * Provide more RESTful things (e.g. OPTIONS)
   * Provide search for tags.

Plans:
   * Read EXIF information from images and store them.
   * Create thumbnails for web galleries.
   * Mark images as public to access them directly via S3-Link. (Partially finished)

How to use it:
   * Uploading an Image:
   POST /images/<UUID>/data

   * Check the upload status:
   GET /images/<UUID>/status
   (Upload to S3 is async. poll for OK)

   * Add title and tags for the image:
   GET /images/<UUID>/info
   POST /images/UUID>/info

   * Downloading an Image:
   GET /images/<UUID>/data
   (Redirects to the S3-Bucket directly, when the image is marked as public - Save bandwith!)

   * Show all tags (really means all - not only the used ones)
   Use that for e.g. autocompletion
   GET /tags

   * Show all images
   GET /images
