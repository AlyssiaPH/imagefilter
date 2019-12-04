package com.chanoir.imagefilter;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;

import static org.bytedeco.opencv.global.opencv_imgproc.GaussianBlur;

public class Blur extends Filter {

    /**
     * Apply a blur on an image.
     * @param image The original image
     * @param size The size of the blur
     * @return the image with the blur effect
     */
    public static Mat filterBlur(Mat image, int size) {
        Mat result = image.clone();
        GaussianBlur(image, result, new Size(size, size), 0);
        return result;
    }
}

