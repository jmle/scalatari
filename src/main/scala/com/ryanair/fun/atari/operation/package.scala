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

    val LOADX_REGISTER =
      new OperationVal("ldx", LoadRegisterX(), 0xA2, 0xA6, 0xB6, 0xAE, 0xBE) {
        override def addressMode(operationCode: Int): AddressingMode =
          (operationCode match {
            case 0xA2 => AddressingModeEnum.IMMEDIATE
            case 0xA6 => AddressingModeEnum.ZERO_PAGE
            case 0xB6 => AddressingModeEnum.ZERO_PAGE_Y
            case 0xAE => AddressingModeEnum.ABSOLUTE
            case 0xBE => AddressingModeEnum.ABSOLUTE_Y
          }).addressMode
      }

    val LOAD_ACCUMULATOR =
      new OperationVal("lda", LoadAccumulatorInstruction(), 0xA9, 0xA5, 0xB5, 0xAD, 0xBD, 0xB9, 0xA1, 0xB1) {
        override private[operation] def addressMode(operationCode: Int): AddressingMode =
          (operationCode match {
            case 0xA9 => AddressingModeEnum.IMMEDIATE
            case 0xA5 => AddressingModeEnum.ZERO_PAGE
            case 0xB5 => AddressingModeEnum.ZERO_PAGE_X
            case 0xAD => AddressingModeEnum.ABSOLUTE
            case 0xBD => AddressingModeEnum.ABSOLUTE_X
            case 0xB9 => AddressingModeEnum.ABSOLUTE_Y
            case 0xA1 => AddressingModeEnum.INDIRECT_X
            case 0xB1 => AddressingModeEnum.INDIRECT_Y
          }).addressMode
      }

    val STACK_INSTRUCTIONS =
      new OperationVal("stack instruction", StackInstruction(), 0x9A, 0xBA, 0x48, 0x68, 0x08, 0x28) {
        override private[operation] def addressMode(operationCode: Int): AddressingMode =
          (operationCode match {
            case 0x9A => AddressingModeEnum.TRANSFER_X_TO_STACK
            case 0xBA => AddressingModeEnum.TRANSFER_STACK_TO_X
            case 0x48 => AddressingModeEnum.PUSH_ACCUMULATOR
            case 0x68 => AddressingModeEnum.PULL_ACCUMULATOR
            case 0x08 => AddressingModeEnum.PUSH_PROCESSOR_STATUS
            case 0x28 => AddressingModeEnum.PULL_PROCESSOR_STATUS
          }).addressMode
      }
  }

  def findOperation(operationCode: Int): Option[(InstructionExecutor, AddressingMode)] =
    Operation.values
      .find(value => value.asInstanceOf[Operation.OperationVal].operationCodes.contains(operationCode))
      .map(_.asInstanceOf[Operation.OperationVal])
      .map(op => (op.executor, op.addressMode(operationCode)))


}