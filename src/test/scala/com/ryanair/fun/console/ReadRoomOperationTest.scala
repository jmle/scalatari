package com.ryanair.fun.console

import java.io.File
import java.nio.file.Paths

import org.scalatest.FlatSpec

class ReadRoomOperationTest extends FlatSpec {

  val resource: String = "/rom/heart_color.bin"
  val file : File = Paths.get(getClass.getResource(resource).toURI).toFile

  "ReadRomOperation " should "read the rom file" in {
    val readRoomOperation = ReadRomOperation(file)
    readRoomOperation.rom.foreach((i: Int) => println(i.toHexString))
  }

}
