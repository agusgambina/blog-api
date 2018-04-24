package models

import play.api.libs.json._

case class Post(
  id: Int,
  title: String,
  body: String
)

object Post {
  implicit val postFormat = Json.format[Post]
}



