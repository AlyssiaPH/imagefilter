package com.chanoir.imagefilter;

import org.bytedeco.opencv.opencv_core.Mat;
import org.opencv.core.CvType;
import org.opencv.imgproc.Imgproc;

import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;

public class GrayScale extends Filter {

    /**
     * Turn an image in grayscales
     * @param image the original image
     * @return the image in grayscales
     */
    public static Mat filterGrayscale(Mat image) {
        Mat result = new Mat(image.rows(), image.cols(), CvType.CV_8UC3);
        cvtColor(image, result, Imgproc.COLOR_RGB2GRAY);
        Logger.logger("Image transform in grayscales.");
        return result;
    }
}
