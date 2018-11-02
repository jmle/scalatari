package com.ryanair.fun.atari

package object instruction {

  object Instruction extends Enumeration {

    abstract class InstructionVal(var command: Byte, val bodyLength: Int) extends Val {
      def execute: Unit
    }

    val LOAD_MEMORY_POSITION = new InstructionVal(0x00, 8) {
      override def execute: Unit = println("I am a load in memory instruction")
    }

    val STORE_MEMORY_POSITION = new InstructionVal(0x01, 8) {
      override def execute: Unit = print("I am a store memory instruction")
    }

    def find(instruction: Array[Byte]): InstructionVal =
      this.values.asInstanceOf[List[InstructionVal]]
        .find(iv => iv.command.equals(instruction(0)))
        .orNull

  }

}
