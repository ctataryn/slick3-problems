package slick3.problem.enums


sealed trait ContentPrivacyStatus

object ContentPrivacyStatus extends AppEnum[ContentPrivacyStatus] {
  override def toString = "PrivacyStatus"
  val values = Set(PUBLIC, PRIVATE, UNLISTED, NONE)
  val stringMap = values.map(v => (v.toString, v)).toMap
  def valueOf(s: String): Option[ContentPrivacyStatus] = stringMap.get(s)

  
  object PUBLIC     extends ContentPrivacyStatus { override def toString = "PUBLIC" }
  object PRIVATE    extends ContentPrivacyStatus { override def toString = "PRIVATE" }
  object UNLISTED   extends ContentPrivacyStatus { override def toString = "UNLISTED" }
  object NONE       extends ContentPrivacyStatus { override def toString = "NONE" }
  
}
