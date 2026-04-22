package it.unibo.pps.u03

import org.junit.*
import org.junit.Assert.*

class Task3Test:

  import u03.Streams.Stream
  import u03.Streams.Stream.*
  import u03.Task3.*

  val intStream: Stream[Int] = cons(0, cons(2, cons(3, cons(7, empty()))))

  @Test def testTakeWhile(): Unit =
    val pred: Int => Boolean = _ < 5
    val resultStream: Stream[Int] = cons(0, cons(2, cons(3, empty())))
    assertEquals(toList(resultStream), toList(takeWhile(intStream)(pred)))

  @Test def testFill(): Unit =
    val resultStream: Stream[String] = cons("a", cons("a", cons("a", empty())))
    assertEquals(toList(resultStream), toList(fill(3)("a")))

  @Test def testFibonacci(): Unit =
    val resultStream: Stream[Int] = cons(0, cons(1, cons(1, cons(2, cons(3, empty())))))
    assertEquals(toList(resultStream), toList(take(fibonacci())(5)))

  @Test def testInterleave(): Unit =
    val s1: Stream[Int] = cons(1, cons(3, cons(5, empty())))
    val s2: Stream[Int] = cons(2, cons(4, cons(6, cons(8, cons(10, empty())))))
    val resultStream: Stream[Int] =  cons(1, cons(2, cons(3, cons(4, cons(5, cons(6, cons(8, cons(10, empty()))))))))
    assertEquals(toList(resultStream), toList(interleave(s1, s2)))