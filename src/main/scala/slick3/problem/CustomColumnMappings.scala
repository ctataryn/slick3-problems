package slick3.problem.repo.model

import java.util.UUID
import scala.reflect.ClassTag
//import scala.slick.driver.MySQLDriver.simple._
import slick.driver.MySQLDriver.api._
import slick3.problem.enums._


object CustomColumnMappings {

  def enumMapping[A:ClassTag](enum: AppEnum[A]) =
    MappedColumnType.base[A, String](
      {_.toString},
      {col => enum.valueOf(col).get})
  
  
  implicit val contentSourceMapping        = enumMapping[ContentSource](ContentSource)

  implicit val contentTypeMapping          = enumMapping[ContentType](ContentType)

  implicit val contentPrivacyStatusMapping = enumMapping[ContentPrivacyStatus](ContentPrivacyStatus)
  
  implicit val languageCodeMapping    = enumMapping[LanguageCode](LanguageCode)
  
  
}

