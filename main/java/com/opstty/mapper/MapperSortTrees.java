package com.opstty.mapper;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MapperSortTrees  extends Mapper<Object, Text,DoubleWritable, Text> {
    private Text specie = new Text();
    private DoubleWritable height = new DoubleWritable();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        String[] splitted = line.split(";");
        if (!splitted[0].equals("GEOPOINT") && !splitted[3].equals("") && !splitted[6].equals("")) {
            specie.set(splitted[3]);
            height.set(Double.parseDouble(splitted[6]));
            context.write(height,specie);
        }
    }
}