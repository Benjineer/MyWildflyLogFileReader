/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logfilereader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author DATA INFOSEC
 */
public class LogFileReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        //specify path of log file drive
        Path path = new File("C:\\Users\\DATA INFOSEC\\Documents\\server.log").toPath();
        //read log file
        List<String> lines = Files.readAllLines(path);

        /*Covert List of lines to Stack to make it 
        readable from the bottom to the top of the log file*/
        Stack<String> all = new Stack<>();
        int count = 0;
        for (String line : lines) {
            count++;
            //add the line number to each read line before adding to the stack.
            all.add("Line: " + count + "  " + line);
        }

        //check and print out the last line in the file to ensure the log is inverted i.e being read from the bottom
        String lastOne = all.peek();
        System.out.println(lastOne);

        //find the first appearance of keyword "caused by" in the log file and printout the line
        while (!all.isEmpty()) {
            String one = all.pop();
            if (one.contains("Caused by")) {
                System.out.println(one);
                break;
            }

        }
    }

}
