# BigDataFrameworkTP4MapReduceJava2

## Project Made by Pellerin Tanguy and BOCK Marc-Antoine

### 1.8 Remarkable trees of Paris
You are going to write some MapReduce jobs on the remarkable trees of Paris using this dataset :
https://github.com/makayel/hadoop-examples-mapreduce/blob/main/src/test/resources/data/trees.csv

Path dataset:
BigDataFrameworkTP4MapReduceJava2/test/resources/data/trees.csv

We have assigned each java class to its question.

### Wordcount 
#### Main:
Mapper:
TokenizerMapper.java

Reducer:
IntSumReducer.java

#### Test:
Mapper:
TokenizerMapperTest.java

Reducer:
IntSumReducerTest.java

### 1.8.1 Districts containing trees (very easy)
#### Main:
Mapper:
MapperDistrict.java

Reducer:
ReducerDistrict.java

#### Test:
Mapper:
MapperDistrictTest.java

Reducer:
ReducerDistrictTest.java

### 1.8.2 Show all existing species (very easy)
#### Main:
Mapper:
MapperSpecies.java
Reducer:
ReducerSpecies.java

#### Test:
Mapper:
MapperSpeciesTest.java

Reducer:
ReducerSpeciesTest.java

### 1.8.3 Number of trees by species (easy)
#### Main:
Mapper:
MapperNumberSpecie.java

Reducer:
ReducerNumberSpecie.java

#### Test:
Mapper:
MapperNumberSpecieTest.java

Reducer:
ReducerNumberSpecieTest.java

### 1.8.4 Maximum height per specie of tree (average)
#### Main:
Mapper:
MapperMaxHeight.java

Reducer:
ReducerMaxHeight.java

#### Test:
Mapper:
MapperMaxHeightTest.java

Reducer:
ReducerMaxHeightTest.java

### 1.8.5 Sort the trees height from smallest to largest (average)
#### Main:
Mapper:
MapperSortTrees.java

Reducer:
ReducerSortTrees.java

#### Test:
Mapper:
MapperSortTest.java

Reducer:
ReducerSortTest.java

### 1.8.6 District containing the oldest tree (difficult)
#### Main:
Mapper:
MapperOldest.java

Reducer:
ReducerOldest.java

### 1.8.7 District containing the most trees (very difficult)
#### Main:
Mappers:
DistrictMostTreeMapper.java
DistrictCountMapper.java

Reducer:
MostTreeReducer.java
