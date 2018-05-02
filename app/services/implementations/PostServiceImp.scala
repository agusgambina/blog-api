package services.implementations

import models.Post
import repositories.PostRepository
import services.PostService

class PostServiceImp(postRepository: PostRepository) extends PostService {

  override def getPosts: Either[String, Set[Post]]  = {
    postRepository.find.fold(
      strError => { Left(strError) } ,
      postList => { Right(postList) }
    )
  }

}
