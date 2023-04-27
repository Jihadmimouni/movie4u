package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

public class Convert {
	/**
	 * @param blob
	 * @return File
	 * @throws SQLException
	 * @throws IOException
	 */
	public static File toFile(Blob blob) throws SQLException, IOException {
	    if (blob==null)
	    	return null;
		System.out.println("Read "+ blob.length() + " bytes ");
	    byte [] array = blob.getBytes( 1, ( int ) blob.length() );
	    File file = File.createTempFile("video", ".mp4", new File("./cache"));
	    FileOutputStream out = new FileOutputStream( file );
	    file.deleteOnExit();
	    out.write( array );
	    out.close();
		return file;
	}	/**
	 * @param file
	 * @return Blob
	 * @throws SQLException
	 */
	public static Blob FileToBlob(File file) throws SQLException {
	    byte[] bArray = new byte[1000];

	    List<Byte> byteList = new ArrayList<>();

	    try (FileInputStream fis = new FileInputStream(file)) {

	        // Converting input file in list of bytes
	        while (fis.read(bArray) > 0) {
	            for (byte b : bArray)
	                byteList.add(b);
	        }

	    } catch (IOException e) {
	        return null;
	    }

	    // Converting list of bytes into array of bytes
	    // as SerialBlob class takes array of bytes
	    byte[] byteArray = new byte[byteList.size()];

	    for (int i = 0; i < byteList.size(); i++) {
	        byteArray[i] = (byte) byteList.get(i);
	    }

	    return new SerialBlob(byteArray);
	}
	
	
	
}
