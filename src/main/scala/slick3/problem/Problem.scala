package slick3.problem.repo.content

import java.util.UUID
import slick.driver.MySQLDriver.api._
import slick3.problem.repo.model.ContentTable
import slick3.problem.repo.model.UserTable
import slick3.problem.repo.model.UserContentTable
import slick3.problem.repo.model.UserContentModel


object Problem {
  def getContentsByUser(userId: UUID, adopted: Boolean = false): Unit = {
    val subQuery =
      adopted match {
        case false => {
          for {
            uc <- UserContentTable.query if uc.userId === userId.toString && !uc.adopted.isDefined
            c  <- ContentTable.query if uc.contentId === c.id
          }
            yield (uc, c)
        }
        case true => {
          for {
            uc <- UserContentTable.query if uc.userId === userId.toString && uc.adopted.isDefined
            c  <- ContentTable.query if uc.contentId === c.id
          }
            yield (uc, c)
        }
      }


    val query =
      UserTable.query.filter(_.id === userId.toString)
        .joinLeft(subQuery).on { case (u, (uc, c)) => u.id === uc.userId}
        .map { case (u, (uc, c)) => (u, c.optionProjection) }
    ()
  }
}
