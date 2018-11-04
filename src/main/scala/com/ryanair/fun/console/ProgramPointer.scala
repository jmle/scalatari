package com.ryanair.fun.console

object ProgramPointer {

  private var pointer: Int = 0

  def moveRelative(numberOfPositions: Int): Unit = pointer + numberOfPositions

  def increment(): Unit = pointer += 1

  def decrement(): Unit = pointer -= 1
}
