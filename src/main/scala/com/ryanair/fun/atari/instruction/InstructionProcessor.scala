package com.ryanair.fun.atari.instruction

import com.ryanair.fun.atari.memory.MemoryMap

class InstructionProcessor(implicit memoryMap: MemoryMap) {

  def init() = ???


  def commandAt(operationCode: Int) : Int= {
    findInstructionByOperationCode(operationCode)
    2
  }

  def stop() = ???

}

object InstructionProcessor {

  def apply(memoryMap: MemoryMap): InstructionProcessor = new InstructionProcessor()(memoryMap)

}
