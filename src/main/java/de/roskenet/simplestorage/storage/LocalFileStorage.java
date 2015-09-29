//package de.roskenet.simplestorage.storage;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.text.MessageFormat;
//
//import org.springframework.context.annotation.Profile;
//import org.springframework.core.io.InputStreamResource;
//import org.springframework.stereotype.Component;
//
//@Component
//@Profile("local")
//public class LocalFileStorage implements PersistentStorage {
//
//    private String localFileName = "/tmp/{0}";
//
//    @Override
//    public void write(final String id, byte[] bytes) {
//        Path path = Paths.get(MessageFormat.format(localFileName, id));
//        
//        try (OutputStream out = new FileOutputStream(path.toFile())){
//            out.write(bytes);
//            
//        } catch (IOException e) {
//
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public InputStreamResource read(final String id) {
//        Path path = Paths.get(MessageFormat.format(localFileName, id));
//
//        //            InputStreamResource inputStream = Files.newInputStream(path);
////            return IOUtils.toByteArray(inputStream);
//		return null;
//
//    }
//}
