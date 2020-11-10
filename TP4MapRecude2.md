
# Tp MapReduce2 JAVA

## PELLERIN Tanguy & BOCK Marc-Antoine

### Copy the jar file on home
```bash
scp hadoop-examples-mapreduce-6.0-version-jar-with-dependencies.jar mbock@hadoop-edge01.efrei.online:
```
### 1.8.1 District containing trees
```bash
yarn jar hadoop-examples-mapreduce-6.0-version-jar-with-dependencies.jar DistrictCount /user/mbock/trees.csv /user/mbock/DistrictCount

20/11/10 12:41:25 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 12:41:34 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 12:41:39 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 12:41:39 INFO mapreduce.Job: Job job_1603290159664_3146 completed successfully
20/11/10 12:41:39 INFO mapreduce.Job: Counters: 53
	File System Counters
		FILE: Number of bytes read=84
		FILE: Number of bytes written=493297
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16778
		HDFS: Number of bytes written=44
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=19674
		Total time spent by all reduces in occupied slots (ms)=12164
		Total time spent by all map tasks (ms)=6558
		Total time spent by all reduce tasks (ms)=3041
		Total vcore-milliseconds taken by all map tasks=6558
		Total vcore-milliseconds taken by all reduce tasks=3041
		Total megabyte-milliseconds taken by all map tasks=10073088
		Total megabyte-milliseconds taken by all reduce tasks=6227968
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=277
		Map output materialized bytes=84
		Input split bytes=98
		Combine input records=97
		Combine output records=17
		Reduce input groups=17
		Reduce shuffle bytes=84
		Reduce input records=17
		Reduce output records=17
		Spilled Records=34
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=218
		CPU time spent (ms)=3350
		Physical memory (bytes) snapshot=1447165952
		Virtual memory (bytes) snapshot=7266996224
		Total committed heap usage (bytes)=1559756800
		Peak Map Physical memory (bytes)=1154449408
		Peak Map Virtual memory (bytes)=3393359872
		Peak Reduce Physical memory (bytes)=292716544
		Peak Reduce Virtual memory (bytes)=3873636352
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=16680
	File Output Format Counters 
		Bytes Written=44
```
```bash
hdfs dfs -cat DistrictCount/part-r-00000  

11
12
13
14
15
16
17
18
19
20
3
4
5
6
7
8
9
```
### 1.8.2 All existing species
```bash

yarn jar hadoop-examples-mapreduce-6.0-version-jar-with-dependencies.jar species /user/mbock/trees.csv /user/mbock/species

20/11/10 12:45:55 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 12:46:04 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 12:46:14 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 12:46:14 INFO mapreduce.Job: Job job_1603290159664_3150 completed successfully
20/11/10 12:46:14 INFO mapreduce.Job: Counters: 53
	File System Counters
		FILE: Number of bytes read=547
		FILE: Number of bytes written=494191
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16778
		HDFS: Number of bytes written=451
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=21420
		Total time spent by all reduces in occupied slots (ms)=28696
		Total time spent by all map tasks (ms)=7140
		Total time spent by all reduce tasks (ms)=7174
		Total vcore-milliseconds taken by all map tasks=7140
		Total vcore-milliseconds taken by all reduce tasks=7174
		Total megabyte-milliseconds taken by all map tasks=10967040
		Total megabyte-milliseconds taken by all reduce tasks=14692352
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=995
		Map output materialized bytes=547
		Input split bytes=98
		Combine input records=97
		Combine output records=45
		Reduce input groups=45
		Reduce shuffle bytes=547
		Reduce input records=45
		Reduce output records=45
		Spilled Records=90
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=189
		CPU time spent (ms)=3570
		Physical memory (bytes) snapshot=1458941952
		Virtual memory (bytes) snapshot=7268683776
		Total committed heap usage (bytes)=1560805376
		Peak Map Physical memory (bytes)=1161302016
		Peak Map Virtual memory (bytes)=3394093056
		Peak Reduce Physical memory (bytes)=297639936
		Peak Reduce Virtual memory (bytes)=3874590720
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=16680
	File Output Format Counters 
		Bytes Written=451

```

