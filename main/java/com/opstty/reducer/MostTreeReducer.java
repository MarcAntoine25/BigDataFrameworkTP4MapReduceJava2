package com.opstty.reducer;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class MostTreeReducer extends Reducer<NullWritable, Text, Text, NullWritable>{

    public void reduce(NullWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException
    {
        String districtMostTree = "";
        int maxNumberOfTree = 0;

        for(Text value : values)
        {
            String[] splitted = value.toString().split(";");
            String district = splitted[0];
            int numberOfTree = Integer.parseInt(splitted[1]);

            if(numberOfTree > maxNumberOfTree)
            {
                districtMostTree = district;
                maxNumberOfTree = numberOfTree;
            }
        }

        context.write(new Text(districtMostTree), NullWritable.get());
    }
}
