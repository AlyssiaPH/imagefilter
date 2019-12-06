package com.chanoir.imagefilter;

import org.apache.commons.cli.*;
import org.bytedeco.opencv.opencv_core.Mat;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;

public class Main {

    public static File repertoryOut = new File("img_output");
    public static File repertory = new File("img");

    public static void main(String[] args) {

        Logger.logger("-----App started-----");

        try {
            ImageFilterCli.parser(args);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
