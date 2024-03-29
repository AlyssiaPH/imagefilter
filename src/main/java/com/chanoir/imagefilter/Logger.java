package com.chanoir.imagefilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Logger {

    /**
     * Complete the log with the current date and the sentence expected.
     * @param sentence The sentence we want to log
     */
    public static void logger(String sentence) {
        try {
            FileWriter myWriter = new FileWriter("access.log",true);
            myWriter.write("\n"+ LocalDateTime.now()+" : "+sentence);
            myWriter.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

