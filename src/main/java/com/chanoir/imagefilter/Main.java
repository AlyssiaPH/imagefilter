package com.chanoir.imagefilter;

import org.apache.commons.cli.*;
import org.bytedeco.opencv.opencv_core.Mat;
import java.io.File;
import java.util.ArrayList;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;

public class Main {

    public static File repertoryOut = new File("img_output");
    public static File repertory = new File("img");

    public static void main(String[] args) {

        Logger.logger("-----App started-----");


        ArrayList<File> fileslist = new ArrayList<>();
        File outputDir = new File("img_output");
        outputDir.mkdirs();

        for (File f : repertory.listFiles()) {
            if (!f.getName().endsWith(".PNG") && !f.getName().endsWith(".jpg") && !f.getName().endsWith(".jpeg") ) {
                continue;
            }

            System.out.println(f);
            Mat img = imread(f.getAbsolutePath());
            Logger.logger("Start edition of : "+f.getName());
            if (img != null) {
                try {
                    img = Blur.filterBlur(img, 45);
                    img = GrayScale.filterGrayscale(img);
                    img = Dilate.filterDilate(img, 10);
                } catch (FilterException e) {
                    Logger.logger("Filter exception, filters not apply.");
                    e.printStackTrace();
                }

                File outputFile = new File(outputDir, f.getName());
                imwrite(outputFile.getAbsolutePath(), img);
                System.out.println("///Done///");
            }
        }
    }
}