```bash

[mbock@hadoop-edge01 ~]$ hdfs dfs -cat species/part-r-00000
araucana
atlantica
australis
baccata
bignonioides
biloba
bungeana
cappadocicum
carpinifolia
colurna
coulteri
decurrens
dioicus
distichum
excelsior
fraxinifolia
giganteum
giraldii
glutinosa
grandiflora
hippocastanum
ilex
involucrata
japonicum
kaki
libanii
monspessulanum
nigra
nigra laricio
opalus
orientalis
papyrifera
petraea
pomifera
pseudoacacia
sempervirens
serrata
stenoptera
suber
sylvatica
tomentosa
tulipifera
ulmoides
virginiana
x acerifolia
```
### 1.8.3 Number Of trees by Species
```bash
yarn jar hadoop-examples-mapreduce-6.0-version-jar-with-dependencies.jar number_species /user/mbock/trees.csv /user/mbock/NumberOfSpecies

20/11/10 12:43:06 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 12:43:15 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 12:43:24 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 12:43:24 INFO mapreduce.Job: Job job_1603290159664_3147 completed successfully
20/11/10 12:43:24 INFO mapreduce.Job: Counters: 53
	File System Counters
		FILE: Number of bytes read=727
		FILE: Number of bytes written=494609
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16778
		HDFS: Number of bytes written=542
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=19848
		Total time spent by all reduces in occupied slots (ms)=27568
		Total time spent by all map tasks (ms)=6616
		Total time spent by all reduce tasks (ms)=6892
		Total vcore-milliseconds taken by all map tasks=6616
		Total vcore-milliseconds taken by all reduce tasks=6892
		Total megabyte-milliseconds taken by all map tasks=10162176
		Total megabyte-milliseconds taken by all reduce tasks=14114816
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=1383
		Map output materialized bytes=727
		Input split bytes=98
		Combine input records=97
		Combine output records=45
		Reduce input groups=45
		Reduce shuffle bytes=727
		Reduce input records=45
		Reduce output records=45
		Spilled Records=90
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=199
		CPU time spent (ms)=3600
		Physical memory (bytes) snapshot=1450815488
		Virtual memory (bytes) snapshot=7273664512
		Total committed heap usage (bytes)=1557659648
		Peak Map Physical memory (bytes)=1156308992
		Peak Map Virtual memory (bytes)=3397165056
		Peak Reduce Physical memory (bytes)=294506496
		Peak Reduce Virtual memory (bytes)=3876499456
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=16680
	File Output Format Counters 
		Bytes Written=542


```

```bash
[mbock@hadoop-edge01 ~]$ hdfs dfs -cat NumberOfSpecies/part-r-00000
araucana	1
atlantica	2
australis	1
baccata	2
bignonioides	1
biloba	5
bungeana	1
cappadocicum	1
carpinifolia	4
colurna	3
coulteri	1
decurrens	1
dioicus	1
distichum	3
excelsior	1
fraxinifolia	2
giganteum	5
giraldii	1
glutinosa	1
grandiflora	1
hippocastanum	3
ilex	1
involucrata	1
japonicum	1
kaki	2
libanii	2
monspessulanum	1
nigra	3
nigra laricio	1
opalus	1
orientalis	8
papyrifera	1
petraea	2
pomifera	1
pseudoacacia	1
sempervirens	1
serrata	1
stenoptera	1
suber	1
sylvatica	8
tomentosa	2
tulipifera	2
ulmoides	1
virginiana	2
x acerifolia	11
```


