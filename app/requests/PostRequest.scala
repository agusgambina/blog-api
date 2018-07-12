package requests

import play.api.libs.json.Json

case class PostRequest(
  title: String,
  body: String
)

object PostRequest {
  implicit val postRequestFormat = Json.format[PostRequest]
}
