package com.ryanair.fun.atari.memory

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


class MemoryMap()  {

  val heap : mutable.ArrayBuffer[Int] = ArrayBuffer()

  def this(heap: Array[Int]){
    this()
    this.load(heap)
  }

  def readPos(position: Int): Int = heap(position)

  def load(heap: Array[Int]) : Unit = {
    this.heap.clear()
    this.heap.appendAll(heap)
  }
}

object MemoryMap {

  def apply(heap: Array[Int]): MemoryMap = new MemoryMap(heap)

  def apply(): MemoryMap = new MemoryMap()
}
