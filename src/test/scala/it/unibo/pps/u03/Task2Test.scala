package it.unibo.pps.u03

import org.junit.*
import org.junit.Assert.*

class Task2Test:

  import u03.Sequences.*
  import u03.Sequences.Sequence.*
  import u03.Task2.*
  import it.unibo.pps.u02.AlgebraicDataTypes.Person
  import it.unibo.pps.u02.AlgebraicDataTypes.Person.*

  val sequencePerson: Sequence[Person] = Cons(Student("mario", 2020), Cons(Teacher("luigi", "Programming"),
    Cons(Student("maria", 2021), Cons(Teacher("laura", "Statistics"), Nil()))))

  val lst = Cons(3, Cons(7, Cons(1, Cons(5, Nil()))))

  @Test def testGetTeacherCourses(): Unit =
    assertEquals(Cons("Programming", Cons("Statistics", Nil())), getTeacherCourses(sequencePerson))

  @Test def testFoldLeft(): Unit =
    assertEquals(-16, foldLeft(lst)(0)(_ - _))
    assertEquals(105, foldLeft(lst)(1)(_ * _))
