package slick3.problem.enums


sealed trait ContentType

object ContentType extends AppEnum[ContentType] {
  override def toString = "ContentType"
  val values = Set[ContentType](VIDEO)
  val stringMap = values.map(v => (v.toString, v)).toMap
  def valueOf(s: String) = stringMap.get(s)
  

  /* Enum values */
  object VIDEO extends ContentType { override def toString = "VIDEO" }

}
