package DAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
		if (blob == null) {
			return null;
		}
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
	public static InputStream FileToBlob(File file) throws SQLException {


	    try  {

	    	return new FileInputStream(file);
	    } catch (IOException e) {
	        return null;
	    }

	 
	    }

	    
	}
	
	
	

