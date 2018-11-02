package com.ryanair.fun.console

import java.io.File

class ReadRomOperation(file: File) {

  lazy val rom: Array[Int] = {
    val inputStreamReader = scala.io.Source.fromFile(file, "ISO-8859-1").reader()
    var content = scala.collection.mutable.ArrayBuffer.empty[Int]
    while (inputStreamReader.ready()) {
      content += inputStreamReader.read()
    }
    content.toArray
  }

}

object ReadRomOperation {

  def apply(file: File): ReadRomOperation = new ReadRomOperation(file)
}
