package com.chanoir.imagefilter;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import java.io.File;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;

public class Main {

    //public static File repertory = new File("ImageFile.java");

    public static void main(String[] args) {
        Mat image = imread("img/Donuuut.PNG");
        if("img" != null){
            Mat out = null;
            try {
                out = Blur.filterBlur(image,-41);
            }
            catch (BlurException e) {
                e.printStackTrace();
            }
            System.out.println("Next////////////");
            out = GrayScale.filterGrayscale(out);
            out = Dilate.filterDilate(out,17);
            imwrite("img_output/Donuuut2.PNG", out);
            System.out.println("Done");
        }
    }
}
