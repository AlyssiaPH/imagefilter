package com.chanoir.imagefilter;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import java.io.File;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;

public class Main {

    //public static File repertory = new File("ImageFile.java");

    public static void main(String[] args) {
        Mat img = imread("img/KFC.jpg");
        if("img" != null){
            try {
                img = Blur.filterBlur(img,79);
            }
            catch (BlurException e) {
                e.printStackTrace();
            }
            img = GrayScale.filterGrayscale(img);
            try {
                img = Dilate.filterDilate(img,6);
            } catch (DilateException e) {
                e.printStackTrace();
            }
            img = img;
            imwrite("img_output/img.jpg", img);
            System.out.println("Done");
        }
    }
}
