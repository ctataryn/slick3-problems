package slick3.problem.enums

trait AppEnum[A] {
  def values: Set[A]
  def stringMap: Map[String, A]
  def valueOf(s: String): Option[A]
}
