package com.formationaloui.sfe.readers

import org.apache.spark.sql.{DataFrame, SparkSession}

object Parquet {

  def readParquet(path: String)(implicit spark: SparkSession): DataFrame = {
    spark
      .read
      .parquet(path)

  }

}
