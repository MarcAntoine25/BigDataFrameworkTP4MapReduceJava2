package com.opstty.mapper;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class MapperOldest extends Mapper<Object, Text, NullWritable, Text> {

    public void map(Object key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        String[] splitted = line.split(";");
        if (!splitted[0].equals("GEOPOINT") && !splitted[1].equals("") && !splitted[5].equals("")){
            String specie = splitted[1];
            String height = splitted[5];
            context.write(NullWritable.get(), new Text(specie + ';' + height));
        }

    }

}