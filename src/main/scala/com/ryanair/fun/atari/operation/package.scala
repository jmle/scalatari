package com.ryanair.fun.atari

import com.ryanair.fun.atari.addressing.{AddressingMode, AddressingModeEnum}

/**
  * http://www.6502.org/tutorials/6502opcodes.html
  */
package object operation {

  object Operation extends Enumeration {

    abstract class OperationVal(val name: String,
                                val executor: InstructionExecutor,
                                val operationCodes: Int*) extends Val(name) {

      private[operation] def addressMode(operationCode: Int): AddressingMode
    }

    val ADD_WITH_CARRY =
      new OperationVal("adc", AddWithCarry(), 0x65, 0x69, 0x75, 0x6D, 0x7D, 0x79, 0x61, 0x71) {
        override def addressMode(operationCode: Int): AddressingMode =
          (operationCode match {
            case 0x69 => AddressingModeEnum.IMMEDIATE
            case _ => AddressingModeEnum.ZERO_PAGE
          }).addressMode
      }

    val AND_WITH_ACCUMULATOR =
      new OperationVal("and", AndWithAccumulator(), 0x25, 0x29, 0x35, 0x2D, 0x3D, 0x39, 0x21, 0x31) {
        override def addressMode(operationCode: Int): AddressingMode =
          (operationCode match {
            case 0x69 => AddressingModeEnum.IMMEDIATE
            case _ => AddressingModeEnum.ZERO_PAGE
          }).addressMode
      }
    val ARITHMETIC_SHIFT_LEFT =
      new OperationVal("asl", ArithmeticShiftLeft(), 0x0A, 0x06, 0x16, 0x0E, 0x1E) {
        override def addressMode(operationCode: Int): AddressingMode =
          (operationCode match {
            case 0x69 => AddressingModeEnum.IMMEDIATE
            case _ => AddressingModeEnum.ZERO_PAGE
          }).addressMode
      }
    val TEST_BIT =
      new OperationVal("bit", TestBit(), 0x24, 0x2C) {
        override def addressMode(operationCode: Int): AddressingMode =
          (operationCode match {
            case 0x69 => AddressingModeEnum.IMMEDIATE
            case _ => AddressingModeEnum.ZERO_PAGE
          }).addressMode
      }

    val PROCESSOR_STATUS =
      new OperationVal("flag", ProcessorStatus(), 0x18, 0x38, 0x58, 0x78, 0xB8, 0xD8, 0xF8) {
        override def addressMode(operationCode: Int): AddressingMode =
          (operationCode match {
            case 0x18 => AddressingModeEnum.CLEAR_CARRY
            case 0x38 => AddressingModeEnum.SET_CARRY
            case 0x58 => AddressingModeEnum.CLEAR_INTERRUPT
            case 0x78 => AddressingModeEnum.SET_INTERRUPT
            case 0xB8 => AddressingModeEnum.CLEAR_OVERFLOW
            case 0xD8 => AddressingModeEnum.CLEAR_DECIMAL
            case 0xF8 => AddressingModeEnum.SET_DECIMAL
          }).addressMode
      }
  }

  def findOperation(operationCode: Int): Option[(InstructionExecutor, AddressingMode)] =
    Operation.values
      .find(value => value.asInstanceOf[Operation.OperationVal].operationCodes.contains(operationCode))
      .map(_.asInstanceOf[Operation.OperationVal])
      .map(op => (op.executor, op.addressMode(operationCode)))


}