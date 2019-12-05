package com.chanoir.imagefilter;

import org.apache.commons.cli.*;
import org.bytedeco.opencv.opencv_core.Mat;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.bytedeco.opencv.global.opencv_imgcodecs.imread;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;

public class imageFilterCli {


    private static Options configFirstParameters(){

        final Option helpFileOption = Option.builder("h")
                .longOpt("help")
                .desc("usage: imagefilter\n" +
                        "-h,----help\n" +
                        "-i,--input-dir <directory> \n -o,--output-dir <directory>"
                        )
                .build();

        final Options firstOptions = new Options();
        firstOptions.addOption(helpFileOption);
        return firstOptions;
    }

    private static Options configParameters(final Options firstOptions){

        final Option imagesInput = Option.builder("id")
                .longOpt("input-dir")
                .desc("Dossier avec les images sur lesquelles appliquer un filtre ")
                .hasArg(true)
                .argName("input-dir")
                .required(true)
                .build() ;

        final Option imagesOutput = Option.builder("od")
                .longOpt("output-dir")
                .desc("Dossier avec les images qui ont été filtrées")
                .hasArg(true)
                .argName("output-dir")
                .required(true)
                .build() ;

        final Option filter = Option.builder("f")
                .longOpt("filters")
                .desc("filtre à appliquer ")
                .hasArg(true)
                .argName("filters")
                .required(true)
                .build() ;

        final Options options = new Options() ;

        for (final Option fo : firstOptions.getOptions()) {
            options.addOption(fo);
            }

        options.addOption(imagesInput);
        options.addOption(imagesOutput);
        options.addOption(filter);

        return options ;
    }


    public static void parser(String[] args) throws ParseException {

        final Options firstOptions = configFirstParameters();
        final Options options = configParameters(firstOptions);

        final CommandLineParser parser1 = new DefaultParser();
        final CommandLine firstLine = parser1.parse(firstOptions, args, true);

        final CommandLineParser parser2 = new DefaultParser();
        final CommandLine line = parser2.parse(options, args);

        final String inputDirectory = line.getOptionValue("input-dir","");
        final String outputDirectory = line.getOptionValue("output-dir","");

        final String filters = line.getOptionValue("filters","");

        System.out.println(inputDirectory);
        System.out.println(outputDirectory);
        System.out.println(filters);

        boolean helpMode = firstLine.hasOption("help");
        if (helpMode) {
            final HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("imageFilterCli", options, true);
            System.exit(0);

            //

        }

        //Apply filters depending of the inputs.

        File repertoryOut = new File(outputDirectory);
        File repertory = new File(inputDirectory);

        ArrayList<File> fileslist = new ArrayList<>();
        File outputDir = new File("img_output");
        outputDir.mkdirs();

        for (File f : repertory.listFiles()) {
            if (!f.getName().endsWith(".PNG") && !f.getName().endsWith(".jpg") && !f.getName().endsWith(".jpeg") && !f.getName().endsWith(".png")) {
                continue;
            }
            Mat img = imread(f.getAbsolutePath());
            Logger.logger("Start edition of : "+f.getName());

            String[] filterslist = filters.split(Pattern.quote("|"));
            System.out.println(filterslist);
            if (img != null) {
            for (String filter : filterslist) {

                String[] filterinfo = filter.split(":");
                int size=1;
                if (filterinfo.length>1){
                    size =(int) Integer.parseInt(filterinfo[1]);
                }
                String filt = filterinfo[0];
                System.out.println("Process///////"+ filt);
                try {
                    switch (filt){
                        case ("blur"):
                            img = Blur.filterBlur(img, size);
                            break;
                        case ("grayscales"):
                            img = GrayScale.filterGrayscale(img);
                            break;
                         case ("dilate"):
                             img = Dilate.filterDilate(img, size);
                    }
                }
                catch (FilterException e) {
                    Logger.logger("Filter exception, filters not apply.");
                    e.printStackTrace();
                }

            }

            String filter=null;


                File outputFile = new File(outputDir, f.getName());
                imwrite(outputFile.getAbsolutePath(), img);
                Logger.logger("Finish edition of : "+f.getName());
                System.out.println("///Done///"+f.getName());
            }
        }
    }








}



