package com.opstty.mapper;


import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

public class MapperDistrict extends Mapper<Object, Text, Text, NullWritable> {
    private final static NullWritable nullw = NullWritable.get();
    private Text district = new Text();

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
            String line = value.toString();
            String[] splitted = line.split(";");
            if (!splitted[0].equals("GEOPOINT")){
                district.set(splitted[1]);
                context.write(district, nullw);
            }
        }
    }

