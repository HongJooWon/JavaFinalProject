package edu.handong.csee.function;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;


import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class ZipReader {


	public ArrayList<String> run(String args) {
		ArrayList<String> lines = new ArrayList<String>();
		String input = args;
		
		lines = readFileInZip(input);
		
		return lines;
		
	}

	public ArrayList<String> readFileInZip(String path) {
		ZipFile zipFile;
		ArrayList<String> lines = new ArrayList<String>();
		try {
			zipFile = new ZipFile(path);
			Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

		    while(entries.hasMoreElements()){
		    	ZipArchiveEntry entry = entries.nextElement();
		        InputStream stream = zipFile.getInputStream(entry);
		    
		        ExcelReader myReader = new ExcelReader();
		        
		        for(String value:myReader.getData(stream)) {
		        	lines.add(value);
		        }
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
	}
	
}
	
	