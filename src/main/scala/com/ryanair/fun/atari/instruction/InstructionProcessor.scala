package com.ryanair.fun.atari.instruction

class InstructionProcessor(val memoryMap: Array[Int]) {

  def init() = ???


  def stop() = ???

}

object InstructionProcessor {

  def apply(memoryMap: Array[Int]): InstructionProcessor = new InstructionProcessor(memoryMap)

}
