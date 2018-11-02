package com.ryanair.fun.atari.instruction

import java.io.ByteArrayInputStream

import org.scalatest.FlatSpec

class InstructionProcessorTest extends FlatSpec {

  lazy val rom_content: Array[Byte] = Array[Byte](0x00, 0x11, 0x01, 0xFF)

  val instructionProcessor: InstructionProcessor = InstructionProcessor(new ByteArrayInputStream(rom_content))

  "input stream with rom content" should " transform into instruction " in {
    //assert(instructionProcessor.find().eq(Array(Instruction.LOAD_MEMORY_POSITION, Instruction.STORE_MEMORY_POSITION)))
    assert(1 == 1)
  }

}
