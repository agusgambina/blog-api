package unit.services

import org.scalatest.mockito.MockitoSugar
import org.scalatestplus.play.PlaySpec
import utils.TestHelpers
import org.mockito.Mockito._
import repositories.PostRepository
import services.implementations.PostServiceImp

class PostServiceSpec extends PlaySpec with MockitoSugar {

  "PostService" should {
    "return list of posts" in {
      val post1 = TestHelpers.randomPost
      val post2 = TestHelpers.randomPost
      val post3 = TestHelpers.randomPost
      val mockPostRepository = mock[PostRepository]
      when(mockPostRepository.findAll).thenReturn(List(post1, post2, post3))

      val postService = new PostServiceImp(mockPostRepository)

      postService.get mustBe List(post1, post2, post3)
    }
  }

}
