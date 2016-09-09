package slick3.problem.repo.model

//import scala.slick.driver.MySQLDriver.simple._
import slick.driver.MySQLDriver.api._
import java.util.UUID


class UserContentTable(tag: Tag) extends Table[UserContentModel](tag, "user_content") {
  def userId    = column[String]("user_id")
  def contentId = column[String]("content_id")
  def adopted   = column[Option[Boolean]]("adopted")

  def * = (userId, contentId, adopted) <> (UserContentModel.mapFromColumns, UserContentModel.mapToColumns)
  
  
  def pkUserContent = primaryKey("pk_user_content", (userId, contentId))
  def fkUserContentUser =
    foreignKey("fk_user_content_user", userId, UserTable.query)(_.id, onDelete = ForeignKeyAction.Restrict)
  def fkUserContentContent =
    foreignKey("fk_user_content_content", contentId, UserTable.query)(_.id, onDelete = ForeignKeyAction.Restrict)
}


object UserContentTable {
  val query = TableQuery[UserContentTable]
  type ColumnTuple = Tuple3[String, String, Option[Boolean]]
}





case class UserContentModel(
    userId: UUID, 
    contentId: UUID,
    adopted: Option[Boolean] = None)

/* This object provides a mapping between the model, which uses UUIDs,
 * and the columns in the DB, which use Strings.
 */
object UserContentModel {
  def mapFromColumns(t: UserContentTable.ColumnTuple): UserContentModel = {
    val (userId, contentId, adopted) = t
    UserContentModel(UUID.fromString(userId), UUID.fromString(contentId), adopted)
  }
  
  def mapToColumns(m: UserContentModel): Option[UserContentTable.ColumnTuple] = {
    Some((m.userId.toString, m.contentId.toString, m.adopted))
  }
}
