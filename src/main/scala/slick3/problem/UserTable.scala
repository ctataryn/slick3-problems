package slick3.problem.repo.model

import slick.driver.MySQLDriver.api._
//import scala.slick.driver.MySQLDriver.simple._
import slick3.problem.model.User
import java.util.UUID 


class UserTable(tag: Tag) extends Table[User](tag, "user") {
  def id    = column[String]("id", O.PrimaryKey)
  def email = column[String]("email")
  
  def * = (id, email) <> (UserModel.mapFromColumns, UserModel.mapToColumns) 
  
  
  def pkUserEmail = index("pk_user_email", email, unique = true)
}


object UserTable {
  val query = TableQuery[UserTable]
  type ColumnTuple = Tuple2[String, String]
}




/* This object provides a mapping between the model, which uses UUIDs,
 * and the columns in the DB, which use Strings.
 */
object UserModel {
  def mapFromColumns(t: UserTable.ColumnTuple): User = {
    val (id, email) = t
    User(UUID.fromString(id), email)
  }
  
  def mapToColumns(m: User): Option[UserTable.ColumnTuple] = {
    Some((m.id.toString, m.email))
  }
}
