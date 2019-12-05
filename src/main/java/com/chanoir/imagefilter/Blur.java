package com.chanoir.imagefilter;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import static org.bytedeco.opencv.global.opencv_imgproc.GaussianBlur;

public class Blur extends Filter {
    /**
     * Apply a blur on an image.
     *
     * @param image The original image
     * @param size  The size of the blur
     * @return the image with the blur effect
     */
    public static Mat filterBlur(Mat image, int size) throws FilterException {
        if (size %2 == 0 || size<0){
            Logger.logger("Filter error : the dilate size need to be superior at 0 and odd.");
            throw new FilterException("The blur size need to be odd and >0.");
        }
        else {
            Mat result = image.clone();
            GaussianBlur(image, result, new Size(size, size), 0);
            Logger.logger("Apply blur to the image.");
            return result;
        }
    }
}

