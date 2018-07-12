package services.implementations

import models.Post
import repositories.PostRepository
import services.PostService

class PostServiceImp(postRepository: PostRepository) extends PostService {

  override def getPosts: List[Post]  = postRepository.findAll

}
