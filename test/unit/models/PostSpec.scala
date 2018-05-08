package unit.models

import models.Post
import org.scalatestplus.play.PlaySpec
import play.api.libs.json._
import utils.TestHelpers

import com.github.nscala_time.time.Imports._
import formatters.DateTimeFormatter._

class PostSpec extends PlaySpec {

  "Post#Json" should {

    "Be able to write a JsValue from a Post" in {
      val postId = TestHelpers.randomId
      val postTitle = TestHelpers.randomPostTitle
      val postBody = TestHelpers.randomPostBody
      val post = new Post(postId, postTitle, postBody)
      Json.toJson(post) mustBe an[JsValue]
      (Json.toJson(post) \ "id").get mustBe JsNumber(postId)
      (Json.toJson(post) \ "title").get mustBe JsString(postTitle)
      (Json.toJson(post) \ "body").get mustBe JsString(postBody)
    }

    "Be able to read a Json from a Post" in {
      val postId = TestHelpers.randomId
      val postTitle = TestHelpers.randomPostTitle
      val postBody = TestHelpers.randomPostBody
      val now = DateTime.now()
      val expectedPost = new Post(postId, postTitle, postBody, false, now, now)

      val jsonPost = Json.obj("id" -> postId, "title" -> postTitle, "body" -> postBody, "isDeleted" -> false, "creationDate" -> now, "lastModificationDate" -> now)

      jsonPost.validate[Post] match {
        case jsSuccessPost: JsSuccess[Post] => {
          val actualPost = jsSuccessPost.get
          actualPost.id mustBe expectedPost.id
          actualPost.title mustBe expectedPost.title
          actualPost.body mustBe expectedPost.body
        }
        case e: JsError => {
          println(e)
          assert(false)
        }
      }
    }

  }

}
