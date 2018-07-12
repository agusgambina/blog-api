//package unit.controllers
//
//import controllers.PostController
//import models.Post
//import org.scalatest.mockito.MockitoSugar
//import org.scalatestplus.play.PlaySpec
//import services.PostService
//import utils.TestHelpers
//import org.mockito.Mockito._
//import play.api.mvc.{Result}
//import play.api.test.FakeRequest
//import play.api.test.Helpers._
//
//import scala.concurrent.Future
//
//class PostControllerSpec extends PlaySpec with MockitoSugar {
//
//  "PostController#getPosts" should {
//    "return posts" in {
//      val post1 = TestHelpers.randomPost
//      val post2 = TestHelpers.randomPost
//      val post3 = TestHelpers.randomPost
//
//      val mockPostService = mock[PostService]
//      when(mockPostService.getPosts).thenReturn(Right(Set(post1, post2, post3)))
//
//      val postService = new PostService() {
//        override def getPosts: Either[String, Set[Post]] = mockPostService.getPosts
//      }
//
//      val postController = new PostController(stubControllerComponents(), postService)
//      val posts: Future[Result] = postController.index.apply(FakeRequest())
//
//      status(posts) mustBe OK
//      contentType(posts) mustBe Some("application/json")
//    }
//  }
//
//
//
//}