### 1.8.4 Max Height per specie of tree
```bash
yarn jar hadoop-examples-mapreduce-6.0-version-jar-with-dependencies.jar max_height /user/mbock/trees.csv /user/mbock/MaxHeight

20/11/10 12:28:35 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 12:28:44 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 12:28:53 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 12:28:54 INFO mapreduce.Job: Job job_1603290159664_3137 completed successfully
20/11/10 12:28:54 INFO mapreduce.Job: Counters: 53
	File System Counters
		FILE: Number of bytes read=907
		FILE: Number of bytes written=494937
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16778
		HDFS: Number of bytes written=675
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=20436
		Total time spent by all reduces in occupied slots (ms)=26452
		Total time spent by all map tasks (ms)=6812
		Total time spent by all reduce tasks (ms)=6613
		Total vcore-milliseconds taken by all map tasks=6812
		Total vcore-milliseconds taken by all reduce tasks=6613
		Total megabyte-milliseconds taken by all map tasks=10463232
		Total megabyte-milliseconds taken by all reduce tasks=13543424
	Map-Reduce Framework
		Map input records=98
		Map output records=96
		Map output bytes=1753
		Map output materialized bytes=907
		Input split bytes=98
		Combine input records=96
		Combine output records=45
		Reduce input groups=45
		Reduce shuffle bytes=907
		Reduce input records=45
		Reduce output records=45
		Spilled Records=90
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=189
		CPU time spent (ms)=3030
		Physical memory (bytes) snapshot=1454665728
		Virtual memory (bytes) snapshot=7270309888
		Total committed heap usage (bytes)=1541931008
		Peak Map Physical memory (bytes)=1159634944
		Peak Map Virtual memory (bytes)=3392892928
		Peak Reduce Physical memory (bytes)=295030784
		Peak Reduce Virtual memory (bytes)=3877416960
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=16680
	File Output Format Counters 
		Bytes Written=675

``

```bash

hdfs dfs -cat MaxHeight/part-r-00000

araucana	9.0
atlantica	25.0
australis	16.0
baccata	13.0
bignonioides	15.0
biloba	33.0
bungeana	10.0
cappadocicum	16.0
carpinifolia	30.0
colurna	20.0
coulteri	14.0
decurrens	20.0
dioicus	10.0
distichum	35.0
excelsior	30.0
fraxinifolia	27.0
giganteum	35.0
giraldii	35.0
glutinosa	16.0
grandiflora	12.0
hippocastanum	30.0
ilex	15.0
involucrata	12.0
japonicum	10.0
kaki	14.0
libanii	30.0
monspessulanum	12.0
nigra	30.0
nigra laricio	30.0
opalus	15.0
orientalis	34.0
papyrifera	12.0
petraea	31.0
pomifera	13.0
pseudoacacia	11.0
sempervirens	30.0
serrata	18.0
stenoptera	30.0
suber	10.0
sylvatica	30.0
tomentosa	20.0
tulipifera	35.0
ulmoides	12.0
virginiana	14.0
x acerifolia	45.0
```
### 1.8.5 Sort the trees Height from smallest to largest
```bash
yarn jar hadoop-examples-mapreduce-7.0-version-jar-with-dependencies.jar SortTree /user/mbock/trees.csv /user/mbock/SortTree


20/11/10 14:46:15 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 14:46:24 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 14:46:33 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 14:46:35 INFO mapreduce.Job: Job job_1603290159664_3225 completed successfully
20/11/10 14:46:35 INFO mapreduce.Job: Counters: 53
	File System Counters
		FILE: Number of bytes read=1951
		FILE: Number of bytes written=497025
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16778
		HDFS: Number of bytes written=1461
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=21339
		Total time spent by all reduces in occupied slots (ms)=26476
		Total time spent by all map tasks (ms)=7113
		Total time spent by all reduce tasks (ms)=6619
		Total vcore-milliseconds taken by all map tasks=7113
		Total vcore-milliseconds taken by all reduce tasks=6619
		Total megabyte-milliseconds taken by all map tasks=10925568
		Total megabyte-milliseconds taken by all reduce tasks=13555712
	Map-Reduce Framework
		Map input records=98
		Map output records=96
		Map output bytes=1753
		Map output materialized bytes=1951
		Input split bytes=98
		Combine input records=96
		Combine output records=96
		Reduce input groups=28
		Reduce shuffle bytes=1951
		Reduce input records=96
		Reduce output records=96
		Spilled Records=192
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=177
		CPU time spent (ms)=3250
		Physical memory (bytes) snapshot=1458737152
		Virtual memory (bytes) snapshot=7272230912
		Total committed heap usage (bytes)=1562378240
		Peak Map Physical memory (bytes)=1159720960
		Peak Map Virtual memory (bytes)=3397226496
		Peak Reduce Physical memory (bytes)=299016192
		Peak Reduce Virtual memory (bytes)=3875004416
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=16680
	File Output Format Counters 
		Bytes Written=1461
