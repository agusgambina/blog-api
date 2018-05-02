package repositories.implementations

import models.Post
import repositories.PostRepository

class PostRepositoryImp extends PostRepository {

  override def find: Either[String, Set[Post]] = ???

}
