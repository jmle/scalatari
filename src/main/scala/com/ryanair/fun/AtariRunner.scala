package com.ryanair.fun

import java.nio.file.Paths

import com.ryanair.fun.atari.Atari
import com.ryanair.fun.console.ReadRomOperation

object AtariRunner extends App {

  val atari : Atari = new Atari()
  atari.loadMemoryWith {
    ReadRomOperation.apply(Paths.get("/home/francisco/workspaces/scalatari/rom/heart_color.bin").toFile).rom
  }

  atari.printMemoryMap()

  for(i <- 0  to 10) {
    atari.executeNextCommand()
  }

}
