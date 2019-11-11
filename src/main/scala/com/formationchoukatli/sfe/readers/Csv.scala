package com.formationaloui.sfe.readers

import org.apache.spark.sql.{DataFrame, SparkSession}

object Csv {

  def readCsv(path: String, sep: String)(implicit spark: SparkSession): DataFrame = {
    spark
      .read
      .option("sep", sep)
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(path)

  }

}
