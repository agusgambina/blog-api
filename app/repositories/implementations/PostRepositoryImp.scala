package repositories.implementations

import anorm.Macro.ColumnNaming
import models.Post
import repositories.PostRepository
import anorm._
import play.api.Logger
import play.api.db.Database

class PostRepositoryImp(blogApiDB: Database) extends PostRepository {

  val parser: RowParser[Post] = Macro.namedParser[Post](ColumnNaming.SnakeCase)

  override def find: Either[String, Set[Post]] = {
    Logger.debug(s"PostRepositoryImp#find")
    blogApiDB.withConnection { implicit connection =>
      SQL("""
        SELECT *
          FROM posts
      """).as(parser.*) match {
        case x: Set[Post] => Right(x)
        case _ => Left("error")
      }
    }
  }

}
