package com.ryanair.fun

import java.io.File
import java.nio.file.Paths

import com.ryanair.fun.atari.Atari
import com.ryanair.fun.console.ReadRomOperation

object AtariRunner extends App {

  val resource: String = "/rom/asymmetrical.bin"
  val file : File = Paths.get(getClass.getResource(resource).toURI).toFile
  val atari : Atari = new Atari()
  atari.loadMemoryWith {
    ReadRomOperation.apply(file).rom
  }

  atari.printMemoryMap()

  for(i <- 0  to 10) {
    atari.executeNextCommand()
//    println(atari.toString)
  }


}
