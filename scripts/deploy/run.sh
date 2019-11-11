#!/usr/bin/env bash
spark-submit --class com.formationchoukatli.sfe.Main \
--master yarn \
--deploy-mode cluster \
--name SEP \
--queue SEP \
--num-executors 6 \
--executor-memory 2 \
--executor-cores 2 \
--driver-memory 2 \
sfe-1.0.0-SNAPSHOT-spark.jar

yarn logs --applicationId sparkApplicationId > log.txt