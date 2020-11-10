package com.opstty.reducer;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class ReducerSortTrees extends Reducer<Text, DoubleWritable,DoubleWritable, Text> {
    private DoubleWritable result = new DoubleWritable();

    public void reduce(DoubleWritable key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {

        for (Text val : values) {
            context.write(key, val);
        }
    }
}