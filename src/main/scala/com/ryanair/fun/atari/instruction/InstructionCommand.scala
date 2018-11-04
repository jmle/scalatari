package com.ryanair.fun.atari.instruction

import com.ryanair.fun.atari.memory.MemoryMap

trait InstructionCommand {

  protected def operand(counter: Int)(implicit memoryMap: MemoryMap): Int

}


case class ImmediateCommand() extends InstructionCommand {

  def operand(counter: Int)(implicit memoryMap: MemoryMap): Int = ???

}

case class ZeroPageCommand() extends InstructionCommand {

  def operand(counter: Int)(implicit memoryMap: MemoryMap): Int = 0 & 0xFF
}