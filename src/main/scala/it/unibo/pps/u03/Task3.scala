package u03

object Task3:

  import u03.Streams.*
  import u03.Streams.Stream.*

  def takeWhile[A](s: Stream[A])(pred: A => Boolean): Stream[A] = s match
    case Cons(h, t) if pred(h()) => cons(h(), takeWhile(t())(pred))
    case _ => empty()

  def fill[A](n: Int)(p : A): Stream[A] = n match
    case n if n > 0 => cons(p, fill(n - 1)(p))
    case _ => empty()

  def fibonacci(): Stream[Int] =
    def fib(f1: Int, f2: Int): Stream[Int] =
      cons(f1 + f2, fib(f2, f1 + f2))
    cons(0, cons(1, fib(0, 1)))

  def interleave[A](s1: Stream[A], s2: Stream[A]): Stream[A] = (s1, s2) match
    case (Cons(h1, t1), Cons(h2, t2)) => cons(h1(), cons(h2(), interleave(t1(), t2())))
    case (Empty(), _) => s2
    case _ => s1

  import u03.Sequences.*

  def cycle[A](lst: Sequence[A]): Stream[A] =
    def _cycle(actual: Sequence[A], acc: Sequence[A]): Stream[A] = actual match
      case Sequence.Cons(h, t) => cons(h, _cycle(t, acc))
      case _ => _cycle(acc, acc)
    _cycle(lst, lst)