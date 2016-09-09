package slick3.problem.repo.model

import java.util.UUID
//import scala.slick.driver.MySQLDriver.simple._
import slick.driver.MySQLDriver.api._
import slick3.problem.model.Content
import slick3.problem.enums.ContentType
import slick3.problem.enums.ContentSource
import slick3.problem.enums.ContentPrivacyStatus
import slick3.problem.repo.model.CustomColumnMappings._


class ContentTable(tag: Tag) extends Table[Content](tag, "content") {
  def id              = column[String]("id")
  def title           = column[String]("title")
  def source          = column[ContentSource]("source")
  def sourceId        = column[String]("source_id")
  def contentType     = column[ContentType]("content_type")
  def duration        = column[Int]("duration")
  def privacyStatus   = column[ContentPrivacyStatus]("privacy_status")
  def thumbnailUrl    = column[Option[String]]("thumbnail_url")
  def publisher       = column[Option[String]]("publisher")
  
  
  def * = 
    (id, title, source, sourceId, contentType, duration, privacyStatus, thumbnailUrl, publisher) <> 
      (ContentModel.mapFromColumns, ContentModel.mapToColumns)
  
  def optionProjection = 
    (id.?, title.?, source.?, sourceId.?, contentType.?, duration.?, privacyStatus.?, thumbnailUrl, publisher) <>
      (ContentModel.mapOptionFromColumns, ContentModel.mapOptionToColumns)
    
       
  def pkContent = primaryKey("pk_content", id)
}


object ContentTable {
  val query = TableQuery[ContentTable]
  type ColumnTuple = 
    Tuple9[String, String, ContentSource, String, ContentType, Int, ContentPrivacyStatus, Option[String], Option[String]]
  type OptionColumnTuple = 
    Tuple9[Option[String], Option[String], Option[ContentSource], 
           Option[String], Option[ContentType], Option[Int], Option[ContentPrivacyStatus], Option[String], Option[String]]
}





/* This object provides a mapping between the model, which uses UUIDs,
 * and the columns in the DB, which use Strings.
 */
object ContentModel {
  
  def mapFromColumns(t: ContentTable.ColumnTuple): Content = {
    val (id, title, source, sourceId, contentType, duration, privacyStatus, thumbnailUrl, publisher) = t 
    Content(UUID.fromString(id), title, source, sourceId, contentType, duration, privacyStatus, thumbnailUrl, publisher) 
  }

  def mapToColumns(m: Content): Option[ContentTable.ColumnTuple] = {
    Some((m.id.toString, m.title, m.source, m.sourceId, m.contentType, m.duration, m.privacyStatus, m.thumbnailUrl, m.publisher))    
  }
  
  
  
  def mapOptionFromColumns(t: ContentTable.OptionColumnTuple): Option[Content] = {
    val (id, title, source, sourceId, contentType, duration, privacyStatus, thumbnailUrl, publisher) = t 
    /* Note that duration, completion, and thumbnailUrl are not included in the for comprehension
     * since they can be None for a non-null DB result.
     */
    for {
      c_id            <- id
      c_title         <- title
      c_source        <- source
      c_sourceId      <- sourceId 
      c_contentType   <- contentType
      c_duration      <- duration
      c_privacyStatus <- privacyStatus
    }
    yield (
      Content(
          id            = UUID.fromString(c_id), 
          title         = c_title, 
          source        = c_source, 
          sourceId      = c_sourceId, 
          contentType   = c_contentType, 
          duration      = c_duration,
          privacyStatus = c_privacyStatus,
          thumbnailUrl  = thumbnailUrl,
          publisher     = publisher))
  }

  
  def mapOptionToColumns(oc: Option[Content]): Option[ContentTable.OptionColumnTuple] = {
    oc.map { c =>
      (Some(c.id.toString), Some(c.title), Some(c.source), Some(c.sourceId), 
       Some(c.contentType), Some(c.duration), Some(c.privacyStatus), c.thumbnailUrl, c.publisher)
    }
  }
  
}
    

