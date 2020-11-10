package com.opstty.reducer;

import junit.framework.TestCase;
import org.apache.hadoop.io.DoubleWritable;
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

public class ReducerMaxHeightTest extends TestCase {
    @Mock
    private Reducer.Context context;
    private ReducerMaxHeight reducerMaxHeight;

    @Before
    public void setup(){this.reducerMaxHeight = new ReducerMaxHeight();}

    @Test
    public void testReduce() throws IOException, InterruptedException {
        String key = "pomifera";
        DoubleWritable value = new DoubleWritable(13.0);
        Iterable<DoubleWritable> values = Arrays.asList(value, value, value);
        this.reducerMaxHeight.reduce(new Text(key), values, this.context);
        verify(this.context).write(new Text(key), new DoubleWritable(13.0));
    }
}
