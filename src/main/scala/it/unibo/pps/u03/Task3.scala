package u03

object Task3:

  import u03.Streams.*
  import u03.Streams.Stream.*

  def takeWhile[A](s: Stream[A])(pred: A => Boolean): Stream[A] = s match
    case Cons(h, t) if pred(h()) => cons(h(), takeWhile(t())(pred))
    case _ => empty()
