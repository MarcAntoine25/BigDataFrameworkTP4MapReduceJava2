package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DistrictCountMapper extends Mapper<Object, Text, Text, IntWritable> {
    private Text ditrict = new Text();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        String[] splitted = line.split(";");
        if (!splitted[0].equals("GEOPOINT")){
            ditrict.set(splitted[1]);
            context.write(ditrict, new IntWritable(1));
        }
    }
}