```

```bash
[mbock@hadoop-edge01 ~]$ hdfs dfs -cat SortTrees/part-r-00000
2.0	sylvatica
5.0	baccata
6.0	atlantica
9.0	araucana
10.0	japonicum
10.0	suber
10.0	bungeana
10.0	dioicus
10.0	sylvatica
11.0	pseudoacacia
12.0	virginiana
12.0	grandiflora
12.0	carpinifolia
12.0	ulmoides
12.0	monspessulanum
12.0	kaki
12.0	papyrifera
12.0	involucrata
13.0	baccata
13.0	pomifera
14.0	kaki
14.0	coulteri
14.0	virginiana
15.0	opalus
15.0	bignonioides
15.0	sylvatica
15.0	carpinifolia
15.0	ilex
16.0	glutinosa
16.0	cappadocicum
16.0	carpinifolia
16.0	australis
18.0	biloba
18.0	serrata
18.0	hippocastanum
18.0	sylvatica
20.0	colurna
20.0	x acerifolia
20.0	tomentosa
20.0	colurna
20.0	decurrens
20.0	colurna
20.0	orientalis
20.0	sylvatica
20.0	tomentosa
20.0	giganteum
20.0	distichum
20.0	orientalis
22.0	biloba
22.0	hippocastanum
22.0	orientalis
22.0	fraxinifolia
22.0	tulipifera
23.0	sylvatica
25.0	atlantica
25.0	biloba
25.0	x acerifolia
25.0	orientalis
25.0	nigra
25.0	biloba
26.0	orientalis
27.0	fraxinifolia
27.0	orientalis
28.0	nigra
30.0	nigra laricio
30.0	petraea
30.0	giganteum
30.0	stenoptera
30.0	carpinifolia
30.0	sempervirens
30.0	sylvatica
30.0	x acerifolia
30.0	distichum
30.0	x acerifolia
30.0	nigra
30.0	sylvatica
30.0	giganteum
30.0	excelsior
30.0	libanii
30.0	libanii
30.0	hippocastanum
31.0	petraea
31.0	orientalis
32.0	x acerifolia
33.0	biloba
34.0	orientalis
35.0	distichum
35.0	tulipifera
35.0	x acerifolia
35.0	giraldii
35.0	giganteum
40.0	x acerifolia
40.0	x acerifolia
40.0	x acerifolia
42.0	x acerifolia
45.0	x acerifolia
```

### 1.8.6 District containing the oldest tree
```bash

yarn jar hadoop-examples-mapreduce-7.0-version-jar-with-dependencies.jar oldestree /user/mbock/trees.csv /user/mbock/oldestree

20/11/10 18:22:01 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 18:22:10 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 18:22:20 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 18:22:21 INFO mapreduce.Job: Job job_1603290159664_3427 completed successfully
20/11/10 18:22:21 INFO mapreduce.Job: Counters: 53
	File System Counters
		FILE: Number of bytes read=764
		FILE: Number of bytes written=494255
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16778
		HDFS: Number of bytes written=2
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=21738
		Total time spent by all reduces in occupied slots (ms)=26276
		Total time spent by all map tasks (ms)=7246
		Total time spent by all reduce tasks (ms)=6569
		Total vcore-milliseconds taken by all map tasks=7246
		Total vcore-milliseconds taken by all reduce tasks=6569
		Total megabyte-milliseconds taken by all map tasks=11129856
		Total megabyte-milliseconds taken by all reduce tasks=13453312
	Map-Reduce Framework
		Map input records=98
		Map output records=77
		Map output bytes=604
		Map output materialized bytes=764
		Input split bytes=98
		Combine input records=0
		Combine output records=0
		Reduce input groups=1
		Reduce shuffle bytes=764
		Reduce input records=77
		Reduce output records=1
		Spilled Records=154
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=230
		CPU time spent (ms)=3450
		Physical memory (bytes) snapshot=1458724864
		Virtual memory (bytes) snapshot=7274307584
		Total committed heap usage (bytes)=1545601024
		Peak Map Physical memory (bytes)=1157140480
		Peak Map Virtual memory (bytes)=3394568192
		Peak Reduce Physical memory (bytes)=301584384
		Peak Reduce Virtual memory (bytes)=3879739392
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=16680
	File Output Format Counters 
		Bytes Written=2

