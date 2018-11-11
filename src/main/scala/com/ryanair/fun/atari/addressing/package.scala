package com.ryanair.fun.atari

import com.ryanair.fun.atari.addressing.AddressingModeEnum.ModeVal

package object addressing {

  object AddressingModeEnum extends Enumeration {

    case class ModeVal(instructionCommand: AddressingMode) extends Val {
      def addressMode : AddressingMode = instructionCommand
    }

    val IMMEDIATE = ModeVal(ImmediateMode())

    val ZERO_PAGE = ModeVal(ZeroPageMode())

    val CLEAR_CARRY = ModeVal(ClearCarryMode())

    val SET_DECIMAL: ModeVal = ModeVal(SetDecimalMode())

    val CLEAR_DECIMAL: ModeVal = ModeVal(ClearDecimalMode())

    val CLEAR_OVERFLOW: ModeVal = ModeVal(ClearOverflow())

    val SET_INTERRUPT: ModeVal = ModeVal(SetInterruptMode())

    val CLEAR_INTERRUPT: ModeVal = ModeVal(ClearInterruptMode())

    val SET_CARRY: ModeVal = ModeVal(SetCarryMode())


  }

}
