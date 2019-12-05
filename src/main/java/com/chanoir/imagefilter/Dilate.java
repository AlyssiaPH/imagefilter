package com.chanoir.imagefilter;

import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Size;
import org.opencv.imgproc.Imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.dilate;
import static org.bytedeco.opencv.global.opencv_imgproc.getStructuringElement;

public class Dilate extends Filter {
    /**
     * Dilate an image.
     * @param image The original image
     * @param size The size of the blur
     * @return the image dilated
     */
    public static Mat filterDilate(Mat image, int size) throws FilterException {
        if (size<0){
            Logger.logger("Filter error : the dilate size need to be superior at 0.");
            throw new FilterException("The size must need to be superior at 0.");
        }
        else {
            Mat result = image.clone();
            Mat element = getStructuringElement(Imgproc.MORPH_RECT, new Size(2 * size + 1, 2 * size + 1));
            dilate(image, result, element);
            Logger.logger("Dilate filter apply to the image.");
            return result;
        }
    }
}