package com.opstty.reducer;

import junit.framework.TestCase;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.Arrays;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ReducerSpeciesTest  extends TestCase {
    @Mock
    private Reducer.Context context;
    private ReducerSpecies reducerSpecies;

    @Before
    public void setup(){ this.reducerSpecies = new ReducerSpecies(); }

    @Test
    public void testReduce() throws IOException, InterruptedException{
        String key = "petrea";
        NullWritable value = NullWritable.get();
        Iterable<NullWritable> values = Arrays.asList(value, value, value);
        this.reducerSpecies.reduce(new Text(key), values, this.context);
        verify(this.context).write(new Text(key), NullWritable.get());
    }
}
