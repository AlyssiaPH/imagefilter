package com.chanoir.imagefilter;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import static org.bytedeco.opencv.global.opencv_imgproc.*;

public class JavaCVHelper {
    public Mat filterBlur(Mat image) {
        int size = 3;
        Mat result = image.clone();
        GaussianBlur(image, result, new Size(size, size), 0);
        return result;
    }

    public Mat filterDilate(Mat image) {
        int size = 8;
        Mat result = image.clone();
        Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
        dilate(image, result, element);
        return result;
    }

    public Mat filterGrayscale(Mat image) {
        Mat result = new Mat(image.rows(), image.cols(), CvType.CV_8UC3);
        cvtColor(image, result, Imgproc.COLOR_RGB2GRAY);
        return result;
    }
}
