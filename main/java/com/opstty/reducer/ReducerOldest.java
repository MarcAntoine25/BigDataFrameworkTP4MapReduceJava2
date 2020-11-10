package com.opstty.reducer;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ReducerOldest extends Reducer<NullWritable, Text, Text, NullWritable> {

    public void reduce(NullWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        String oldestTreeDistrict = "";
        int oldestTree = 2020;

        for (Text value : values) {
            String[] splitted = value.toString().split(";");
            String district = splitted[0];
            int treeAge = Integer.parseInt(splitted[1]);

            if (treeAge < oldestTree) {
                oldestTreeDistrict = district;
                oldestTree = treeAge;
            }
        }

        context.write(new Text(oldestTreeDistrict), NullWritable.get());
    }
}

