package models

import com.github.nscala_time.time.Imports._

import play.api.libs.json._

case class Post(
  id: Int,
  title: String,
  body: String,
  isDeleted: Boolean = false,
  creationDate: DateTime = DateTime.now(),
  lastModificationDate: DateTime = DateTime.now()
)

object Post {
  import formatters.DateTimeFormatter._
  implicit val postFormat = Json.format[Post]
}



