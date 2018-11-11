package com.ryanair.fun.atari.operation

import com.ryanair.fun.atari.addressing.AddressingMode

trait InstructionExecutor {

  def run(addressingMode: AddressingMode): Unit
}

case class AddWithCarry() extends InstructionExecutor {

  def run(addressingMode: AddressingMode) =
    println(s"add with carry, ${addressingMode.getClass.getSimpleName}")
}


case class AndWithAccumulator() extends InstructionExecutor {

  def run(addressingMode: AddressingMode) =
    println(s"and with accumulator, ${addressingMode.getClass.getSimpleName}")
}


case class ArithmeticShiftLeft() extends InstructionExecutor {

  def run(addressingMode: AddressingMode) =
    println(s"arithmetic shift left, ${addressingMode.getClass.getSimpleName}")
}


case class TestBit() extends InstructionExecutor {

  def run(addressingMode: AddressingMode) =
    println(s"Test Bit, ${addressingMode.getClass.getSimpleName}")
}


case class ProcessorStatus() extends InstructionExecutor {

  def run(addressingMode: AddressingMode) =
    println(s"Processor Status, ${addressingMode.getClass.getSimpleName}")
}


