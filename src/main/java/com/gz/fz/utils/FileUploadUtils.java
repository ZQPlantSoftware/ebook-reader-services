package com.gz.fz.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class FileUploadUtils {

//    public static String BASE_PATH;// = "/Users/georgezou/Documents/WORK/DEMO/gz-epub/";
	
	public static String downloadAndDecompressing (String inputUrl, String outputUrl, String webServerPath) throws IOException {

		String path = FileUploadUtils.zipDecompressing(
			FileUploadUtils.downloadNet(inputUrl, outputUrl, webServerPath), outputUrl, webServerPath
		);

		return path;
	}

	@SuppressWarnings({ "unused", "resource" })
	public static String downloadNet(String urlStr, String outputUrl, String webServerPath) throws IOException {
		 Integer bytesum = 0;
		 Integer byteread = 0;

		 URL url = new URL(urlStr);

		 URLConnection conn = url.openConnection();
		 InputStream inStream = conn.getInputStream();

		 String res = outputUrl + webServerPath + TimeUtils.format() + '/';
		 new File(res).mkdir();
		 res += UUID.randomUUID().toString().substring(0, 8) + ".zip";
		 FileOutputStream fs = new FileOutputStream(res);
		
		 byte[] buffer = new byte[1204];
		 int length;
		 while ((byteread = inStream.read(buffer)) != -1) {
		 	bytesum += byteread;
		 	System.out.println(bytesum);
		 	fs.write(buffer, 0, byteread);
		 }

		 return res;
	}

    @SuppressWarnings("resource")
	public static String zipDecompressing(String filePath, String toPath, String webServerPath) throws ZipException,IOException {
            // get a zip file instance
            File file = new File ( filePath ) ;
            
            // get a ZipFile instance
            ZipFile zipFile = new ZipFile ( file ) ;

            // create a ZipInputStream instance
            ZipInputStream zis = new ZipInputStream ( new FileInputStream (
                    file ) ) ;

            // create a ZipEntry instance , lay the every file from
            // decompress file temporarily
            ZipEntry entry = null ;
            
            String res = webServerPath + TimeUtils.format() + '/' + UUID.randomUUID().toString().substring(0, 8) + '/';
            String path = toPath + res;
            new File(path).mkdirs();
            
            // a circle to get every file
            while ((entry = zis.getNextEntry()) != null ) {
                System.out.println ( "decompress file :"
                        + entry.getName() ) ;

                // define the path to set the file
                File outFile = new File ( path + entry.getName ( ) ) ;
                
                if (entry.isDirectory()) {
                    new File(outFile.getParent()).mkdirs();
                    continue;
                }
                
                // if the file's parent directory wasn't exits ,than
                // create the directory
                if ( ! outFile.getParentFile ( ).exists ( ) ) {
                    outFile.getParentFile ( ).mkdir ( ) ;
                }

                // if the file not exits ,than create the file
                if ( ! outFile.exists ( ) ) {
                    outFile.createNewFile ( ) ;
                }

                // create an input stream
                BufferedInputStream bis = new BufferedInputStream (
                        zipFile.getInputStream ( entry ) ) ;

                // create an output stream
                BufferedOutputStream bos = new BufferedOutputStream (
                        new FileOutputStream ( outFile ) ) ;
                byte [ ] b = new byte [ 100 ] ;
                while ( true ) {
                    int len = bis.read ( b ) ;
                    if ( len == - 1 )
                        break ;
                    bos.write ( b , 0 , len ) ;
                }
                // close stream
                bis.close ( ) ;
                bos.close ( ) ;
            }
            zis.close ( ) ;
            
            return res;
        }

}
