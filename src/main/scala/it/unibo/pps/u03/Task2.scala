package u03


object Task2:

  import Sequences.*
  import Sequence.*
  import it.unibo.pps.u02.AlgebraicDataTypes.Person
  import it.unibo.pps.u02.AlgebraicDataTypes.Person.*

  def getTeacherCourses(s: Sequence[Person]): Sequence[String] =
    //map(filter(s) { case Teacher(_, _) => true; case _ => false }) { case Teacher(_, c) => c; case _ => "" }
    flatMap(s) { case Teacher(_, c) => Cons(c, Nil()); case _ => Nil() }


  def foldLeft[A, B](s: Sequence[A])(initial: B)(opt: (B, A) => B): B =

    @scala.annotation.tailrec
    def _optLeft(current: Sequence[A], acc: B): B = current match
      case Cons(h, t) => _optLeft(t, opt(acc, h))
      case Nil() => acc

    _optLeft(s, initial)  