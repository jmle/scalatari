package com.ryanair.fun.console

import java.nio.file.Paths

import org.scalatest.FlatSpec

class ReadRoomOperationTest extends FlatSpec {

  val file = Paths.get("/Users/cejudogomezf/workspaceSpare/scalatari/rom/", "heart_color.bin").toFile
  val readRoomOperation = ReadRomOperation(file)

  "ReadRomOperation " should "read the rom file" in {
    readRoomOperation.rom.foreach((i: Int) => println(i.toHexString))
  }

}
