package com.chanoir.imagefilter;

import javafx.scene.effect.GaussianBlur;
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
            Mat out = Blur.filterBlur(image,17);
            imwrite("img_output/Donuuut2.PNG", out);
            System.out.println("Done");
        }
    }
}
