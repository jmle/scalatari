package com.ryanair.fun.atari.microprocessor

class MOS6502 {

  object MainRegister {
    private var accumulator: Int = 0
  }

  object IndexRegisters {
    private var xIndex: Int = 0
    private var yIndex = 0
    private var stackPointer: Int = 0
  }

  object ProgramCounter {
    private var counter: Int = 0

    def moveRelative(numberOfPositions: Int): Unit = counter + numberOfPositions

    def increment(): Unit = counter += 1

    def decrement(): Unit = counter -= 1

    def currentPosition: Int = counter
  }

  object StatusRegister {
    private val processorFlags: Byte = 0x00
  }

  val programCounter: ProgramCounter.type = this.ProgramCounter

}

