package com.ryanair.fun.atari.operation

import com.ryanair.fun.atari.microprocessor.MOS6502

trait InstructionExecutor {

  def run(operand: Int)(implicit mos6502: MOS6502): Unit
}

case class AddWithCarry() extends InstructionExecutor {

  def run(operand: Int)(implicit mos6502: MOS6502): Unit =
    println(s"add with carry")
}

case class AndWithAccumulator() extends InstructionExecutor {

  def run(operand: Int)(implicit mos6502: MOS6502): Unit =
    println(s"and with accumulator")
}

case class ArithmeticShiftLeft() extends InstructionExecutor {

  def run(operand: Int)(implicit mos6502: MOS6502): Unit =
    println(s"arithmetic shift left")
}

case class TestBit() extends InstructionExecutor {

  def run(operand: Int)(implicit mos6502: MOS6502): Unit =
    println(s"Test Bit")
}

case class ProcessorStatus() extends InstructionExecutor {

  def run(operand: Int)(implicit mos6502: MOS6502): Unit =
    println(s"Processor Status")
}

case class LoadRegisterX() extends InstructionExecutor {

  def run(operand: Int)(implicit mos6502: MOS6502): Unit = {
    println(s"Load X register")
    mos6502.IndexRegisters.loadX(operand)
  }
}

case class LoadAccumulatorInstruction() extends InstructionExecutor {

  def run(operand: Int)(implicit mos6502: MOS6502): Unit = {
    println(s"Load Accumulator")
    mos6502.MainRegister.getAccumulator
  }
}

case class StackInstruction() extends InstructionExecutor {

  override def run(operand: Int)(implicit mos6502: MOS6502): Unit = {}
}
