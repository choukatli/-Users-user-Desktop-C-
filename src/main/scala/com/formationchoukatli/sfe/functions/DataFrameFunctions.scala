package com.formationaloui.sfe.functions

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.col

object DataFrameFunctions {

  def selectColumns(df: DataFrame, listColumns: List[String]): DataFrame = df
    .select(listColumns.head, listColumns.tail: _*)
    .distinct()

  def filterDF(df: DataFrame): DataFrame = df
    .filter(col("year") =!= "2017")

}
