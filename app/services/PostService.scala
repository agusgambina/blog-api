package services

import models.Post

trait PostService {

  def getPosts: Either[String, Set[Post]]

}
