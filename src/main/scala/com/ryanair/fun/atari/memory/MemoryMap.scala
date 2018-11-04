package com.ryanair.fun.atari.memory


class MemoryMap private(val heap: Array[Int]) {

  def readPos(position: Int): Int = heap(position)
}

object MemoryMap {

  def apply(heap: Array[Int]): MemoryMap = new MemoryMap(heap)
}