```


```bash
hdfs dfs -cat oldestree/part-r-00000
5

```


### 1.8.7 District containing the most tree

```bash
yarn jar hadoop-examples-mapreduce-7.0-version-jar-with-dependencies.jar mosttrees /user/mbock/trees.csv /user/mbock/districtcount /user/mbock/mosttrees

20/11/10 21:17:14 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/10 21:17:14 INFO hdfs.DFSClient: Created token for mbock: HDFS_DELEGATION_TOKEN owner=mbock@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605039434240, maxDate=1605644234240, sequenceNumber=6116, masterKeyId=46 on ha-hdfs:efrei
20/11/10 21:17:14 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for mbock: HDFS_DELEGATION_TOKEN owner=mbock@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605039434240, maxDate=1605644234240, sequenceNumber=6116, masterKeyId=46)
20/11/10 21:17:14 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
20/11/10 21:17:14 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/mbock/.staging/job_1603290159664_3628
20/11/10 21:17:15 INFO input.FileInputFormat: Total input files to process : 1
20/11/10 21:17:15 INFO mapreduce.JobSubmitter: number of splits:1
20/11/10 21:17:15 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_3628
20/11/10 21:17:15 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for mbock: HDFS_DELEGATION_TOKEN owner=mbock@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605039434240, maxDate=1605644234240, sequenceNumber=6116, masterKeyId=46)]
20/11/10 21:17:15 INFO conf.Configuration: found resource resource-types.xml at file:/etc/hadoop/3.1.5.0-152/0/resource-types.xml
20/11/10 21:17:15 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/10 21:17:16 INFO impl.YarnClientImpl: Submitted application application_1603290159664_3628
20/11/10 21:17:16 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_3628/
20/11/10 21:17:16 INFO mapreduce.Job: Running job: job_1603290159664_3628
20/11/10 21:17:27 INFO mapreduce.Job: Job job_1603290159664_3628 running in uber mode : false
20/11/10 21:17:27 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 21:17:36 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 21:17:41 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 21:17:42 INFO mapreduce.Job: Job job_1603290159664_3628 completed successfully
20/11/10 21:17:42 INFO mapreduce.Job: Counters: 53
	File System Counters
		FILE: Number of bytes read=865
		FILE: Number of bytes written=494885
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=16778
		HDFS: Number of bytes written=80
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=22227
		Total time spent by all reduces in occupied slots (ms)=11836
		Total time spent by all map tasks (ms)=7409
		Total time spent by all reduce tasks (ms)=2959
		Total vcore-milliseconds taken by all map tasks=7409
		Total vcore-milliseconds taken by all reduce tasks=2959
		Total megabyte-milliseconds taken by all map tasks=11380224
		Total megabyte-milliseconds taken by all reduce tasks=6060032
	Map-Reduce Framework
		Map input records=98
		Map output records=97
		Map output bytes=665
		Map output materialized bytes=865
		Input split bytes=98
		Combine input records=0
		Combine output records=0
		Reduce input groups=17
		Reduce shuffle bytes=865
		Reduce input records=97
		Reduce output records=17
		Spilled Records=194
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=183
		CPU time spent (ms)=3150
		Physical memory (bytes) snapshot=1447571456
		Virtual memory (bytes) snapshot=7265955840
		Total committed heap usage (bytes)=1554513920
		Peak Map Physical memory (bytes)=1155624960
		Peak Map Virtual memory (bytes)=3393273856
		Peak Reduce Physical memory (bytes)=291946496
		Peak Reduce Virtual memory (bytes)=3872681984
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=16680
	File Output Format Counters 
		Bytes Written=80
