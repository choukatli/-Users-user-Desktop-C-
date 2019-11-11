package com.formationaloui.sfe

import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}
import com.formationaloui.sfe.readers.Csv.readCsv
import com.formationaloui.sfe.functions.DataFrameFunctions.{selectColumns, filterDF}
import com.formationaloui.sfe.Save._

import scala.util.{Failure, Success, Try}

object Main {

  def main(args: Array[String]): Unit = {

    implicit val spark: SparkSession = SparkSession
      .builder()
      .config("spark.sql.hive.convertMetastoreParquet", "false")
      .master("local")
      //.enableHiveSupport()
      .getOrCreate()

    // args
    //val csvPath = args(0)
    val FORMAT = "parquet"
    val database = "database"
    val table = "table"
    val cols: List[String] = List("year", "house", "value")

    // read CSV
    val csvDF: Try[DataFrame] = Try(readCsv("src/test/resources/ex.csv", ";"))

    // save as parquet hive table
    csvDF match {
      case Success(df) =>
        df.show()

        // select
        val dfWithSpecificColumns: DataFrame = selectColumns(df, cols)
        dfWithSpecificColumns.show()

        // filter
        val dfFiltred = filterDF(dfWithSpecificColumns)
        dfFiltred.show()

        // save
        saveParquet(dfFiltred, "../resultat", 1, SaveMode.Overwrite)
      case Failure(e) =>
        throw new Exception(s"Cannot read Dataframe.\n For more details: $e")
    }


    // Stop spark
    spark.stop()
  }

}