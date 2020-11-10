package com.opstty.mapper;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class DistrictMostTreeMapper extends Mapper<Object, Text, NullWritable, Text> {

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {

        String[] splitted = value.toString().split("\t");

        context.write(NullWritable.get(), new Text(splitted[0]+";"+ splitted [1]));
    }

}