20/11/10 21:17:42 INFO client.AHSProxy: Connecting to Application History server at hadoop-master03.efrei.online/163.172.100.24:10200
20/11/10 21:17:42 INFO hdfs.DFSClient: Created token for mbock: HDFS_DELEGATION_TOKEN owner=mbock@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605039462877, maxDate=1605644262877, sequenceNumber=6117, masterKeyId=46 on ha-hdfs:efrei
20/11/10 21:17:42 INFO security.TokenCache: Got dt for hdfs://efrei; Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for mbock: HDFS_DELEGATION_TOKEN owner=mbock@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605039462877, maxDate=1605644262877, sequenceNumber=6117, masterKeyId=46)
20/11/10 21:17:42 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
20/11/10 21:17:42 INFO mapreduce.JobResourceUploader: Disabling Erasure Coding for path: /user/mbock/.staging/job_1603290159664_3629
20/11/10 21:17:43 INFO input.FileInputFormat: Total input files to process : 1
20/11/10 21:17:43 INFO mapreduce.JobSubmitter: number of splits:1
20/11/10 21:17:43 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1603290159664_3629
20/11/10 21:17:43 INFO mapreduce.JobSubmitter: Executing with tokens: [Kind: HDFS_DELEGATION_TOKEN, Service: ha-hdfs:efrei, Ident: (token for mbock: HDFS_DELEGATION_TOKEN owner=mbock@EFREI.ONLINE, renewer=yarn, realUser=, issueDate=1605039462877, maxDate=1605644262877, sequenceNumber=6117, masterKeyId=46)]
20/11/10 21:17:43 INFO impl.TimelineClientImpl: Timeline service address: hadoop-master03.efrei.online:8190
20/11/10 21:17:44 INFO impl.YarnClientImpl: Submitted application application_1603290159664_3629
20/11/10 21:17:44 INFO mapreduce.Job: The url to track the job: https://hadoop-master01.efrei.online:8090/proxy/application_1603290159664_3629/
20/11/10 21:17:44 INFO mapreduce.Job: Running job: job_1603290159664_3629
20/11/10 21:17:54 INFO mapreduce.Job: Job job_1603290159664_3629 running in uber mode : false
20/11/10 21:17:54 INFO mapreduce.Job:  map 0% reduce 0%
20/11/10 21:18:04 INFO mapreduce.Job:  map 100% reduce 0%
20/11/10 21:18:09 INFO mapreduce.Job:  map 100% reduce 100%
20/11/10 21:18:09 INFO mapreduce.Job: Job job_1603290159664_3629 completed successfully
20/11/10 21:18:09 INFO mapreduce.Job: Counters: 53
	File System Counters
		FILE: Number of bytes read=120
		FILE: Number of bytes written=493415
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=195
		HDFS: Number of bytes written=3
		HDFS: Number of read operations=8
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=22008
		Total time spent by all reduces in occupied slots (ms)=11808
		Total time spent by all map tasks (ms)=7336
		Total time spent by all reduce tasks (ms)=2952
		Total vcore-milliseconds taken by all map tasks=7336
		Total vcore-milliseconds taken by all reduce tasks=2952
		Total megabyte-milliseconds taken by all map tasks=11268096
		Total megabyte-milliseconds taken by all reduce tasks=6045696
	Map-Reduce Framework
		Map input records=17
		Map output records=17
		Map output bytes=80
		Map output materialized bytes=120
		Input split bytes=115
		Combine input records=0
		Combine output records=0
		Reduce input groups=1
		Reduce shuffle bytes=120
		Reduce input records=17
		Reduce output records=1
		Spilled Records=34
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=176
		CPU time spent (ms)=3070
		Physical memory (bytes) snapshot=1450364928
		Virtual memory (bytes) snapshot=7267627008
		Total committed heap usage (bytes)=1543503872
		Peak Map Physical memory (bytes)=1157283840
		Peak Map Virtual memory (bytes)=3392917504
		Peak Reduce Physical memory (bytes)=293081088
		Peak Reduce Virtual memory (bytes)=3874709504
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=80
	File Output Format Counters 
		Bytes Written=3
```


```bash
[mbock@hadoop-edge01 ~]$ hdfs dfs -cat mosttrees/part-r-00000
16
```