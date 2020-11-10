package com.opstty.mapper;

import junitparams.FileParameters;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)

public class MapperDistrictTest {
    @Mock
    private Mapper.Context context;
    private MapperDistrict mapperDistrict;

    @Before
    public void setup() {
        this.mapperDistrict = new MapperDistrict();
    }

    @Test
    @FileParameters(value = "src/test/resources/data/trees.csv")
    public void testMap() throws IOException, InterruptedException {
        String value = "(48.8685686134, 2.31331809304);8;Calocedrus;decurrens;Cupressaceae;1854;20.0;195.0;Cours-la-Reine, avenue Franklin-D.-Roosevelt, avenue Matignon, avenue Gabriel;Cèdre à encens;;11;Jardin des Champs Elysées";

        this.mapperDistrict.map(null, new Text(value), this.context);
        verify(this.context, times(1))
                .write(new Text("8"), NullWritable.get());

    }
}
