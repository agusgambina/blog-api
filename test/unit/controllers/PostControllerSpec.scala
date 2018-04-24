package unit.controllers

import controllers.PostController
import models.Post
import org.scalatest.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec
import services.PostService
import utils.TestHelpers
import org.mockito.Mockito._
import play.api.mvc.{ControllerComponents, Result}
import play.api.test.FakeRequest
import repositories.PostRepository
import play.api.test.Helpers._

import scala.concurrent.Future

class PostControllerSpec extends PlaySpec with MockitoSugar {

  "PostController#getPosts" should {
    "return posts" in {
      val post1 = new Post(TestHelpers.randomId, TestHelpers.randomPostTitle, TestHelpers.randomPostBody)
      val post2 = new Post(TestHelpers.randomId, TestHelpers.randomPostTitle, TestHelpers.randomPostBody)
      val post3 = new Post(TestHelpers.randomId, TestHelpers.randomPostTitle, TestHelpers.randomPostBody)

      val mockPostService = mock[PostService]
      when(mockPostService.getPosts) thenReturn Right(List(post1, post2, post3))

      val postService = new PostService() {
        override def getPosts: Either[String, List[Post]] = mockPostService.getPosts
      }

      val postController = new PostController(stubControllerComponents(), postService)
      val posts: Future[Result] = postController.index.apply(FakeRequest())

      status(posts) mustBe OK
      contentType(posts) mustBe Some("application/json")
    }
  }



}
