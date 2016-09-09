package slick3.problem.enums


sealed trait ContentSource

object ContentSource extends AppEnum[ContentSource] {
  override def toString = "ContentSource"
  val values = Set[ContentSource](Unknown, YouTube, SoundCloud)
  val stringMap = values.map(v => (v.toString, v)).toMap
  def valueOf(s: String) = stringMap.get(s)
    

  /* Enum values */
  object Unknown extends ContentSource { override def toString = "Unknown"}
  object YouTube extends ContentSource { override def toString = "YouTube"}
  object SoundCloud extends ContentSource { override def toString = "SoundCloud"}

}


