package com.ryanair.fun.atari

import com.ryanair.fun.atari.addressing.AddressingMode
import com.ryanair.fun.atari.memory.MemoryMap
import com.ryanair.fun.atari.microprocessor.MOS6502
import com.ryanair.fun.atari.operation.InstructionExecutor

class Atari {

  private implicit val mos6502: MOS6502 = new MOS6502()

  implicit val memoryMap: MemoryMap = MemoryMap()

  def loadMemoryWith(heap: Array[Int]): Unit = memoryMap.load(heap)

  def printMemoryMap(): Unit = memoryMap.heap.map(_.toHexString).fold("")(_ + " " + _).toUpperCase.foreach(print)


  def executeNextCommand(): Unit = {
    val operationCode = memoryMap.readPos(mos6502.programCounter.currentPosition)

    val (operationType, addressMode) = operation.findOperation(operationCode) match {
      case Some((x, y)) => (x, y)
      case None => throw new RuntimeException(s"Operation code ${operationCode.toHexString} does not match any operation")
    }
    runInstruction(operationType, addressMode)

    mos6502.programCounter.increment()
  }

  private def runInstruction(executor: InstructionExecutor, addressMode: AddressingMode): Unit =
    executor.run(addressMode.operand())


  override def toString: String = {
    mos6502.toString
  }
}
