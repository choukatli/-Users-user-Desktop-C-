package com.formationaloui.sfe

import org.apache.spark.sql.{DataFrame, SaveMode}

object Save {

  def saveCsv(df: DataFrame,
              path: String,
              repartition: Int,
              sep: String,
              mode: SaveMode): Unit = df
    .repartition(repartition)
    .write
    .option("header", "true")
    .option("sep", sep)
    .mode(mode)
    .csv(path)

  def saveParquet(df: DataFrame,
                  path: String,
                  repartition: Int,
                  mode: SaveMode): Unit = df
    .repartition(repartition)
    .write
    .format("parquet")
    .mode(mode)
    .save(path)

  def saveHiveTable(df: DataFrame, database: String, table: String, mode: SaveMode, format: String): Unit = df
    .write
    .mode(mode)
    .format(format)
    .saveAsTable(s"$database.$table")

}
