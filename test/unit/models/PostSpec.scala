package unit.models

import models.Post
import org.scalatestplus.play.PlaySpec
import play.api.libs.json._
import utils.TestHelpers

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
      val jsonPost = Json.obj("id" -> postId, "title" -> postTitle, "body" -> postBody)
      val post = jsonPost.validate[Post] match {
        case jsPost: JsSuccess[Post] => jsPost.get
        case e: JsError => println(e)
      }
      val originalPost = new Post(postId, postTitle, postBody)
      post mustBe originalPost
    }

  }

}
