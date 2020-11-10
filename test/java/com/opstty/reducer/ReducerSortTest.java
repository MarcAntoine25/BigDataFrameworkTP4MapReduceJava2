
package com.opstty.reducer;
// Reducer working but we don't finish the all test until 1.8.5 to 1.8,7
/*
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

public class ReducerSortTest extends TestCase {
    @Mock
    private Reducer.Context context;
    private ReducerSortTrees reducerSortTrees;

    @Before
    public void setup(){this.reducerSortTrees = new ReducerSortTrees();}

    @Test
    public void testReduce() throws IOException, InterruptedException {
        //String key = "pomifera";
        Double key = 13.0;
        Text valueText = new Text("pomifera");
        Iterable<Text> values = Arrays.asList(valueText, valueText, valueText);
        this.reducerSortTrees.reduce(new DoubleWritable(key), values, this.context);
        verify(this.context).write(new DoubleWritable(13.0),valueText);
    }
}
*/