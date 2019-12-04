package com.chanoir.imagefilter;

import org.bytedeco.opencv.opencv_core.Mat;
import java.io.File;
import java.util.ArrayList;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;

public class Main {

    public static File repertory = new File("img");

    public static void main(String[] args) {

        ArrayList<File> fileslist = new ArrayList();

        for (File f : repertory.listFiles()) {
            Mat img = imread(f.getAbsolutePath());
            if ("img" != null) {
                try {
                    img = Blur.filterBlur(img, 45);
                    img = GrayScale.filterGrayscale(img);
                    img = Dilate.filterDilate(img, 10);
                } catch (FilterException e) {
                    e.printStackTrace();
                }

                img = img;
                imwrite("img_output/img.jpg", img);
                System.out.println("///Done///");
            }
        }
    }
}
