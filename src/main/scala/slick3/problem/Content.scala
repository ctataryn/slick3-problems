package slick3.problem.model

import java.util.UUID
import slick3.problem.enums.ContentType
import slick3.problem.enums.ContentSource
import slick3.problem.enums.ContentPrivacyStatus

/**
  * This abstract class allows us to pass around a Content or ContentWithoutId
  */
abstract class ContentBase {
  def title:          String
  def source:         ContentSource
  def sourceId:       String
  def contentType:    ContentType
  def duration:       Int
  def privacyStatus:  ContentPrivacyStatus
  def thumbnailUrl:   Option[String]
  def publisher:      Option[String]

  def toContent(id: UUID) =
    Content(
      id            = id,
      title         = this.title,
      source        = this.source,
      sourceId      = this.sourceId,
      contentType   = this.contentType,
      duration      = this.duration,
      privacyStatus = this.privacyStatus,
      thumbnailUrl  = this.thumbnailUrl,
      publisher     = this.publisher)

}


case class Content(
    id:             UUID, 
    title:          String, 
    source:         ContentSource,
    sourceId:       String,
    contentType:    ContentType, 
    duration:       Int,
    privacyStatus:  ContentPrivacyStatus,
    thumbnailUrl:   Option[String],
    publisher:      Option[String]) extends ContentBase {

}
 
    
    
case class ContentWithoutId(
    title:          String, 
    source:         ContentSource,
    sourceId:       String,
    contentType:    ContentType, 
    duration:       Int,
    privacyStatus:  ContentPrivacyStatus,
    thumbnailUrl:   Option[String],
    publisher:      Option[String]) extends ContentBase {

}
    
    
