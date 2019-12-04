package com.chanoir.imagefilter;

import org.bytedeco.libfreenect._freenect_context;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;

public class Main {

    public static File repertory = new File("img");

    public static void main(String[] args) {

        ArrayList<File> fileslist = new ArrayList();

        for(File f : repertory.listFiles()) {
            Mat img = imread(f.getAbsolutePath());
            if("img" != null){
                try {
                    img = Blur.filterBlur(img,75);
                    img = GrayScale.filterGrayscale(img);
                    img = Dilate.filterDilate(img,10);
                }
                catch (FilterException e) {
                    e.printStackTrace();
                }
                imwrite("img_output/img.jpg", img);
                System.out.println("///Done///");
        }
/*
        Mat img = imread("img/KFC.jpg");
        if("img" != null){
            try {
                img = Blur.filterBlur(img,74);
                img = GrayScale.filterGrayscale(img);
                img = Dilate.filterDilate(img,10);
            }
            catch (FilterException e) {
                e.printStackTrace();
            }
            imwrite("img_output/img.jpg", img);
            System.out.println("///Done///");    */
        }
    }
}
