package com.ryanair.fun.atari.addressing

import com.ryanair.fun.atari.memory.MemoryMap
import com.ryanair.fun.atari.microprocessor.MOS6502

trait AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int

}

case class ImmediateMode() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    val programCounter = mos6502.programCounter
    mos6502.programCounter.increment()
    memoryMap.readPos(programCounter.currentPosition)
  }
}

case class ZeroPageMode() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    val programCounter = mos6502.programCounter
    programCounter.increment()
    memoryMap.readPos(programCounter.currentPosition) & 0x0F
  }
}

case class ZeroPageModeX() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    val programCounter = mos6502.programCounter
    programCounter.increment()
    memoryMap.readPos(programCounter.currentPosition) & 0x0F
  }
}

case class ZeroPageModeY() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    val programCounter = mos6502.programCounter
    programCounter.increment()
    memoryMap.readPos(programCounter.currentPosition) & 0x0F
  }
}

case class Absolute() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    val programCounter = mos6502.programCounter
    programCounter.increment()
    memoryMap.readPos(programCounter.currentPosition) & 0x0F
  }
}

case class AbsoluteX() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    val programCounter = mos6502.programCounter
    programCounter.increment()
    memoryMap.readPos(programCounter.currentPosition) & 0x0F
  }
}

case class AbsoluteY() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    val programCounter = mos6502.programCounter
    programCounter.increment()
    memoryMap.readPos(programCounter.currentPosition) & 0x0F
  }
}

case class IndirectX() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    val programCounter = mos6502.programCounter
    programCounter.increment()
    memoryMap.readPos(programCounter.currentPosition) & 0x0F
  }
}

case class IndirectY() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    val programCounter = mos6502.programCounter
    programCounter.increment()
    memoryMap.readPos(programCounter.currentPosition) & 0x0F
  }
}

case class ClearCarryMode() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    println("Do nothing yet")
    0
  }
}

case class SetDecimalMode() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    println("Do nothing yet")
    0
  }
}

case class ClearDecimalMode() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    println("Do nothing yet")
    0
  }
}

case class ClearOverflow() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    println("Do nothing yet")
    0
  }
}


case class SetInterruptMode() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    println("Do nothing yet")
    0
  }
}

case class ClearInterruptMode() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    println("Do nothing yet")
    0
  }
}

case class SetCarryMode() extends AddressingMode {

  def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    println("Do nothing yet")
    0
  }
}

case class TransferXToStackMode() extends AddressingMode{
  override def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    mos6502.IndexRegisters.loadStack(mos6502.IndexRegisters.getX)
    0
  }
}

case class TransferStackToXMode() extends AddressingMode{
  override def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    mos6502.IndexRegisters.loadX(mos6502.IndexRegisters.getStack)
    0
  }
}

case class PushAccumulatorMode() extends AddressingMode{
  override def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    0
  }
}

case class PullAccumulatorMode() extends AddressingMode{
  override def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    0
  }
}

case class PushProcessorStatusMode() extends AddressingMode{
  override def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    0
  }
}

case class PullProcessorStatusMode() extends AddressingMode{
  override def operand()(implicit mos6502: MOS6502, memoryMap: MemoryMap): Int = {
    0
  }
}
