package slick3.problem.enums


sealed trait LanguageCode


object LanguageCode extends AppEnum[LanguageCode] {
  override def toString = "LanguageCode"
  val values = Set[LanguageCode](ar, bn, cr, cs, da, de, el, en, es, fa, fi, fr, gu, ha, hi, hu, id, ja, jv, kn, ko, it, mr, ml, my, nl, no, pa, pl,
                                 pt, ru, su, sv, ta, te, th, tl, tr, uk, ur, vi, zh)
  
  
  val stringMap = values.map(v => (v.toString, v)).toMap
  def valueOf(s: String) = stringMap.get(s)
  
  
  object ar extends LanguageCode { override def toString = "ar" }
  object bn extends LanguageCode { override def toString = "bn" }
  object cr extends LanguageCode { override def toString = "cr" }
  object cs extends LanguageCode { override def toString = "cs" }
  object da extends LanguageCode { override def toString = "da" }
  object de extends LanguageCode { override def toString = "de" }
  object el extends LanguageCode { override def toString = "el" }
  object en extends LanguageCode { override def toString = "en" }
  object es extends LanguageCode { override def toString = "es" }
  object fa extends LanguageCode { override def toString = "fa" }
  object fi extends LanguageCode { override def toString = "fi" }
  object fr extends LanguageCode { override def toString = "fr" }
  object gu extends LanguageCode { override def toString = "gu" }
  object ha extends LanguageCode { override def toString = "ha" }
  object hi extends LanguageCode { override def toString = "hi" }
  object hu extends LanguageCode { override def toString = "hu" }
  object id extends LanguageCode { override def toString = "id" }
  object ja extends LanguageCode { override def toString = "ja" }
  object jv extends LanguageCode { override def toString = "jv" }
  object kn extends LanguageCode { override def toString = "kn" }
  object ko extends LanguageCode { override def toString = "ko" }
  object it extends LanguageCode { override def toString = "it" }
  object ml extends LanguageCode { override def toString = "ml" }
  object mr extends LanguageCode { override def toString = "mr" }
  object my extends LanguageCode { override def toString = "my" }
  object nl extends LanguageCode { override def toString = "nl" }
  object no extends LanguageCode { override def toString = "no" }
  object pa extends LanguageCode { override def toString = "pa" }
  object pl extends LanguageCode { override def toString = "pl" }
  object pt extends LanguageCode { override def toString = "pt" }
  object ru extends LanguageCode { override def toString = "ru" }
  object su extends LanguageCode { override def toString = "su" }
  object sv extends LanguageCode { override def toString = "sv" }
  object ta extends LanguageCode { override def toString = "ta" }
  object te extends LanguageCode { override def toString = "te" }
  object th extends LanguageCode { override def toString = "th" }
  object tl extends LanguageCode { override def toString = "tl" }
  object tr extends LanguageCode { override def toString = "tr" }
  object uk extends LanguageCode { override def toString = "uk" }
  object ur extends LanguageCode { override def toString = "ur" }
  object vi extends LanguageCode { override def toString = "vi" }
  object zh extends LanguageCode { override def toString = "zh" }
  
  
  
}

