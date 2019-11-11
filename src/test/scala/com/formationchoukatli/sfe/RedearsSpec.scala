package com.formationaloui.sfe

import com.holdenkarau.spark.testing.{DataFrameSuiteBase, SharedSparkContext}
import org.apache.spark.sql.DataFrame
import org.scalatest.FunSuite
import com.formationaloui.sfe.readers.Csv.readCsv
import com.formationaloui.sfe.readers.Parquet.readParquet


class RedearsSpec extends FunSuite with SharedSparkContext with DataFrameSuiteBase {

  test("read csv file") {
    val outputDf: DataFrame = readCsv("src/test/resources/ex.csv", ";")(spark)
    assert(outputDf.select("value").first().getDouble(0) === 3.75)
  }

  test("read tsv file") {
    val outputDf: DataFrame = readCsv("src/test/resources/ex.tsv", "|")(spark)
    assert(outputDf.select("value").first().getDouble(0) === 3.75)
  }

  test("read parquet file") {
    val outputDf: DataFrame = readParquet("src/test/resources/ex.parquet")(spark)
    assert(outputDf.select("first_name").first().getString(0) === "Amanda")
  }

}
