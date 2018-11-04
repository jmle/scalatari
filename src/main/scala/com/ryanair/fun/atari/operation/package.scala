package com.ryanair.fun.atari

import com.ryanair.fun.atari.instruction.Instruction

/**
  * http://www.6502.org/tutorials/6502opcodes.html
  */
package object operation {

  object Operation extends Enumeration {

    abstract class OperationVal(val name: String, val operationCodes: Int*) extends Val(name) {
      def operate(operationCode: Int): Instruction.InstructionVal
    }

    val ADD_WITH_CARRY = new OperationVal("adc", 0x65, 0x69, 0x75, 0x6D, 0x7D, 0x79, 0x61, 0x71) {
      override def operate(operationCode: Int): Instruction.InstructionVal =
        operationCode match {
          case 0x69 => Instruction.IMMEDIATE
          case _ => Instruction.ZERO_PAGE
        }
    }
    val AND_WITH_ACCUMULATOR = new OperationVal("and", 0x25, 0x29, 0x35, 0x2D, 0x3D, 0x39, 0x21, 0x31) {
      override def operate(operationCode: Int): Instruction.InstructionVal =
        operationCode match {
          case 0x69 => Instruction.IMMEDIATE
          case _ => Instruction.ZERO_PAGE
        }
    }
    val ARITHMETIC_SHIFT_LEFT = new OperationVal("asl", 0x0A, 0x06, 0x16, 0x0E, 0x1E) {
      override def operate(operationCode: Int): Instruction.InstructionVal =
        operationCode match {
          case 0x69 => Instruction.IMMEDIATE
          case _ => Instruction.ZERO_PAGE
        }
    }
    val TEST_BIT = new OperationVal("bit", 0x24, 0x2C) {
      override def operate(operationCode: Int): Instruction.InstructionVal =
        operationCode match {
          case 0x69 => Instruction.IMMEDIATE
          case _ => Instruction.ZERO_PAGE
        }
    }
  }

  def findOperation(operationCode: Int): Operation.OperationVal =
    Operation.values.asInstanceOf[List[Operation.OperationVal]]
      .find(value => value.operationCodes.contains(operationCode))
      .orNull

}