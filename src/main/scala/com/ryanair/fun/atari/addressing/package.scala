package com.ryanair.fun.atari

package object addressing {

  object AddressingModeEnum extends Enumeration {


    case class ModeVal(instructionCommand: AddressingMode) extends Val {
      def addressMode: AddressingMode = instructionCommand
    }

    val IMMEDIATE = ModeVal(ImmediateMode())

    val ZERO_PAGE = ModeVal(ZeroPageMode())

    val ZERO_PAGE_X = ModeVal(ZeroPageModeX())

    val ZERO_PAGE_Y = ModeVal(ZeroPageModeY())

    val ABSOLUTE = ModeVal(Absolute())

    val ABSOLUTE_X = ModeVal(AbsoluteX())

    val ABSOLUTE_Y = ModeVal(AbsoluteY())

    val INDIRECT_X = ModeVal(IndirectX())

    val INDIRECT_Y = ModeVal(IndirectY())

    val CLEAR_CARRY = ModeVal(ClearCarryMode())

    val SET_DECIMAL: ModeVal = ModeVal(SetDecimalMode())

    val CLEAR_DECIMAL: ModeVal = ModeVal(ClearDecimalMode())

    val CLEAR_OVERFLOW: ModeVal = ModeVal(ClearOverflow())

    val SET_INTERRUPT: ModeVal = ModeVal(SetInterruptMode())

    val CLEAR_INTERRUPT: ModeVal = ModeVal(ClearInterruptMode())

    val SET_CARRY: ModeVal = ModeVal(SetCarryMode())

    val TRANSFER_X_TO_STACK = ModeVal(TransferXToStackMode())

    val TRANSFER_STACK_TO_X = ModeVal(TransferStackToXMode())

    val PUSH_ACCUMULATOR = ModeVal(PushAccumulatorMode())

    val PULL_ACCUMULATOR = ModeVal(PullAccumulatorMode())

    val PUSH_PROCESSOR_STATUS = ModeVal(PushProcessorStatusMode())

    val PULL_PROCESSOR_STATUS = ModeVal(PullProcessorStatusMode())

  }

}
