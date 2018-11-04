package com.ryanair.fun.atari

import com.ryanair.fun.atari.instruction.Instruction.InstructionVal

package object instruction {

  object Instruction extends Enumeration {

    case class InstructionVal(command: Int, instructionCommand: InstructionCommand) extends Val

    val IMMEDIATE = InstructionVal(0x00, ImmediateCommand())

    val ZERO_PAGE = InstructionVal(0x01, ZeroPageCommand())

  }

  def findInstructionByOperationCode(instruction: Int): InstructionCommand =
    Instruction.values.asInstanceOf[List[InstructionVal]]
      .find(iv => iv.command.equals(instruction))
      .map(i => i.instructionCommand).orNull

}
