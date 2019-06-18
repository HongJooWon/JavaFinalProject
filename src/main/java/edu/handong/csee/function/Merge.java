package edu.handong.csee.function;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import edu.handong.csee.function.Exceptions;

public class Merge extends Thread{

    /**public static void main(String[] args) {

        String idFile = "100"; //최종파
        int numFiles = 3; //파일개

        try {
            mergeCsvFiles(idFile, numFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	**/
	
	public void run(String[] args) {
		
		try {
			Thread.sleep(1000);
				
		} catch (InterruptedException ie) {
			ie.printStackTrace();
			// TODO: handle exception
		}
		
		try {
			if(args.length<2)
				throw new Exceptions();
		} catch (Exceptions e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		ZipReader myreader = new ZipReader();
		ArrayList<String> lines = new ArrayList<String>();
		String input = args[1];
		String output = args[3];
		
		lines = myreader.readFileInZip(input);
		
		try {
            mergeFiles(lines, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
    public void mergeFiles(ArrayList<String> lines, String idFile) throws IOException {

    	FileWriter writer = new FileWriter(idFile);


        String collect = lines.stream().collect(Collectors.joining(","));
        System.out.println(collect);

        writer.write(collect);
        writer.close();
    }

}