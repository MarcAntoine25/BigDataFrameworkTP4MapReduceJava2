package com.opstty;

import com.opstty.job.*;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");
            programDriver.addClass("DistrictCount", DistrictCount.class,
                    "A map/reduce program that counts the rounding in the trees csv files.");
            programDriver.addClass("species", Species.class,
                    "A map/reduce program that counts a list of different trees species .");
            programDriver.addClass("number_species", NumberSpecie.class,
                    "A map/reduce program that counts the number of species trees  .");
            programDriver.addClass("max_height", MaxHeight.class,
                    "A map/reduce program get max height trees");
            programDriver.addClass("sort_trees", SortTrees.class,
                    "A map/reduce program that sort the trees to smallest and largest height in the trees csv files.");
            programDriver.addClass("oldestree", OldestTree.class,
                    "A map/reduce program that give the oldest tree in the trees csv files.");
            programDriver.addClass("mosttrees", DistrictMaxTrees.class,
                    "Used to get the district with the most trees");

            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
