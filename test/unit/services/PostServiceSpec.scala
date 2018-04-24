package unit.services

import models.Post
import org.scalatest.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec
import utils.TestHelpers
import org.mockito.Mockito._
import repositories.PostRepository
import services.implementations.PostServiceImp

class PostServiceSpec extends PlaySpec with MockitoSugar {

  "PostService" should {
    "return list of posts" in {
      val post1 = new Post(TestHelpers.randomId, TestHelpers.randomPostTitle, TestHelpers.randomPostBody)
      val post2 = new Post(TestHelpers.randomId, TestHelpers.randomPostTitle, TestHelpers.randomPostBody)
      val post3 = new Post(TestHelpers.randomId, TestHelpers.randomPostTitle, TestHelpers.randomPostBody)
      val mockPostRepository = mock[PostRepository]
      when(mockPostRepository.find) thenReturn Right(List(post1, post2, post3))

      val postService = new PostServiceImp(mockPostRepository)

      val posts = postService.getPosts
      posts.right.get mustBe List(post1, post2, post3)
    }
  }

}
