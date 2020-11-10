package com.opstty.job;

import com.opstty.mapper.DistrictCountMapper;
import com.opstty.mapper.DistrictMostTreeMapper;
import com.opstty.reducer.IntSumReducer;
import com.opstty.reducer.MostTreeReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class DistrictMaxTrees {
    public static void main(String[] args) throws Exception {
        Configuration conf1 = new Configuration();

        Job job1 = Job.getInstance(conf1, "Districtcount");
        job1.setJarByClass(DistrictMaxTrees.class);

        job1.setMapperClass(DistrictCountMapper.class);
        job1.setReducerClass(IntSumReducer.class);

        job1.setMapOutputKeyClass(Text.class);
        job1.setMapOutputValueClass(IntWritable.class);
        job1.setOutputKeyClass(Text.class);
        job1.setOutputValueClass(IntWritable.class);

        FileInputFormat.addInputPath(job1, new Path(args[0]));
        FileOutputFormat.setOutputPath(job1, new Path(args[1]));
        job1.waitForCompletion(true);


        Configuration conf2 = new Configuration();
        Job job2 = Job.getInstance(conf2, "mosttreedistrict");
        job2.setJarByClass(DistrictMaxTrees.class);
        job2.setMapperClass(DistrictMostTreeMapper.class);
        job2.setReducerClass(MostTreeReducer.class);

        job2.setMapOutputKeyClass(NullWritable.class);
        job2.setMapOutputValueClass(Text.class);
        job2.setOutputKeyClass(Text.class);
        job2.setOutputValueClass(NullWritable.class);

        FileInputFormat.addInputPath(job2, new Path(args[1]));
        FileOutputFormat.setOutputPath(job2, new Path(args[2]));

        System.exit(job2.waitForCompletion(true) ? 0 : 1);
    }
}
