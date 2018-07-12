package functional.repositories

import functional.common.BlogApiOneAppPerSuiteWithComponents
import models.Post
import requests.PostRequest
import utils.TestHelpers


class PostRepositorySpec extends BlogApiOneAppPerSuiteWithComponents {
  var postTitle = TestHelpers.randomPostTitle
  var postBody = TestHelpers.randomPostBody
  var postRequest = new PostRequest(postTitle, postBody)
  var postId: Long = -1
  var post: Post = new Post(1,"title", "body")

  "PostRepositorySpec" must {
    "create a new post" in {
      postId = components.postRepository.create(postRequest).get
      postId must be > 0l
    }

    "find the post saved in the previous test" in {
      post = components.postRepository.findById(postId).get
      post.id mustBe postId
      post.title mustBe postTitle
      post.body mustBe postBody
      post.isDeleted mustBe false
    }

    "findAll posts" in {
      val posts = components.postRepository.findAll

      posts must not be empty
    }
  }

}
