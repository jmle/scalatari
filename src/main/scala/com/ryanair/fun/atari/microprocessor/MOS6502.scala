package com.ryanair.fun.atari.microprocessor

class MOS6502 {

  object MainRegister {

    private var accumulator: Int = 0

    override def toString = s"{'accumulator' : '${accumulator}'}"

    def getAccumulator = accumulator

  }

  object IndexRegisters {

    private var xIndex: Int = 0
    private var yIndex = 0
    private var stackPointer: Int = 0

    def loadX(value: Int): Unit = xIndex = value

    def loadY(value: Int): Unit = yIndex = value

    def loadStack(value: Int): Unit = stackPointer = value

    def clearX: Int = {
      val currentX = xIndex
      xIndex = 0
      currentX
    }

    def clearY: Int = {
      val currentY = yIndex
      yIndex = 0
      currentY
    }

    def getX = xIndex

    def getY = yIndex

    def getStack = stackPointer

    override def toString =
      s"""indexRegisters : {
         |  {'x' : '${xIndex}'},
         |  {'y' : '${yIndex}'},
         |  {'stackPointer' : '${stackPointer}'}
         |}""".stripMargin

  }

  object ProgramCounter {
    private var counter: Int = 0

    def moveRelative(numberOfPositions: Int): Unit = counter + numberOfPositions

    def increment(): Unit = counter += 1

    def decrement(): Unit = counter -= 1

    def currentPosition: Int = counter

    override def toString = s"{'program counter' : '$counter'}"
  }

  object StatusRegister {
    private val processorFlags: Byte = 0x00

    override def toString = s"{'processor flag' : '$processorFlags'}"

  }

  val programCounter: ProgramCounter.type = this.ProgramCounter

  override def toString: String =
    Stream(ProgramCounter, MainRegister, IndexRegisters, StatusRegister).map(_.toString).mkString(",\n")


}

