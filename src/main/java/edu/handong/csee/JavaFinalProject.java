package edu.handong.csee;


import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import edu.handong.csee.function.Merge;

public class JavaFinalProject{
	
	public boolean input;
	public boolean output;

	public static void main(String[] args) {
		
		Options options = new Options();
		 
        options.addOption("i", "input", false, "input files");
        options.addOption("o", "add", false, "Output file");
 
        CommandLineParser parser = new DefaultParser();
        CommandLine cmdLine = null;
 
        try {
            cmdLine = parser.parse(options, args);
        } catch (ParseException e) {

            return;
        }
 

 
        if (cmdLine.hasOption("input")) {
        	Merge merging = new Merge();
    		merging.run(args);
        }
        
        if (cmdLine.hasOption("output")) {
        	Merge merging = new Merge();
    		merging.run(args);
        }
    }
}
	
	