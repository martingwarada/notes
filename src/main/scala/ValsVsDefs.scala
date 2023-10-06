/** TODO Explains difference between val functions and def methods
 *
 *  1.
 *
 */

object ValsVsDefs extends App {


  // val functions
  val add1: Int => Int = (x: Int) => x + 1

  // add above similar to:
  val add2: Function1[Int, Int] = (x: Int) => x + 1
  val add3: (Int) => Int = (x: Int) => x + 1

  /*
   val functions
   1. 100% a function
   2. val functions are instances of Function0 through Function22
       and the methods that are available are andThen, compose and toString methods
   3. val functions can use case expressions without a beginning match
  */

 // def functions
  def add3(x: Int) = x + 1

  /*
   1. technically its not a function
   2. method needs to be defined within a class of object
   3. has access to other members in the same class
   4. its passed an implicit reference to the class's instance e.g.
      when map is called on list it will have an implicit reference to THIS object
      so it can access elements in the instance's list
   5. can specify generic types def foo[A](a: A): String = ???
   6. when you use a method where a val is expected the compiler does ETA expansion
   */

  //Using generic types
  def firstChar[A](a: A) = a.toString.charAt(0)
  firstChar(45) // 4
  firstChar("road") // r

  //  will not compile as val functions are not parametized(generic)
  //  val firstChar[A] = (a: A) => a.toString.charAt(0)

  // however you can coerce a parametized def method into a function
  val myChar1 = firstChar[Int] _
  myChar1(34)
  val myChar2 = firstChar[Int](23)

  // Also you could do this
  class SomeTypes[A, B] extends Function2[A, B, Int] { //Note Function2[A, B, Int] is similar to (A, B) => Int
    override def apply(a: A, b: B): Int = a.toString.length + b.toString.length
  }
  val someTypes = new SomeTypes[Any, Any]
  someTypes("Martin", "Gwa")
}
