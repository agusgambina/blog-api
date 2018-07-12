package repositories.implementations

import anorm.Macro.ColumnNaming
import models.Post
import repositories.PostRepository
import anorm._
import play.api.db.Database
import requests.PostRequest

class PostRepositoryImp(database: Database) extends PostRepository {

  val parser: RowParser[Post] = Macro.namedParser[Post](ColumnNaming.SnakeCase)

  override def create(postRequest: PostRequest): Option[Long] = database.withConnection { implicit c =>
    SQL(
      """
        INSERT INTO posts(title, body)
        VALUES({title}, {body})
      """
    ).on('title -> postRequest.title, 'body -> postRequest.body).executeInsert()
  }

  override def findAll: List[Post]  = database.withConnection { implicit c =>
    SQL("""
      SELECT *
      FROM posts
      WHERE is_deleted IS false
    """).as(parser.*)
  }

  override def findById(postId: Long): Option[Post] = database.withConnection { implicit c =>
    SQL(
      """
        SELECT *
        FROM posts
        WHERE id = {postId}
      """).on('postId -> postId).as(parser.singleOpt)
  }
}
